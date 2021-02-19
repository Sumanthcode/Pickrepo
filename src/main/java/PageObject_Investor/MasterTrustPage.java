package PageObject_Investor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterTrustPage {
	
	@FindBy(xpath="//p[text()='Master Trust']")
	private WebElement masterTrust;
	
	@FindBy(xpath="//input[@placeholder='Client ID']")
	private WebElement clientId;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement pwd;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signIn;
	
	@FindBy(name="answers[]")
	private WebElement ans;
	
	public MasterTrustPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void getMasterTrust()
	{
		masterTrust.click();
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
	
	public void setAns(String s)
	{
		ans.sendKeys(s);
	}

}
