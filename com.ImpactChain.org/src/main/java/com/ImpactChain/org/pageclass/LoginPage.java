package com.ImpactChain.org.pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ImpactChain.org.utils.FunctionLibraryESG;

public class LoginPage extends FunctionLibraryESG {

	WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement username;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='button']")
	WebElement loginBtn;

	@FindBy(xpath = "//img[@class='image']")
	WebElement impactChainLogo;

	@FindBy(xpath = "//span[normalize-space()='Powered by']")
	WebElement copperWireLogo;

	@FindBy(xpath = "//span[@class='el-checkbox__inner']")
	WebElement keeploginCheckBox;

	@FindBy(xpath = "//span[@class='show-pwd']//*[name()='svg']")
	WebElement pwdViewBtn;

	@FindBy(xpath = "//span[normalize-space()='Forgot Password']")
	WebElement forgotPasswordBtn;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions:Get login page title
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	// Action:login
	public void login(String un, String pwd) {

		sendInput(username, un);

		sendInput(password, pwd);

		clickElement(loginBtn);

	}

	public void verifyLoginText() {

		verify(getText(loginBtn), "Sign In");

	}

}
