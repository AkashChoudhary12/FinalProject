package com.ImpactChain.org.pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ImpactChain.org.utils.FunctionLibraryESG;

public class DashboardPage extends FunctionLibraryESG{
	
	

	WebDriver driver;

	@FindBy(xpath = "//h2[contains(text(),'Dashboard')]")
	WebElement DashboardTitle;

	@FindBy(xpath = "//*[contains(@src, 'users')]")
	WebElement UserIcon;

	@FindBy(xpath = "//*[contains(text(), 'Log Out')]")
	WebElement LogOutOption;

	@FindBy(xpath = "//span[contains(text(),'ESG Data Registry')]")
	WebElement esgDataRegistry;

	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verityTitle() {
		verify(getText(DashboardTitle), "Dashboard");
	}

	public void clickUserIcon() {
		clickElement(UserIcon);
	}

	public void clickLogOut() {
		clickElement(LogOutOption);
	}

}
