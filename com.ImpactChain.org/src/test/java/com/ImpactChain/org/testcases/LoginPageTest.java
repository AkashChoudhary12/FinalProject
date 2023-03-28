package com.ImpactChain.org.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ImpactChain.org.base.TestBase;
import com.ImpactChain.org.pageclass.DashboardPage;
import com.ImpactChain.org.pageclass.LoginPage;

public class LoginPageTest extends TestBase {

	private LoginPage loginPage;
	private DashboardPage dashboardPage;

	public LoginPageTest() {
		// calls the constructor of extended TestBase class
		super();

	}

	@Parameters("browser")
	@BeforeTest
	public void configExtent(@Optional("") String browser) {

		setExtent();

	}

	@AfterTest
	public void endExtentReport() {

		endReport();
//		extent.flush();

	}

	@BeforeMethod
	@Parameters("browser")
	public void setUp(Method method, @Optional("") String browser) throws Exception {

//		LogUtil.startTestCase(method.getName());
		initialization(browser);

	}

	@Test
	public void verifyLogin() {
		
		
		logger = extent.createTest("verify login functionality");
		loginPage = new LoginPage(driver);
		loginPage.login("shanti@globallogic.com", "123456");

		dashboardPage = new DashboardPage(driver);
		dashboardPage.verityTitle();
		dashboardPage.clickUserIcon();
		dashboardPage.clickLogOut();
		loginPage.verifyLoginText();

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		setExtentLogAndAddScreenshot(result);
//		LogUtil.endTestCase(result.getMethod().getMethodName());
		driver.quit();
		System.out.println("From tearDown");
	}

}
