package com.internal.project.services;

import java.util.List;

import com.internal.project.entities.ResourceAllocationList;

public interface ResourceAllocationListService {
	
	public ResourceAllocationList findResourceAllocationByresourceId(Long resourceId);
	public List<ResourceAllocationList> getAllresourceList();
}
