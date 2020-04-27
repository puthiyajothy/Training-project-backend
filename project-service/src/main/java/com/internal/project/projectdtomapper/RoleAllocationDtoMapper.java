package com.internal.project.projectdtomapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internal.project.converter.RoleAllocationConverter;
import com.internal.project.project.entities.RoleAllocation;
import com.internal.project.project.services.RoleAllocationService;
import com.internal.project.projectdto.RoleAllocationDto;


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

