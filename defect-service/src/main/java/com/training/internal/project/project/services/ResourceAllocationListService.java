package com.training.internal.project.project.services;

import java.util.List;

import com.training.internal.project.project.entities.ResourceAllocationList;

public interface ResourceAllocationListService {
	
	public ResourceAllocationList findResourceAllocationByresourceId(Long resourceId);
	public List<ResourceAllocationList> getAllresourceList();
}
