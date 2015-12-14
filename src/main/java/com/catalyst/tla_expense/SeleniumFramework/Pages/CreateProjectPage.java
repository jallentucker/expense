package com.catalyst.tla_expense.SeleniumFramework.Pages;

import com.catalyst.tla_expense.SeleniumFramework.PageObject;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateProjectPage extends PageObject {
	private WebDriver driver;
	
    public CreateProjectPage(WebDriver driver) {
		super(driver);
        goTo("http://localhost:8080/home");

    }
    public void clickOnCatalogToEnableUpdate(){
        click(By.id("createProjectBtn")); // click on the first catalog number.
    }
    
    
}