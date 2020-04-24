package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HoverOverAndMouseOverSolo {
	
	WebDriver driver;

	@Test
	public void handleHoverOver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.dell.com/en-us");
		Thread.sleep(4000);
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//button[@id='l2']"))).build().perform();
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='l2_3']/child::span"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.linkText("High Performance Computing")).click();
		Thread.sleep(3000);
		
		Thread.sleep(4000);
		driver.close();
		driver.quit();
	}
	
	
	
	//@After will run after each method
	//So we can use this to close browser EVEN IF TEST FAILS
	@After
	public void closeEverything() {
		
		driver.close();
		driver.quit();
	}
}

