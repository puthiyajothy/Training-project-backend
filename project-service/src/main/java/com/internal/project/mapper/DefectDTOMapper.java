package com.internal.project.mapper;


import java.sql.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internal.project.converter.DefectDTOConverter;
import com.internal.project.dto.DefectDTO;
import com.internal.project.entities.Defect;
import com.internal.project.services.DefectService;

@Service
public class DefectDTOMapper {
	@Autowired
	private DefectDTOConverter defectDTOConverter;
	
	@Autowired
	private DefectService defectService;
	
	private static Logger logger = LogManager.getLogger(DefectDTO.class);
	
	@SuppressWarnings("static-access")
	public Defect createDefect(DefectDTO defectDTO) {
		logger.info("DefectData Mapper -> Defect Saved");
		return defectService.createDefect(defectDTOConverter.defectDataToDefectEntity(defectDTO));
	}
	
	@SuppressWarnings("static-access")
	public List <DefectDTO>getAllDefects(){
		logger.info("DefectData Mapper -> Defect List");
		List<Defect> defectList= defectService.getAllDefects();
		return defectDTOConverter.defectEntityToDefectData(defectList);	
		
	}
	
	public DefectDTO deleteDefect(Long defid) {
		logger.info("DefectData Mapper -> Defect deleted");
		defectService.deleteDefect(defid);
		return null;
		
	}
	
	@SuppressWarnings("static-access")
	public DefectDTO getByDefectId(Long defid) {
		logger.info("DefectData Mapper -> getByDefectId");
		Defect defect= defectService.getByDefectId(defid);
		return defectDTOConverter.defectEntityToDefectData(defect);
	}
	

	@SuppressWarnings("static-access")
	public Defect updateDefect(DefectDTO defectDTO) {
		logger.info("DefectData Mapper -> Defect Details Updated ", defectDTO.getDefid());
		return defectService.updateDefect(defectDTOConverter.defectDataToDefectEntity(defectDTO));
	}
	
	
	
	@SuppressWarnings("static-access")
	public List<DefectDTO> getAllDefectByProjectById(Long pid){
		logger.info("DefectData Mapper -> Defect List by productId");
		List<Defect> defectProject=defectService.getProjectById(pid);
		return defectDTOConverter.defectEntityToDefectData(defectProject);
	}
	
	@SuppressWarnings("static-access")
	public List<DefectDTO> getAllDefectByModuleById(Long  mid){
		logger.info("DefectData Mapper -> Defect List by moduleId");
		List<Defect> defectModule=defectService.getModuleById(mid);
		return defectDTOConverter.defectEntityToDefectData(defectModule);
		
	}
	
	@SuppressWarnings("static-access")
	public List<DefectDTO> getAllDefectByPriority(String priority) {
		List<Defect> defectPriority=defectService.getDefectByPriority(priority);
		return defectDTOConverter.defectEntityToDefectData(defectPriority);
	}
	@SuppressWarnings("static-access")
	public List<DefectDTO> getAllDefectBySeverity(String severity) {
		List<Defect> defectSeverity=defectService.getDefectBySeverity(severity);
		return defectDTOConverter.defectEntityToDefectData(defectSeverity);
	}
	@SuppressWarnings("static-access")
	public List<DefectDTO> getAllDefectByType(String type) {
		List<Defect> defectType=defectService.getDefectByType(type);
		return defectDTOConverter.defectEntityToDefectData(defectType);
	}
	
}
