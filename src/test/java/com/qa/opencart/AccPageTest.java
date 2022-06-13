package com.qa.opencart;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Base.BaseTest;
import com.qa.opencart.Utils.constants;
import com.qa.opencart.pages.LoginPage;

public class AccPageTest extends BaseTest {
	
	@BeforeClass
	public void accPageSetup() {
		accPage=loginPage.doLogin(prop.getProperty("Uname"), prop.getProperty("Password"));
	}
	
	@Test
	public void accPageTitleTest() {
	 String title =accPage.getAccountPageTitle();
	 Assert.assertEquals(title, constants.ACC_PAGE_TITLE);
	}

	@Test
	public void SearchExistTest() {
		Assert.assertTrue(accPage.isSearchExist());
	}
	
	@Test
     public void accSectionsTest() {
		List<String> actSecList= accPage.getAccSecList();
		System.out.println("Account Section List ="+ actSecList );
		Assert.assertEquals(actSecList, constants.ACCOUNTS_SECTION_LIST);
	}

	@Test
	public void searchHeaderTest() {
		searchResultsPage=accPage.doSearch("Macbook");
		String searchResultsActualeader=searchResultsPage.getResultsPageHeader();
		Assert.assertTrue(searchResultsActualeader.contains("Macbook"));
	}
	
	@Test
	    public void searchProductTest() throws InterruptedException {
		Thread.sleep(5000);
		searchResultsPage=accPage.doSearch("Mac");
		int actProductCount=searchResultsPage.getProductResultList().size();
		Assert.assertEquals(actProductCount, constants.SEARCH_PRODUCT_COUNT);
		}
	
	@Test
	public void getSearchProductListTest() {
		searchResultsPage=accPage.doSearch("Mac");
		List<String> productList= searchResultsPage.getProductResultList();
		System.out.println(productList);
		
	}
	
//	@Test
//	public void selectProductTest() {
//		searchResultsPage.selectProduct(productName);
//	}
	
}
