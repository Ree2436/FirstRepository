package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class XpathAxisandAssertion {

	@Test
	public void handleCssElements() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
        driver.get("http://techfios.com/test/billing/?ng=login/");		
        Thread.sleep(5000);
        
        //Xpath Axis:
        //parent  (Shortcut for going to parent /..)
        //child
        //following-sibling
        //preceding-sibling
        //ancestor
        //descendant
        //Add //relationship::(then xpath to desired node)
        
        driver.findElement(By.xpath("//div[@class= 'sign-in-inner']//descendant::input[@type = 'text']")).sendKeys("echfiosdemo@gmail.com");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[@class='form-group']//child::*")).sendKeys("abc123");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[@class='m-top-md p-top-sm']//child::button")).click();
        Thread.sleep(4000);
        
        
        //Assertion
        String expectedTitle = "Dashboard- TechFios Test Application - Billing";
        String actualTitle = driver.getTitle();
        
//        if(actualTitle.equalsIgnoreCase(expectedTitle)) {
//            System.out.println("Test Pass!"); 	
//        }
//        else {
//        	System.out.println("Test Failed.");
//        	throw new RuntimeException();
//        }
        
        //Assertion will throw exception when test fails. Will continue to next line if test passes.
        //Assert.assertEquals(Stringmessage, String expected, String actual)
        Assert.assertEquals("Test Failed", expectedTitle, actualTitle);
        
        String dashboardTitleXpath = "//div[@id='page-wrapper']//descendant::h2";
        
        //Explicit Wait. Wait applied specifically to each element, each time. Includes a time constraint.
        //Can also specify conditions such as visibilityofelementlocated, elementtobeclickable
        //To use explicit wait, we must first create a WebDriverWait "wait" object to get functions:
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dashboardTitleXpath)));
		
		driver.close();
		driver.quit();
	}

}
