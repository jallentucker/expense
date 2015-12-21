package com.catalyst.tla_expense.validation;

import org.springframework.stereotype.Service;

import com.catalyst.tla_expense.entities.LineItem;
import com.catalyst.tla_expense.entities.LineItemType;

@Service
public class LineItemValidation {

	/**
	 * Function that wraps the all of the validation functions into a single call.
	 * @param lineItem
	 * @return boolean
	 * @throws Exception
	 */
	public boolean validateLineItem(LineItem lineItem) throws Exception {
		return validateLineItemType(lineItem) && validateLineItemMonetaryAmount(lineItem) && validateLineItemProject(lineItem);
	}

	/**
	 * Checks to see that a type of line item has been selected.
	 * @param lineItem
	 * @return boolean
	 * @throws Exception
	 */
	public boolean validateLineItemType(LineItem lineItem) throws Exception {
			boolean result = true;
			LineItemType lineItemType = lineItem.getLineItemType();
			int lineItemTypeId = lineItemType.getLineItemTypeId();
			if(lineItemTypeId == 0){
				result = false;
				throw new Exception("Not a line item type");
			}
			return result;
	}

	/**
	 * Checks to see that the monetary amount is not equal to zero
	 * @param lineItem
	 * @return boolean
	 * @throws Exception
	 */
	public boolean validateLineItemMonetaryAmount(LineItem lineItem) throws Exception {
		boolean result = true;
		double monetaryAmount = lineItem.getMonetaryAmount();
		if (monetaryAmount == 0) {
			result = false;
			throw new Exception("Monetary Amount cannot be 0");
		}
		return result;
	}
	
	/**
	 * Checks to ensure that a project has been selected for the line item.  Also works as validation
	 * for a report since a project is required for a report
	 * @param lineItem
	 * @return boolean
	 * @throws Exception
	 */
	public boolean validateLineItemProject(LineItem lineItem) throws Exception{
		boolean result = true;
		int projectId = lineItem.getReport().getReportId();
		if(projectId == 0){
			result = false;
			throw new Exception("Project is not specified");
		}
		return result;
	}
}
