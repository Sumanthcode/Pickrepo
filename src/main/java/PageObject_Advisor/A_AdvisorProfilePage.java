package PageObject_Advisor;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class A_AdvisorProfilePage {
	
	@FindBy(xpath="//input[@placeholder='Full Name']")
	private WebElement fullNameField;
	
	@FindBy(xpath="//span[@class='error ng-star-inserted']")
	private WebElement error;
	
	@FindBy(xpath="//a[contains(@class,'save')]")
	private WebElement save;
	
	@FindBy(xpath="//button[text()='NISM Certified']")
	private WebElement nismCertificateButton;
	
	public A_AdvisorProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void setFullName(String name)
	{
		fullNameField.sendKeys(name);
	}
	
	public void getNameIsRequiredErrorMsg()
	{
		Assert.assertTrue(error.getText().equalsIgnoreCase("Name is required!"));
	}
	
	public void getSave()
	{
		save.click();
	}
	
	public void getNISMCertificateButton()
	{
	
		nismCertificateButton.click();
	}
	

}
