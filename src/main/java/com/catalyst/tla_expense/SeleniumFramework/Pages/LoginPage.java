package com.catalyst.tla_expense.SeleniumFramework.Pages;

import com.catalyst.tla_expense.SeleniumFramework.PageObject;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageObject {
    public LoginPage(WebDriver driver) {
		super(driver);
		goTo("http://localhost:8080");
	}
}