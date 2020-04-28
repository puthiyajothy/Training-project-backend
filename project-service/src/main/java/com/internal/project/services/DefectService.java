package com.internal.project.services;


import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.internal.project.entities.Defect;

@Service
public interface DefectService {

	public Defect createDefect(Defect defect);   
	public Defect getByDefectId(Long defid);
	public Defect updateDefect(Defect defect);
	public Defect deleteDefect(Long defid);   
	public List<Defect> getAllDefects(); 
	
	public Defect updateDefectStatus(int statusId); 
	public Defect updateReassignTo(String reassignTo); 
	public Defect updateDefectComment(int commentId); 
	public Defect updateDefectAttachment(int attachmentId);
	public List<Defect> getProjectById (Long pid); 
	public List<Defect> getModuleById (Long pid); 
	public List<Defect> getDefectByAvailableIn (String availableIn);
	public List<Defect> getDefectByFoundIn (String foundIn);
	public List<Defect> getDefectByFixedIn (String fixedIn);
	
	public List<Defect> getDefectByDate (Date dateAndTime);
	public boolean isDefectAlreadyExist(Long defid);
	public List<Defect> getDefectByStatus(String status); 
	public List<Defect> getDefectByPriority(String priority);
	public List<Defect> getDefectBySeverity(String severity);
	public List<Defect> getDefectByType(String type);
	
	public Long countDefect();
	public double countDefectDensity();
	
	public Long getStatusNew(); 
	public Long getStatusOpen();
	public Long getStatusClose();
	public Long getStatusRejected();
	public Long getStatusDefered();
	public Long getStatusReOpen();
	public Long getStatusFixed();
	     	
}
