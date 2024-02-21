package testCases;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.ForgotPasswordPage;
import pageObjects.LoginPage;
import pageObjects.SetNewPasswordPage;
import pageObjects.YopmailPage;
import testBase.BaseClassREA;

public class TC_005_ForgotPassword extends BaseClassREA {

	@Test(groups = { "sanity" })
	public void verify_signup() throws InterruptedException {
		logger.info("***  Starting TC_005_ForgotPassword through Email  ***");
		logger.debug("caputuring application debug logs.......");
		try {
			LoginPage lp=new LoginPage(driver);	
			ForgotPasswordPage fp=new ForgotPasswordPage(driver);
			YopmailPage yp = new YopmailPage (driver);
			SetNewPasswordPage snp = new SetNewPasswordPage (driver);
			DashboardPage db = new DashboardPage(driver);
			
			lp.clickLogIn();
			lp.clickForgotPassword();
			fp.Email(p.getProperty("Email"));
			fp.click_ResetPassword();
			
			
			 driver.navigate().to("https:yopmail.com/");	
			 logger.info("* Navigate to Yopmail *");			    
			 yp.setEmail(p.getProperty("Email"));
			 logger.info("* Email Entered *");
			 yp.clickCheck_Inbox();				    
			 driver.switchTo().frame("ifmail");
			 yp.clickResetYourPassword();
			 
			 Thread.sleep(2000);
			 
			 driver.close();		  	    
			  	Set <String> windowHandles = driver.getWindowHandles();	       
		        for (String windowHandle : windowHandles) 	            
		            { driver.switchTo().window(windowHandle);
		            logger.info("Window ID   "+ windowHandle);
		            logger.info("Page Title  "+ driver.getTitle());
		         
		            if (driver.getTitle().contains("Xsel")) 
		               {    	
		            	Thread.sleep(5000);
		                snp.clearPassword();
		                snp.setPassword(p.getProperty("NewPassword"));
		                
		                snp.clearConfirmPassword();
		                snp.setConfirmPassword(p.getProperty("NewPassword"));
		                
		                snp.clickReset();
		                break; 		  	
		                }
		            }
			
		        logger.info("*  Providing Username & Pswd  *");
				lp.clickLogIn();
				lp.clearUserName();
			    lp.setUserName(p.getProperty("Email"));
			    lp.clearPassword();
			    lp.setPassword(p.getProperty("NewPassword"));	    
			    lp.clickSignIn();
			    logger.info("*  Clicked on Login button  *");
			    Thread.sleep(7000);
			    db.clickProfileMenu();
			    logger.info("*  Clicked on Profile Menu button  *");
			    logger.info("Profile Menu Email is --"+db.ProfileEmail()); 
			    
			    logger.info(db.ProfileEmail());
			    logger.info(p.getProperty("Email"));
			    
			   // boolean targetEmailID=db.isEmailIDExists();	    	    
			    if   (db.ProfileEmail().equals(p.getProperty("Email")))
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
		logger.info("***  Finished TC_005_ForgotPassword  ***");
	    }
	}


