package ua.opnu.equipment_rental;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByCustomerId(Long customerId);
    List<Rental> findByEmployeeId(Long employeeId);
}
