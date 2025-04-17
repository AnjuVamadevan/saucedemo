package com.utitlities;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import io.qameta.allure.Allure;

public class Utilities {
	
	public static boolean isElementDisplayed(WebDriver driver, By locator)
	{
		return driver.findElement(locator).isDisplayed();
	}
	
	public static void clickElement(WebDriver driver, By locator)
	{
		driver.findElement(locator).click();
	}
    
   //Returns the visible text of an element.
   // Overload 1: Accepts By locator

    public static String getText(WebDriver driver, By locator) {
        
        String text = driver.findElement(locator).getText();
        if (text == null || text.isEmpty()) {
            System.out.println("[Warning]: getText() returned empty.");
        }
        return text;
    }
    
    // Overload 2: Accepts WebElement directly
    public static String getText(WebElement element) {
        String text = element.getText();
        if (text == null || text.isEmpty()) {
            System.out.println("[Warning]: getText() returned empty.");
        }
        return text;
    }
	public static void sendText(WebDriver driver, By locator, String value)
	{
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(value);
	}
	public static String getPropertiesFileValue(String propertyName) throws IOException
	{
		String propertyValue;
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream("./src/main/java/config.properties");
		prop.load(fis);
		propertyValue = prop.getProperty(propertyName);
		return propertyValue;
	}

    public static File captureScreenshot(WebDriver driver, String testName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Generate timestamp
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));

        File destFile = new File("screenshots/" + testName + "_" + timestamp + ".png");
        Files.createDirectories(destFile.getParentFile().toPath());
        Files.copy(srcFile.toPath(), destFile.toPath());

        // Add to Allure report
        Allure.addAttachment(testName + " - Screenshot",
                new ByteArrayInputStream(Files.readAllBytes(destFile.toPath())));

        return destFile;
    }
    
    public static void allureLogStep(String step) {
        Allure.step(step); 
    }
    
    public static Object[][] readDataFromCSV(String filePath) throws IOException, CsvValidationException {
        List<Object[]> dataList = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                dataList.add(nextLine);
            }
        }

        return dataList.toArray(new Object[0][]);
    }
 
}
