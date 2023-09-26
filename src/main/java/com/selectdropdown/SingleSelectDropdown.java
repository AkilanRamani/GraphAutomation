package com.selectdropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingleSelectDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("F:\\MakeSeleniumEasy\\HTML Files\\singleSelectDD.html");
		
		// Locating select tag web element
		WebElement singleSelectTagDropdownWebElement= driver.findElement(By.id("SingleDD"));
		// Passing select tag web element to Select class constructor to get a Select class object
		Select selectObject= new Select(singleSelectTagDropdownWebElement);
		
		// How to print all options available in drop-down
		List<WebElement> allOptions=selectObject.getOptions();
		System.out.println("All options are printed below:");
		for(WebElement option: allOptions)
		{
			String value= option.getText();
			System.out.println(value);
		}
		
		// How to select a value from drop-down
		
		selectObject.selectByIndex(1);
		Thread.sleep(2000);
		selectObject.selectByValue("Kannada");
		Thread.sleep(2000);
		selectObject.selectByVisibleText("English");
		
		// How to get selected value from dropdown
		selectObject.selectByVisibleText("English");
		WebElement selectedValue= selectObject.getFirstSelectedOption();
		String optionValue= selectedValue.getText();
		System.out.println("Selected value is: "+optionValue);
		
		// Get selected option using getAllSelectedOptions()
		
		List<WebElement> selectedOptn= selectObject.getAllSelectedOptions();
		if(selectedOptn.size()>=1)
		{
			System.out.println("Selected value is: "+selectedOptn.get(0).getText());
		}
		
		
		// What happens when we pass wrong index/value/visibletext
		
		//selectObject.selectByIndex(10);
		//selectObject.selectByValue("Kannada");
		//selectObject.selectByVisibleText("English ");
		 
		
		
	
		driver.quit();
	}

	}


