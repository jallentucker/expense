package com.catalyst.tla_expense.PageObjectFramework.Pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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
		
		boolean save = true; 
		
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		report.sendKeys(By.id("reportName"), "        ");
		Select projectDropdown = new Select(driver.findElement(By.id("projectDropDown")));
		projectDropdown.selectByIndex(1);
		Select expenseTypeDropdown = new Select(driver.findElement(By.xpath("/html/body/ui-view/div/div/div[2]/form/div/div/div[4]/div[1]/div[2]/select")));
		expenseTypeDropdown.selectByIndex(1);
		report.sendKeys(By.xpath("/html/body/ui-view/div/div/div[2]/form/div/div/div[4]/div[1]/div[3]/input"), "100");
		
		try{
			System.out.println("IF statement hit, setting save to true");
			 if((report.find(By.id("ReportSave")).isDisplayed())){
				 save = true;
				 
			 }else{
				 save = false;
			 }
		}catch(Exception e){
			save = false;
			System.out.println("Exception occured, setting save to false");
		}
		
		assertTrue(!save);
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
	public void checkThatAReportCantBeSavedWithoutAProject() {
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		//giving our report a name
		report.sendKeys(By.id("reportName"), SeleniumConstants.generateString());
		//creating 2 line items
		report.click(By.id("lineitemBtn"));
		Select dropdown2 = new Select(driver.findElement(By.xpath("/html/body/ui-view/div/div/div[2]/form/div/div/div[4]/div[1]/div[2]/select")));
		dropdown2.selectByIndex(1);
		report.sendKeys(By.xpath("/html/body/ui-view/div/div/div[2]/form/div/div/div[4]/div[1]/div[3]/input"),"55");
		Select dropdown3 = new Select(driver.findElement(By.xpath("/html/body/ui-view/div/div/div[2]/form/div/div/div[5]/div[1]/div[2]/select")));
		dropdown3.selectByIndex(1);
		report.sendKeys(By.xpath("/html/body/ui-view/div/div/div[2]/form/div/div/div[5]/div[1]/div[3]/input"),"55");
		
		boolean saveBtnFound = true;
		try{
		
			saveBtnFound =  report.find(By.id("ReportSave")).isDisplayed();
			
		}
		catch(Exception E){
			saveBtnFound = false;
		}
		finally{
			assertFalse(saveBtnFound);
		}

	}
	

	//testing card 23--submitting a report
	
	//function used to enter report name attach it to a project and input two line items, thus creating a valid report
	public void enterReportNameProjectLineitems(CreateReportPage report){
		//attaching a project to report
		Select dropdown1 = new Select(driver.findElement(By.id("projectDropDown")));
		dropdown1.selectByIndex(1);
		//giving our report a name
		report.sendKeys(By.id("reportName"), seleniumConstants.generateString());
		//creating 2 line items
		report.click(By.id("lineitemBtn"));
		Select dropdown2 = new Select(driver.findElement(By.xpath("/html/body/ui-view/div/div/div[2]/form/div/div/div[4]/div[1]/div[2]/select")));
		dropdown2.selectByIndex(1);
		report.sendKeys(By.xpath("/html/body/ui-view/div/div/div[2]/form/div/div/div[4]/div[1]/div[3]/input"),"55");
		Select dropdown3 = new Select(driver.findElement(By.xpath("/html/body/ui-view/div/div/div[2]/form/div/div/div[5]/div[1]/div[2]/select")));
		dropdown3.selectByIndex(1);
		report.sendKeys(By.xpath("/html/body/ui-view/div/div/div[2]/form/div/div/div[5]/div[1]/div[3]/input"),"55");
	}

	
	
	@Test 
	public void checkThatOnlySaveButtonExistsWhenReportNotSaved() {
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		/*using a try catch finally
		 * if submit button is displayed, then set to true
		 * if not displayed, goes to catch and sets to false
		 * expect submit button to not be displayed and set to false
		 */
		boolean submitBtnFound = true;
		try{
		
			submitBtnFound =  report.find(By.id("ReportSubmit")).isDisplayed();
			
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
		
		//function creates a valid report with associated project, valid name, and two line items
		enterReportNameProjectLineitems(report);
		//click save
		report.click(By.id("ReportSave"));
		/*using a try catch finally
		 * if submit button is displayed, then set to true
		 * if not displayed, goes to catch and sets to false
		 * expect submit button to be displayed and set to true
		 */
		boolean elementFound = false;
		try{
		elementFound =	report.find(By.id("ReportSubmit")).isDisplayed();
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
		//creates a valid report
		enterReportNameProjectLineitems(report);
		//save and submit a valid report
		report.click(By.id("ReportSave"));
		new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(By.id("ReportSubmit")));
		report.click(By.id("ReportSubmit"));
		//acts like a wait to find element on new page before grabbing URL
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
		
		//checks to see if line item is displayed
		boolean elementFound = false;
		try{
			elementFound = report.find(By.id("ReportSave")).isDisplayed();
		}
		catch(Exception E){
			elementFound = false;
		}
		finally{
			assertTrue(elementFound);
		}

	}

	/*@Test 
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
		

	}*/

	//testing card 25--adding line item to report

	@Test 
	public void lineItemButtonPresentAndClickingPresentsLineItemRow() {
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		
		boolean btnPresent = false;
		boolean lineitemPresent = false;
		String lineitemActual = "";
		/*checks for the presence of the line item button and line item row
		 * if not present, then goes to catch and sets to false
		 */
		try{
			btnPresent = report.find(By.id("lineitemBtn")).isDisplayed();
			report.click(By.id("lineitemBtn"));
			lineitemPresent = report.find(By.xpath("/html/body/ui-view/div/div/div[2]/form/div/div/div[4]/div[1]")).isDisplayed();
			lineitemActual = report.getInnerHtml(By.id("lineitemBtn"));
			
		}
		catch(Exception E){
			btnPresent = false;
			lineitemPresent = false;
		}
		finally{
			
			assertEquals("Add Line Item",lineitemActual);
			assertTrue(btnPresent);
			assertTrue(lineitemPresent);

		}


	}

	@Test 
	public void lineItemRowContainsDropDownOfTypesAndInputOfMonetaryAmount() {
		seleniumConstants.loginUser(driver);
		CreateReportPage report = new CreateReportPage(driver);
		//grab list of all line item types, set to strings, and check against expected types
		List<WebElement> selectedOptions = new Select(driver.findElement(By.xpath("/html/body/ui-view/div/div/div[2]/form/div/div/div[4]/div[1]/div[2]/select"))).getOptions();
		String[] selects = new String[9];
		int i = 0;
		for(WebElement select: selectedOptions){
			selects[i] = select.getText();
			i++;
		}
		assertEquals("Select your Expense Type", selects[0]);
		assertEquals("Mileage", selects[1]);
		assertEquals("Per Diem", selects[2]);
		assertEquals("Lodging", selects[3]);
		assertEquals("Travel", selects[4]);
		assertEquals("Meals", selects[5]);
		assertEquals("Entertainment", selects[6]);
		assertEquals("Parking", selects[7]);
		assertEquals("Other", selects[8]);
		
		//check that the monetary amount is displayed on the page
		boolean monetaryAmountInputFound = false;
		try{
		
			monetaryAmountInputFound = report.find(By.xpath("/html/body/ui-view/div/div/div[2]/form/div/div/div[4]/div[1]/div[3]/input")).isDisplayed();
		}
		catch(Exception E){
			monetaryAmountInputFound = false;
		}
		finally{
			assertTrue(monetaryAmountInputFound);
		}

	}
}
