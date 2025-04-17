package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utitlities.Utilities;

public class CheckoutPage {
	 WebDriver driver;

	    // Locators
	    By checkoutPageTitleText = By.xpath("//span[contains(text(),'Checkout: Your Information')]");
	    By firstnameTextField = By.id("first-name");
	    By lastnameTextField = By.id("last-name");
	    By postalcodeTextField = By.id("postal-code");
	    By continueButton = By.id("continue");
	    By finishButton = By.id("finish");
	    By confirmationMessage = By.xpath("//h2[contains(text(),'Thank you for your order!')]");
	    By confirmantionTitle = By.xpath("//span[contains(text(),'Checkout: Complete!')]");
	    
	    public CheckoutPage(WebDriver driver) {
	        this.driver = driver;
	    }
	    
	    public boolean validateNavigationToCheckoutPage()
	    {
	    	return Utilities.isElementDisplayed(driver, checkoutPageTitleText);

	    }
	    
	    
	    public void fillUserInfo(String firstname, String lastname, String postalcode)
	    {
	    	
	    	Utilities.sendText(driver, firstnameTextField, firstname);
	    	Utilities.sendText(driver, lastnameTextField, lastname);
	    	Utilities.sendText(driver, postalcodeTextField, postalcode);
	    	Utilities.clickElement(driver, continueButton);
	  
	    }
	    
	    public void completeCheckOut()
	    {
	    	Utilities.clickElement(driver, finishButton);

	    }
	    
	    public boolean isOrderPlaced()
	    {
	    	return Utilities.isElementDisplayed(driver, confirmantionTitle) && Utilities.isElementDisplayed(driver, confirmationMessage);

	    }
	    
	    

}
