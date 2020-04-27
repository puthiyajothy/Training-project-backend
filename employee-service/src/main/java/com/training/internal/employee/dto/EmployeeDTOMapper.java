package com.training.internal.employee.dto;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.internal.employee.dto.EmployeeDTO;
import com.training.internal.employee.entities.Employee;
import com.training.internal.employee.repositories.EmployeeRepository;
import com.training.internal.employee.services.impl.EmployeeServiceImpl;

@Service
public class EmployeeDTOMapper {
	@Autowired
	private EmployeeServiceImpl employeeServiceimp;

	@Autowired
	private EmployeeConverter employeeConverter;

	private static Logger logger = LogManager.getLogger(EmployeeRepository.class);

	@SuppressWarnings("static-access")
	// Save Method for EmployeeMapper
	public Employee saveEmployee(EmployeeDTO employeeDTO) {
		logger.info("New Employee Successfully saved");
		return employeeServiceimp.saveEmployee(EmployeeConverter.EmployeeDTOToEmployee(employeeDTO));
	}

	@SuppressWarnings("static-access")
	// List Method for EmployeeMapper
	public List<EmployeeDTO> getAllSortEmployeeInfo(Long empId) {
		logger.info(" Employee Successfully Get All Employee Details ");
		List<Employee> sortEmployeeList = employeeServiceimp.findByEmployeeOrderByEmployeeIdDesc(empId);
		return EmployeeConverter.EmployeeToEmployeeDTO(sortEmployeeList);

	}

	// GetByID Method for EmployeeMapper
	@SuppressWarnings("static-access")
	public EmployeeDTO getById(Long empId) {
		logger.info(" Employee Successfully Get By Id ");
		Employee employee = employeeServiceimp.getByempId(empId);
		return EmployeeConverter.EmployeeToEmployeeDTO(employee);

	}

	// Delete Method for EmployeeMapper
	public EmployeeDTO deleteByEmployeeId(Long empId) {
		logger.info(" successfully deleted ");
		employeeServiceimp.deleteEmployeeByempId(empId);
		return null;

	}

	// Find Employee By Email
	public EmployeeDTO getByEmployeeEmailforMapper(String email) {
		Employee employee = employeeServiceimp.getByEmail(email);
		return EmployeeConverter.EmployeeToEmployeeDTO(employee);

	}

	@SuppressWarnings({ "static-access", "unused" })
	// Update Employee
	public Employee UpdateEmployee(EmployeeDTO employeeDTO) {
		logger.info("Employee is Updated", employeeDTO.getEmpId());
		Employee employee = EmployeeConverter.EmployeeDTOToEmployee(employeeDTO);
		return employeeServiceimp.updateEmployee(EmployeeConverter.EmployeeDTOToEmployee(employeeDTO));

	}

//	@SuppressWarnings({ "static-access", "unused" })
	// Update Employee
//	public Employee UpdateBenchTrue(Long EmpId, EmployeeDTO employeeDTO) {
//		logger.info("Employee is Updated", employeeDTO.getEmpId());
//		Employee employee = EmployeeConverter.EmployeeDTOToEmployee(employeeDTO);
//		employeeService.updateBenchTrue(EmpId, employeeConverter.EmployeeDTOToEmployee(employeeDTO));
//		return employee;
//
//	}

//	@SuppressWarnings({ "static-access", "unused" })
//	// Update Employee
//	public Employee UpdateBenchFalse(Long EmpId, EmployeeDTO employeeDTO) {
//		logger.info("Employee is Updated", employeeDTO.getEmpId());
//		Employee employee = EmployeeConverter.EmployeeDTOToEmployee(employeeDTO);
//		employeeService.updateBenchFalse(EmpId, employeeConverter.EmployeeDTOToEmployee(employeeDTO));
//		return employee;
//
//	}
	@SuppressWarnings("static-access")
	// Find Employee By Designation
	public List<EmployeeDTO> getEmployeeByDesignation(Long designationid) {
		logger.info("Successfully Get Employee By Designation");
		List<Employee> employee = employeeServiceimp.getByDesignation(designationid);
		return EmployeeConverter.EmployeeToEmployeeDTO(employee);

	}

	@SuppressWarnings("static-access")
	// Find Employee By Name
	public List<EmployeeDTO> getEmployeeByName(String name) {
		logger.info("Successfully Get Employee By Name");
		List<Employee> employee = employeeServiceimp.getByName(name);
		return EmployeeConverter.EmployeeToEmployeeDTO(employee);
	}

	// Count Method for Employee
	public long getByEmployeeCountforMapper() {
		return employeeServiceimp.count();
	}
	
	
//	public List<EmployeeDTO> getAllPm() {
//		logger.info(" Employee Successfully Get All Employee Details ");
//		List<Employee> pmList = employeeServiceimp.getByDesignation(designationid);
//		return employeeConverter.EmployeeToEmployeeDTOList(pmList);
//
//	}
	
	public List<EmployeeDTO> getAllOthers() {
		logger.info(" Employee Successfully Get All Employee Details ");
		List<Employee> othersList = employeeServiceimp.getByQaAndDevelopersOnly();
		return EmployeeConverter.EmployeeToEmployeeDTO(othersList);
	}
	
	public List<EmployeeDTO> getHr() {
		logger.info(" Employee Successfully Get All Employee Details ");
		List<Employee> othersList = employeeServiceimp.getHR();
		return EmployeeConverter.EmployeeToEmployeeDTO(othersList);

	}
	
	public List<EmployeeDTO> getByEmployees(String empId,String employeeid, String name, String firstname,
			String email,String designationname){
		List<Employee> list = employeeServiceimp.getByEmployee(empId,employeeid, name, firstname, email,designationname);
				return EmployeeConverter.EmployeeToEmployeeDTO(list);
		
	}

}
