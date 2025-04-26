package ua.opnu.equipment_rental;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public Rental save(Rental rental) {
        return rentalRepository.save(rental);
    }

    public List<Rental> getRentalsByCustomer(Long customerId) {
        return rentalRepository.findByCustomerId(customerId);
    }

    public List<Rental> getRentalsByEmployee(Long employeeId) {
        return rentalRepository.findByEmployeeId(employeeId);
    }

    public Rental returnRental(Long id) {
        Rental rental = rentalRepository.findById(id).orElseThrow();
        rental.setReturned(true);
        return rentalRepository.save(rental);
    }

    public void delete(Long id) {
        rentalRepository.deleteById(id);
    }
}
