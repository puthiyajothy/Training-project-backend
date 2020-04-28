package com.internal.project.services.impl;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.internal.project.project.entities.Defect;
import com.internal.project.project.repositories.DefectRepository;
import com.internal.project.project.services.DefectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Service
public class DefectServiceImpl implements DefectService {
	@Autowired
	private DefectRepository defectRepository;

	private static Logger logger = LogManager.getLogger(DefectRepository.class);

	@Override
	public Defect createDefect(Defect defect) {
		logger.info("DefectService started -> SaveAllDefects");
		return defectRepository.save(defect);
	}

	@Override
	public Defect getByDefectId(Long defid) {
		logger.info("DefectService started -> GetAllDefectById");
		
		return defectRepository.getByDefectId(defid);
	}

	@Override
	public Defect updateDefect(Defect defect) {

		logger.info("DefectService started -> updateDefect");
		Long defid = defect.getDefid();
		logger.info("DefectService started -> getDefectId");
		boolean isExist = defectRepository.getByDefectId(defid) != null;
		if (isExist) {
			logger.info("DefectService started -> Updateed By DefectId");
			return defectRepository.save(defect);
		} else {
			logger.info("DefectService started -> DefectId Not Found");
		}
		return null;
	}

	@Override
	public Defect deleteDefect(Long defid) {
		logger.info("DefectService started -> DeleteDefectById");
		defectRepository.deleteById(defid);
		return null;
	}

	@Override
	public List<Defect> getAllDefects() {
		logger.info("DefectService started -> ListAllDefects");
		return defectRepository.findAll();
	}

	@Override
	public List<Defect> getProjectById(Long defid) {
		logger.info("DefectService started -> getProjectById");
		return defectRepository.getByProjectId(defid);
	}

	@Override
	public List<Defect> getModuleById(Long mid) {
		logger.info("DefectService started -> getModuleById");
		return defectRepository.getByModuleId(mid);
	}

	@Override
	public boolean isDefectAlreadyExist(Long mid) {
		logger.info("DefectService started -> isDefectAlreadyExist");
		return defectRepository.existsById(mid);
	}

	@Override
	public List<Defect> getDefectByDate(Date dateAndTime) {
		logger.info("DefectService started -> getDefectByDate");
		return defectRepository.getByDefectDate(dateAndTime);
	}

	@Override
	public Defect updateDefectStatus(int statusId) {
		return null;
	}

	@Override
	public Defect updateReassignTo(String reassignTo) {

		return null;
	}

	@Override
	public Defect updateDefectComment(int commentId) {

		return null;
	}

	@Override
	public Defect updateDefectAttachment(int attachmentId) {

		return null;
	}

	@Override
	public List<Defect> getDefectByAvailableIn(String availableIn) {
		logger.info("DefectService started -> getDefectByAvailableIn");
		return defectRepository.getByAvailableIn(availableIn);
	}

	@Override
	public List<Defect> getDefectByFoundIn(String foundIn) {
		logger.info("DefectService started -> getDefectByFoundIn");
		return defectRepository.getByFoundIn(foundIn);
	}

	@Override
	public List<Defect> getDefectByFixedIn(String fixedIn) {
		logger.info("DefectService started -> getDefectByfixedIn");
		return defectRepository.getByFixedIn(fixedIn);
	}

	@Override
	public List<Defect> getDefectByStatus(String status) {
		logger.info("DefectService started -> getDefectByStatus");
		return defectRepository.getByStatus(status);
	}

	@Override
	public List<Defect> getDefectByPriority(String priority) {
		logger.info("DefectService started -> getDefectByPriority");
		return defectRepository.getByPriority(priority);
	}

	@Override
	public List<Defect> getDefectBySeverity(String severity) {
		logger.info("DefectService started -> getDefectBySeverity");
		return defectRepository.getBySeverity(severity);
	}

	@Override
	public List<Defect> getDefectByType(String type) {
		logger.info("DefectService started -> getDefectByType");
		return defectRepository.getByType(type);
	}

	@Override
	public Long countDefect() {
		Long totCount = defectRepository.count();
		System.out.println("total count " + totCount);
		Long totRejCount = defectRepository.countByStatus("rejected");
		System.out.println("rejected count " + totRejCount);
		Long ratio = ((totCount - totRejCount) * 100) / totCount;
		System.out.println("ratio " + ratio);
		return ratio;
	}

	@Override
	public double countDefectDensity() {

		double kloc = 5000;
		double defectCount = defectRepository.count();
		System.out.println("Total count :" + defectCount);
		double defectDen = defectCount * (1000 / kloc);
		System.out.println("Ratio :" + defectDen);
		return defectDen;
	}

	// Hari matrix
	@Override
	public Long getStatusNew() {
		Long totNew = defectRepository.countByStatus("New");
		return totNew;
	}

	@Override
	public Long getStatusOpen() {
		Long totOpen = defectRepository.countByStatus("Open");
		return totOpen;
	}

	@Override
	public Long getStatusClose() {
		Long totClose = defectRepository.countByStatus("Close");
		return totClose;
	}

	@Override
	public Long getStatusRejected() {
		Long totRej = defectRepository.countByStatus("Rejected");
		return totRej;
	}

	@Override
	public Long getStatusDefered() {
		Long totDefered = defectRepository.countByStatus("Defered");
		return totDefered;
	}

	@Override
	public Long getStatusReOpen() {
		Long totReOpen = defectRepository.countByStatus("ReOpen");
		return totReOpen;
	}

	@Override
	public Long getStatusFixed() {
		Long totFixed = defectRepository.countByStatus("Fixed");
		return totFixed;
	}

}
