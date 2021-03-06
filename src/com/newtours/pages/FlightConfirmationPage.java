package com.newtours.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FlightConfirmationPage {


	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//font[contains(text(), 'Flight Confirmation')]")
	private WebElement fligtConfirmationHeader;
	
	@FindBy(xpath="//font[contains(text(), 'USD')]")
	private List<WebElement> prices;
	
	public FlightConfirmationPage (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait (driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void printConfirmation () {
		this.wait.until(ExpectedConditions.visibilityOf(fligtConfirmationHeader));
		System.out.println (this.fligtConfirmationHeader.getText());
		System.out.println (this.prices.get(1).getText());
	}
}
