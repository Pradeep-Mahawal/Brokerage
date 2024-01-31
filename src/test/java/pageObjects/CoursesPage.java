package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursesPage extends BasePage {
	
	
	
	public CoursesPage(WebDriver driver) {
		super(driver);	
	}

	
			
	  //Locators
	  @FindBy(xpath="//button[normalize-space()='All courses']") WebElement Btn_AllCourses;
	  @FindBy(xpath="//button[normalize-space()='My courses']") WebElement Btn_MyCourses;
	  @FindBy(xpath="//button[normalize-space()='All Learning Path']") WebElement Btn_All_LP;
	  @FindBy(xpath="//button[normalize-space()='My Learning Path']") WebElement Btn_My_LP;
	  @FindBy(xpath="//button[normalize-space()='My Onboarding Path']") WebElement Btn_My_OBLP;
	  
	
	
	
	
	  //Actions
}
