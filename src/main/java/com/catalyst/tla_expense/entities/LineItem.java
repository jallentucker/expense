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
	
	/**
	 * Links the table by lineItemType id
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "line_item_type_id")
	private LineItemType lineItemType;
	
	/**
	 * Links the table by report id
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "report_id")
	private Report report;

	/**
	 * Getters and Setters
	 * @return
	 */
	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

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
