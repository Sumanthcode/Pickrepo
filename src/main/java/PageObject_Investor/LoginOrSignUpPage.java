package PageObject_Investor;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginOrSignUpPage {
	
	@FindBy(xpath = "//div[@class='box ng-star-inserted']/h2")
	public WebElement loginOrSignUpTitle;
	
	@FindBy(xpath="//img[@src='assets/new-images/contact_logo.svg']")
	public WebElement useMobileNumber;
	
	@FindBy(xpath = "//div[@class='ngx-mat-tel-input-container custom web']//div[@class='arrow-down']")
	public WebElement dropDown;

	@FindBy(xpath = "//p[text()='Enter OTP']")
	public WebElement enterOtpTitle;

	@FindBy(xpath = "//input[@placeholder='Search...']") // stage
	public WebElement searchField;

	@FindBy(xpath = "//div[contains(text(),'India')]")
	public WebElement country;

	@FindBy(xpath = "//div[@class='ngx-mat-tel-input-container custom web']//input")
	public WebElement mobileNumberField;
	
	@FindBy(xpath="//p[@class='f-r center ng-star-inserted']")
	public WebElement loginWithMobileNumberTitle;
	
	@FindBy(xpath="//p[@class='f-r center ng-star-inserted']/img")
	public WebElement back;

	@FindBy(xpath = "//button[@class='login-next']")
	public WebElement nextButton;

	@FindBy(xpath = "//span[@class='error ng-star-inserted']")
	public WebElement errorMessage;

	@FindBy(xpath = "//div[@class='broker']/p")
	public List<WebElement> brokers;
	
	@FindBy(xpath="//div[@class='ngx-mat-tel-input-container custom web']//span")
	public WebElement defaultCountryCode;
	
	@FindBy(xpath="//span[@class='scope ng-star-inserted']")
	public WebElement asA;
	
	@FindBy(xpath="//img[@src='assets/new-images/google_logo.png']")
	public WebElement continueWithGoogle;
	
	@FindBy(xpath="//div[@class='BHzsHc']")
	public WebElement useAnotherAccount;
	
	@FindBy(xpath="//input[@autocomplete='username']")
	public WebElement emailField;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement passwordField;
	
	@FindBy(xpath="//div[@class='VfPpkd-RLmnJb']")
	public WebElement next;
	
	@FindBy(xpath="//span[@class='error ng-star-inserted']")
	public WebElement error;

	public LoginOrSignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void getUseMobileNumber()
	{
		useMobileNumber.click();
	}
	public void getDefaultCountryCode()
	{
		System.out.println("hyyyh");
		Assert.assertTrue(defaultCountryCode.getText().equals("+91"));
	}

	public void getDropDown() {
		dropDown.click();
	}

	public void setSearchField(String country) {
		searchField.sendKeys(country);
	}

	public void getCountry() {
		country.click();
	}

	public void setMobileNumberField(String number) {

		mobileNumberField.sendKeys(number);
		// mobileNumberField.clear();

	}

	public void getMobileNumberField() {
		mobileNumberField.clear();
	}

	public void getNextButton() {
		nextButton.click();
	}

	public void getErrorMessage(WebDriver driver) {

		try
		{
			Assert.assertFalse(error.isDisplayed());
		}
		catch(Exception e)
		{
			
		}
		

	}

	

	public void getEnterOtpTitle() {

		Assert.assertTrue(enterOtpTitle.getText().equals("Enter OTP"));
	}

	public void setMobileNumberField1() {
		mobileNumberField.sendKeys("9826727726");
	}
	
	public void getPhoneNumberRequiredMsgTitle()
	{
		Assert.assertTrue(errorMessage.getText().equalsIgnoreCase("Phone Number is required."));
	}

	
	

}
