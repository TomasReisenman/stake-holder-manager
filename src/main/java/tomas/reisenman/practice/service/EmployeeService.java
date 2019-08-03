package tomas.reisenman.practice.service;

import tomas.reisenman.practice.exceptions.StakeHolderNotFoundException;
import tomas.reisenman.practice.model.Employee;
import tomas.reisenman.practice.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }

    public Employee findById(final Long id){
        return employeeRepo
                .findById(id)
                .orElseThrow(() -> new StakeHolderNotFoundException("No employee with id: " + id));
    }

    public Employee updateEmployee(final Long id, final Map<String ,String > employee){

        Employee foundEmployee = findById(id);

        foundEmployee.setContactEmail(employee.getOrDefault("contactEmail",foundEmployee.getContactEmail()));
        foundEmployee.setName(employee.getOrDefault("name",foundEmployee.getName()));
        foundEmployee.setSurname(employee.getOrDefault("surname",foundEmployee.getSurname()));
        foundEmployee.setPosition(employee.getOrDefault("position",foundEmployee.getPosition()));

        ValidationService.validateConstraints(foundEmployee);

        return employeeRepo.save(foundEmployee);
    }

    public void deleteById(final Long id){
        employeeRepo.deleteById(id);
    }

    public Employee saveEmployee(final Employee employee){

        ValidationService.validateConstraints(employee);

        return employeeRepo.save(employee);
    }





}
