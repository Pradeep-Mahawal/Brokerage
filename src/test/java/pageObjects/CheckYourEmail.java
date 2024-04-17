package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckYourEmail extends BasePage {

	public CheckYourEmail(WebDriver driver) {
		super(driver);
	}
	// Locators

	// Check your email Page -- verification link
	@FindBy(css = ".default-btn.signinBtn.mt-4")
	WebElement Btn_EnterCodeManually;
	@FindBy(css = "p[class='text-center'] strong")
	WebElement Email;

	
	// Check your email Page -- Code Screen
	@FindBy(css = "input[aria-label='Please enter OTP character 1']")
	WebElement IB_Code;
	@FindBy(css = "button.default-btn.signinBtn")
	WebElement Btn_VerifyEmail;
	
	
	//Actions
	
	public void clickEnterCodeManually ()
	{Btn_EnterCodeManually.click();}
	
	public void clickVerifyEmail ()
	{Btn_VerifyEmail.click();}
	
	public void setCode (String code)
	{IB_Code.sendKeys(code);}
	
	public String EmailID()
	{return Email.getText();}

}
