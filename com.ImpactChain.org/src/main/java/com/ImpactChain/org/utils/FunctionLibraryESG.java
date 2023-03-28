package com.ImpactChain.org.utils;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FunctionLibraryESG {
	
	
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse;

	public FunctionLibraryESG(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(
				Integer.parseInt(getProperty("src\\main\\resources\\config.properties", "timeOut_duration"))));
		jse = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	public void sendInput(WebElement locator, String input) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		scrollToElement(element);
		HighlightElement(element);
		element.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
		element.sendKeys(input);

		LogUtil.info("sent input successfully");

	}

	public void clickElement(WebElement locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		scrollToElement(element);
		HighlightElement(element);
		element.click();
		LogUtil.info("click element successfully");

	}

	public String getText(WebElement locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
		scrollToElement(element);
		HighlightElement(element);
		LogUtil.info("get Text successfully");
		return element.getText();

	}

	public String getAttribute(WebElement locator, String attribute) {
		WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
		scrollToElement(element);
		HighlightElement(element);
		return element.getAttribute(attribute);
	}

	public void selectDropDown(WebElement element1, String DropDownName) {
		WebElement element = wait.until(ExpectedConditions.visibilityOf(element1));
		Select select = new Select(element);
		select.selectByVisibleText(DropDownName);
		scrollToElement(element);
		HighlightElement(element);

		LogUtil.info("Dropdown Selected successfully");

	}

	public void HighlightElement(WebElement element) {
		try {
			jse.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);

		} catch (Exception e) {
			LogUtil.info("Failed to HighLight");
		}
	}

	public void scrollToElement(WebElement element) {
		try {
			jse.executeScript("arguments[0].scrollIntoView(false);", element);
		} catch (Exception e) {
			LogUtil.info("Failed to scroll");
		}
	}

	public void verify(Object obj1, Object obj2) {
		Assert.assertEquals(obj1, obj2);
		LogUtil.info("verify successfully");
	}

	public String getProperty(String filepath, String propertyName) {

		try {
			FileReader fr = new FileReader(filepath);
			Properties props = new Properties();
			props.load(fr);
			return props.getProperty(propertyName);
		} catch (Exception e) {

			LogUtil.info("Failed to getProperty");

		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	

}
