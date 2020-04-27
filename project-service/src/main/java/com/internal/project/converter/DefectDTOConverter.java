package com.internal.project.converter;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.internal.project.project.entities.Defect;
import com.internal.project.project.entities.Module;
import com.internal.project.project.entities.Project;
import com.internal.project.projectdto.DefectDTO;

import org.apache.logging.log4j.LogManager;

@Service
public class DefectDTOConverter {

	private static Logger logger = LogManager.getLogger(Defect.class);

//========================To list all defect details=============================================================
	public static List<DefectDTO> defectEntityToDefectData(List<Defect> defectList) {

		if (defectList != null) {
			logger.info("Coverting DefectEntity to DefectData");
			List<DefectDTO> listDefectData = new ArrayList<>();
			for (Defect defect : defectList) {
				
				DefectDTO defectDTO = new DefectDTO();

				defectDTO.setDefectId(defect.getDefectId());
							
				defectDTO.setProjectId(defect.getProject().getProjectId());
				defectDTO.setProjectName(defect.getProject().getProjectName());
				defectDTO.setModuleId(defect.getModule().getModuleId());
				defectDTO.setModuleName(defect.getModule().getModuleName());
				defectDTO.setDefectDescription(defect.getDefectDescription());
				defectDTO.setStepsToRecreate(defect.getStepsToRecreate());
				defectDTO.setAssignTo(defect.getAssignTo());
				defectDTO.setReassignTo(defect.getReassignTo());
				defectDTO.setEnteredBy(defect.getEnteredBy());
				defectDTO.setFixedBy(defect.getFixedBy());
                defectDTO.setAbbre(defect.getAbbre());
				defectDTO.setDateAndTime(defect.getDateAndTime());
				defectDTO.setAvailableIn(defect.getAvailableIn());
				defectDTO.setFoundIn(defect.getFoundIn());
				defectDTO.setFixedIn(defect.getFixedIn());
				 defectDTO.setSeverity(defect.getSeverity());
				 defectDTO.setPriority(defect.getPriority());
				 defectDTO.setType(defect.getType());
				 defectDTO.setStatus(defect.getStatus());
				//defectData.setName(defect.getDefectConfig().getName());
				
				listDefectData.add(defectDTO);

			}
			return listDefectData;
		}
		return null;
	}

//========================To convert DefectEntity to DefectDTO =====================================================

	@SuppressWarnings("unused")
	public static DefectDTO defectEntityToDefectData(Defect defect) {
		DefectDTO defectDTO = new DefectDTO();

		if (defectDTO != null) {
			logger.info("Coverting DefectEntity to DefectDTO");

			defectDTO.setDefectId(defect.getDefectId());
			defectDTO.setProjectId(defect.getProject().getProjectId());
			defectDTO.setProjectName(defect.getProject().getProjectName());
			defectDTO.setModuleId(defect.getModule().getModuleId());
			defectDTO.setModuleName(defect.getModule().getModuleName());
			defectDTO.setDefectDescription(defect.getDefectDescription());
			defectDTO.setStepsToRecreate(defect.getStepsToRecreate());
			defectDTO.setAssignTo(defect.getAssignTo());
			defectDTO.setReassignTo(defect.getReassignTo());
			defectDTO.setEnteredBy(defect.getEnteredBy());
			defectDTO.setFixedBy(defect.getFixedBy());
			defectDTO.setDateAndTime(defect.getDateAndTime());
			defectDTO.setAvailableIn(defect.getAvailableIn());
			defectDTO.setFoundIn(defect.getFoundIn());
			defectDTO.setFixedIn(defect.getFixedIn());
			 defectDTO.setAbbre(defect.getAbbre());
			 defectDTO.setSeverity(defect.getSeverity());
			 defectDTO.setPriority(defect.getPriority());
			 defectDTO.setType(defect.getType());
			 defectDTO.setStatus(defect.getStatus());
				//defectData.setName(defect.getDefectConfig().getName());
			return defectDTO;
		}
		return null;
	}

	
//========================To convert DefectDTO to DefectEntity =====================================================
	
	public static Defect defectDataToDefectEntity(DefectDTO defectDTO) {
		Defect defect = new Defect();
		if (defectDTO != null) {
			logger.info("Coverting DefectData to DefectEntity");
			
			Project project = new Project();
			Module module = new Module();
			
			module.setModuleId(defectDTO.getModuleId());
			defect.setDefectId(defectDTO.getDefectId());
			project.setProjectId(defectDTO.getProjectId());
			defect.setProject(project);
			defect.setModule(module);
			defect.setDefectDescription(defectDTO.getDefectDescription());
			defect.setStepsToRecreate(defectDTO.getStepsToRecreate());
			defect.setAssignTo(defectDTO.getAssignTo());
			defect.setReassignTo(defectDTO.getReassignTo());
			defect.setEnteredBy(defectDTO.getEnteredBy());
			defect.setFixedBy(defectDTO.getFixedBy());
			defect.setDateAndTime(defectDTO.getDateAndTime());
			defect.setAvailableIn(defectDTO.getAvailableIn());
			defect.setFoundIn(defectDTO.getFoundIn());
			defect.setFixedIn(defectDTO.getFixedIn());
			 defect.setAbbre(defectDTO.getAbbre());
			 defect.setSeverity(defectDTO.getSeverity());
			 defect.setPriority(defectDTO.getPriority());
			 defect.setType(defectDTO.getType());
			 defect.setStatus(defectDTO.getStatus());
			return defect;
		}
		return null;
	}

}
