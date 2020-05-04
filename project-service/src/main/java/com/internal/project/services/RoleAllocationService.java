package com.internal.project.services;

import java.util.List;

import com.internal.project.entities.RoleAllocation;


public interface RoleAllocationService {
	
	public RoleAllocation createRoleAllocation (RoleAllocation  roleAllocation);
	
	public List <RoleAllocation> getAllRoleDetails();
	
	public RoleAllocation updateRoleAllocation(Long empId,RoleAllocation roleAllocation);
	
	public RoleAllocation getByroleId( Long roleId);
	
	public List<RoleAllocation> findByProjectRoleAllocationOrderByRoleAllocationIdDesc(Long projectroleId);

	public RoleAllocation getByprojectRoleId(Long projectroleId);

	public RoleAllocation deleteProjectByprojectId(Long projectroleId);

	public List<RoleAllocation> getroleByProject(Long resourceId);
	
	public List<RoleAllocation> getByQaAndDevelopersOnly();


}
