package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class DashboardPage extends BasePage {

	
	//Constructor
	public DashboardPage(WebDriver driver) 
	{
		super(driver);
	}
		 
	
	
	//Locators 
	@FindBy(xpath="//div[@id='idClickProfileWeb']") WebElement BtnProfileMenu ;
	@FindBy(xpath="//h3[normalize-space()='My Dashboard']")WebElement Txtdashboard;
	@FindBy(xpath="//nav//div[@class='proemail']") WebElement Msg_EmailId ;  // User EmailId
	@FindBy(xpath="//a[normalize-space()='Learn']") WebElement Btn_Learn ;
	@FindBy(xpath="//a[normalize-space()='Home']") WebElement Btn_Home ;
	@FindBy(xpath="//a[normalize-space()='Partners']") WebElement Btn_Partners ;
	@FindBy(xpath="//a[normalize-space()='Subscriptions']") WebElement Btn_Subscriptions ;
	@FindBy(xpath="//nav//a[8]//div[1]") WebElement Btn_Logout ;
	
	
	
	//Actions
	public void clickProfileMenu()
	{BtnProfileMenu.click();}
	
	public void click_LogOut()
	{Btn_Logout.click();}
	
	public String ProfileEmail()
	{return Msg_EmailId.getText();}
	
	
	public boolean isEmailIDExists()  //my profile email id display status
	{
		try {
		    return (Msg_EmailId.isDisplayed());
		   }  
		catch(Exception e) 
		{
			return(false);
		}
	}

	public boolean isDashboardExists()  // Dashboard id display status
	{
		try {
		    return (Txtdashboard.isDisplayed());
		   }  
		catch(Exception e) 
		{
			return(false);
		}
	}







}






	
	
