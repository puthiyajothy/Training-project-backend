package com.training.internal.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.internal.employee.entities.Designation;

public interface DesignationRepository extends JpaRepository<Designation, Long> {
	
//	get by Designation Id Method
	public Designation findBydesignationid (Long designationid);
	
//	delete Designation method
	public void deleteDesignationBydesignationid(Long designationid);

}
