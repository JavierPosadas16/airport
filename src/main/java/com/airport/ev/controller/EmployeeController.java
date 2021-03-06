package com.airport.ev.controller;
import com.airport.ev.exception.Mensaje;
import com.airport.ev.model.Employee;
import com.airport.ev.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/apiv1")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/clientes/add")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok().body(this.employeeService.createEmployee(employee));
	}


	//Lista todos los empleados
	@GetMapping("/listaEmpleados")
	public ResponseEntity<?> getAllEmployee() {
		List<Employee> lista = employeeService.getAllEmployee();
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin Info en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(employeeService.getAllEmployee());
	}
	//Lista empleado por Id
	@GetMapping("/empleado/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
	}

	//Actualiza empleado
	@PutMapping("/actualizarEmpleado/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
		employee.setId(id);
		return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
	}

	//elimina empleado
	@DeleteMapping("/eliminaLenguaje/{id}")
	public HttpStatus deleteEmployee(@PathVariable long id) {
		this.employeeService.deleteEmployee(id);
		return HttpStatus.OK;
	}
}