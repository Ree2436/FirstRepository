package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	@Test
	public void handleCssElements() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		
		driver.findElement(By.xpath("//input[@type= 'text']")).sendKeys("techfiosdemo@gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("abc123");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@name = 'login']")).click();
		Thread.sleep(5000);
		
		
		driver.close();
		driver.quit();
	}

}
