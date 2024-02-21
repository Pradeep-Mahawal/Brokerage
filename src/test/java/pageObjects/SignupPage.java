package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage{

	
	//Constructor
	public SignupPage(WebDriver driver) 
	{
		super(driver);	
	}

	//Locators
	@FindBy(xpath="//span[normalize-space()='Login']")WebElement Btn_Login;
	@FindBy(xpath="//span[normalize-space()='Sign Up']")WebElement Btn_Signup;
	@FindBy(xpath="//h2[normalize-space()='Create an account']") WebElement PTitle_Signup;
	@FindBy(xpath="//input[@placeholder='Enter your first name, last name']") WebElement IF_Name;
	@FindBy(css="input[placeholder='Enter your email']") WebElement IF_Email;
	@FindBy(css="input[placeholder='Enter your brokerage name']") WebElement IF_Brokerage;
	@FindBy(xpath="//input[@id='passInput']") WebElement IF_Password;
	@FindBy(xpath="//button[normalize-space()='Get Started']") WebElement Btn_GetStarted;
	@FindBy(xpath="//strong[normalize-space()='Log in']") WebElement Link_Log_in;
	@FindBy(xpath="//h2[normalize-space()='Check your email']") WebElement CheckYourEmailPage;
	@FindBy(css="p[class='text-center'] strong") WebElement VerificationLinkMail;
	//Check your email Page  -- verification link
	@FindBy(css=".default-btn.signinBtn.mt-4") WebElement Btn_EnterCodeManually;
	@FindBy(xpath="//form/div[2]/div")WebElement Validation_Msg;
	
	//Check your email Page  -- Code Screen
	@FindBy(css="input[aria-label='Please enter OTP character 1']")WebElement IB_Code ;
	@FindBy(css="button.default-btn.signinBtn")WebElement Btn_VerifyEmail;
	
	//Email Verified  
	@FindBy(css="button.default-btn.signinBtn.mt-4")WebElement Btn_Continue;
	

	
	//button[normalize-space()='Enter code manually']
	//Actions
	
	public void clickLogin ()
	{Btn_Login.click();}
	
	
	public void clickSignup ()
	{Btn_Signup.click();}
	
	
	public void setName (String name)
	{IF_Name.sendKeys(name);}
	
	public void clearName ()
	{IF_Name.clear();}
	
	public void setEmail (String email)
	{IF_Email.sendKeys(email);}
	
	public void clearEmail ()
	{IF_Email.clear();}
	
	public void setBrokerage (String brokeragename)
	{IF_Brokerage.sendKeys(brokeragename);}
	
	public void clearBrokerage ()
	{IF_Brokerage.clear();}
	
	public void setPassword (String Password)
	{IF_Password.sendKeys(Password);}
	
	public void clearPassword ()
	{IF_Password.clear();}
	
	public void clickGetStarted ()
	{Btn_GetStarted.click();}
	
	public void clickLoginLink ()
	{Link_Log_in.click();}
	
	
	public boolean isErrorMsgExists()   
	{
		try {
			return (Validation_Msg.isDisplayed());
		} catch (Exception NoSuchElementException) {
			return (false);
		}
	}
	
	
	
	
	
	public String ErrorMsg()
	{return Validation_Msg.getText();}
	
	public void clickEnterCodeManually ()
	{Btn_EnterCodeManually.click();}
	
	
	public void setCode (String code)
	{IB_Code.sendKeys(code);}
	
	public void clickVerifyEmail ()
	{Btn_VerifyEmail.click();}
	
	
	public void clickContinue ()
	{Btn_Continue.click();}
	
	
}
