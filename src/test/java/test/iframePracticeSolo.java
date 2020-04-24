package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class iframePracticeSolo {

	@Test
	public void handleiframe() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		Thread.sleep(3000);
		
		driver.switchTo().frame("packageListFrame");
		Thread.sleep(3000);
		driver.findElement(By.linkText("java.awt.datatransfer")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("ClipboardOwner")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.linkText("StringSelection")).click();
	    
		
		driver.close();
		driver.quit();
	}

}
