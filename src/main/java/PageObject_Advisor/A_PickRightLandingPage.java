package PageObject_Advisor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class A_PickRightLandingPage {
	WebDriver driver;
	@FindBy(xpath="//div[@class='account_nav']/button")
	private WebElement joinAsAdvisor;
	
	
	
	
	public A_PickRightLandingPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void getJoinAsAdvisor()
	{
		joinAsAdvisor.click();
	}
	
	

}
