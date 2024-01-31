package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	
	
	@Test(groups= {"sanity"})
	public void verify_login() throws InterruptedException
	
	{   
		logger.info("***  Starting TC_001_LoginTest  ***");
	    logger.debug("caputuring application debug logs.......");
		try  
		{ 
			
			
		//Login Page	
		LoginPage lp=new LoginPage(driver);
		
		logger.info("*  Providing Username & Pswd  *");
		lp.clearUserName();
	    lp.setUserName(p.getProperty("b2c_LMS_stagng_VUser"));
	    lp.clearPassword();
	    lp.setPassword(p.getProperty("b2c_LMS_stagng_Vpsd"));
	    
	    lp.clickSignIn();
	    logger.info("*  Clicked on Login button  *");
	    
	    
	    //HomePage 
	    
	    HomePage hmp = new HomePage(driver);
	    
	   
	    Thread.sleep(Duration.ofSeconds(40));
	    
	    hmp.clickProfileMenu();
	    logger.info("*  Clicked on Profile Menu button  *");
	   
	   
	    boolean targetEmailID=hmp.isEmailIDExists();
	    
	    
		if(targetEmailID==true)
			 {
			    logger.info("Login Test Passed .... ");
			   
			    Assert.assertTrue(true);
			  }
			    else
			    {
			    	logger.error("Login Test Failed ..");
			    	Assert.fail();
			    }
		}
	
		catch (Exception e) 
		   {
			logger.error("*  Test Failed catch block *");
			Assert.fail();
		   }
		logger.info("***  Finished TC_001_Login  ***");
	}

}

