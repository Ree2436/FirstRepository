package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaTest {

	@Test
	public void handleCssElements() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");		
        Thread.sleep(5000);
        
        driver.findElement(By.xpath("//input[contains(@placeholder, 'Search')]")).sendKeys("tekken 7");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(@class, 'style-scope ytd-searchbox')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(text(), 'Tekken 7 Patch 3.31 Armor King Wishlist!') and @class = 'style-scope ytd-video-renderer']")).click();
		Thread.sleep(10000);
		
		
		
		driver.close();
		driver.quit();
	}

}
