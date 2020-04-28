package com.internal.project.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.internal.project.entities.Defect;
import com.internal.project.entities.Module;

public interface DefectRepository extends JpaRepository<Defect, Long> {

	Defect getByDefectId(Long defid);

	@Query(value = "FROM Defect WHERE projectid =:projectid")
	List<Defect> getByProjectId(@Param("projectid") Long pid);

	@Query(value = "FROM Defect WHERE mid =:mid")
	List<Defect> getByModuleId(@Param("mid") Long moduleId);
	
	List<Defect> findDefectByModule(Module module);

//	@Query(value = "SELECT d FROM Defect d WHERE status =:status")
//	List<Defect> getByStatus(@Param("status") String status);

	@Query(value = "SELECT d FROM Defect d WHERE priority =:priority")
	List<Defect> getByPriority(@Param("priority") String priority);

	@Query(value = "SELECT d FROM Defect d WHERE severity =:severity")
	List<Defect> getBySeverity(@Param("severity") String severity);

	@Query(value = "SELECT d FROM Defect d WHERE type =:type")
	List<Defect> getByType(@Param("type") String type);

	Long countByStatus(String status);

//@Query("SELECT COUNT(*) FROM Defect d WHERE d.status=:rejected")
//Long countRejectedDefect(@Param("rejected") String defectId);

//For Severity Index Start
	@Query("SELECT COUNT(severity) FROM Defect WHERE severity='Low'")
	int countBySeverity();

	@Query("SELECT COUNT(severity) FROM Defect WHERE severity='Medium'")
	int countBySeverityMedium();

	@Query("SELECT COUNT(severity) FROM Defect WHERE severity='High'")
	int countBySeverityhigh();

	@Query("SELECT COUNT(status) FROM Defect WHERE status='Rejected' ")
	int countByStatusRejected();

	public long count();

	@Query("SELECT highWeight FROM SeverityWeight")
	int getHighWeight();

	@Query("SELECT mediumWeight FROM SeverityWeight")
	int getMediumWeight();

	@Query("SELECT lowWeight FROM SeverityWeight")
	int getLowWeight();
//For Severity Index End

	@Query("SELECT COUNT(severity) FROM Defect WHERE status='Rejected' AND severity = 'low'")
	int countByStatusRejectedlow();

	@Query("SELECT COUNT(severity) FROM Defect WHERE status='Rejected' AND severity = 'High'")
	int countByStatusRejectedHigh();

	@Query("SELECT COUNT(severity) FROM Defect WHERE status='Rejected' AND severity = 'medium'")
	int countByStatusRejectedmedium();
}
