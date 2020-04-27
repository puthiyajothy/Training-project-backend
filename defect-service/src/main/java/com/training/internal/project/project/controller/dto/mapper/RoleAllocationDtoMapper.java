package com.training.internal.project.project.controller.dto.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.internal.project.project.controller.converter.RoleAllocationConverter;
import com.training.internal.project.project.controller.dto.RoleAllocationDto;
import com.training.internal.project.project.entities.RoleAllocation;
import com.training.internal.project.project.services.RoleAllocationService;


@Service
public class RoleAllocationDtoMapper {
	
	
	@Autowired
	private RoleAllocationService  roleAllocationService;
	
	
	public RoleAllocation saveRoleAllocationforMapper(RoleAllocationDto roleAllocationDto) {
		RoleAllocation roleAllocation = RoleAllocationConverter.roleAllocationDtoToRoleAllocation(roleAllocationDto);				
			return roleAllocationService.createRoleAllocation(roleAllocation);
		
	}
	
	
	public List<RoleAllocationDto>getllRoleAllocationForMapper(){
		List<RoleAllocation>roleAllocationList=roleAllocationService.getAllRoleDetails();
		return RoleAllocationConverter.roleAllocationToRoleAllocationDto(roleAllocationList);
		}
	
	public RoleAllocationDto getByroleId(Long roleId) {
		RoleAllocation roleAllocation= roleAllocationService.getByroleId(roleId);
		return RoleAllocationConverter.roleAllocationToRoleAllocationDto(roleAllocation);
		
	}
	
	public RoleAllocation UpdateRoleAllocation (Long empId,RoleAllocationDto roleAllocationDto ) {
		RoleAllocation roleAllocation = RoleAllocationConverter.roleAllocationDtoToRoleAllocation(roleAllocationDto);
	  return roleAllocationService.updateRoleAllocation(empId,roleAllocation);
	}
	
		}

