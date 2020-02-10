package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class setUpClass {

	public static WebDriver driver;
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src//test//resources//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
}
