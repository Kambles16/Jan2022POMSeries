package com.qa.opencart;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Base.BaseTest;
import com.qa.opencart.Utils.ExcelUtil;
import com.qa.opencart.Utils.constants;

import bsh.org.objectweb.asm.Constants;

public class ProductInfoPageTest extends BaseTest {
	
	@BeforeClass
	public void productInfoPageSetup() {
		accPage=loginPage.doLogin(prop.getProperty("Uname"), prop.getProperty("Password"));
	}
	
	@DataProvider
	public Object[][] getProductData(){
		Object data[][]=ExcelUtil.getData(constants.PRODUCT_DATA_SHEET);
		return data;
		}
	
	@Test(dataProvider="getProductData()")
	public void productInfoPageHeaderTest(String mainProduct , String productName ) throws InterruptedException {
		searchResultsPage=accPage.doSearch(productName);
		productInfo=searchResultsPage.selectProduct(mainProduct);
		Thread.sleep(3000);
	//	String ProductHeader= productInfo.getProductHeader();
		Assert.assertEquals(productInfo.getProductHeader(), mainProduct);
	}
	
	
	@Test
	public void productImagesTest() {
		searchResultsPage =	accPage.doSearch("MacBook Pro");
		productInfo = searchResultsPage.selectProduct("MacBook Pro");
		Assert.assertTrue(productInfo.getImgCount()== constants.IMAGES_COUNT);;
	}
	
	@Test
	public void productInfoTest() {
		searchResultsPage=accPage.doSearch("MacBook Pro");
		productInfo = searchResultsPage.selectProduct("MacBook Pro");
		Map<String , String> actProductInfoMap = productInfo.getProductInfo();
		actProductInfoMap.forEach((k,v)-> System.out.println(k +" : "+ v));
		softAssert.assertEquals(actProductInfoMap.get("productname"), "MacBook Pro");
		softAssert.assertEquals(actProductInfoMap.get("Brand"), "Apple");
		softAssert.assertEquals(actProductInfoMap.get("Reward Points"), "800");
		softAssert.assertAll();
	}
	

	

}
