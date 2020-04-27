package com.internal.project.project.services;

import java.util.List;

import com.internal.project.project.entities.ResourceAllocation;

public interface ResourceAllocationService {

//	<--Save Resource Allocation Method--->
	public ResourceAllocation saveresource(ResourceAllocation resourceAllocation);

//	<---Resource Allocation List Method--->
	public List<ResourceAllocation> gettAllResource();

//	<---Get Resource Allocation By Resource Allocation Id--->
	public ResourceAllocation findResourceAllocationByresourceId(Long resourceId);

//	<---List Resource Allocation By Resource Allocation By Id--->
	public List<ResourceAllocation> getresourceById();

//    <---save Resource Allocation Bulk Date--->
	void saveResourceTable(List<ResourceAllocation> resourceAllocation);
	
//  <--- Resource Allocation Delete  Method--->
	public ResourceAllocation deleteResourceById(Long resourceId);

}
