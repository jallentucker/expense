package com.catalyst.tla_expense.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.catalyst.tla_expense.entities.Status;
import com.catalyst.tla_expense.services.StatusService;

@RestController
public class StatusController {
	
	@Autowired
	private StatusService statusService;
	
	public void setStatusService(StatusService statusService) {
		this.statusService = statusService;
	}
	
	/**
	 * Retrieves all statuses in the database
	 * @return full list of stored statuses
	 */
	@RequestMapping(value="/getAllStatuses", method=RequestMethod.GET)
	public List<Status> getStatuses() {
		return statusService.getStatuses();
	}
	
	/**
	 * Retrieves a status by name if in the database
	 * @param statusName
	 * @return matching status
	 */
	@RequestMapping(value="/getSingleCondition/{name}", method=RequestMethod.GET)
	public Status getStatusByName(@PathVariable String statusName) {
		return statusService.getStatusByName(statusName);
	}

}
