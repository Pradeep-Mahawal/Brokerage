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
	@FindBy(css="tbody tr p:nth-child(2)") WebElement rawCode ;
	@FindBy(xpath="//a[normalize-space()='Verify Now']") WebElement Btn_VerifyNow ;
	@FindBy(xpath="//a[contains(text(),'Reset')]")  WebElement Btn_ResetYourPassword;
	
	
	
	//Actions
	
	
	public void setEmail (String email)
	{IB_Email.sendKeys(email);}
	
	public void clickCheck_Inbox ()
	{Btn_CheckInbox.click();}
	
	//public String Code()
	//{return rawCode.getText();}
	
	public String Code() {
	    String rawText = rawCode.getText();
	    String lastFourDigits = rawText.substring(rawText.length() - 4);
	    return lastFourDigits;
	}
	
	public void clickVerifyNow ()
	{Btn_VerifyNow.click();}
	
	public void clickResetYourPassword()
	{Btn_ResetYourPassword.click();}
	
	
}
