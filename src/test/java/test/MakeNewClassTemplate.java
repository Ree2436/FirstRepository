package test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class MakeNewClassTemplate {

	WebDriver driver;

	
	//@Before
	public void LaunchBrowser() {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

	//@Test
	public void handleHoverOver() throws InterruptedException {

		Thread.sleep(2000);
		driver.get("URL");
		
		
		
		
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

	
}
