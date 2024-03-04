package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.TermandConditionPage;
import pageObjects.SignupPage;
import pageObjects.YopmailPage;
import testBase.BaseClassREA;

public class TC_002_SignupTestbyOTP extends BaseClassREA {

	@Test(groups= {"sanity"})
	public void verify_signup ()  throws InterruptedException
	
	
	
	{   
		logger.info("***  Starting TC_002_SignupTest OTP  ***");
	    logger.debug("caputuring application debug logs.......");
		try  
		{ 
			
			LoginPage lp=new LoginPage(driver);		
			SignupPage sp = new SignupPage(driver);
			TermandConditionPage tc =new TermandConditionPage(driver);
			DashboardPage db = new DashboardPage(driver);
			
			sp.clickSignup();
			
			logger.info("*  Providing User Data  *");
			sp.clearName();
		    sp.setName(p.getProperty("Name"));
		    logger.info("*  Name Provided  *");
		    
		    sp.clearEmail();
		    sp.setEmail(p.getProperty("Email2"));
		    logger.info("*  Email Provided  *");
		    
		    sp.clearBrokerage();
		    sp.setBrokerage(p.getProperty("Brokerage"));
		    logger.info("*  Broker name Provided  *");
		    
		    sp.clearPassword();
		    sp.setPassword(p.getProperty("Password"));
		    logger.info("*  Password Provided  *");
		    
		    
		    sp.clickGetStarted();
		    logger.info("* Clicked on GetStarted *");
		    
		     Thread.sleep(5000);
		     		    
		     if (sp.isErrorMsgExists()) 
		       {
		    	logger.error(sp.ErrorMsg());
		    	Assert.fail();
		       } 		    	 
		     else 		    	 
		     {
		    	sp.clickEnterCodeManually();
		    	logger.info("* Clicked on Enter Code Manually *");
			    Thread.sleep(3000);
			    driver.navigate().to("https:yopmail.com/");	
			    logger.info("* Navigate to Yopmail *");
			    YopmailPage yp = new YopmailPage (driver);
			    yp.setEmail(p.getProperty("Email2"));
			    logger.info("* Email Entered *");
			    yp.clickCheck_Inbox();				    
			    driver.switchTo().frame("ifmail");	
			    //yp.clickVerifyNow();			    
			   // logger.info("* Clicked on Verify Now *");							    //for OTP
											  String otp = yp.Code();											  
											    driver.navigate().back();
											    logger.info(otp);
											    Thread.sleep(2000);
											    driver.navigate().back();		    
											    //sp.clickEnterCodeManually();
											    //logger.info("* clicked Enter Code Manually *");
											    Thread.sleep(3000);
											    sp.setCode(otp);
											    logger.info("* otp entered *");
											    Thread.sleep(3000);
											    sp.clickVerifyEmail();	
											    logger.info("* clicked verify *");
			 
					sp.clickContinue();
					logger.info("*  Providing Username & Pswd  *");
					sp.clickLogin();
					lp.clearUserName();
				    lp.setUserName(p.getProperty("Email2"));
				    lp.clearPassword();
				    lp.setPassword(p.getProperty("Password"));	    
				    lp.clickSignIn();
				    logger.info("*  Clicked on Login button  *");
				    
				    tc.checkCheckbox();
				    tc.clickIAgree();
		    
		    //HomePage 	    
		    	   
		    Thread.sleep(15000);    
		    db.clickProfileMenu();
		    logger.info("*  Clicked on Profile Menu button  *");
		    logger.info("Profile Menu Email is --"+db.ProfileEmail()); 
		    
		    logger.info(db.ProfileEmail());
		    logger.info(p.getProperty("Email2"));
		    
		   // boolean targetEmailID=db.isEmailIDExists();	    	    
		    if   (db.ProfileEmail().equals(p.getProperty("Email2")))
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
		}
		     
		     catch (Exception e) 
		   {
			logger.error("*  Test Failed catch block *");
			Assert.fail();
		   }
		logger.info("***  Finished TC_001_SignUp  ***");
	
	
	
 }
  }
