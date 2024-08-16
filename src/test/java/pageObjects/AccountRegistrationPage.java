package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	//constructor
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//locator
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtTelphone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtConfirmPassword;
	@FindBy(xpath="//input[@name='agree']") WebElement  chkdPolicy;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")	WebElement msgConfirmation;
	//Action methods
	
	
	public void SetFirstName(String fName) {
		txtFirstName.sendKeys(fName);
	}
	
	
	public void SetLastName(String lName) {
		txtLastName.sendKeys(lName);
	}
	public void SetEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void SetTelphone(String tel) {
		txtTelphone.sendKeys(tel);
	}
	public void SetPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void SetConfirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);
	}
	public void SetPrivacyPolicy() {
		chkdPolicy.click();
	}
	
	public void ClickCtnBtn() {
		btnContinue.click();
	}
	
	public String getConfirmationMsg() {
		try {
		return(msgConfirmation.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
		
	}

}
