package com.training.internal.project.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.internal.project.project.controller.dto.RoleAllocationDto;
import com.training.internal.project.project.controller.dto.mapper.RoleAllocationDtoMapper;
import com.training.internal.project.project.entities.RoleAllocation;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RoleAllocationController {

	@Autowired
	private RoleAllocationDtoMapper roleAllocationDtoMapper;

	@PostMapping(value = "/createroleallocation")
	public ResponseEntity<Object> createRoleAllocation(@Valid @RequestBody RoleAllocationDto roleAllocationDto) {
//		return roleAllocationDtoMapper.createRole(roleAllocationDto);
		roleAllocationDtoMapper.saveRoleAllocationforMapper(roleAllocationDto);
		return null;
	}

	@GetMapping(value = "/GetAllRole")
	public ResponseEntity<List<RoleAllocationDto>> listroleInfo() {
		return new ResponseEntity<>(roleAllocationDtoMapper.getllRoleAllocationForMapper(), HttpStatus.OK);

	}

	@PutMapping("updaterole/{empId}")
	public ResponseEntity<Long> updateRoleAllocation(@PathVariable("empId") Long empId,
			@RequestBody RoleAllocationDto roleAllocationDto) {
		if (roleAllocationDtoMapper.UpdateRoleAllocation(empId, roleAllocationDto) != null)
			;
		{
			return new ResponseEntity<Long>(HttpStatus.OK);
		}

	}

}
