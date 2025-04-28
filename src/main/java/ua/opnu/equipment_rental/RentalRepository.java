package ua.opnu.equipment_rental;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByCustomerId(Long customerId);
    List<Rental> findByEmployeeId(Long employeeId);

    List<Rental> findByReturnedFalse();

    @Query("SELECT r FROM Rental r WHERE r.returned = false AND r.endDate < CURRENT_DATE")
    List<Rental> findOverdueRentals();

    @Query("SELECT COUNT(r) FROM Rental r WHERE r.equipment.id = :equipmentId")
    Long countByEquipmentId(Long equipmentId);

    @Query("SELECT r.equipment.id FROM Rental r WHERE :date BETWEEN r.startDate AND r.endDate AND r.returned = false")
    List<Long> findUnavailableEquipmentIdsByDate(LocalDate date);

    @Query("SELECT SUM(DATEDIFF(r.endDate, r.startDate) * e.dailyRate) FROM Rental r JOIN r.equipment e WHERE r.returned = true")
    Double getTotalRevenue();

    @Query("SELECT r.equipment FROM Rental r GROUP BY r.equipment ORDER BY COUNT(r) DESC")
    List<Equipment> findMostRentedEquipment();
}
