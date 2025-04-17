package com.testcases;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.configuration.Base;
import com.pages.CartPage;
import com.pages.CheckoutPage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.utitlities.Utilities;

import io.qameta.allure.Allure;

public class BaseTest extends Base {

    protected LoginPage loginPage;
    protected ProductPage productPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected WebDriverWait wait;
    //private static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected final Logger logger = LogManager.getLogger(getClass());


    @BeforeMethod
    public void setUp() throws IOException {
        initialisation();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Swag Labs"));

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            if (ITestResult.FAILURE == result.getStatus()) {
                Utilities.captureScreenshot(driver, result.getName());
                logger.info("Screenshot captured for failed test: " + result.getName());
            }

            // Add Allure step to indicate test status
            switch (result.getStatus()) {
                case ITestResult.SUCCESS -> Allure.step("✅ Test Passed");
                case ITestResult.FAILURE -> Allure.step("❌ Test Failed");
                case ITestResult.SKIP -> Allure.step("⚠️ Test Skipped");
            }


        } catch (IOException e) {
            logger.error("Error in tearDown: {}", e.getMessage());
        } finally {
            driver.quit();
        }
    }

}
