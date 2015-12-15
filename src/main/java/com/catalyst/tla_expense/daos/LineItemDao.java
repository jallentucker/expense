package com.catalyst.tla_expense.daos;

import java.util.List;

import com.catalyst.tla_expense.entities.LineItem;

public interface LineItemDao {

	public List<LineItem> getAllLineItems();

	public void addLineItem(LineItem lineItem);

	public void deleteLineItemById(Integer id);

	public void updateLineItem(LineItem lineItem);

}
