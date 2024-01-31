package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LearnPage extends BasePage {

	
	//Constructor
	public LearnPage(WebDriver driver) {
		super(driver);}
		
	//Locators
	@FindBy(xpath="//li[normalize-space()='Courses']") WebElement Btn_Courses;
	@FindBy(xpath="//li[normalize-space()='Videos']") WebElement Btn_Videos;
	@FindBy(xpath="//li[normalize-space()='Coaching']") WebElement Btn_Coaching;
	@FindBy(xpath="//li[normalize-space()='Certifications']") WebElement Btn_Certifications;
	@FindBy(xpath="//li[normalize-space()='Roleplay']") WebElement Btn_Roleplay;
	@FindBy(xpath="//li[normalize-space()='Events']") WebElement Btn_Events;
	@FindBy(xpath="//li[normalize-space()='Others']") WebElement Btn_Others;
	
	
	
	//Actions
	
	
}