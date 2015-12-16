package com.catalyst.tla_expense.validation;

import org.springframework.stereotype.Service;

import com.catalyst.tla_expense.entities.LineItem;
import com.catalyst.tla_expense.entities.LineItemType;

@Service
public class LineItemValidation {

	public boolean validateLineItem(LineItem lineItem) throws Exception {
		return validateLineItemType(lineItem) && validateLineItemMonetaryAmount(lineItem);
	}

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

	public boolean validateLineItemMonetaryAmount(LineItem lineItem) throws Exception {
		boolean result = true;
		double monetaryAmount = lineItem.getMonetaryAmount();
		if (monetaryAmount == 0) {
			result = false;
			throw new Exception("Monetary Amount cannot be 0");
		}
		return result;
	}
}
