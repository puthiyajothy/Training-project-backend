package com.internal.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internal.project.entities.RoleAllocation;

public interface RoleAllocationRepository extends JpaRepository<RoleAllocation, Long> {
	// Find Employee By ID Method
//	RoleAllocation findEmployeeByEmpId(Long empId);

	RoleAllocation getByroleId(Long roleId);
//	 RoleAllocation getByempId(Long empId);

}
