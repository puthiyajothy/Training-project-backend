package com.training.internal.project.dashBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.internal.project.dashBoard.entiry.SeverityCount;


public interface DashboardRepository extends JpaRepository<SeverityCount,Long>{

}
