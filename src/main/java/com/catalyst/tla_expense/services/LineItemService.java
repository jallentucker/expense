package com.catalyst.tla_expense.services;

import java.util.List;

import com.catalyst.tla_expense.entities.LineItem;

public interface LineItemService {

	public List<LineItem> getAllLineItems();

	public void addLineItem(LineItem lineItem);

	public void deleteLineItemById(Integer lineItemId);

	public void updateLineItem(LineItem lineItem);

}
