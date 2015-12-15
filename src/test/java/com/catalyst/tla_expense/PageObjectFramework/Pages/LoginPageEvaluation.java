package com.catalyst.tla_expense.PageObjectFramework.Pages;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.catalyst.tla_expense.SeleniumFramework.TestPageObject;
import com.catalyst.tla_expense.SeleniumFramework.Pages.LoginPage;
import com.catalyst.tla_expense.utility.SeleniumConstants;

public class LoginPageTest extends TestPageObject {

<<<<<<< HEAD:src/test/java/com/catalyst/tla_expense/PageObjectFramework/Pages/LoginPageEvaluation.java
public class LoginPageEvaluation extends TestPageObject{
=======
	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
>>>>>>> Constant_Localhost:src/test/java/com/catalyst/tla_expense/PageObjectFramework/Pages/LoginPageTest.java

	@Test
	public void checkThatItGoesToTheRightPage() {
		LoginPage login = new LoginPage(driver);
		String actualURL = login.getUrl();
		assertEquals((URL + "/login"), actualURL);
	}

	@Test
	public void checkThatThePageGetsTheTitle() {
		LoginPage login = new LoginPage(driver);
		String actualtitle = login.getTitle();
		assertEquals("Expenses Application", actualtitle);
	}

	@Test
	public void checkThatValidUserNameAndPasswordNavigatesToHomePage() {
		LoginPage login = new LoginPage(driver);
		login.sendKeys(By.id("username"), "dummy@gmail.com");
		login.sendKeys(By.id("password"), "Password1!");
		login.click(By.id("loginSubmit"));

		new WebDriverWait(driver, 180)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='createProjectBtn']")));

		String actualURL = login.getUrl();
		assertEquals((URL + "/#/home"), actualURL);

	}

}
