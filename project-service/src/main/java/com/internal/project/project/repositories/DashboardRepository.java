package com.internal.project.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internal.project.project.entities.SeverityCount;


public interface DashboardRepository extends JpaRepository<SeverityCount,Long>{

}
