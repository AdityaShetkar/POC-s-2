package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@GetMapping("/")
	public String getHome() {
		return "Home";
	}

	@GetMapping(value = "/getAll")
	public List<Employee> get(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "4", required = false) int pageSize) {
		return employeeServiceImpl.getPagi(pageNumber, pageSize);
	}

	@PostMapping("/save")
	public Employee save(@RequestBody Employee employeeObj) {
		employeeServiceImpl.save(employeeObj);
		return employeeObj;
	}

	@GetMapping("/getById/{eid}")
	public Optional<Employee> get(@PathVariable int eid) {
		Optional<Employee> employeeObj = employeeServiceImpl.get1(eid);
		System.out.println(employeeObj);
		if (employeeObj == null) {
			throw new RuntimeException("Employee with id " + eid + " is not found");
		}
		return employeeServiceImpl.get1(eid);
	}

	@GetMapping("/getByName/{name}")
	public Optional<Employee> get(@PathVariable String empname) {
		Optional<Employee> optional = employeeServiceImpl.get(empname);
		if (optional == null) {
			throw new RuntimeException("Employee with name " + empname + " is not found");
		}
		return employeeServiceImpl.get(empname);
	}

//	@DeleteMapping("/delete/{e_id}")
//	public String delete(@PathVariable int e_id) {
//		employeeServiceImpl.delete1(e_id);
//		return "Employee has been deleted with id: " + e_id;
//	}

	@DeleteMapping("/delete/{name}")
	public String delete(@PathVariable String empname) {
		employeeServiceImpl.delete(empname);
		return "Employee has been deleted with id: " + empname;
	}

}
