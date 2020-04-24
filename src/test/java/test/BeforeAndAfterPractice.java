package test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class BeforeAndAfterPractice {

	WebDriver driver;

	// @Before will run before everything else. So we can place functions that is
	// needed for EVERY method here
	// instead of needlessly writing them in every method
	// Must always be executed before @Test
	@Before
	public void LaunchBrowser() {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

	@Test
	public void handleHoverOver() throws InterruptedException {

		Thread.sleep(4000);
		driver.get("https://www.dell.com/en-us");
		// To use Hover over we must use a class called "Actions"
		// Be sure to import correctly. org.openqa.selenium.interactions (usually 1st
		// one)
		Actions action = new Actions(driver);
		WebElement DEALS_TAB_ELEMENT = driver.findElement(By.xpath("//ul[@class='mh-site-nav']//descendant::button[contains(text(), 'Deals')]"));

		Thread.sleep(4000);
		// When using moveToElement be sure to ALWAYS end with .build().perform();
		action.moveToElement(DEALS_TAB_ELEMENT).build().perform();
		Thread.sleep(4000);
		WebElement GAMING_PC_DEALS_ELEMENT = driver.findElement(By.partialLinkText("Gaming PC Deals"));
		GAMING_PC_DEALS_ELEMENT.click();
		Thread.sleep(4000);
		driver.close();
		driver.quit();
	}

	@Test
	public void handlebeforeafter() throws InterruptedException {

		driver.get("http://techfios.com/test/billing/?ng=admin/");

		WebElement USERNAME_ELEMENT = driver.findElement(By.xpath("//input[@id = 'username']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.id("password"));
		WebElement SIGNINBUTTON_ELEMENT = driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]"));

		USERNAME_ELEMENT.sendKeys("techfiosdemo@gmail.com");
		Thread.sleep(4000);
		PASSWORD_ELEMENT.sendKeys("abc123");
		Thread.sleep(4000);
		SIGNINBUTTON_ELEMENT.click();
		Thread.sleep(4000);

		//String expectedTitle = "Dashboard- TechFios Test Application - Billing";
		//String actualTitle = driver.getTitle();
		//Thread.sleep(4000);

		//Assert.assertEquals("Test Failed", expectedTitle, actualTitle);

		driver.close();
		driver.quit();

	}

	// @After will run after each method
	// So we can use this to close browsers EVEN IF TEST FAILS
	// Must be executed after @Test
	@After
	public void closeEverything() {

		driver.close();
		driver.quit();
	}
}
