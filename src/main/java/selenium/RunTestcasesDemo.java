package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class RunTestcasesDemo {
	WebDriver driver;

	//
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_DemoRunOnJenkins() {
		String loginTitle = driver.getTitle();
		Assert.assertEquals("Guru99 Bank Home Page", loginTitle);
		WebElement userTxt = driver.findElement(By.xpath("//input[@name='uid']"));
		Assert.assertTrue(userTxt.isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
