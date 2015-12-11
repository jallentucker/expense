package com.catalyst.tla_expense.SeleniumFramework.Pages;

import org.openqa.selenium.WebDriver;

import com.catalyst.tla_expense.SeleniumFramework.PageObject;

public class CreateReportPage extends PageObject {

	public CreateReportPage(WebDriver driver) {
		super(driver);
		goTo("http://localhost:8080/#/createReport");
	}

}
