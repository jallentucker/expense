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

	/**
	 * Generates the line_item_type_id which is the primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="line_item_type_id")
	private int lineItemTypeId;
	
	/**
	 * Set of 8 unique line item types that are injected into the database
	 * upon app launch: mileage, per diem, lodging, travel, meals, entertainment,
	 * parking, and other.
	 */
	@Column(name="line_item_type")
	private String lineItemType;

	/**
	 * Getters and Setters
	 * @return
	 */
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
