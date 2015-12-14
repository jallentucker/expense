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
	 * Search Statuses by name and returns the Status if found
	 * @param statusName
	 * @return status with matching name
	 */
	public Status getStatusByName(String statusName);

}
