package com.qa.opencart;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Base.BaseTest;
import com.qa.opencart.Utils.ExcelUtil;
import com.qa.opencart.Utils.constants;

public class RegistrationPageTest extends BaseTest{
	
	@BeforeClass
	public void regpageSetUp() {
		registrationPage=loginPage.navigateToRegistrationPage();
	}
	
	public String getRandomEmail() {
		Random random= new Random();
		int num= random.nextInt(1000);
		String email= "Jan2022Automation"+ num + "@gmail.com" ;
		return email;
	}
//	
//	@DataProvider //Annotation in testNG
//	public Object[][] getRegData() {
//		return new Object [][]{{"Shaurya" ,"Anna", "9900112233", "Sharuya123", "Yes"},
//				{"Shaurya12" ,"Annade", "9900911223", "Sharuya123", "Yes"},
//				{"Shaurya1092" ,"Ansdnade", "9900911223", "Sharuya123", "Yes"}};
//	}
	
	@DataProvider
	public static Object[][] getRegData() {
		Object regData[][] = ExcelUtil.getData(constants.SHEET_NAME);
		return regData;
	}
	
	@Test(dataProvider = "getRegData")
	public void registrationTest(String firstName, String lastName, String telephone, String password, String Subscribe) {
		Assert.assertTrue(registrationPage.doRegistration(firstName, lastName, getRandomEmail(), telephone,  password, Subscribe));
	}
	
	
	

}
