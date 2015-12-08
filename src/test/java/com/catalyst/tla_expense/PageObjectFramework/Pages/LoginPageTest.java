package com.catalyst.tla_expense.PageObjectFramework.Pages;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class LoginPageTest {
private WebDriver driver;

/*@Before
public void setUp(){
	System.setProperty("webdriver.chrome.driver", "C:/windows/chromedriver.exe");
	//create a new instance of this new html
	_driver = new ChromeDriver();
	_driver.get("http://www.amazon.com/");
}
@Test
public void verifyTitle(){
	String actualTitle = _driver.getTitle();
	assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", actualTitle);
}
@After 
public void tearDown() throws Exception{
	_driver.quit();
}*/

@Test
public void SignInLinkShouldTakeMeToSignInPage(){
		
		Amazon store = new Amazon(SeleniumDriver.getDriver());
		String expectedUrl = "https://www.amazon.com/gp/goldbox/ref=nav_cs_gb";
		Actions builder = new Actions(_driver);
		By hoverElement = By.xpath("//*[@id='nav-link-yourAccount']/span[1]");
		builder.moveToElement((WebElement) hoverElement).perform();
		String actualUrl = store.create().getUrl();
		WebElement addButtonPresent = (new WebDriverWait(_driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("addTarget")));
		store.createAccount().selectLinkByName("Forgot your password?");
		
		Assert.assertEquals(expectedUrl,  actualUrl);
}
}
