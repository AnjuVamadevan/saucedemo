package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utitlities.Utilities;

public class LoginPage {
    
    WebDriver driver;

    // Locators
    By usernameTextbox = By.id("user-name");
    By passwordTextbox = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
    	
        Utilities.sendText(driver,usernameTextbox,username);
    }

    public void enterPassword(String password) {
        Utilities.sendText(driver,passwordTextbox,password);

    }

    public void clickLogin() {
        //driver.findElement(loginButton).click();
    	Utilities.clickElement(driver, loginButton);
    }

    public String getErrorMessage() {
        //return driver.findElement(errorMessage).getText();
    	return Utilities.getText(driver, errorMessage);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
