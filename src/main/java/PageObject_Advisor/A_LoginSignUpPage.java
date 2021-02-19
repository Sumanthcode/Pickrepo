package PageObject_Advisor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class A_LoginSignUpPage {
	WebDriver driver;
	@FindBy(xpath="//div[@class='box ng-star-inserted']/h2")
	private WebElement loginSignUpTitle;
	
	@FindBy(xpath="//span[@class='scope ng-star-inserted']")
	private WebElement asA;
	
	
	public A_LoginSignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void getloginSignUpTitle()
	{
		Assert.assertTrue(loginSignUpTitle.getText().equalsIgnoreCase("Login/Sign Up"));
		Assert.assertTrue(asA.getText().equalsIgnoreCase("As an advisor"));
	}
	

}
