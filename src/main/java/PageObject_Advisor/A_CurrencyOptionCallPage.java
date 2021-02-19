package PageObject_Advisor;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class A_CurrencyOptionCallPage {
	
	@FindBy(xpath = "//input[@formcontrolname='scriptName']")
	public WebElement scripNameField;
	
	@FindBy(xpath = "//span[contains(text(),'USD')]")
	public List<WebElement> currencyOptionAutoSuggesions;
	
	@FindBy(xpath = "//span[text()='Buy']")
	public WebElement callTypeBuy;
	
	@FindBy(xpath = "//span[text()='Sell']")
	public WebElement callTypeSell;
	
	@FindBy(xpath="//p[text()='Weekly']")
	public WebElement expiryOptionWeeklyRadioButton;
	
	@FindBy(xpath="//p[text()='Monthly']")
	public WebElement expiryOptionMonthlyRadioButton;
	
	@FindBy(xpath="//span[text()='Call']")
	public WebElement typeCall;
	
	@FindBy(xpath="//span[text()='Put']")
	public WebElement typePut;
	
	@FindBy(xpath="//select[@formcontrolname='strike']")
	public WebElement strikePriceDropDown;
	
	@FindBy(xpath="(//div[@class='script-details']/p)[2]")
	public WebElement cmpValue;
	
	@FindBy(xpath = "//p[text()='Market Price']")
	public WebElement marketPriceRadioButton;

	@FindBy(xpath = "//p[text()='Recommended Price']")
	public WebElement recommendedPriceRadioButton;
	
	@FindBy(xpath = "//input[@formcontrolname='purchasePrice']")
	public WebElement recommendedPriceField;
	
	@FindBy(xpath = "//input[@formcontrolname='stopLoss']")
	public WebElement stopLossField;
	
	@FindBy(xpath = "//input[@formcontrolname='targetOne']")
	public WebElement targetField;
	
	@FindBy(xpath = "//input[@placeholder='Min Range']")
	public WebElement minRangeField;

	@FindBy(xpath = "//input[@placeholder='Max Range']")
	public WebElement maxRangeField;
	
	@FindBy(xpath = "//span[text()='Intra Day']")
	public WebElement timeFrameIntraDay;
	
	@FindBy(xpath = "//div[@class='selection-field']/span[text()='Low']")
	public WebElement riskValueLow;
	
	@FindBy(xpath = "//span[text()=' Publish Call']")
	public WebElement publishCall;
	
	@FindBy(xpath = "//div[@class='call-header close']")
	public WebElement closeCallButton;
	
	@FindBy(xpath = "//div[@class='alert_heading']")
	public WebElement Msg;
	
	@FindBy(xpath="//span[@class='error ng-star-inserted']")
	public WebElement errorMsg;
	
	public A_CurrencyOptionCallPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void setscripNameField(String scrip) {
		scripNameField.sendKeys(scrip);
	}
	
	public String getCurrencyOptionAutoSuggesions() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(2000);
		int count=0;
		String scripName = currencyOptionAutoSuggesions.get(count).getText();
		currencyOptionAutoSuggesions.get(count).click();
		count++;
		if(count==2)
		{
			count=0;
		}
		return scripName;
	}
	
	public void getCallTypeSell() {
		callTypeSell.click();
	}

	public void getCallTypeBuy() {
		callTypeBuy.click();
	}
	
	public boolean getWeeklyRadioButton()
	{
		expiryOptionWeeklyRadioButton.click();
		return errorMsg.isDisplayed();
	}
	
	public void getMonthlyRadioButton()
	{
		expiryOptionMonthlyRadioButton.click();
	}
	
	public void getTypeCall()
	{
		typeCall.click();
	}
	
	public void getTypePut()
	{
		typePut.click();
	}
	
	public void setStringPrice()
	{
		strikePriceDropDown.click();
		Select s=new Select(strikePriceDropDown);
		s.selectByVisibleText("280");
	}
	
	public double getCmpValue()
	{
		 return Double.parseDouble(cmpValue.getText().replace("C.M.P : \u20B9",""));
	}
	
	public void getRecommendedPriceRadioButton() {
		recommendedPriceRadioButton.click();

	}

	public void setRecommendedPriceField(double d) {
		recommendedPriceField.sendKeys(String.valueOf(d));
	}
	
	public void getMarketPriceRadioButton() {
		marketPriceRadioButton.click();
	}
	
	public void setStopLossFieldForOption(double cmp)
	{
		
		if (callTypeBuy.getAttribute("class").equals("selected")) {
			stopLossField.sendKeys(String.valueOf(cmp-3.0));
		} else if (callTypeSell.getAttribute("class").equals("selected")) {
			
			stopLossField.sendKeys(String.valueOf(cmp+3.0));
		}
	}

	public void setTargetField(double cmp) {
		if (callTypeBuy.getAttribute("class").equals("selected")) {
			targetField.sendKeys(String.valueOf(cmp + 5.0));
		} else if (callTypeSell.getAttribute("class").equals("selected")) {
			targetField.sendKeys(String.valueOf(cmp - 5.0));
		}

	}
	
	public void setMinRangeField(double cmp) {
		if (callTypeBuy.getAttribute("class").equals("selected")) {
			minRangeField.sendKeys(String.valueOf(cmp - ((cmp+5.0) - cmp)/4));
			Assert.assertTrue(true);
		} else if (callTypeSell.getAttribute("class").equals("selected")) {
			minRangeField.sendKeys(String.valueOf(cmp + (cmp - (cmp-5.0))/4));
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

	}
	
	public void setMaxRangeField(double cmp) {
		if (callTypeBuy.getAttribute("class").equals("selected")) {
			maxRangeField.sendKeys(String.valueOf(cmp + ((cmp+5.0) - cmp)/4));
			Assert.assertTrue(true);
			// String []min= {"","maxRange - 10.0", };
		} else if (callTypeSell.getAttribute("class").equals("selected")) {
			maxRangeField.sendKeys(String.valueOf(cmp - (cmp - (cmp-5.0))/4));
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
	}
	
	public void getTimeFrameIntraDay() {
		timeFrameIntraDay.click();
	}
	
	public void getRiskValueLow() {

		riskValueLow.click();
	}
	
	public void getCloseCallButton() {
		closeCallButton.click();
	}
	
	public void getPublishCallWhenThereISSufficientBalance() throws InterruptedException {
		Thread.sleep(2000);
		publishCall.click();
		if (Msg.getText().equalsIgnoreCase("Call given successfully.")) {
			Assert.assertTrue(true);
		} else {
			Thread.sleep(8000);
			getCloseCallButton();
			Assert.assertTrue(false);
		}
	}

}
