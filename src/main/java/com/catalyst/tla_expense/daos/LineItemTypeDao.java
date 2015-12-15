package com.catalyst.tla_expense.daos;

import java.util.List;

import com.catalyst.tla_expense.entities.LineItemType;

public interface LineItemTypeDao {

	List<LineItemType> getAllLineItemTypes();

}
