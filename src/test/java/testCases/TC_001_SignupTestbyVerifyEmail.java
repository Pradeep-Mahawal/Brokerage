package testCases;

import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.CheckYourEmail;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.SignupPage;
import pageObjects.TermandConditionPage;
import pageObjects.YopmailPage;
import testBase.BaseClassREA;

public class TC_001_SignupTestbyVerifyEmail extends BaseClassREA {

	@Test(groups = { "sanity" })
	public void verify_signup() throws InterruptedException

	{
		SoftAssert myassert = new SoftAssert();
		logger.info("***  Starting TC_001_SignupTest through Email  ***");
		logger.debug("caputuring application debug logs.......");

		LoginPage lp = new LoginPage(driver);
		SignupPage sp = new SignupPage(driver);
		TermandConditionPage tc = new TermandConditionPage(driver);
		DashboardPage db = new DashboardPage(driver);
		CheckYourEmail cye = new CheckYourEmail(driver);

		sp.clickSignup();
		logger.info("*  Providing User Data  *");
		sp.clearName();
		sp.setName(p.getProperty("Name1"));
		logger.info("*  Name Provided  *");

		sp.clearEmail();
		sp.setEmail(p.getProperty("Email1"));
		logger.info("*  Email1 Provided  *");

		sp.clearBrokerage();
		sp.setBrokerage(p.getProperty("Brokerage"));
		logger.info("*  Broker name Provided  *");

		sp.clearPassword();
		sp.setPassword(p.getProperty("Password"));
		logger.info("*  Password Provided  *");

		sp.clickGetStarted();
		logger.info("* Clicked on GetStarted *");

		Thread.sleep(5000);
		if (sp.isErrorMsgExists()) {
			logger.error(sp.ErrorMsg());
			Assert.fail();
		} else {
			myassert.assertEquals(cye.EmailID(), p.getProperty("Email1"));
			sp.clickEnterCodeManually();
			logger.info("* Clicked on Enter Code Manually *");
			Thread.sleep(3000);
			driver.navigate().to("https:yopmail.com/");
			logger.info("* Navigate to Yopmail *");
			YopmailPage yp = new YopmailPage(driver);
			yp.setEmail(p.getProperty("Email1"));
			logger.info("* Email1 Entered *");
			yp.clickCheck_Inbox();
			driver.switchTo().frame("ifmail");
			yp.clickVerifyNow();
			logger.info("* Clicked on Verify Now *"); // for OTP
			driver.close();
			Set<String> windowHandles = driver.getWindowHandles();
			for (String windowHandle : windowHandles) {
				driver.switchTo().window(windowHandle);
				logger.info("Window ID   " + windowHandle);
				logger.info("Page Title  " + driver.getTitle());

				if (driver.getTitle().contains("Xsel")) {
					Thread.sleep(9000);
					sp.clickContinue();
					break;
				}
			}

			logger.info("*  Providing Username & Pswd  *");
			//sp.clickLogin();
			lp.clearUserName();
			lp.setUserName(p.getProperty("Email1"));
			lp.clearPassword();
			lp.setPassword("Abcd@1234");
			lp.clickSignIn();
			logger.info("*  Clicked on Login button  *");
			tc.checkCheckbox();
			tc.clickIAgree();

			// HomePage

			Thread.sleep(15000);
			db.clickProfileMenu();
			logger.info("*  Clicked on Profile Menu button  *");
			logger.info("Profile Menu Email1 is --" + db.ProfileEmail());
			logger.info(db.ProfileEmail());
			logger.info(p.getProperty("Email1"));
			myassert.assertEquals(db.ProfileEmail(), p.getProperty("Email1"));
		    }
		    logger.info("***  Finished TC_001_SignupTest through Email1  ***");

	}
}