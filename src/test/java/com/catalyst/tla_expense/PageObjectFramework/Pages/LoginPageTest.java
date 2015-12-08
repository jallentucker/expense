package com.catalyst.tla_expense.PageObjectFramework.Pages;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.catalyst.tla_expense.SeleniumFramework.Pages.LoginPage;

import junit.framework.Assert;


public class LoginPageTest extends TestPageObject{
private WebDriver driver;

@Test
public void checkThatItGoesToTheRightPage(){

    LoginPage login = new LoginPage(driver);

    String actualURL = login.getUrl();

    assertEquals("http://localhost:8080/login", actualURL);
}

@Test
public void checkThatThePageGetsTheTitle(){

    LoginPage login = new LoginPage(driver);

    String actualtitle = login.getTitle();

    assertEquals("Expense Application", actualtitle);
}

@Test
public void checkThatValidUserNameAndPasswordNavigatesToHomePage(){

    LoginPage login = new LoginPage(driver);

    login.sendKeys(By.id("username"), "dummy");
    login.sendKeys(By.id("password"), "password1");
    

    login.click(By.id("loginSubmit"));

    String actualURL = login.getUrl();
    assertEquals("http://localhost:8080/home", actualURL);
}
}
