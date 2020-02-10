package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CLASS_NAME, using = "login")
	WebElement signInBtn;
	
	@FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
	WebElement WomenMenu;
	
	@FindBy(xpath = "//ul[@class='product_list grid row']/li")
	List<WebElement> Productos;
	
	@FindBy(xpath = "//span[text()='Add to cart']")
	List<WebElement> AddToCarButton;
	
	@FindBy(xpath="//div[@id='layer_cart']//div[@class='clearfix']//a[@rel=\"nofollow\"]")
	WebElement checkoutBtn;
	
	public void clickSignIn() {
		signInBtn.click();
	}
	
	public void womenMenu() {
		WomenMenu.click();
	}
	
	public void producselection(int index, WebDriver driver) {
		Actions ac = new Actions(driver);
        System.out.println(Productos.size());
        if (index <= Productos.size()-1) {
            ac.moveToElement(Productos.get(index)).perform();
            AddToCarButton.get(index).click();
        }
	}
	
	public void checkout(WebDriver driver) {
		Actions ac = new Actions(driver);
		ac.moveToElement(checkoutBtn);
		checkoutBtn.click();
	}
}
