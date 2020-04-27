package com.training.internal.employee.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.internal.employee.dto.DesignationConverter;
import com.training.internal.employee.dto.DesignationDTO;
import com.training.internal.employee.entities.Designation;
import com.training.internal.employee.services.impl.DesignationServiceImpl;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DesignationController {

	@Autowired
	private DesignationServiceImpl designationserviceimpl;
	
	@Autowired
	private DesignationConverter designationConverter;

	private static Logger logger = LogManager.getLogger(DesignationServiceImpl.class);

	@SuppressWarnings("static-access")
	@PostMapping(value = "/createdesignation")
//	<---Save New Designation API--->
	public Designation savedesignation(@RequestBody DesignationDTO designationDTO) {
		logger.info("Designation Controller -> New Designation Created succesfully");
//		return designationserviceimpl.savedesignation(designation);
		return designationserviceimpl.savedesignation(designationConverter.DesignationDTOToDesignation(designationDTO));

	}
	
	@SuppressWarnings("static-access")
	@GetMapping(value = "/getAllDesignation")
//	<---List All Designation-->
	public List<DesignationDTO> getAllDesignation() {
		logger.info("Designation Controller -> GetDesignation");
		List<Designation> designationlist = designationserviceimpl.getAllDesignation();
		return designationConverter.DesignationToDesignationDTO(designationlist);

	}

	@GetMapping("/getbydesignationId/{designationid}")
	// <---Get Designation By Designation ID--->
	public ResponseEntity<Designation> getDesignationById(@PathVariable(name = "designationid") Long designationid) {
		logger.info("Designation Controller --> Get by Designation by Id");
		return new ResponseEntity<>(designationserviceimpl.getBydesignationid(designationid), HttpStatus.OK);
	}

}
