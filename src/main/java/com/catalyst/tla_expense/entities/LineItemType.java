package com.catalyst.tla_expense.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="line_item_type", schema="public")
public class LineItemType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="line_item_type_id")
	private int lineItemTypeId;
	
	@Column(name="line_item_type")
	private String lineItemType;

	public int getLineItemTypeId() {
		return lineItemTypeId;
	}

	public void setLineItemTypeId(int lineItemTypeId) {
		this.lineItemTypeId = lineItemTypeId;
	}

	public String getLineItemType() {
		return lineItemType;
	}

	public void setLineItemType(String lineItemType) {
		this.lineItemType = lineItemType;
	}
	
	
}
