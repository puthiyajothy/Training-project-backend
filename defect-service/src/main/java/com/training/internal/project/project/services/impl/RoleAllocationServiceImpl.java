package com.training.internal.project.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.internal.project.project.entities.RoleAllocation;
import com.training.internal.project.project.repositories.RoleAllocationRepository;
import com.training.internal.project.project.services.RoleAllocationService;

@Service
public class RoleAllocationServiceImpl implements RoleAllocationService {

	@Autowired
	private RoleAllocationRepository roleAllocationRepository;
	
	
	
	@Override
	public RoleAllocation createRoleAllocation(RoleAllocation roleAllocation) {
				return roleAllocationRepository.save(roleAllocation) ;
	}

	@Override
	public List<RoleAllocation> getAllRoleDetails() {
		return roleAllocationRepository.findAll();
	}

//	@Override
//	public RoleAllocation updateRoleAllocation(Long empId,RoleAllocation roleAllocation) {
//		System.out.println("serviceImpl");
	//	Long id = roleAllocation.getEmpId();
		
//		System.out.println(id);
//		boolean isExist = roleAllocationRepository.findEmployeeByEmpId(id) != null;
//		if (isExist) {
			
//			return roleAllocationRepository.save(roleAllocation);
//		} else {
//			
//		}
//
//		return null;
//}
		
		

	@Override
	public RoleAllocation getByroleId(Long roleId) {
		
		return roleAllocationRepository.getByroleId(roleId);
	}

@Override
public RoleAllocation updateRoleAllocation(Long empId, RoleAllocation roleAllocation) {
	// TODO Auto-generated method stub
	return null;
}


	}
