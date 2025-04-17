package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utitlities.Utilities;

public class CartPage {
	 WebDriver driver;
	 

	    // Locators
	    By cartPageTitleText = By.xpath("//span[contains(text(),'Your Cart')]");
	    By cartItemsInventory = By.className("cart_item");
	    By checkoutButton = By.id("checkout");
	    
	    public CartPage(WebDriver driver) {
	        this.driver = driver;
	    }
	    
	    public boolean validateNavigationToCartPage()
	    {
	    	
	    	return Utilities.isElementDisplayed(driver, cartPageTitleText);

	    }
	    
	    public boolean validateAddedNoOfItemsArePresentInCartPage(int numOfItems)
	    {
	    	
	    	return driver.findElements(cartItemsInventory).size() == numOfItems;
	  
	    }
	    
	    public void clickOnCheckout()
	    {
	    	
	    	Utilities.clickElement(driver, checkoutButton);;
	  
	    }

}
