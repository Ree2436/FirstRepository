package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertandPopups {

	@Test
	public void handlePopUps() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.rediff.com/");
		
		driver.findElement(By.xpath("//a[contains(text(), 'Sign in')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class= 'cell']//descendant::input[@class = 'signinbtn']")).click();
		Thread.sleep(3000);
		
		//We should add an Explicit wait in case browser closes before alert box pops up
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'cell']//descendant::input[@class = 'signinbtn']")));
		//When alert box pops up, you will need to handle it with a variation of this code
		//in this example the pop up window has an ok button to click so we use the following code
		driver.switchTo().alert().accept();
		Thread.sleep(4000);
		
		//For an alert/popup that has a cancel button you use the following code:
		//driver.switchTo().alert().dismiss();
		
		//To capture an Alert message you will use the following code:
		//driver.switchTo().alert().getText().
		
		//To send some data to an alert box:
		//driver.switchTo().alert().sendKeys("Example Here");
		
		driver.close();
		driver.quit();
	}

}
