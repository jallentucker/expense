package com.catalyst.tla_expense.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.tla_expense.daos.StatusDao;
import com.catalyst.tla_expense.entities.Status;
import com.catalyst.tla_expense.services.StatusService;

@Service
public class StatusServiceImpl implements StatusService {
	
	@Autowired
	private StatusDao statusDao;
	
	/**
	 * Sets the statusDao in order to exchange data
	 * @param statusDao
	 */
	public void setStatusDao(StatusDao statusDao) {
		this.statusDao = statusDao;
	}
	
	/**
	 * Retrieves all statuses in the database
	 * @return full list of stored statuses
	 */
	@Override
	public List<Status> getStatuses() {
		return statusDao.getStatuses();
	}

	/**
	 * Search Statuses by name and return the Status if found
	 * @param statusName
	 * @return status with matching name
	 */
	@Override
	public Status getStatusById(int id) {
		return statusDao.getStatusById(id);
	}

}
