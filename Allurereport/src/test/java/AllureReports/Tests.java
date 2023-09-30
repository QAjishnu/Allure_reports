package AllureReports;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class Tests {

	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("headless");
		driver = new ChromeDriver();
		driver.get("https://www.nopcommerce.com/en/login?returnUrl=%2Fen");
		driver.manage().window().maximize();
		}
	@Test(priority=1, description= "logo testing")
	public void logopresence()
	{
		boolean status=driver.findElement(By.xpath("//img[@title='nopCommerce']")).isDisplayed();
		Assert.assertEquals(status, true);
	}
	
	@Test(priority=2, description= "Login Scenario with wrong username and password.")
	@Description("VErify")
	@Epic("EP001")
	@Feature("To be login")
	@Story("Demo Story")
	@Severity(SeverityLevel.MINOR)
	@Step("Verify Log")
	
	public void LoginTest()
	{
		driver.findElement(By.id("Username")).sendKeys("testtest01");
		driver.findElement(By.id("Password")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");
}
	@Test(priority=3)
	public void RegistrationTest()
	{
		throw new SkipException("skipping the test");
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}



