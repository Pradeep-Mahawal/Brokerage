package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LoginPage extends BasePage {

	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
 
	
	//Locators
	
	//Approach 1
	//By img_logo_loc=By.xpath("//h2[normalize-space()='Log in to your account'])");
	//By txt_username_loc=By.xpath("//input[@placeholder='Enter your brokerage email']");
	//By txt_pswd_loc=By.xpath("(//input[@id='passInput'])[1]");
	
	//Approach 2
	
	@FindBy(xpath="//h2[normalize-space()='Log in to your account'])") WebElement img_Logo;
	@FindBy(xpath="//input[@name='email']") WebElement txt_username ;
	@FindBy(xpath="//input[@name='password']") WebElement txt_password ;
	@FindBy(xpath="//button[normalize-space()='Sign In']") WebElement btn_signin ;
    @FindBy(css="div[class='mb-2 login-msg'] div")WebElement msgConfirmation;
    @FindBy(xpath="//a[normalize-space()='Forgot Password?']")WebElement btn_ForgotPassword;
    @FindBy(xpath="//strong[normalize-space()='Sign up']")WebElement btn_Signup;
    
    
    
    //Actions
	public void setUserName (String username)
	{txt_username.sendKeys(username);}
	
	public void clearUserName()
	{txt_username.clear();}
	
	public void setPassword (String password)
	{txt_password.sendKeys(password);}
	
	public void clearPassword()
	{txt_password.clear();}
	 
	public void clickSignIn()
	{btn_signin.click();}
	
	public void clickForgotPassword()
	{btn_ForgotPassword.click();}
	
	public void clickSignup()
	{btn_Signup.click();}
	
	
	public String getConfirmationMsg() {
		try{
		    return (msgConfirmation.getText());
		}  catch(Exception e) {
			return(e.getMessage());
		                                }
	                                         }
}
	                            
	

	
	

