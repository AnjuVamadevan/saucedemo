package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dataprovider.LoginData;
import com.utitlities.Utilities;

public class CartPageTest extends BaseTest {
	
	
    @Test(priority=8,dataProvider = "validCredentials", dataProviderClass = LoginData.class)
    public void testCheckoutRandomAsset(String username, String password, String expectedInUrl) throws Exception
	{

		logger.info("[TC001] Cart Page");
		Utilities.allureLogStep("[TC001] Cart Page");
		
        logger.info("Verification of random order placement");
        Utilities.allureLogStep("Verification of random order placement");
        
        logger.info("Login with user : "+username);
        Utilities.allureLogStep("Login with user : "+username);
        loginPage.login(username, password);
        
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedInUrl),"Login failed");
        logger.info("Login successful");
        Utilities.allureLogStep("Login successful");
        
        Assert.assertTrue(productPage.addSpecifiedRandomItemsToCart(3),"All/Some items are not getting added to cart");
        logger.info("Adding 3 random items to cart");
        Utilities.allureLogStep("Adding 3 random items to cart");
        
        productPage.clickCartIcon();
        logger.info("Navigating to cart");
        Utilities.allureLogStep("Navigating to cart");
        
        Assert.assertTrue(cartPage.validateNavigationToCartPage(),"Navigation to cart failed");
        logger.info("Successfully navigated to cart");
        Utilities.allureLogStep("Successfully navigated to cart");
        
        Assert.assertTrue(cartPage.validateAddedNoOfItemsArePresentInCartPage(3),"No of items present in the cart doesn't match");
        logger.info("Added no of items are present in the cart");
        Utilities.allureLogStep("Added no of items are present in the cart");
        
        cartPage.clickOnCheckout();
        logger.info("Proceeding to checkout");
        Utilities.allureLogStep("Proceeding to checkout");
        
        Assert.assertTrue(checkoutPage.validateNavigationToCheckoutPage(),"Navigation to checkout failed");
        logger.info("Successfully navigated to checkout page");
        Utilities.allureLogStep("Successfully navigated to checkout page");
        
        checkoutPage.fillUserInfo("John", "Doe", "12356");
        logger.info("Added user info and navigated further");
        Utilities.allureLogStep("Added user info and navigated further");
        
        checkoutPage.completeCheckOut();
        logger.info("Completed final checkout process");
        Utilities.allureLogStep("Completed final checkout process");
        
        Assert.assertTrue(checkoutPage.isOrderPlaced(),"Order is not getting placed"); 
        logger.info("Verified order is getting placed succesfully");
        Utilities.allureLogStep("Verified order is getting placed succesfully");
        


		logger.info("PASS");
		Utilities.allureLogStep("PASS");
		
	}






}
