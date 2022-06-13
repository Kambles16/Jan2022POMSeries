package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utils.ElemntUtil;
import com.qa.opencart.Utils.constants;

public class RegistrationPage {

	private WebDriver driver;
	private ElemntUtil eleUtil;

	private By firstName = By.xpath("//input[@name=\"firstname\"]");
	private By lastName = By.xpath("//input[@name=\"lastname\"]");
	private By email = By.xpath("//input[@name=\"email\"]");
	private By telephone = By.xpath("//input[@name=\"telephone\"]");
	private By password = By.xpath("//input[@name=\"password\"]");
	private By confirmPwd = By.xpath("//input[@name=\"confirm\"]");
	private By subscribeYes = By.xpath("//label[@class=\"radio-inline\"]/input[@type=\"radio\" and @value=\"1\"]");
	private By subscribeNo = By.xpath("//label[@class=\"radio-inline\"]/input[@type=\"radio\" and @value=\"0\"]");
	private By agreeCheckBox = By.xpath("//input[@name=\"agree\"]");
	private By continueBtn = By.xpath("//input[@value=\"Continue\"]");
	private By accSuccMsg = By.cssSelector("div#content h1");
	private By logout = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean doRegistration(String firstName, String lastName, String email, String telephone, String password,
			 String subscribe) {

		eleUtil.doSendkeys(this.firstName, firstName);
		eleUtil.doSendkeys(this.lastName, lastName);
		eleUtil.doSendkeys(this.email, email);
		eleUtil.doSendkeys(this.telephone, telephone);
		eleUtil.doSendkeys(this.password, password);
		//eleUtil.doSendkeys(this.confirmPwd, confirmPwd);

		if (subscribe.equalsIgnoreCase("Yes")) {
			eleUtil.doClick(subscribeYes);
		} else
			eleUtil.doClick(subscribeNo);

		eleUtil.doClick(agreeCheckBox);
		eleUtil.doClick(continueBtn);
		String text= getSuccessMsg();
		if(text.contains(constants.REGISTER_SUCCESS_MESSAGE)) {
			goToRegistrationPage();
			return true;
		}
		return false;
	}

	public String getSuccessMsg() {
		return eleUtil.getElementText(accSuccMsg);

	}
	
	private void goToRegistrationPage() {
		eleUtil.doClick(logout);
		eleUtil.doClick(registerLink);
	}

}
