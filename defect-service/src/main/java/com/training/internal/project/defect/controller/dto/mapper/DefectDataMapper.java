package com.training.internal.project.defect.controller.dto.mapper;


import java.sql.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.internal.project.defect.controller.dto.DefectDTO;
import com.training.internal.project.defect.controller.dto.converter.DefectDataConverter;
import com.training.internal.project.defect.entities.Defect;
import com.training.internal.project.defect.services.DefectService;

@Service
public class DefectDataMapper {
	@Autowired
	private DefectDataConverter defectDataConverter;
	
	@Autowired
	private DefectService defectService;
	
	private static Logger logger = LogManager.getLogger(DefectDTO.class);
	
	@SuppressWarnings("static-access")
	public Defect createDefect(DefectDTO defectDTO) {
		logger.info("DefectData Mapper -> Defect Saved");
		return defectService.createDefect(defectDataConverter.defectDataToDefectEntity(defectDTO));
	}
	
	@SuppressWarnings("static-access")
	public List <DefectDTO>getAllDefects(){
		logger.info("DefectData Mapper -> Defect List");
		List<Defect> defectList= defectService.getAllDefects();
		return defectDataConverter.defectEntityToDefectData(defectList);	
		
	}
	
	public DefectDTO deleteDefect(String defectId) {
		logger.info("DefectData Mapper -> Defect deleted");
		defectService.deleteDefect(defectId);
		return null;
		
	}
	
	@SuppressWarnings("static-access")
	public DefectDTO getByDefectId(String defectId) {
		logger.info("DefectData Mapper -> getByDefectId");
		Defect defect= defectService.getByDefectId(defectId);
		return defectDataConverter.defectEntityToDefectData(defect);
	}
	

	@SuppressWarnings("static-access")
	public Defect updateDefect(DefectDTO defectDTO) {
		logger.info("DefectData Mapper -> Defect Details Updated ", defectDTO.getDefectId());
		return defectService.updateDefect(defectDataConverter.defectDataToDefectEntity(defectDTO));
	}
	
	
	
	@SuppressWarnings("static-access")
	public List<DefectDTO> getAllDefectByProjectById(String projectId){
		logger.info("DefectData Mapper -> Defect List by productId");
		List<Defect> defectProject=defectService.getProjectById(projectId);
		return defectDataConverter.defectEntityToDefectData(defectProject);
	}
	
	@SuppressWarnings("static-access")
	public List<DefectDTO> getAllDefectByModuleById(String moduleId){
		logger.info("DefectData Mapper -> Defect List by moduleId");
		List<Defect> defectModule=defectService.getModuleById(moduleId);
		return defectDataConverter.defectEntityToDefectData(defectModule);
		
	}
	
	
	@SuppressWarnings("static-access")
	public List<DefectDTO> getAllDefectByDate(Date dateAndTime){
		logger.info("DefectData Mapper -> Defect List by dateandTimeId ");
		List<Defect> defectDateandTime=defectService.getDefectByDate(dateAndTime);
		return defectDataConverter.defectEntityToDefectData(defectDateandTime);
	}
	
	@SuppressWarnings("static-access")
	public List<DefectDTO> getAllDefectByAvailableIn(String availableIn){
		List<Defect> defectAvailableIn=defectService.getDefectByAvailableIn(availableIn);
		return defectDataConverter.defectEntityToDefectData(defectAvailableIn);
		
	}
	@SuppressWarnings("static-access")
	public List<DefectDTO> getAllDefectByFoundIn(String foundIn){
		List<Defect> defectFoundIn=defectService.getDefectByFoundIn(foundIn);
		return defectDataConverter.defectEntityToDefectData(defectFoundIn);
		
	}
	@SuppressWarnings("static-access")
	public List<DefectDTO> getAllDefectByFixedIn(String fixedIn){
		List<Defect> defectFixedIn=defectService.getDefectByFixedIn(fixedIn);
		return defectDataConverter.defectEntityToDefectData(defectFixedIn);
		
	}
	@SuppressWarnings("static-access")
	public List<DefectDTO> getAllDefectByStatus(String status) {
		List<Defect> defectStatus=defectService.getDefectByStatus(status);
		return defectDataConverter.defectEntityToDefectData(defectStatus);
	}
	@SuppressWarnings("static-access")
	public List<DefectDTO> getAllDefectByPriority(String priority) {
		List<Defect> defectPriority=defectService.getDefectByPriority(priority);
		return defectDataConverter.defectEntityToDefectData(defectPriority);
	}
	@SuppressWarnings("static-access")
	public List<DefectDTO> getAllDefectBySeverity(String severity) {
		List<Defect> defectSeverity=defectService.getDefectBySeverity(severity);
		return defectDataConverter.defectEntityToDefectData(defectSeverity);
	}
	@SuppressWarnings("static-access")
	public List<DefectDTO> getAllDefectByType(String type) {
		List<Defect> defectType=defectService.getDefectByType(type);
		return defectDataConverter.defectEntityToDefectData(defectType);
	}
	
}
