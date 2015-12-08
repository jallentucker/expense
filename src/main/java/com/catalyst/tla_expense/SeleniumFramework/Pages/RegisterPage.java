package com.catalyst.tla_expense.SeleniumFramework.Pages;

import com.catalyst.tla_expense.SeleniumFramework.PageObject;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends PageObject {
    public RegisterPage(WebDriver driver) {
		super(driver);
		goTo("http://localhost:8080/register");
    }
}