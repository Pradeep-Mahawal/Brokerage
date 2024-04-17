package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
	 
	WebDriver driver;
	
	//Constructor
	public BasePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	
    }
    /*"Btn" for Button
      "Txt" for Text Field
      "Lk" for Link
      "Lbl" for Label
      "Chk" for Checkbox
      "Rdo" for Radio Button
      "Drp" for Dropdown
      "Tbl" for Table
      "Cln" for Column
      "Rw" for Row*/
  
	}
 

