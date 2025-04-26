package ua.opnu.equipment_rental;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee update(Long id, Employee employee) {
        Employee existing = employeeRepository.findById(id).orElseThrow();
        existing.setName(employee.getName());
        existing.setPosition(employee.getPosition());
        return employeeRepository.save(existing);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
