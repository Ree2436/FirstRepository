package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementVariablePractice {

	@Test
	public void handleCssElements() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		
		//When saving a Web Element industry standards are to save it in All caps, words seperated by underscore
		//and ends with ELEMENT
		//Stored Elements listed together is called an Element Library
		WebElement USERNAME_ELEMENT = driver.findElement(By.xpath("//input[@id = 'username']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.id("password"));
		WebElement SIGNINBUTTON_ELEMENT = driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]"));
		
		USERNAME_ELEMENT.sendKeys("techfiosdemo@gmail.com");
		Thread.sleep(4000);
		PASSWORD_ELEMENT.sendKeys("abc123");
		Thread.sleep(4000);
		SIGNINBUTTON_ELEMENT.click();
		Thread.sleep(4000);
		
		
		driver.close();
		driver.quit();
	}

}
