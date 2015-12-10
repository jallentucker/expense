package com.catalyst.tla_expense.PageObjectFramework.Pages;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.catalyst.tla_expense.SeleniumFramework.TestPageObject;
import com.catalyst.tla_expense.SeleniumFramework.Pages.LoginPage;


public class LoginPageTest extends TestPageObject{

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
    assertEquals("Expenses Application", actualtitle);
}

@Test
public void checkThatValidUserNameAndPasswordNavigatesToHomePage(){
    LoginPage login = new LoginPage(driver);
    login.sendKeys(By.id("username"), "dummy");
    login.sendKeys(By.id("password"), "password1");
    login.click(By.id("loginSubmit"));
    String actualURL = login.getUrl();
    assertEquals("http://localhost:8080/#/home", actualURL);
}

}
