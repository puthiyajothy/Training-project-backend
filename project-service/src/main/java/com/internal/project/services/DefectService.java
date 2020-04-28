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
	public List<Defect> getProjectById (Long projectid); 
	public List<Defect> getModuleById (Long projectid);  
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
