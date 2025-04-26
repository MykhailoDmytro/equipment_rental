package ua.opnu.equipment_rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping
    public ResponseEntity<Rental> addRental(@RequestBody Rental rental) {
        // Тут ми зберігаємо оренду разом з пов'язаними об'єктами
        return new ResponseEntity<>(rentalService.save(rental), HttpStatus.CREATED);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Rental>> getRentalsByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(rentalService.getRentalsByCustomer(customerId));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Rental>> getRentalsByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(rentalService.getRentalsByEmployee(employeeId));
    }

    @PutMapping("/return/{id}")
    public ResponseEntity<Rental> returnRental(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.returnRental(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable Long id) {
        rentalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
