package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SetNewPasswordPage extends BasePage {

	public SetNewPasswordPage(WebDriver driver) 	
	{
		super(driver);
	}

	//Locators
	
	@FindBy(xpath="//input[@placeholder='Enter Password']")WebElement IB_Password;
	@FindBy(xpath="//input[@placeholder='Confirm Password']")WebElement IB_ConfirmPassword;
	@FindBy(xpath="//button[normalize-space()='Reset']")WebElement Btn_Reset ;
	
	//Actions
	
	public void clearPassword()
	{IB_Password.clear();}
	
	public void setPassword (String username)
	{IB_Password.sendKeys(username);}
	
	public void clearConfirmPassword()
	{IB_ConfirmPassword.clear();}
	
	public void setConfirmPassword (String username)
	{IB_ConfirmPassword.sendKeys(username);}
	
	public void clickReset()
	{Btn_Reset.click();}
}
