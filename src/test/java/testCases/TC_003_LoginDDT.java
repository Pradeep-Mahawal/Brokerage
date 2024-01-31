package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass; 
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass 
{
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email,String password,String exp) throws InterruptedException
	
	{
		logger.info("****  Starting TC_002_LoginDDT   ****");
		
		
		
		//Login Page	
		LoginPage lp=new LoginPage(driver);
				
		lp.clearUserName();
		lp.setUserName(email);
		
		lp.clearPassword();
		lp.setPassword(password);
		
		logger.info("*  Providing Username & Pswd  *");	    
		
		lp.clickSignIn();
		logger.info("*  Clicked on Login button  *");
			    
			    
		//HomePage 
		Thread.sleep(30000);	    
		HomePage hmp = new HomePage(driver);
		boolean targetDashboard=hmp.isDashboardExists();    
			    
		if(exp.equalsIgnoreCase("Valid"))	
		{	if(targetDashboard==true)
			{
			    hmp.clickProfileMenu();
				hmp.click_LogOut();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
	} 
			    
	if(exp.equalsIgnoreCase("Invalid"))	
	{if(targetDashboard==true)   
		{
			hmp.click_LogOut();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
	}

	
	
	}
}
