package com.training.internal.project.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.training.internal.project.project.entities.Module;
import com.training.internal.project.project.entities.RoleAllocation;
import com.training.internal.project.project.entities.SubModule;


public interface RoleAllocationRepository  extends JpaRepository<RoleAllocation, Long> {
	// Find Employee By ID Method
//	RoleAllocation findEmployeeByEmpId(Long empId);

	RoleAllocation getByroleId(Long roleId);
//	 RoleAllocation getByempId(Long empId);
	
}
