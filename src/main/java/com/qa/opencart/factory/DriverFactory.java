package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public static ThreadLocal<WebDriver> tLDriver = new ThreadLocal<WebDriver>();

	public WebDriver init_driver(Properties prop) {

		String broweser_Name = prop.getProperty("browser");

		System.out.println("Browser name is " + broweser_Name);

		if (broweser_Name.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			// driver= new ChromeDriver();
			tLDriver.set(new ChromeDriver());

		} else if (broweser_Name.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver =new FirefoxDriver();
			tLDriver.set(new FirefoxDriver());
		} else if (broweser_Name.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else {
			System.out.println("Please pass the correct browser");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().fullscreen();
		getDriver().get(prop.getProperty("url"));

		return getDriver();

	}

	public WebDriver getDriver() {
		return tLDriver.get();
	}

	public Properties init_properties() {

		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/Config/properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}
	
	public static String  getScreenshot() {
		
		File srcFile = ((TakesScreenshot)tLDriver).getScreenshotAs(OutputType.FILE);
		String ScreenshotPath= System.getProperty("user.dir")+"/Screenshot/ "+ System.currentTimeMillis()+".png";
		File destination= new File(ScreenshotPath);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 return ScreenshotPath;
	
	}
		
}
