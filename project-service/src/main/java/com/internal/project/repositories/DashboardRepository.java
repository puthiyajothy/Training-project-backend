package com.internal.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internal.project.entities.SeverityCount;


public interface DashboardRepository extends JpaRepository<SeverityCount,Long>{

}
