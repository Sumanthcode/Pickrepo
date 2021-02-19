package PageObject_Investor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AliceBluePage {
	
	@FindBy(xpath="//p[text()='Alice Blue']")
	private WebElement aliceBlue;
	
	@FindBy(name="client_id")
	private WebElement clientId;
	
	@FindBy(name="password")
	private WebElement pwd;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signIn;
	
	@FindBy(name="answer1")
	private WebElement ans1;
	
	@FindBy(name="answer2")
	private WebElement ans2;
	
	public AliceBluePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void getAliceBlue()
	{
		aliceBlue.click();
	}
	
	public void setClientId(String clientid)
	{
		clientId.sendKeys(clientid);
	}
	
	public void setPassword(String password)
	{
		pwd.sendKeys(password);
	}
	
	public void getSignIn()
	{
		signIn.click();
	}
	
	public void setAns1(String a1)
	{
		ans1.sendKeys(a1);
	}
	
	public void setAns2(String a2)
	{
		ans2.sendKeys(a2);
	}
	
	
	

}
