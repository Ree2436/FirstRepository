package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VariousElements {
	
	@Test
	public void exploreVariouselements() throws InterruptedException {
		
	//Set Chrome Driver as your default driver
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		//Instantiate chromedriver object
		WebDriver driver = new ChromeDriver();
		
		//Implicit wait. Driver will wait until an action is performed based on time that is set. In this case, driver will wait 10 seconds
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//Delete cookies and History
		driver.manage().deleteAllCookies();
		
		//Maximize window
		driver.manage().window().maximize();
		
		//Go to website
		driver.get("http://objectspy.space/");
		
		//Click on radio button: Male
		driver.findElement(By.id("sex-0")).click();
		Thread.sleep(5000);
		
		//Fill in First Name field
		driver.findElement(By.name("firstname")).sendKeys("Riyad");
		Thread.sleep(5000);
		
		//Click on LinkText
		driver.findElement(By.linkText("Link Test : New Page")).click();
		Thread.sleep(5000);
		
		//Partial LinkText
		//driver.findElement(By.partialLinkText("OS-API Product FrontEnd")).click();
		//Thread.sleep(5000);
		
		//Class Name ***Not Recommended because value in class name repeats itself at times
		//driver.findElement(By.className("control-group")).click();
		
		//Slows down an action 1000ms = 1 sec
		Thread.sleep(5000);
		//Close browser
		driver.close();
		//Make sure to quit driver so browser does not use up bandwidth
		driver.quit();

		
	}
	
}
