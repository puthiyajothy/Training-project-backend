package com.training.internal.project.project.services;

import java.util.List;

import com.training.internal.project.project.entities.RoleAllocation;


public interface RoleAllocationService {
	
	public RoleAllocation createRoleAllocation (RoleAllocation  roleAllocation);
	
	
	public List <RoleAllocation> getAllRoleDetails();
	
	public RoleAllocation updateRoleAllocation(Long empId,RoleAllocation roleAllocation);
	
	public RoleAllocation getByroleId( Long roleId);


}
