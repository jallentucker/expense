package com.catalyst.tla_expense.SeleniumFramework;

import java.util.Collection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public abstract class PageObject {
    private WebDriver driver;
	private String url;
	protected String title;
	protected static By body = By.xpath("//body");
	protected static By xpathTitle = By.xpath("//title");
	
	public PageObject(WebDriver driver){
		this.driver = driver;
	}
	
	protected WebElement find(By by)
	{
		return driver.findElement(by);
	}
	
	protected void clear(By by){
		find(by).clear();
	}
	
	protected void sendKeys(By by, String value){
		find(by).sendKeys(value);
	}
	
	protected void clearAndSendKeys(By by, String value)
	{
		clear(by);
		sendKeys(by, value);
	}
	
	protected void click(By by){
		find(by).click();
	}
	
	protected Collection<WebElement> findAll(By by){
		return driver.findElements(by);
	}
	
	protected String getInnerHtml(By by){
		return find(by).getAttribute("innerHTML");
	}
	
	protected String getText(By by){
		return find(by).getText();
	}
	
	public String getTitle(){
		return getInnerHtml(xpathTitle);
	}
	
	public String getUrl(){
		return driver.getCurrentUrl();
	}
	
	public void goTo(String url){
		driver.get(url);
	}
	
	public void submit(By by)
	{
		find(by).submit();
	}
	
	public void selectByText(By by, String optionText){
		Select select = new Select(find(by));
		if (!select.equals(null))
		{
			try
			{
				select.selectByVisibleText(optionText);
			}
			catch (Exception ex)
			{
				String errMsg = String.format(
						"PageObject: There is no option '%s' in '%s'.",
						optionText, by);
			}
		}
	}

	
}
