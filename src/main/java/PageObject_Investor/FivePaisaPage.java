package PageObject_Investor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FivePaisaPage {
	
	@FindBy(xpath="//p[text()='5 Paisa']")
	private WebElement fivePaisa;
	
	@FindBy(xpath="//input[@placeholder='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@placeholder='password']")
	private WebElement pwd;
	
	@FindBy(xpath="//input[@type='date']")
	private WebElement date;
	
	@FindBy(xpath="//span[@class='mat-button-wrapper']")
	private WebElement submit;
	
	public FivePaisaPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void getFivePaisa()
	{
		fivePaisa.click();
	}
	
	public void setEmail(String e)
	{
		email.sendKeys(e);
	}
	
	public void setPassword(String p)
	{
		pwd.sendKeys(p);
	}
	
	public void setDate(String d)
	{
		date.sendKeys(d);
	}
	
	public void getSubmit()
	{
		submit.click();
	}

}
