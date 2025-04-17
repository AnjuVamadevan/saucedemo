package com.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dataprovider.LoginData;
import com.utitlities.Utilities;

import jdk.jfr.Description;



 public class LoginPageTest extends BaseTest{
	
    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);
    

	
	@Test(priority=0)
	public void testTitleVerification()
	{

		logger.info("[TC001] Login Page");
		Utilities.allureLogStep("[TC001] Login Page"); 
		
        logger.info("Verification of login page title");
        Utilities.allureLogStep("Verification of login page title");
        
		String actual_title = driver.getTitle();
        logger.debug("Actual title: "+ actual_title);
        Utilities.allureLogStep("Actual title: "+ actual_title);
        
		String expected_title = "Swag Labs"; 
		Assert.assertEquals(actual_title, expected_title,"Title doesn't match");
		logger.info("Test verification title matched");
		Utilities.allureLogStep("Test verification title matched");
		
		logger.info("PASS");
		Utilities.allureLogStep("PASS");
		
	}

    @Test(priority=2,dataProvider = "validCredentials", dataProviderClass = LoginData.class)
	public void testValidLogin(String username, String password, String expectedInUrl)
	{
        logger.info("[TC002] Login Page");
        Utilities.allureLogStep("[TC002] Login Page");
        
        logger.info("Verification of valid login for "+username);
        Utilities.allureLogStep("Verification of valid login for "+username);
        
        logger.info("Enter valid username");
        Utilities.allureLogStep("Enter valid username");
        loginPage.enterUsername(username);
        
        logger.info("Enter valid password");
        Utilities.allureLogStep("Enter valid password");
        loginPage.enterPassword(password);
        
        logger.info("Click on login button");
        Utilities.allureLogStep("Click on login button");
        loginPage.clickLogin();
        
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedInUrl),"Logged in doesn't match");
        Assert.assertTrue(productPage.verifySwagLabsTitle().contains("Swag Labs"),"Title doesn't match");
        logger.info("Test verification dashboard title matched");
        Utilities.allureLogStep("Test verification dashboard title matched");
        
        // Verify session-username cookie
        String sessionUsername = driver.manage().getCookieNamed("session-username").getValue();
        logger.info("Cookie [session-username]: " + sessionUsername);
        Utilities.allureLogStep("Cookie [session-username]: " + sessionUsername);

        Assert.assertEquals(sessionUsername, username, "Cookie 'session-username' should match the logged-in username");
        logger.info("Cookie validation passed: session-username = " + username);
        Utilities.allureLogStep("Cookie validation passed: session-username = " + username);
        

        
		logger.info("PASS");
		Utilities.allureLogStep("PASS");

 
	}
	
    @Test(priority=1, dataProvider = "invalidCredentials", dataProviderClass = LoginData.class)
    @Description("Login with invalid credentials")
	public void testInvalidLogin(String username, String password, String expectedErrorMsg)
	{
        logger.info("[TC003] Login Page");
        Utilities.allureLogStep("[TC003] Login Page");
        
        logger.info("Verification of invalid login scenario "+expectedErrorMsg);
        Utilities.allureLogStep("Verification of invalid login scenario "+expectedErrorMsg);
        
        logger.info("Enter username");
        Utilities.allureLogStep("Enter username");
        loginPage.enterUsername(username);
        
        logger.info("Enter password");
        Utilities.allureLogStep("Enter password");
        loginPage.enterPassword(password);
        
        logger.info("Click on login button");
        Utilities.allureLogStep("Click on login button");
        loginPage.clickLogin();
        
        Assert.assertTrue(loginPage.getErrorMessage().contains(expectedErrorMsg),"Error message doesn't match");
        logger.info("Test verification invalid login message matched");
        Utilities.allureLogStep("Test verification invalid login message matched");
        
		logger.info("PASS");
		Utilities.allureLogStep("PASS");
 	}
    

}
