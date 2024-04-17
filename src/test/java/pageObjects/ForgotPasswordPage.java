package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class ForgotPasswordPage extends BasePage {

	
	//Constructor
	public ForgotPasswordPage(WebDriver driver) 
	{
		super(driver);	
	}

	
	//Locators
	@FindBy(xpath="//h2[normalize-space()='Forgot password?']") WebElement imgpagename_Forgot_Password ;
	@FindBy(xpath="//input[@id='email']")WebElement inputbox_Email ;
	@FindBy(xpath="//button[normalize-space()='Reset Password']")WebElement btn_Reset_Password ;
	@FindBy(xpath="//p[@class='cursor-pointer mt-4 pt-2']")WebElement btn_Back_to_login ;
	
	 //Actions
		public void setUserName (String username)
		{inputbox_Email.sendKeys(username);}
		 
		public void click_ResetPassword()
		{btn_Reset_Password.click();}
		
		public void click_Back_to_login()
		{btn_Back_to_login.click();}
		
		
		
		public String getPageName() {
			try{
			    return (imgpagename_Forgot_Password.getText());
			}  catch(Exception e) {
				return(e.getMessage());
			                                }
		                                         }
	
}