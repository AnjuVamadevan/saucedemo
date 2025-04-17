package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utitlities.Utilities;

public class ProductPage {
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    By swagLabsTitle = By.xpath("//div[@class='app_logo']");
    By productsTitle = By.xpath("//span[@class='title']");
    By productSortDropdown = By.className("product_sort_container");
    By itemNameInventory = By.className("inventory_item_name");
    By itemPriceInventory = By.className("inventory_item_price");
    By productDropdownActiveOption = By.xpath("//span[@class='active_option']");
    By addToCartButtonGenericXpath = By.xpath("//button[contains(text(),'Add to cart')]");
    By removeButtonGenericXpath = By.xpath("//button[contains(text(),'Remove')]");
    By cartIcon = By.id("shopping_cart_container");
    

    
    public ProductPage(WebDriver driver)
    {
    	this.driver = driver;
    }
    
    public String verifySwagLabsTitle()
    {
    	//return driver.findElement(swagLabsTitle).getText();
    	return Utilities.getText(driver, swagLabsTitle);
    }
    
    public String verifyProductsTitle()
    {
    	//return driver.findElement(swagLabsTitle).getText();
    	return Utilities.getText(driver, productsTitle);
    }
    
    public boolean sortProductBy(String option)
    {
    	Select productDropdown = new Select(driver.findElement(productSortDropdown));
    	productDropdown.selectByVisibleText(option);
    	return Utilities.getText(driver, productDropdownActiveOption).contains(option);

    }
    
 
    
    public ArrayList<String> getAllItemNames()
    {
    	ArrayList<String> itemNames = new ArrayList<String>();
    	
    	List<WebElement> itemNamesWE = driver.findElements(itemNameInventory);
        for(int i = 0 ; i < itemNamesWE.size(); i++) {
        	
        	//System.out.print(Utilities.getText(itemNamesWE.get(i))+"\n");
        	itemNames.add(Utilities.getText(itemNamesWE.get(i)));
        }
    	return itemNames;
    	
    }
    public ArrayList<Double> getAllItemPrices()
    {
    	ArrayList<Double> itemPrices = new ArrayList<Double>();

    	List<WebElement> itemPricesWE = driver.findElements(itemPriceInventory);
        for(int i = 0 ; i < itemPricesWE.size(); i++) {
        	
        	itemPrices.add(Double.parseDouble(Utilities.getText(itemPricesWE.get(i)).replace("$", "")));
        }
    	return itemPrices;    	
    }
    
    public boolean validateIfProductsAreNameSorted(String option,ArrayList<String> itemValues)
    {
    	
    	if (option == "Name (A to Z)")
    	{
    		ArrayList<String> ascSortItemValues = new ArrayList<>(itemValues);
    		Collections.sort(ascSortItemValues);
        	return itemValues.equals(ascSortItemValues);

    			
    	}
    	else if (option == "Name (Z to A)")
    	{
    		ArrayList<String> dscSortItemValues = new ArrayList<>(itemValues);
    		Collections.sort(dscSortItemValues,Collections.reverseOrder());
        	return itemValues.equals(dscSortItemValues);    			
    			
    	}
    	
    	else
    	{
    		return false ;
    	}
    	
    }
    
    public boolean validateIfProductsArePriceSorted(String option,ArrayList<Double> itemValues)
    {
    	
    	if (option == "Price (low to high)")
    	{
    		ArrayList<Double> ascSortItemValues = new ArrayList<>(itemValues);
    		Collections.sort(ascSortItemValues);
        	return itemValues.equals(ascSortItemValues);

    			
    	}
    	else if (option == "Price (high to low)")
    	{
    		ArrayList<Double> dscSortItemValues = new ArrayList<>(itemValues);
    		Collections.sort(dscSortItemValues,Collections.reverseOrder());
        	return itemValues.equals(dscSortItemValues);    			
    			
    	}
    	else
    	{
    		return false ;
    	}

    	
    } 
    
    public boolean addSpecifiedRandomItemsToCart(int numOfItems) throws Exception
    {
    	List <WebElement> allAddToCartButtonsWE = driver.findElements(addToCartButtonGenericXpath);
    	Collections.shuffle(allAddToCartButtonsWE, new Random());
    	
    	if(numOfItems < allAddToCartButtonsWE.size())
    	{
    		for(int i = 0; i<numOfItems; i++) {
    			
    			allAddToCartButtonsWE.get(i).click();
    			
    		}
    	}
    	else
    	{
    		throw new Exception("The mentioned no.of items is not available"); 
    	}
    	
    	return driver.findElements(removeButtonGenericXpath).size() == numOfItems;
    }
    
    public void clickCartIcon()
    {
    	Utilities.clickElement(driver, cartIcon);

    }

}
