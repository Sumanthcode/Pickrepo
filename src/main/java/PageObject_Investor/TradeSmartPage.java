package PageObject_Investor;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TradeSmartPage {
	
	@FindBy(xpath = "//p[text()='Trade Smart']")
	private WebElement tradeSmart;

	@FindBy(xpath = "//input[@placeholder='Client id']")
	private WebElement clientId;

	@FindBy(xpath = "//input[@placeholder='password']")
	private WebElement password;

	@FindBy(xpath = "//input[@id='ans_1']")
	private WebElement digitBirthDate;

	@FindBy(xpath = "//div[@class='sign-btn-sec']/button")
	private WebElement signIn;

	@FindBy(xpath = "//a[@href='https://swing.tradesmartonline.in/app-center']")
	private WebElement here;

	@FindBy(xpath = "//a[@class='create-app-btn']")
	private WebElement createNewApp;

	@FindBy(xpath = "//input[@formcontrolname='appName']")
	private WebElement appName;

	@FindBy(xpath = "//button[@value='submit']")
	private WebElement submit;

	@FindBy(xpath = "//a[text()='App Center']")
	private WebElement appCentre;

	@FindBy(xpath = "//span[@class='app-details-inner']")
	private List<WebElement> appDetails;

	@FindBy(xpath = "//input[@placeholder='UID']")
	private WebElement UID;

	@FindBy(xpath = "//input[@placeholder='appId']")
	private WebElement appId;

	@FindBy(xpath = "//input[@formcontrolname='appSecretKey']")
	private WebElement appSecurityKey;

	@FindBy(xpath = "//input[@placeholder='pass key']")
	private WebElement passKey;
	
	@FindBy(xpath="//span[@class='mat-button-wrapper']")
	private WebElement tradeSubmit;
	
	@FindBy(xpath="//div[@class='box ng-star-inserted']/h2")
	private WebElement welcomeUserTitle;
	
	public TradeSmartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void getTradeSmart() {
		tradeSmart.click();

	}

	public void getCreateNewApp() {
		createNewApp.click();
	}

	public void setAppName(String name) {
		appName.sendKeys(name);
	}

	public void getSubmit() {
		submit.click();
	}

	public void setClientId(String clientid) {
		clientId.sendKeys(clientid);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void setDigitBirthDate(String birthYear) {
		digitBirthDate.sendKeys(birthYear);
	}

	public void getSignIn() {
		signIn.click();
	}

	public void getHere() {
		here.click();
	}

	public void getAppCentre() {
		appCentre.click();
	}

	public String[] getAppDetails() {
		String a[] = new String[appDetails.size()];
		for (int i = 0; i < appDetails.size(); i++) {
			a[i] = appDetails.get(i).getText();
			
		}
		return a;
		

	}
	
	public void setUID(String uid)
	{
		UID.sendKeys(uid);
	}
	
	public void setAppId(String appid)
	{
		appId.sendKeys(appid);
	}
	
	public void setAppSecuritykey(String securityKey)
	{
		appSecurityKey.sendKeys(securityKey);
	}
	
	public void setPassKey(String passkey)
	{
		passKey.sendKeys(passkey);
	}
	
	public void getTradeSubmit()
	{
		tradeSubmit.click();
	}
	
	public void getWelcomeUserTitle()
	{
		Assert.assertTrue(welcomeUserTitle.getText().equalsIgnoreCase("Welcome User"));
	}
	

}
