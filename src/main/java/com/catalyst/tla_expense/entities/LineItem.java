package com.catalyst.tla_expense.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "line_item", schema = "public")
public class LineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "line_item_id")
	private int lineItemId;

	@Column(name = "monetary_amount")
	private double monetaryAmount;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "line_item_type_id")
	private LineItemType lineItemType;

	public int getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(int lineItemId) {
		this.lineItemId = lineItemId;
	}

	public double getMonetaryAmount() {
		return monetaryAmount;
	}

	public void setMonetaryAmount(double monetaryAmount) {
		this.monetaryAmount = monetaryAmount;
	}

	public LineItemType getLineItemType() {
		return lineItemType;
	}

	public void setLineItemType(LineItemType lineItemType) {
		this.lineItemType = lineItemType;
	}

}
