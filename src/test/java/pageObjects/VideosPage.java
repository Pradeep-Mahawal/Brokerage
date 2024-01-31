package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VideosPage extends BasePage {

	public VideosPage(WebDriver driver) {
		super(driver);
		

}
	
	//Locators
	@FindBy(xpath="//button[normalize-space()='Most popular']") WebElement Btn_Most_popular;
	@FindBy(xpath="//button[normalize-space()='Most liked']") WebElement Btn_Most_liked;
	@FindBy(xpath="//button[normalize-space()='My Videos']") WebElement Btn_My_Videos;
	
	
	//Actions
	
	
	
	
}
