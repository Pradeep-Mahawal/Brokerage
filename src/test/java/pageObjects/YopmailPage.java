package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailPage extends BasePage {
	
	
	public YopmailPage(WebDriver driver) 
	{
		super(driver);
	}

	
	//Locators 
	@FindBy(xpath="//input[@id='login']") WebElement IB_Email ;
	@FindBy(css=".material-icons-outlined.f36") WebElement Btn_CheckInbox ;
	@FindBy(css="td[valign='top'] strong") WebElement Code ;
	@FindBy(xpath="//a[normalize-space()='Verify Now']") WebElement Btn_VerifyNow ;
	@FindBy(xpath="//a[contains(text(),'Reset')]")  WebElement Btn_ResetYourPassword;
	
	
	
	//Actions
	
	
	public void setEmail (String email)
	{IB_Email.sendKeys(email);}
	
	public void clickCheck_Inbox ()
	{Btn_CheckInbox.click();}
	
	public String Code()
	{return Code.getText();}
	
	public void clickVerifyNow ()
	{Btn_VerifyNow.click();}
	
	public void clickResetYourPassword()
	{Btn_ResetYourPassword.click();}
	
	
}
