package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	//constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement link_myAcc;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement link_myReg;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement linkLogin;
	
	//Action methods
	
	public void clickMyAccount() {
		link_myAcc.click();
	}
	
	public void ClickRegister() {
		link_myReg.click();
	}
	
	public void ClickLogin() {
		linkLogin.click();
	}

}
