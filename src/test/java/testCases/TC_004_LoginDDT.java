package testCases;

import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.SignupPage;
import testBase.BaseClassREA;
import utilities.DataProviders;

public class TC_004_LoginDDT extends BaseClassREA {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String email, String password, String exp) throws InterruptedException

	{
		
		
		logger.info("****  Starting TC_004_LoginDDT   ****");
		logger.debug("caputuring application debug logs.......");
		
		try {
	
			LoginPage lp = new LoginPage(driver);
			SignupPage sp = new SignupPage(driver);
			DashboardPage db = new DashboardPage(driver);
			
			sp.clickLogin();
			logger.info("*  Providing Username & Pswd  *");
			lp.clearUserName();
			lp.setUserName(email);
			lp.clearPassword();
			lp.setPassword(password);
	
			lp.clickSignIn();
			logger.info("*  Clicked on Login button  *");
	
			
			Thread.sleep(Duration.ofSeconds(20));
			
			
			boolean targetPage=db.isHomePageExists();
			
			if (exp.equalsIgnoreCase("Valid")) 
				
				
			{
				if (targetPage==true)
				{
					db.clickProfileMenu();
					db.click_LogOut();
					Assert.assertTrue(true);
				} 
				else
				{
					Assert.assertTrue(false);
					driver.get(p.getProperty("b2c_LMS_stagng_URL"));
				}
			}
	
			if (exp.equalsIgnoreCase("Invalid")) 
			{
				if (targetPage==true) 
				{
					db.clickProfileMenu();
					db.click_LogOut();
					Assert.assertTrue(false);
				} 
				else 
				{
					Assert.assertTrue(true);
					driver.get(p.getProperty("b2c_LMS_stagng_URL"));
					
				}
			}
		}
		
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
			driver.close();
		}

		logger.info("***  Finished TC_004_LoginDDT  ***");
	}
}
