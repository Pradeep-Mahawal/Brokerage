package day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration; 
import io.github.bonigarcia.wdm.WebDriverManager;


public class Example {
	
	public static void main (String[]args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		driver.get("https://realtorsuccesslearning-stg-b2c.niit-mts.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		WebElement Emailbox =driver.findElement(By.xpath("//input[@name='email']"));
		Emailbox.sendKeys("pradeep_1@yopmail.com");
		Emailbox.clear();
		Emailbox.sendKeys("pradeep_2@yopmail.com");
		
		WebElement Paswword =driver.findElement(By.xpath("//input[@name='password']"));
		Paswword.sendKeys("Abcd@1234");
		
		
		WebElement SignIn =driver.findElement(By.xpath("//button[normalize-space()='Sign In']"));
		SignIn.click();
		
		
		
		Thread.sleep(10000);
		WebElement ProfileMenu =driver.findElement(By.xpath("//*[@id=\"idParent\"]/nav/div/div/div/div[3]/ul[2]"));
		ProfileMenu.click();
	
		
		
		
		

		 
	
		
		
		
		
		
		
		
		
		

	
		
		
		
	}
}