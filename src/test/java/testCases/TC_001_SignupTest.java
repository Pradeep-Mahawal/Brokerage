package testCases;

import org.testng.Assert;

import pageObjects.SignupPage;
import testBase.BaseClass;

public class TC_001_SignupTest extends BaseClass {

	
	public void verify_signup ()  throws InterruptedException
	
	
	{   
		logger.info("***  Starting TC_001_LoginTest  ***");
	    logger.debug("caputuring application debug logs.......");
		try  
		{ 
			
			//signup page
			SignupPage sp = new SignupPage(driver);
			
			
			logger.info("*  Providing User Data  *");
			sp.clearName();
		    sp.setName(p.getProperty(""));
		    
		    sp.clearEmail();
		    sp.setEmail(p.getProperty(""));
		    
		    sp.clearBrokerage();
		    sp.setBrokerage(p.getProperty(""));
		    
		    sp.clearPassword();
		    sp.setPassword(p.getProperty(""));
		    
		    sp.clickGetStarted();
		    
			
		}catch (Exception e) 
		   {
			logger.error("*  Test Failed catch block *");
			Assert.fail();
		   }
		logger.info("***  Finished TC_001_SignUp  ***");
	
	
	
}
}