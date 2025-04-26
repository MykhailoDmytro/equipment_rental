package ua.opnu.equipment_rental;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer update(Long id, Customer customer) {
        Customer existing = customerRepository.findById(id).orElseThrow();
        existing.setName(customer.getName());
        existing.setPhone(customer.getPhone());
        return customerRepository.save(existing);
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
