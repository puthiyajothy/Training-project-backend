package com.training.internal.employee.services.impl;

import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.training.internal.employee.entities.Employee;
import com.training.internal.employee.repositories.EmployeeRepository;
import com.training.internal.employee.services.EmployeeService;
import com.training.internal.employee.util.ExcelUtils;

@Service
//Implement from Employee Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	private static Logger logger = LogManager.getLogger(EmployeeRepository.class);

	@Override
	// Save Employee
	public Employee saveEmployee(Employee employee) {

		try {
			logger.info("Employee Service Imp:--> Save Employee Details methods");
			return employeeRepository.save(employee);
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
		return null;

	}

	@Override
	// List Employee
	public List<Employee> findByEmployeeOrderByEmployeeIdDesc(Long empId) {
		try {
			logger.info("Employee Service Imp:--> Get All Employee Details Methods");
			return employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "empId"));
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
		return null;

	}

	@Override
	// Find By Employee Id
	public Employee getByempId(Long empId) {
		try {
			logger.info("Employee Service Imp:-->Get By Employee ID Methods");
			return employeeRepository.findEmployeeByEmpId(empId);
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
		return null;

	}

	@Override
	// Delete Employee
	public void deleteEmployeeByempId(Long empId) {
		try {
			logger.info("Delete Employee Details Methods");
			employeeRepository.deleteById(empId);
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}

	}

	@Override
	// Update Employee
	public Employee updateEmployee(Employee employee) {
		try {
			Long empId = employee.getEmpId();
			boolean isExist = employeeRepository.findEmployeeByEmpId(empId) != null;
			if (isExist) {
				logger.info("Employee updates Successfully");
				return employeeRepository.save(employee);
			} else {
				logger.info("Employee Id is Not Found");
			}

		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}

		return null;
	}

	@Override
	// Find By Employee Email
	public Employee getByEmail(String email) {
		try {
			logger.info("Successfully Get Employee By Email");
			return employeeRepository.findEmployeeByEmail(email);
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
		return null;

	}

	@Override
	// Find By Employee Name
	public List<Employee> getByName(String name) {
		try {
			logger.info("Successfully Get Employee By Name");
			return employeeRepository.findByName(name);
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
		return null;

	}

	@Override
	// Find By Employee Designation
	public List<Employee> getByDesignation(Long designationid) {
		try {
			logger.info("Successfully Get Employee By Designation");
			return employeeRepository.findByDesignation(designationid);
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
		return null;

	}

	@Override
//	Employee Table Count method
	public long count() {
		try {
			return employeeRepository.count();
		} catch (Exception ex) {
			logger.error("Employee Service Imp:--> Error" + ex.getMessage());
		}
		return 0;

	}

	@Override
	// Save Customers to DataBase
	public void store(MultipartFile file) {
		try {
			List<Employee> lstCustomers = ExcelUtils.parseExcelFile(file.getInputStream());
			employeeRepository.saveAll(lstCustomers);
		} catch (IOException e) {
			throw new RuntimeException("FAIL! -> message = " + e.getMessage());
		}
	}

	@Override
	public long countDeveloper(Long designationid) {
		return employeeRepository.getDeveloperCount(designationid);
	}

	@Override
	public long countDeveloperby(String designationname) {
		return employeeRepository.countByDesignationName(designationname);
	}

	@Override
	public List<Employee> getBydesignationname() {// TODO Auto-generated method stub
		return employeeRepository.getEmployeeByDesigName();
	}

	@Override
	public List<Employee> getByQaAndDevelopersOnly() {
		return employeeRepository.getQaAndDevelopers();
	}

	@Override
	public List<Employee> getHR() {
		return employeeRepository.getHrOnly();
	}

	@Override
	public List<Employee> getByEmployee(String empId, String employeeid, String name, String firstname, String email,
			String designationname) {
		return employeeRepository.findEmployeeByEmployeeidOrNameOrFirstnameOrEmail(empId, employeeid, name, firstname,
				email, designationname);
	}

}