package com.catalyst.tla_expense.PageObjectFramework.Pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.catalyst.tla_expense.SeleniumFramework.PageObject;
import com.catalyst.tla_expense.SeleniumFramework.TestPageObject;
import com.catalyst.tla_expense.SeleniumFramework.Pages.CreateReportPage;
import com.catalyst.tla_expense.SeleniumFramework.Pages.RegisterPage;
import com.catalyst.tla_expense.utility.SeleniumConstants;

public class CreateReportPageEvaluation extends TestPageObject
{
	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
	
	public static String generateString()
	{
		Random rng = new Random();
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int length = 8;
		char[] text = new char[length];
		for(int i=0; i < length; i++)
		{
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		
		return new String(text);
	}

	
	@Test
	public void checkThatItGoesToTheRightPage() {
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		String actualURL = report.getUrl();
		assertEquals((URL + "/#/createReport"), actualURL);
	}
	
	@Test
	public void checkThatWhitespaceDoesNotGetAdded() {
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		report.sendKeys(By.id("reportName"), "        ");
		report.click(By.id("ReportSubmit"));
		
		String actualURL = report.getUrl();
		assertEquals((URL + "/#/createReport"), actualURL);
	}
	
	@Test
	public void checkThatReportWasSubmitted() {
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		Select dropdown = new Select(driver.findElement(By.id("projectDropDown")));
		report.sendKeys(By.id("reportName"), generateString());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dropdown.selectByIndex(1);
		report.click(By.id("ReportSubmit"));
		report.find(By.id("logout_button"));
		String actualURL = report.getUrl();
		assertEquals((URL + "/#/home"), actualURL);
	}
	
	@Test
	public void checkThatCancelButtonWorks() {
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		report.click(By.id("ReportCancel"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actualURL = report.getUrl();
		assertEquals((URL + "/#/home"), actualURL);
	}
	
	@Test 
	public void checkThatAReportIsntSubmittedWithoutAProject() {
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		report.sendKeys(By.id("reportName"), generateString());
		report.click(By.id("ReportSubmit"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actualURL = report.getUrl();
		assertEquals((URL + "/#/createReport"), actualURL);
	}
	

	//testing card 23--submitting a report

	@Test 
	public void checkThatOnlySaveButtonExistsWhenReportNotSaved() {
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		boolean submitBtnFound = true;
		try{
			//just need submit button id
			report.find(By.id(""));
			submitBtnFound = true;
		}
		catch(Exception E){
			submitBtnFound = false;
		}
		finally{
			assertFalse(submitBtnFound);
		}
	}

	@Test 
	public void whenReportValidAndSavedClickedSubmitBtnDisplayed() {
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		
		/*
		 * need to create valid report
		 * with line items and adding name and clicking related project
		 */
		
		report.click(By.id("SaveBtn"));
		boolean elementFound = false;
		try{
			//just need submit button id
			report.find(By.id(""));
			elementFound = false;
		}
		catch(Exception E){
			elementFound = true;
		}
		finally{
			assertTrue(elementFound);
		}

	}

	@Test 
	public void whenReportSavedAndClickSubmitBtnThenReportPersistedAndRedirectedToHome() {
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		/*
		 * need to create valid report
		 * with line items and adding name and clicking related project
		 */
		
		//need to find ids os save and submit buttons
		report.click(By.id("SaveBtn"));
		report.click(By.id("SubmitBtn"));
		report.find(By.id("logout_button"));
		String actualUrl = report.getUrl();
		String expectedURL = "http://localhost:8080/#/home";
		assertEquals(expectedURL, actualUrl);
	}


	//testing card 24--saving a report

	@Test 
	public void whenAddedLineItemThenSaveBtnAppears() {
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);

		/*
		 * need to create valid report
		 * with line items and adding name and clicking related project
		 */
		
		boolean elementFound = false;
		try{
			//just need submit button id
			report.find(By.id(""));
			elementFound = false;
		}
		catch(Exception E){
			elementFound = true;
		}
		finally{
			assertTrue(elementFound);
		}

	}

	@Test 
	public void whenNotSelectingAnyDropboxesAndClickSaveErrorMessageDisplays() {
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		
		

	}

	//testing card 25--adding line item to report

	@Test 
	public void lineItemButtonPresentAndClickingPresentsLineItemRow() {
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);

	}

	@Test 
	public void lineItemRowContainsDropDownOfTypesAndInputOfMonetaryAmount() {
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);

	}
}
