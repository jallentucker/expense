package com.catalyst.tla_expense.PageObjectFramework.Pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.catalyst.tla_expense.SeleniumFramework.PageObject;
import com.catalyst.tla_expense.SeleniumFramework.TestPageObject;
import com.catalyst.tla_expense.SeleniumFramework.Pages.CreateReportPage;
import com.catalyst.tla_expense.SeleniumFramework.Pages.RegisterPage;
import com.catalyst.tla_expense.utility.SeleniumConstants;

public class CreateReportPageEvaluation extends TestPageObject
{
	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
	public WebDriver webDriver;
	

	
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
		report.sendKeys(By.id("reportName"), seleniumConstants.generateString());
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
		report.sendKeys(By.id("reportName"), seleniumConstants.generateString());

		report.click(By.id("ReportSubmit"));
		
		String actualURL = report.getUrl();
		assertEquals((URL + "/#/createReport"), actualURL);
	}
	

	//testing card 23--submitting a report
	
	public void enterReportNameProjectLineitems(CreateReportPage report){
		Select dropdown1 = new Select(driver.findElement(By.id("projectDropDown")));
		report.sendKeys(By.id("reportName"), seleniumConstants.generateString());
		dropdown1.selectByIndex(1);
		report.click(By.id("lineitemBtn"));
		Select dropdown2 = new Select(driver.findElement(By.xpath("/html/body/ui-view/div/div/div[2]/form/div/div/div[3]/div[1]/div[2]/select")));
		dropdown2.selectByIndex(1);
		report.sendKeys(By.xpath("/html/body/ui-view/div/div/div[2]/form/div/div/div[3]/div[1]/div[3]/input"),"55");
		Select dropdown3 = new Select(driver.findElement(By.xpath("/html/body/ui-view/div/div/div[2]/form/div/div/div[4]/div[1]/div[2]/select")));
		dropdown3.selectByIndex(1);
		report.sendKeys(By.xpath("/html/body/ui-view/div/div/div[2]/form/div/div/div[4]/div[1]/div[3]/input"),"55");
	}

	
	
	@Test 
	public void checkThatOnlySaveButtonExistsWhenReportNotSaved() {
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		boolean submitBtnFound = true;
		try{
		
			report.find(By.id("ReportSubmit"));
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
		
		enterReportNameProjectLineitems(report);
		
		report.click(By.id("ReportSave"));
		
		boolean elementFound = false;
		try{
			report.find(By.id("ReportSubmit"));
			elementFound = true;
		}
		catch(Exception E){
			elementFound = false;
		}
		finally{
			assertTrue(elementFound);
		}

	}

	@Test 
	public void whenReportSavedAndClickSubmitBtnThenReportPersistedAndRedirectedToHome() {
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		enterReportNameProjectLineitems(report);
		
		report.click(By.id("ReportSave"));
		report.click(By.id("ReportSubmit"));
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

		enterReportNameProjectLineitems(report);
		
		boolean elementFound = false;
		try{
			report.find(By.id("ReportSave"));
			elementFound = true;
		}
		catch(Exception E){
			elementFound = false;
		}
		finally{
			assertTrue(elementFound);
		}

	}

	@Test 
	public void whenNotSelectingAnyDropboxesAndClickSaveErrorMessageDisplays() {
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		Select dropdown1 = new Select(driver.findElement(By.id("projectDropDown")));
		report.sendKeys(By.id("reportName"), seleniumConstants.generateString());
		dropdown1.selectByIndex(1);
		report.click(By.id("lineitemBtn"));
		report.click(By.id("lineitemBtn"));
		report.click(By.id("SaveBtn"));
		
		//now check for error messages
		

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
