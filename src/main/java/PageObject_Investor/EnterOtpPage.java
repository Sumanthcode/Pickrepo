package PageObject_Investor;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class EnterOtpPage {
	@FindBy(xpath = "//p[text()='Enter OTP']")
	public WebElement enterOtpTitle;

	@FindBy(xpath = "//input[contains(@id,'otp')]")
	public List<WebElement> otp;

	@FindBy(xpath = "//div[@class='mat-checkbox-inner-container']")
	public WebElement checkBox;
	
	@FindBy(xpath="//span[@class='mat-checkbox-label']")
	public WebElement iAgreeLable;

	@FindBy(xpath = "//button[text()='Next']")
	public WebElement nextButton;

	@FindBy(xpath = "//div[@class='action ng-star-inserted']/a/span")
	public WebElement resendOtpTimeFirst;

	@FindBy(xpath="//h2[@class='mb40 size24 ng-star-inserted']")
	 public WebElement areYouNewToTheStockTitle;

	@FindBy(xpath = "//a[@class='change-number']")
	public WebElement changeNumber;

	@FindBy(xpath = "//a[@class='ng-star-inserted']")
	public WebElement resendOtpButton;

	@FindBy(xpath = "//div[@class='alert-container ng-star-inserted']")
	public WebElement OtpErrorMessage;
	
	@FindBy(xpath="//img[@src='assets/new-images/left-arrow-icon.svg']")
	public WebElement back;
	
	@FindBy(xpath="//input[@placeholder='Enter referral code, if any']")
	public WebElement referralCodeField;
	public EnterOtpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void getEnterOtpTitle() {
		Assert.assertTrue(enterOtpTitle.getText().equals("Enter OTP"));
	}

	/*public void setOtp() {

		Scanner s = new Scanner(System.in);
		String[] c = new String[4];
		for (int i = 0; i < c.length; i++) {
			System.out.println("enter the otp");
			String n = s.next();
			c[i] = n;

		}

	//	Assert.assertTrue(resendOtpTimeFirst.isDisplayed());

		for (int i = 0; i < otp.size(); i++) {
			otp.get(i).sendKeys(c[i]);
		}
	}*/
	
	public void setOtp()
	{
		String []c= {"2","7","9","8"};
		for (int i = 0; i < otp.size(); i++) {
			otp.get(i).sendKeys(c[i]);
		}
		
	}
	
	public void getBack()
	{
		back.click();
	}

	public void getCheckBox(WebDriver driver) {
		
		Assert.assertFalse(driver.findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-1']")).getAttribute("class")
				.contains("checkbox-checked"));
		Assert.assertFalse(driver.findElement(By.xpath("//button[text()='Next']")).isEnabled());
		checkBox.click();
		Assert.assertTrue(driver.findElement(By.xpath("//mat-checkbox[@id='mat-checkbox-1']")).getAttribute("class")
				.contains("checkbox-checked"));
		Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Next']")).isEnabled());
		

	}
	
	public void getCheckBox()
	{
	   checkBox.click();
	}

	public void getNextButton() {
		nextButton.click();

	}
	
	public void nextButtonEnabledOrDisabledOnRemovingOneNumberInOtp()
	{
		SoftAssert s=new SoftAssert();
		s.assertFalse(nextButton.isEnabled());
		s.assertAll();
		
	}

	public void getAreYouNewToTheStockTitle()
	{
		Assert.assertTrue(areYouNewToTheStockTitle.getText().equalsIgnoreCase("Are you new to stocks?"));
	}
	
	public void getChangeNumber() {
		changeNumber.click();

	}

	public void getResendOtpButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(resendOtpButton));
		Assert.assertTrue(resendOtpButton.isDisplayed());
		// resendOtpButton.click();
		// AsserrtresendOtpTimeFirst.isDisplayed();

	}
	
	/*public void getOtpErrorMessage()
	{
		Assert.assertTrue(OtpErrorMessage.isDisplayed());
	}*/
	
	public void getReferralCodeField()
	{
		Assert.assertFalse(referralCodeField.getAttribute("class").contains("dirty"));
	}
	
	public void isReferalCodeFieldDisplayed()
	{
		Assert.assertFalse(referralCodeField.isDisplayed());
	}
	
	public void isCheckBoxIsDisplayed()
	{
		
			
		Assert.assertFalse(checkBox.isDisplayed());
	}

}
