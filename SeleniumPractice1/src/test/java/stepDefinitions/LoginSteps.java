package stepDefinitions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//Objects
import pageObjects.HomePage;
import pageObjects.LoginPageObjects;

public class LoginSteps {
	
	WebDriver driver = setUpClass.driver;
	HomePage homepageobj = new HomePage(driver);
	LoginPageObjects loginpageobjs = new LoginPageObjects(driver);
	Actions action = new Actions(driver);
	
	@Given("The user is in the login page")
	public void user_on_login_page() {
		
		homepageobj.clickSignIn(); // Esta instancia manda a llamar un metodo que hace que
									//se ejecute un metodo para dar click al boton de sign in
		
		//driver.findElement(By.className("login")).click();
		//WebDriverWait wait = new WebDriverWait(driver,10);
	}
	
	@When("The user enter username as {string}")
		public void username(String username) {
		loginpageobjs.PutUser(username);
	}
	
	@And("The user enter password as {string}")
	public void userpassword(String password) {
		loginpageobjs.PutPassword(password);
	}
	
	@And("The user click on sign in button")
	public void clickslogin() {
		loginpageobjs.ClickSignIn();
	}
	
	@Then("The user sould be logged correctly")
	public void user_able_to_view_credentials() {
		assertTrue(loginpageobjs.MyAccountHeaderText().equals("MY ACCOUNT"));
	}
	
	//Scenario 2
	
	@Given("User in login")
	public void user_login_page() {
		System.setProperty("webdriver.chrome.driver", "src//test//resources//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.className("login")).click();
		//WebDriverWait wait = new WebDriverWait(driver,10);
	}
	
	@When("The user is {string}")
		public void usrname(String username) {
		WebElement uesernameLbl = driver.findElement(By.id("email"));
		uesernameLbl.sendKeys(username);
	}
	
	@And("The password is {string}")
	public void usrpsswd(String password) {
		WebElement passwordLbl = driver.findElement(By.id("passwd"));
		passwordLbl.sendKeys(password);
	}
	
	@And("Click on sign in")
	public void clicklogin() {
		WebElement signBtb = driver.findElement(By.id("SubmitLogin"));
		signBtb.click();
	}
	
	@Then("The user shuld not be able to login")
	public void not_able_to_log() {
		if(driver.findElement(By.xpath("//div[@class='alert alert-danger']//*[contains(text(),'failed')]")) != null) {
			WebElement pageAssertion = driver.findElement(By.xpath("//div[@class='alert alert-danger']//*[contains(text(),'failed')]"));
			assertFalse(pageAssertion.isDisplayed() == false);	
		}else if(driver.findElement(By.xpath("//div[@class='alert alert-danger']//*[contains(text(),'invalid')]")) != null) {
			WebElement pageAssertion = driver.findElement(By.xpath("//div[@class='alert alert-danger']//*[contains(text(),'failed')]"));
			assertFalse(pageAssertion.isDisplayed() == false);
		}
		
		driver.quit();
	}
	
	//Scenario 3
	
		@Given("User try to log wo both fields")
		public void user_try_login_wo_fields() {
			System.setProperty("webdriver.chrome.driver", "src//test//resources//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://automationpractice.com/index.php");
			driver.findElement(By.className("login")).click();
			//WebDriverWait wait = new WebDriverWait(driver,10);
		}
		
		@When("User is empty {string}")
			public void blankuser(String username) {
			WebElement uesernameLbl = driver.findElement(By.id("email"));
			uesernameLbl.sendKeys(username);
		}
		
		@And("Password is empty {string}")
		public void blankpassword(String password) {
			WebElement passwordLbl = driver.findElement(By.id("passwd"));
			passwordLbl.sendKeys(password);
		}
		
		@And("Click button")
		public void clickbutton() {
			WebElement signBtb = driver.findElement(By.id("SubmitLogin"));
			signBtb.click();
		}
		
		@Then("Error message displayed")
		public void blank_error() {
			if(driver.findElement(By.xpath("//div[@class='alert alert-danger']//*[contains(text(),'required')]")) != null) {
				WebElement pageAssertion = driver.findElement(By.xpath("//div[@class='alert alert-danger']//*[contains(text(),'An email address required.')]"));
				assertFalse(pageAssertion.isDisplayed() == false);	
			}
			driver.quit();
		}
		
	
		//Scenario 4
		
			@Given("User try to log with blank user")
			public void user_try_login_blank_user() {
				System.setProperty("webdriver.chrome.driver", "src//test//resources//Drivers//chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("http://automationpractice.com/index.php");
				driver.findElement(By.className("login")).click();
				//WebDriverWait wait = new WebDriverWait(driver,10);
			}
			
			@When("User is blank {string}")
				public void blankmail(String username) {
				WebElement uesernameLbl = driver.findElement(By.id("email"));
				uesernameLbl.sendKeys(username);
			}
			
			@And("Password is {string}")
			public void rightpassword(String password) {
				WebElement passwordLbl = driver.findElement(By.id("passwd"));
				passwordLbl.sendKeys(password);
			}
			
			@And("Click sign in")
			public void clickbtn() {
				WebElement signBtb = driver.findElement(By.id("SubmitLogin"));
				signBtb.click();
			}
			
			@Then("Error blank user")
			public void blank_user_error() {
				if(driver.findElement(By.xpath("//div[@class='alert alert-danger']//*[contains(text(),'required')]")) != null) {
					WebElement pageAssertion = driver.findElement(By.xpath("//div[@class='alert alert-danger']//*[contains(text(),'An email address required.')]"));
					assertFalse(pageAssertion.isDisplayed() == false);	
				}
				driver.quit();
			}
	
			//Scenario 5
			
			@Given("User try to log with blank password")
			public void user_try_login_blank_pass() {
				System.setProperty("webdriver.chrome.driver", "src//test//resources//Drivers//chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("http://automationpractice.com/index.php");
				driver.findElement(By.className("login")).click();
				//WebDriverWait wait = new WebDriverWait(driver,10);
			}
			
			@When("User is {string}")
				public void rightmail(String username) {
				WebElement uesernameLbl = driver.findElement(By.id("email"));
				uesernameLbl.sendKeys(username);
			}
			
			@And("Password is blank {string}")
			public void blankpass(String password) {
				WebElement passwordLbl = driver.findElement(By.id("passwd"));
				passwordLbl.sendKeys(password);
			}
			
			@And("Click sign-in")
			public void clicksignbtn() {
				WebElement signBtb = driver.findElement(By.id("SubmitLogin"));
				signBtb.click();
			}
			
			@Then("Error blank password")
			public void blank_pass_error() {
				if(driver.findElement(By.xpath("//div[@class='alert alert-danger']//*[contains(text(),'required')]")) != null) {
					WebElement pageAssertion = driver.findElement(By.xpath("//div[@class='alert alert-danger']//*[contains(text(),'Password is required.')]"));
					assertFalse(pageAssertion.isDisplayed() == false);	
				}
				driver.quit();
			}
			
			//PRACTICA COMPRAR
			@Given("The user go to login")
			public void loginscr() {
				homepageobj.clickSignIn();
			}
			
			@When("Using user {string} and password {string}")
			public void login(String user,String password) {
				loginpageobjs.login(user, password);
			}
			
			@And("Click in women menu")
			public void womenmenu() {
				homepageobj.womenMenu();
				homepageobj.producselection(1,driver);
			}
			
			@And("Proceed to checkout")
			public void Proceed_checkout() {
				homepageobj.checkout(driver);
			}
			
			@Then("Fin")
			public void Fin() {
				
			}
			
}		
