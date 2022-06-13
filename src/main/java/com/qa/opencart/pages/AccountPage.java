package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utils.ElemntUtil;

public class AccountPage {

	private WebDriver driver;
	private ElemntUtil eleUtil;

	private By search = By.xpath("//input[@name= \"search\"]");
	private By searchBtn = By.cssSelector("div#search button");
	private By header = By.cssSelector("div#logo h1");
	private By AccSecList = By.cssSelector("div#content h2");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil= new ElemntUtil(driver);
	}

	public String getAccountPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public boolean isAccountPageHeaderExist() {
		return eleUtil.ElemtIsDisplayed(header);
	}

	public boolean isSearchExist() {
		return eleUtil.ElemtIsDisplayed(search);
	}

	public SearchResultsPage doSearch(String ProductName) {
		eleUtil.doSendkeys(search, ProductName);
		eleUtil.doClick(searchBtn);
		return new SearchResultsPage(driver);

	}
	
	public List<String> getAccSecList() {
		List<WebElement> HeaderList= eleUtil.getElements(AccSecList);
		List<String> AccHeaderList= new ArrayList<String>();
		for(WebElement e:HeaderList ) {
		 String text=e.getText();
		 AccHeaderList.add(text);
		}
		return AccHeaderList;
	}

}
