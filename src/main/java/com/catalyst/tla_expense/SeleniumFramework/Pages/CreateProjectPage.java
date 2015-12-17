package com.catalyst.tla_expense.SeleniumFramework.Pages;

import com.catalyst.tla_expense.SeleniumFramework.PageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CreateProjectPage extends PageObject {
	private WebDriver driver;
	
    public CreateProjectPage(WebDriver driver) {
		super(driver);
        goTo(URL + "/home");

    }
    public void clickOnCatalogToEnableUpdate(){
        click(By.id("createProjectBtn")); // click on the first catalog number.
    }
    
    
}