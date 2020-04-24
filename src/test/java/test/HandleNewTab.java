package test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class HandleNewTab {

	WebDriver driver;

	
	@Before
	public void LaunchBrowser() {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		

	}

	@Test
	public void handleNewTabandWindow () throws InterruptedException {

		driver.get("https://www.yahoo.com/");
		By SEARCH_FIELD_LOCATOR = (By.cssSelector("input#header-search-input"));
		driver.findElement(SEARCH_FIELD_LOCATOR).sendKeys("xpath");
		//To have driver hit ENTER key to search:
		driver.findElement(SEARCH_FIELD_LOCATOR).sendKeys(Keys.ENTER);
		//System.out.println(driver.getWindowHandles());
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("XPath Tutorial - W3Schools")));
		By W3_LINK_LOCATOR = By.linkText("XPath Tutorial - W3Schools");
		driver.findElement(W3_LINK_LOCATOR).click();
		//System.out.println(driver.getWindowHandles());
		Thread.sleep(4000);
		By SQL_LINK_LOCATOR = By.linkText("SQL");
		
		//In order to switch window, we must create a for each loop:
		for(String windowHandle : driver.getWindowHandles()) {
		      
			driver.switchTo().window(windowHandle);
	}
		
		//In case we need to add an Explicit wait for element to be clickable:
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(SQL_LINK_LOCATOR));
		driver.findElement(SQL_LINK_LOCATOR).click();
		
		
		//Window handles change when you open and close windows. It will stay the same until you close it
		//To get window handle:
		//System.out.println(driver.getWindowHandles());
		
		
		driver.close();
		driver.quit();
	}

	
//    @After
//	public void closeEverything() {
//        driver.close();
//		driver.quit();
//	}
}
