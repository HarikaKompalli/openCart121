package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void verify_login(){
	try {
		logger.info("***** Started TC_002_LoginTest *****");	
		logger.debug("This is a debug log message");
		
		//Homepage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");
		hp.ClickLogin();
		logger.info("Clicked on login Link.. ");
		
		//loginPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//myAccountPage
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccExists();
//		Assert.assertEquals(targetPage, true, "Login Failed");
		Assert.assertTrue(targetPage);
		logger.info("Test passed");
		}
		
	    catch(Exception e) {
		Assert.fail();
		}
	
		finally {
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}
	}

}
