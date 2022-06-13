package com.qa.opencart.Utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElemntUtil {

	private WebDriver driver;

	public ElemntUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By Locator) {
		return driver.findElement(Locator);

	}

	public void doSendkeys(By Locator, String Locator_Value) {
		WebElement ele = getElement(Locator);
		ele.clear();
		ele.sendKeys(Locator_Value);
	}
//	
//	public void doSendkeys(By Locator, int Locator_Value) {
//		WebElement ele = getElement(Locator);
//		ele.clear();
//		ele.sendKeys(Locator_Value);
//	}

	public void doClick(By Locator) {
		getElement(Locator).click();
	}

	public boolean ElemtIsDisplayed(By Locator) {
		return getElement(Locator).isDisplayed();
	}

	public String getElementText(By Locator) {
		return getElement(Locator).getText();
	}

	public List<WebElement> getElements(By Locator) {
		return driver.findElements(Locator);
	}

	public List<String> getLinkText(By Locator) {
		List<WebElement> Links = getElements(Locator);
		List<String> ArraytextLink = new ArrayList<String>();

		for (WebElement e : Links) {
			String text = e.getText();

			if (!text.isEmpty()) {
				ArraytextLink.add(text);
				System.out.println(ArraytextLink);
			}

		}
		return ArraytextLink;
	}

	public List<String> getElementAttribute(By Locator, String AttributeValue) {
		List<WebElement> AttributeElements = getElements(Locator);
		List<String> AttributeList = new ArrayList<String>();

		for (WebElement e : AttributeElements) {
			String Attribute = e.getAttribute(AttributeValue);

			System.out.println(Attribute);
			AttributeList.add(Attribute);

		}
		return AttributeList;

	}

	// ==================DropDown Utils========================//

	public void selectElementByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void selectElementByVisisblrText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	public void selectElementByValue(By locator, String Value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(Value);
	}

	public List<String> getDropdownOptions(By Locator) {
		Select select = new Select(getElement(Locator));
		List<WebElement> OptionsList = select.getOptions();// list of contries
		List<String> CountryName = new ArrayList<String>();
		for (WebElement e : OptionsList) {
			String Text = e.getText();
			System.out.println(Text);
			CountryName.add(Text);
		}
		return CountryName;
	}

	public void selectDropdownOptions(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> OptionsList = select.getOptions();

		for (WebElement e : OptionsList) {
			String Text = e.getText();
			if (Text.contains(value)) {
				e.click();
				break;
			}
		}
	}

//	public void doSendkeys(By locator, int i) {
//	  getElement(locator)
//	  
//		
//	}

//	public  WebElement waitForElementToBeVisible(By locator, int timeOut) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));//sel 4.x
//		
//		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//	}
//	

}
