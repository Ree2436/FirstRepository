package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class AssertionPractice {

	@Test
	public void handleCssElements() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		
		driver.findElement(By.xpath("//input[@type= 'text']")).sendKeys("techfiosdemo@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("abc123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name = 'login']")).click();
		Thread.sleep(3000);
		
		String DashboardTitle = "//div[@id='page-wrapper']//descendant::h2";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DashboardTitle)));
		
		String expectedTitile = "Dashboard- TechFios Test Application - Billing";
		String actualTitle = driver.getTitle();
		Assert.assertEquals("Test Failed", expectedTitile, actualTitle);
				
		
		////div[@id='page-wrapper']//descendant::h2 
		//Dashboard- TechFios Test Application - Billing
		//Assert validates by setting a conditon for failure and throwing exception accordingly.
		driver.close();
		driver.quit();
	}

}
