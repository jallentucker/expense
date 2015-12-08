package com.catalyst.tla_expense.services;

import java.util.List;

import com.catalyst.tla_expense.entities.Status;

public interface StatusService {
	
	/**
	 * Retrieves all statuses in the database
	 * @return full list of stored statuses
	 */
	public List<Status> getStatuses();
	
	/**
	 * Search Statuses by name and return the Status if found
	 * @param statusName
	 * @return status with matching name
	 */
	public Status getStatusByName(String statusName);

}
