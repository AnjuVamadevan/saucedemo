package com.testcases;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dataprovider.LoginData;
import com.utitlities.Utilities;




public class ProductPageTest extends BaseTest{
	
	
    private static final Logger logger = LogManager.getLogger(ProductPageTest.class);
    
	
    @Test(priority=3,dataProvider = "validCredentials", dataProviderClass = LoginData.class)
    public void testTitleVerification(String username, String password, String expectedInUrl)
	{

		logger.info("[TC001] Product Page");
		Utilities.allureLogStep("[TC001] Product Page");
		
        logger.info("Verification of main and sub titles");
        Utilities.allureLogStep("Verification of main and sub titles");
        
        logger.info("Login with user : "+username);
        Utilities.allureLogStep("Login with user : "+username);
        loginPage.login(username, password);
        
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedInUrl),"Login failed");
        logger.info("Login successful");
        Utilities.allureLogStep("Login successful");

        Assert.assertTrue(productPage.verifySwagLabsTitle().contains("Swag Labs"),"Swag Labs title not matched");
		logger.info("Test verification main title matched");
		Utilities.allureLogStep("Test verification main title matched");

		Assert.assertTrue(productPage.verifyProductsTitle().contains("Products"),"Products title not matched");
		logger.info("Test verification sub title matched");
		Utilities.allureLogStep("Test verification sub title matched");


		logger.info("PASS");
		Utilities.allureLogStep("PASS");
		
	}
    
    @Test(priority=4,dataProvider = "validCredentials", dataProviderClass = LoginData.class)
    public void testSortNameAtoZ(String username, String password, String expectedInUrl)
	{

		logger.info("[TC002] Product Page");
		Utilities.allureLogStep("[TC002] Product Page");
		
        logger.info("Verification sort feature : Name (A to Z)");
        Utilities.allureLogStep("Verification sort feature : Name (A to Z)");
        
        logger.info("Login with user : "+username);
        Utilities.allureLogStep("Login with user : "+username);
        loginPage.login(username, password);
        
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedInUrl),"Login failed");
        logger.info("Login successful");
        Utilities.allureLogStep("Login successful");
        

        Assert.assertTrue(productPage.sortProductBy("Name (A to Z)"),"Select dropdown option failed");
        logger.info("Selected \"Name (A to Z)\" sort option");
        Utilities.allureLogStep("Selected \"Name (A to Z)\" sort option");
        
        ArrayList<String> itemNames = productPage.getAllItemNames();
        logger.debug("All product names retrived for validation");
        Utilities.allureLogStep("All product names retrived for validation");

        Assert.assertTrue(productPage.validateIfProductsAreNameSorted("Name (A to Z)", itemNames),"Items not sorted");
        logger.info("Verified all item are sorted according to name in aescending order");
		Utilities.allureLogStep("Verified all item are sorted according to name in aescending order");

		logger.info("PASS");
		Utilities.allureLogStep("PASS");
		
	}
    
    @Test(priority=5,dataProvider = "validCredentials", dataProviderClass = LoginData.class)
    public void testSortNameZtoA(String username, String password, String expectedInUrl)
	{

		logger.info("[TC002] Product Page");
		Utilities.allureLogStep("[TC002] Product Page");
		
        logger.info("Verification sort feature : Name (Z to A)");
        Utilities.allureLogStep("Verification sort feature : Name (Z to A)");
        
        logger.info("Login with user : "+username);
        Utilities.allureLogStep("Login with user : "+username);
        loginPage.login(username, password);
        
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedInUrl));
        logger.info("Login successful");
        Utilities.allureLogStep("Login successful");
        


        Assert.assertTrue(productPage.sortProductBy("Name (Z to A)"),"Select dropdown option failed");
        logger.info("Selected \"Name (Z to A)\" sort option");
        Utilities.allureLogStep("Selected \"Name (Z to A)\" sort option");
        
        
        ArrayList<String> itemNames = productPage.getAllItemNames();
        logger.debug("All product names retrived for validation");
        Utilities.allureLogStep("All product names retrived for validation");

        Assert.assertTrue(productPage.validateIfProductsAreNameSorted("Name (Z to A)", itemNames),"Items are not sorted");
        logger.info("Verified all item are sorted according to name in descending order");
		Utilities.allureLogStep("Verified all item are sorted according to name in descending order");

		logger.info("PASS");
		Utilities.allureLogStep("PASS");
		
	}

    @Test(priority=6,dataProvider = "validCredentials", dataProviderClass = LoginData.class)
    public void testSortPriceLowtoHigh(String username, String password, String expectedInUrl)
	{

		logger.info("[TC002] Product Page");
		Utilities.allureLogStep("[TC003] Product Page");
		
        logger.info("Verification sort feature : Price (low to high)");
        Utilities.allureLogStep("Verification sort feature : Price (low to high)");
        
        logger.info("Login with user : "+username);
        Utilities.allureLogStep("Login with user : "+username);
        loginPage.login(username, password);
        
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedInUrl),"Login failed");
        logger.info("Login successful");
        Utilities.allureLogStep("Login successful");
        


        Assert.assertTrue(productPage.sortProductBy("Price (low to high)"),"Select dropdown option failed");
        logger.info("Selected \"Price (low to high)\" sort option");
        Utilities.allureLogStep("Selected \"Price (low to high)\" sort option");
        
        
        ArrayList<Double> itemPrices = productPage.getAllItemPrices();
        logger.debug("All product names retrived for validation");
        Utilities.allureLogStep("All product names retrived for validation");

        Assert.assertTrue(productPage.validateIfProductsArePriceSorted("Price (low to high)", itemPrices),"Items are not sorted");
        logger.info("Verified all items are sorted according to price from low to high");
		Utilities.allureLogStep("Verified all items are sorted according to price from low to high");

		logger.info("PASS");
		Utilities.allureLogStep("PASS");
		
	}
    
    @Test(priority=7,dataProvider = "validCredentials", dataProviderClass = LoginData.class)
    public void testSortPriceHightoLow(String username, String password, String expectedInUrl)
	{

		logger.info("[TC002] Product Page");
		Utilities.allureLogStep("[TC003] Product Page");
		
        logger.info("Verification sort feature : Price (high to low)");
        Utilities.allureLogStep("Verification sort feature : Price (high to low)");
        
        logger.info("Login with user : "+username);
        Utilities.allureLogStep("Login with user : "+username);
        loginPage.login(username, password);
        
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedInUrl),"Login failed");
        logger.info("Login successful");
        Utilities.allureLogStep("Login successful");
        


        Assert.assertTrue(productPage.sortProductBy("Price (high to low)"),"Select dropdown option failed");
        logger.info("Selected \"Price (high to low)\" sort option");
        Utilities.allureLogStep("Selected \"Price (high to low)\" sort option");
        
        
        ArrayList<Double> itemPrices = productPage.getAllItemPrices();
        logger.debug("All product names retrived for validation");
        Utilities.allureLogStep("All product names retrived for validation");

        Assert.assertTrue(productPage.validateIfProductsArePriceSorted("Price (high to low)", itemPrices),"Items are not sorted");
        logger.info("Verified all items are sorted according to price from low to high");
		Utilities.allureLogStep("Verified all items are sorted according to price from low to high");

		logger.info("PASS");
		Utilities.allureLogStep("PASS");
		
	}


}
