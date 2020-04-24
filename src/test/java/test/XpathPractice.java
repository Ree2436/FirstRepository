package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPractice {

	@Test
	public void validUserShouldBeAbleToLogin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		Thread.sleep(4000);
		
		//using * means ALL or Any. replace tag with *. in this example input was replaced with * so
		//instead of using //input[@placeholder='Email Address'] we used //*[@placeholder='Email Address']
		driver.findElement(By.xpath("//input[@placeholder= 'Email Address']")).sendKeys("techfiosdemo@gmail.com");
		Thread.sleep(4000);
		
		//Finding Xpath using contains(). Formula: contains(@attribute,'value') in this example instead of
		//using //input[@placeholder='Password'] we used //input[contains(@placeholder, 'ssword') and @class='form-control']
		//We can add as many conditions using and. We can also add as many contains() as well
		//You can also replace tage ""input" with * and program will work
		driver.findElement(By.xpath("//input[contains(@placeholder, 'ssword') and @class='form-control']")).sendKeys("abc123");
		Thread.sleep(4000);
		
		//Finding Xpath using text(). text() does not take parameters. You can use text() on text you think is
		//valuable and will not change. In this case the "Sign in" button is valuable and can be used.
		//Works only on text that is black in DOM
		//in this case to use text we will use xpath: //button[text()= 'Sign in'], however we can also use
		//contains: //button[contains(text(), 'Sign in') and @name='login']
		//We can also use "and" to add additional conditions
		driver.findElement(By.xpath("//button[contains(text(), 'Sign in') and @name='login']")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//span[contains(text(), 'Transactions')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[contains(text(), 'Transfer')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("faccount")).click();
		Thread.sleep(4000);
		
		
		
		driver.close();
		driver.quit();
	}

}
