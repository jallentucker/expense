package com.catalyst.tla_expense.SeleniumFramework.Pages;

import com.catalyst.tla_expense.SeleniumFramework.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {
    public HomePage(WebDriver driver) {
		super(driver);
		goTo("http://localhost:8080/home");
		}
}