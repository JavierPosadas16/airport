package com.airport.ev.service;
import com.airport.ev.model.Employee;
import com.airport.ev.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
/***
        LanguageServiceImp ln = new LanguageServiceImp();
        CountryServiceImp co = new CountryServiceImp();
        AirportServiceImp ai = new AirportServiceImp();
        employeeRepository.save(employee);
        ai.createAirport(employee.getAirport());***/

        return employeeRepository.save(employee);
    }
    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> EmployeeT = this.employeeRepository.findById(employee.getId());

        if (EmployeeT.isPresent()) {
            Employee updateEmployee = EmployeeT.get();
            updateEmployee.setId(employee.getId());
            updateEmployee.setSurname(employee.getSurname());
            updateEmployee.setFirstname(employee.getFirstname());
            updateEmployee.setLanguage(employee.getLanguage());
            updateEmployee.setCountry(employee.getCountry());
            updateEmployee(updateEmployee);
            return updateEmployee;
        } else {
            try {
                throw new Exception("Empleado no econtrado con el id: " + employee.getId());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long EmployeeId) {
        Optional<Employee> EmployeeT = this.employeeRepository.findById(EmployeeId);

        if (EmployeeT.isPresent()) {
            return EmployeeT.get();
        } else {
            try {
                throw new Exception("Aereopuerto no econtrado con el id: " + EmployeeId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void deleteEmployee(long EmployeeId) {
        Optional<Employee> EmployeeT = this.employeeRepository.findById(EmployeeId);

        if (EmployeeT.isPresent()) {
            this.employeeRepository.delete(EmployeeT.get());
        } else {
            try {
                throw new Exception("Aereopuerto no econtrado con el id: " + EmployeeId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
