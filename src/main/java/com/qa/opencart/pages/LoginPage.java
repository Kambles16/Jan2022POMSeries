package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utils.ElemntUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElemntUtil eleUtil;
	
	//1.Private By locators
	private By emailID=By.name("email");
	private By pwd = By.id("input-password");
	private By LoginBtn = By.xpath("//input[@type=\"submit\"]"); 
	private By forgotPwd= By.linkText("Forgotten Password");
	private By RegisterLink= By.xpath("//div/a[text()=\"Register\"]");
	
	//2.public page class constructor
	
	public  LoginPage(WebDriver driver) {
		this.driver =driver;
		eleUtil = new ElemntUtil(driver);
	}
	
	//3.public page actions
	
	public String LoginPageTitle() {
		return driver.getTitle();		
		}
	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public Boolean isForgotPwdLinkExists() {
	 return	eleUtil.ElemtIsDisplayed(forgotPwd);
		//return driver.findElement(forgotPwd).isDisplayed();
	}
	
	public AccountPage doLogin(String Uname, String Pwd) {
	  //  eleUtil.waitForElementToBeVisible
		
		eleUtil.doSendkeys(emailID, Uname);
		eleUtil.doSendkeys(pwd, Pwd);
		eleUtil.doClick(LoginBtn);
		return new AccountPage(driver);
	
	}
	
	public boolean isRegisterationLinkExist() {
		return eleUtil.ElemtIsDisplayed(RegisterLink);
	}
	
	public RegistrationPage navigateToRegistrationPage() {
		
		if(isRegisterationLinkExist()) {
			eleUtil.getElement(RegisterLink).click();
			return new RegistrationPage(driver);  //object of registration page
		}
		return null;
	}
	
	

}
