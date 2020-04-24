package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class iframePractice {

	@Test
	public void handleiframe() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		Thread.sleep(4000);
		
		//We must first find frame size
		//System.out.println(driver.findElement(By.tagName("iframe")).getSize());
		//System.out.println(driver.findElement(By.tagName("frame")).getSize());
		
		//Must switch driver before changing frames
		//We do not know which frame is which so we can try from index 1 then 2, then 3....
		//OR we can switch to frame using the Attribute name as seen below
		//NOTE* You can find name of frame by typing //frame in DOM
		driver.switchTo().frame("packageListFrame");
		//We can create an explicit wait if driver cannot click on link
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("java.applet")));
		driver.findElement(By.linkText("java.applet")).click();
		Thread.sleep(4000);
		//After clicking link on frame to, we can bring driver back to default frame
		driver.switchTo().defaultContent();
		//If u want to switch to another frame using frame index:
		driver.switchTo().frame(1);
		Thread.sleep(4000);
		driver.findElement(By.linkText("AppletContext")).click();
		Thread.sleep(4000);
		
	    
		
		driver.close();
		driver.quit();
	}

}
