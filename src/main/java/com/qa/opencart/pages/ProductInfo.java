package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utils.ElemntUtil;
import com.qa.opencart.Utils.constants;

public class ProductInfo {

	private WebDriver driver;
	private ElemntUtil eleUtil;
	private HashMap<String, String> map;

	private By ProductHeader = By.cssSelector("div#content h1");
	private By imgProduct = By.cssSelector("div#content img");
	private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1)");
	private By productpriceData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2)");
	private By qty = By.id("input-quantity");
	private By addToCart = By.id("button-cart");
	private By successAddtoCart = By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]");

	public ProductInfo(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElemntUtil(driver);
	}

	public String getProductHeader() {
		return eleUtil.getElementText(ProductHeader);

	}

	public int getImgCount() {
		List<WebElement> images = eleUtil.getElements(imgProduct);
		int imgCount = images.size();
		return imgCount;

	}

	public Map<String, String> getProductInfo() {
		map = new HashMap<String, String>();
		map.put("productname",getProductHeader() );
		map.put("ImgCount", String.valueOf(getImgCount()));
		getMetaData();
		getProductPriceData();
		return map;
	}

	private void getMetaData() {
		List<WebElement> Metadata = eleUtil.getElements(productMetaData);
		// Brand: Apple
		// Product Code: Product 17
		// Reward Points: 700
		// Availability: Out Of Stock
		for (WebElement e : Metadata) {
			String text = e.getText().trim();
			String data[] = text.split(":");
			String DataKey = data[0].trim();
			String dataValue = data[1].trim();
			map.put(DataKey, dataValue);
		}
	}
	
	private void getProductPriceData() {
		List<WebElement> priceList=eleUtil.getElements(productpriceData);
		  String price= priceList.get(0).getText().trim();
		  String exPrice= priceList.get(1).getText().trim();
	        map.put("price", price);
	        map.put("exPrice", exPrice);
			
		}

//  public void getQuntity() {
//	  WebElement TextboxQuntity = eleUtil.getElement(qty);
//	  eleUtil.doSendkeys(qty, 1);
//	  
//  }
}
