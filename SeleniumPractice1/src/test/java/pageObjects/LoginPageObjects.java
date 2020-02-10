package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

	public LoginPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "SubmitLogin")
	WebElement signInButton;
	
	@FindBy(id="email")
	WebElement LogInUser;
	
	@FindBy(id="passwd")
	WebElement LogInPassword;
	
	@FindBy(how = How.CLASS_NAME, using = "page-heading")
	WebElement HeaderAccount;
	
	public String MyAccountHeaderText() {
		return HeaderAccount.getText();
	}
	
	public void PutUser(String usr) {
		LogInUser.sendKeys(usr);
	}

	public void PutPassword(String pass) {
		LogInPassword.sendKeys(pass);
	}
	
	public void ClickSignIn() {
		signInButton.click();
	}
	
	public void login(String usr,String pass) {
		PutUser(usr);
		PutPassword(pass);
		ClickSignIn();
		
	}
	
}
