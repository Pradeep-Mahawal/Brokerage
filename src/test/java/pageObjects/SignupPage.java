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
	
	@FindBy(xpath="//h2[normalize-space()='Create an account']") WebElement PN_Signup;
	@FindBy(xpath="//input[@placeholder='Enter your first name, last name']") WebElement IF_Name;
	@FindBy(xpath="//input[@placeholder='Enter your brokerage email']") WebElement IF_Email;
	@FindBy(xpath="input[placeholder='Enter your brokerage name']") WebElement IF_Brokerage;
	@FindBy(xpath="//input[@id='passInput']") WebElement IF_Password;
	@FindBy(xpath="//button[normalize-space()='Get Started']") WebElement Btn_GetStarted;
	@FindBy(xpath="//strong[normalize-space()='Log in']") WebElement Link_Log_in;
	
	
	
	//Actions
	
	
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
	
	public void clickLogin ()
	{Link_Log_in.click();}
	
	
	
	
}
