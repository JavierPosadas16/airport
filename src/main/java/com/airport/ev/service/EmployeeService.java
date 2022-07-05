package com.airport.ev.service;
import com.airport.ev.model.Employee;

import java.util.List;


public interface EmployeeService {
	Employee updateEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(long employeeId);
	void deleteEmployee(long id);
}
