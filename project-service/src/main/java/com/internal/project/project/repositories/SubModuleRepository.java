package com.internal.project.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.internal.project.project.entities.Module;
import com.internal.project.project.entities.SubModule;

public interface SubModuleRepository extends JpaRepository<SubModule, String> {

	@Query(value = "FROM SubModule WHERE module_id= :subModuleId")
	SubModule getBySubModuleId(@Param("subModuleId") String subModuleId);
	
	List<SubModule> findModuleBysubModuleId(Module module);

	@Query(value = "FROM SubModule WHERE sub_module_name= :subModuleName")
	List<SubModule> getBysubModuleName(@Param("subModuleName") String subModuleName);
	
	List<SubModule> findSubModuleByModule(Module module);
}
