package com.qa.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfo;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {

	public WebDriver driver;
	public DriverFactory df;
	public LoginPage loginPage;
	public AccountPage accPage;
	public SearchResultsPage searchResultsPage;
	public Properties prop;
	public ProductInfo productInfo;
	public RegistrationPage registrationPage;
	public SoftAssert softAssert;
	
	@BeforeTest
	public void setUp() {
	df= new DriverFactory();
    prop =  df.init_properties();
	driver= df.init_driver(prop);
	loginPage = new LoginPage(driver);
	accPage= new AccountPage(driver);
	searchResultsPage= new SearchResultsPage(driver);
	registrationPage = new RegistrationPage(driver);
	softAssert =new SoftAssert();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
