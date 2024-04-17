package testCases;

import java.time.Duration;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.SignupPage;
import testBase.BaseClassREA;

public class TC_003_LoginTest extends BaseClassREA {
	
	
	
	@Test(groups= {"sanity"})
	public void verify_login() throws InterruptedException
	
	{   
		SoftAssert myassert = new SoftAssert();
		logger.info("***  Starting TC_003_LoginTest  ***");
	    logger.debug("caputuring application debug logs.......");
		
			
			
		//Login Page	
		LoginPage lp=new LoginPage(driver);
		SignupPage sp = new SignupPage(driver);
		DashboardPage db = new DashboardPage(driver);
		
		logger.info("*  Providing Username & Pswd  *");
		sp.clickLogin();
		lp.clearUserName();
	    lp.setUserName(p.getProperty("b2c_LMS_stagng_VUser"));
	    lp.clearPassword();
	    lp.setPassword(p.getProperty("b2c_LMS_stagng_Vpsd"));
	    
	    lp.clickSignIn();
	    logger.info("*  Clicked on Login button  *");
	    
	    
	    //HomePage 

	    Thread.sleep(Duration.ofSeconds(15));	    
	    db.clickProfileMenu();
	    logger.info("*  Clicked on Profile Menu button  *");
		logger.info("Profile Menu Email is --" + db.ProfileEmail());
		logger.info(db.ProfileEmail());
		logger.info(p.getProperty("b2c_LMS_stagng_VUser"));
		myassert.assertEquals(db.ProfileEmail(), p.getProperty("b2c_LMS_stagng_VUser"));
	   	
		logger.info("***  Finished TC_003_Login  ***");
	}
	
}



