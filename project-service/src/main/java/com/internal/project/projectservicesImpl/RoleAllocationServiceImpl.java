package com.internal.project.projectservicesImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.internal.project.entities.RoleAllocation;
import com.internal.project.repositories.RoleAllocationRepository;
import com.internal.project.services.RoleAllocationService;

@Service
public class RoleAllocationServiceImpl implements RoleAllocationService {

	@Autowired
	private RoleAllocationRepository roleAllocationRepository;

	@Override
	public RoleAllocation createRoleAllocation(RoleAllocation roleAllocation) {
		return roleAllocationRepository.save(roleAllocation);
	}

	@Override
	public List<RoleAllocation> getAllRoleDetails() {
		return roleAllocationRepository.findAll();
	}

//	@Override
//	public RoleAllocation updateRoleAllocation(Long empId,RoleAllocation roleAllocation) {
//		System.out.println("serviceImpl");
	// Long id = roleAllocation.getEmpId();

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

	@Override
	public List<RoleAllocation> findByProjectRoleAllocationOrderByRoleAllocationIdDesc(Long projectroleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleAllocation getByprojectRoleId(Long projectroleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleAllocation deleteProjectByprojectId(Long projectroleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleAllocation> getroleByProject(Long resourceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleAllocation> getByQaAndDevelopersOnly() {
		// TODO Auto-generated method stub
		return null;
	}

}
