package PageObject_Advisor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class A_WelcomeAdvisorPage {
	//WebDriver driver;
	@FindBy(xpath="//div[@class='content-container']//h1")
	private WebElement welcomeAdvisortitle;
	
	@FindBy(xpath="//div[@class='name f-r column']/p")
	private WebElement mobileNumber;
	
	@FindBy(xpath="//img[@src='assets/new-images/notification.svg']")
	private WebElement notification;
	
	@FindBy(xpath="//div[@class='notification-header']/h4")
	private WebElement notificationTitle;
	
	@FindBy(xpath="//img[@src='assets/new-images/icon-close.svg']")
	private WebElement closeNotificationButton;
	
	@FindBy(xpath="//button[@type='button']")
	private WebElement completeProfile;
	
	public A_WelcomeAdvisorPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void getWelcomeAdvisortitle()
	{
		Assert.assertTrue(welcomeAdvisortitle.getText().equalsIgnoreCase("Welcome Advisor!"));
	}
	
	public void welcomeAdvisorIsDisplayedOrNOtWheninvalidOTP()
	{
		Assert.assertFalse(welcomeAdvisortitle.isDisplayed());
	}
	
	public void getMobileNumber(String num)
	{
		System.out.println(mobileNumber.getText());
		Assert.assertTrue(mobileNumber.getText().equalsIgnoreCase(num));
	}
	
	public void getNotificationTitle()
	{
		notification.click();
		Assert.assertTrue(notificationTitle.getText().equalsIgnoreCase("Notifications"));
	}
	
	public void getCloseNotificationButton() {
		closeNotificationButton.click();
		
	}
	
	public void notificationTitleAfterClose()
	{
		//System.out.println(welcomeAdvisortitle.getText());
		Assert.assertFalse(closeNotificationButton.isDisplayed());
	}
	
	public void getCompleteProfile(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,4);
		wait.until(ExpectedConditions.visibilityOf(welcomeAdvisortitle));
		completeProfile.click();
	}

}
