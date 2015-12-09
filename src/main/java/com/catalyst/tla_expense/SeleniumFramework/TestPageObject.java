package com.catalyst.tla_expense.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;


public abstract class TestPageObject {
    protected WebDriver driver;
    SeleniumSettings seleniumSettings;
    @Before
    public void beforeAllSeleniumTests(){
        seleniumSettings = new SeleniumSettings();
        driver = seleniumSettings.getDriver();
    }
    @After
    public void afterAllSeleniumTests(){
        driver.quit();
    }
}





