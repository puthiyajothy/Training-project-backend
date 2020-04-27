package com.training.internal.employee.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.training.internal.employee.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// Find Employee By ID Method
		Employee findEmployeeByEmpId(Long empId);

		// Find Employee By Email
		Employee findEmployeeByEmail(String email);

		// Find Employee By Designation
		@Query(value = "from Employee where designationid = :designationid")
		List<Employee> findByDesignation(Long designationid);

		// Find Employee By Name
		@Query(value = "from Employee where name = :name")
		List<Employee> findByName(String name);

		// Find Employee By DesignationId
		@Query("SELECT COUNT(designationid) FROM Employee WHERE designationid=:designationid")
		Long getDeveloperCount(Long designationid);

		// Find Employee By Designation Name
		@Query("SELECT designationid FROM Designation WHERE designationname=:designationName")
		Long countByDesignationName(String designationName);
		
		String fetchAllSubjectId = "SELECT e.name FROM employee e WHERE e.designationid in (SELECT designationid from designation d where d.designationname=:designationname)";
		@Query(value = fetchAllSubjectId, nativeQuery = true)
		<T> List<T> getAllByDesignationName(String designationname);	


		String fetchEmployeeByDesignation = "SELECT * FROM employee e WHERE e.availability>0 and e.designationid in (SELECT designationid from designation d where d.designationname=\"PM\")";
		@Query(value = fetchEmployeeByDesignation, nativeQuery = true)
		List<Employee> getEmployeeByDesigName();
		
		String fetchQAAndDeveolersOnly = "SELECT * FROM employee e WHERE e.designationid in (SELECT designationid from designation d where d.designationname!=\"HR\")";
		@Query(value = fetchQAAndDeveolersOnly, nativeQuery = true)
		List<Employee> getQaAndDevelopers();
		
		String fetchHrOnly = "SELECT * FROM employee e WHERE e.designationid in (SELECT designationid from designation d where d.designationname=\"HR\")";
		@Query(value = fetchHrOnly, nativeQuery = true)
		List<Employee> getHrOnly();
		
		String query = "SELECT * FROM employee inner join designation on employee.designationid = designation.designationid WHERE (emp_id = :empId OR employee_id = :employeeid OR name = :name OR firstname = :firstname OR email = :email OR designationname = :designationname )";
		@Query(value = query , nativeQuery = true)
		List<Employee> findEmployeeByEmployeeidOrNameOrFirstnameOrEmail(@Param("empId")String empId, @Param("employeeid") String employeeid,@Param("name") String name,@Param("firstname") String firstname,@Param("email") String email, @Param("designationname") String designationname);

}