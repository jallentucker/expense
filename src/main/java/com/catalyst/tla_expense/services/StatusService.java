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
	 * Search Statuses by id and return the Status if found
	 * @param statusId
	 * @return status with matching id
	 */
	public Status getStatusById(int id);

}
