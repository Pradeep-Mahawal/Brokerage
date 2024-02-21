package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class TermandConditionPage extends BasePage {
	
	  //Constructor
		public TermandConditionPage(WebDriver driver) 
		{
			super(driver);
		}
			 
		//Locators 
		@FindBy(xpath="//*[@id=\"termofusein\"]") WebElement checkbox ;
		@FindBy(xpath="//button[normalize-space()='View User Terms of Service']") WebElement Btn_View ;
		@FindBy(xpath="//button[normalize-space()='Cancel']") WebElement Btn_Cancel ;
		@FindBy(xpath="//button[normalize-space()='I Agree']") WebElement Btn_I_Agree ;
		
		
		//Actions
		 public void checkCheckbox() 
		    {
		        if (!checkbox.isSelected())
		        {
		            checkbox.click();
		        }
		    }
		
		 public void clickView ()
			{Btn_View.click();}
		
		 public void clickCancel ()
			{Btn_Cancel.click();}
		 public void clickIAgree ()
			{Btn_I_Agree.click();}
		

         }
