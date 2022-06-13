package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.opencart.Utils.ElemntUtil;

public class SearchResultsPage {

	private WebDriver driver;
	private ElemntUtil eleUtil;
	

	private By searchHeader = By.cssSelector("div#content h1");
	private By MacBook = By.xpath("//a[text()=\"MacBook Pro\"]");
	private By products = By.xpath("//img[contains(@title,\"MacBook\")]");
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil= new ElemntUtil(driver);
	}
	
	public String getResultsPageHeader() {
		if(eleUtil.ElemtIsDisplayed(searchHeader)) {
			return eleUtil.getElementText(searchHeader);
			}
		return null;
			}
	
	public List<String> getProductResultList() {
		List<String> prodList= new ArrayList<String>();
		List<WebElement> product=eleUtil.getElements(products);
		for(WebElement prod: product) {
			String prodName=prod.getText();
			prodList.add(prodName);
		}
		return prodList;
	}
	
    public ProductInfo selectProduct(String productName) {
    	System.out.println("product name entered is "+ productName);
    	List<WebElement> product= eleUtil.getElements(products);
    	for(WebElement e: product) {
    		if(e.getText().contains(productName)) {
    			e.click();
    			break;
    		}
    	}
    	return new ProductInfo(driver);
	
}

}
