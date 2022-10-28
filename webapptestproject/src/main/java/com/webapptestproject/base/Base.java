package com.webapptestproject.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.webapptestproject.actiondriver.ActionImpl;
import com.webapptestproject.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

// http://automationpractice.com/
public class Base {
	
	public static Properties prop;
	
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	@BeforeSuite(groups= {"Smoke", "Sanity", "Regression"})
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") +"\\Configuration\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Parameters("browser")
	public static void loadWebapp(String browser) {
	//	String browser = prop.getProperty("browser");
		if( browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		} else {
			System.out.println("Browser Name Invalid !");
		}
		getDriver().manage().deleteAllCookies();
		// check
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// fix
	//	getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	//	ActionImpl.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
		
	}
	
	public static RemoteWebDriver getDriver() {
		return driver.get();
	}
	

	public static RemoteWebDriver getThreadDriver() {
		return driver.get();
	}

	@AfterSuite(groups= {"Smoke", "Regression", "Sanity"})
	public void afterSuite() {
		ExtentManager.endReport();
	}
}
