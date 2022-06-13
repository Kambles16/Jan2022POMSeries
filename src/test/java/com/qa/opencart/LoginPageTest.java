package com.qa.opencart;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Base.BaseTest;
import com.qa.opencart.Utils.constants;

public class LoginPageTest extends BaseTest{
	
	@Test
	public void loginPageTitleTest() {
		String title=loginPage.LoginPageTitle();
		Assert.assertEquals(title, constants.LOGIN_PAGE_TITLE);
	}

	@Test
	public void loginPageUrlTest() {
		String URL=loginPage.getLoginPageUrl();
		Assert.assertTrue(URL.contains(constants.URL_FRACTION));
	}
	
	@Test 
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExists());
		}
	
	@Test
	public void loginToApp() throws InterruptedException {
		Thread.sleep(5000);
		accPage=loginPage.doLogin(prop.getProperty("Uname"),prop.getProperty("Password"));
		Assert.assertTrue(accPage.isAccountPageHeaderExist());
	}
}
