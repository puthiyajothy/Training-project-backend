package com.internal.project.dashBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internal.project.dashBoard.entiry.SeverityCount;


public interface DashboardRepository extends JpaRepository<SeverityCount,Long>{

}
