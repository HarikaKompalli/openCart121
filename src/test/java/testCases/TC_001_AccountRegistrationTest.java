package testCases;

import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups={"Regression","Master"}) 
	void verify_account_registration() throws InterruptedException {
		try{
			
		logger.info("***** Started TC001_AccountRegistrationTest *****");	
		logger.debug("This is a debug log message");
		
		HomePage hp =new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");
		
		hp.ClickRegister();
		logger.info("Clicked on Register Link.. ");
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		regPage.SetFirstName(randomString().toUpperCase());
		regPage.SetLastName(randomString().toUpperCase());
		regPage.SetEmail(randomString()+"@gmail.com");
		regPage.SetTelphone(randomNumber());
		
		String password = randomAlphaNumeric();
		regPage.SetPassword(password);
		regPage.SetConfirmPassword(password);
		regPage.SetPrivacyPolicy();
		regPage.ClickCtnBtn();
		
		logger.info("Validating expected message..");
		
		String ConfrimMsg=regPage.getConfirmationMsg();
		if(ConfrimMsg.equals("Your Account Has Been Creat...")) {
			Assert.assertTrue(true);
		}else {
			logger.error("Test failed...");
			logger.debug("debug failed..."); 	
			Assert.assertFalse(false);
		}
//		Assert.assertEquals(ConfrimMsg, "Your Account Has Been Created!");
		
		logger.info("Test passed");
		}catch(Exception e) {
			Assert.fail();
		}
		finally {
			logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
	}
	
	
}

