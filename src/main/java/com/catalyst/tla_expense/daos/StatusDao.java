package com.catalyst.tla_expense.daos;

import java.util.List;

import com.catalyst.tla_expense.entities.Status;

public interface StatusDao {
	
	/**
	 * Retrieves all statuses in the database
	 * @return full list of stored statuses
	 */
	public List<Status> getStatuses();
	
	/**
	 * Search Statuses by id and returns the Status if found
	 * @param statusId
	 * @return status with matching id
	 */
	public Status getStatusById(int id);

}
