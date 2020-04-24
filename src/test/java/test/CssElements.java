package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssElements {

	@Test
	public void handleCssElements() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://objectspy.space/");
		
		Thread.sleep(5000);
		//Click on Male using Css tagname#id. In this example: "input#sex-0"
		driver.findElement(By.cssSelector("input#sex-0")).click();
		Thread.sleep(5000);
		//Click on Female using Css tag[attribute='value'] In this example: input[value='Female']
		driver.findElement(By.cssSelector("input[value='Female']")).click();
		Thread.sleep(5000);
		//Other methods you can use: tag.class which would be label.radio
		// OR tag.class[attribute='value'] which would be label.radio[for='sex-1']
		
		driver.close();
		driver.quit();
	}

}
