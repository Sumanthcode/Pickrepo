package PageObject_Advisor;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class A_EquityFutureCallPage {
	
	@FindBy(xpath = "//input[@formcontrolname='scriptName']")
	public WebElement scripNameField;
	
	@FindBy(xpath = "//span[contains(text(),'MARI')]")
	public List<WebElement> EquityFutureAutoSuggesions;
	
	@FindBy(xpath = "//div[@class='cmp']/span")
	public WebElement cmpValue;
	
	@FindBy(xpath = "//span[text()='Buy']")
	public WebElement callTypeBuy;
	
	@FindBy(xpath="//p[text()='Recommended Price']")
	public WebElement recommendedPriceRadioButton;
	
	@FindBy(xpath="//input[@formcontrolname='purchasePrice']")
	public WebElement recommendedPriceField;
	
	@FindBy(xpath = "//p[text()='Market Price']")
	public WebElement marketPriceRadioButton;
	
	@FindBy(xpath = "//input[@formcontrolname='stopLoss']")
	public WebElement stopLossField;
	
	@FindBy(xpath = "//span[text()='Sell']")
	public WebElement callTypeSell;
	
	@FindBy(xpath = "//input[@formcontrolname='targetOne']")
	public WebElement targetField;
	
	@FindBy(xpath = "//input[@placeholder='Min Range']")
	public WebElement minRangeField;

	@FindBy(xpath = "//input[@placeholder='Max Range']")
	public WebElement maxRangeField;
	
	@FindBy(xpath = "//input[@placeholder='Quantity']")
	public WebElement quantityField;
	
	@FindBy(xpath = "//p[@class='ratio']")
	public WebElement riskRewardRatio;
	
	@FindBy(xpath = "//span[text()='Intra Day']")
	public WebElement timeFrameIntraDay;
	
	@FindBy(xpath = "((//div[@class='selection-field'])[3]/span)[1]")
	public WebElement riskValueLow;
	
	@FindBy(xpath = "//span[text()=' Publish Call']")
	public WebElement publishCall;
	
	@FindBy(xpath = "//div[@class='call-header close']")
	public WebElement closeCallButton;
	
	@FindBy(xpath = "//div[@class='alert_heading']")
	public WebElement equityMarketingTimeErrorMsg;
	
	@FindBy(xpath="//div[@class='values profit']/p")
	public WebElement investmentValue;
	
	@FindBy(xpath="//p[@class='lotSize ng-star-inserted']")
	public WebElement lotSize;
	public A_EquityFutureCallPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void setscripNameField(String scrip) {
		scripNameField.sendKeys(scrip);
	}
	
	public String getEquityFutureAutoSuggesions() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(2000);
		String scripName = EquityFutureAutoSuggesions.get(1).getText();
		EquityFutureAutoSuggesions.get(1).click();
		return scripName;
	}
	
	double cmp;

	public double getCmpValue() throws InterruptedException {
		Thread.sleep(2000);
		cmp = Double.parseDouble(cmpValue.getText().replace("\u20B9", "").replace(",", ""));
		return cmp;

	}
	
	public void getCallTypeBuy()
	{
		callTypeBuy.click();
	}
	
	public void getCallTypeSell() {
		callTypeSell.click();
	}
	
	public void getMarketPriceRadioButton() {
		marketPriceRadioButton.click();
	}
	
	public void getRecommendedPriceRadioButton()
	{
		recommendedPriceRadioButton.click();
		
	}
	
	public void setRecommendedPriceField(String d)
	{
		recommendedPriceField.sendKeys(d);
	}
	
	public double setStopLossFieldForFutre(double stopLoss)
	{
	     double sl=0.0;
		
		if (callTypeBuy.getAttribute("class").equals("selected")) {
			 sl = (stopLoss-((stopLoss+5.0) - stopLoss)/4)-2.0;
			stopLossField.sendKeys(String.valueOf(sl));
			
		} else if (callTypeSell.getAttribute("class").equals("selected")) {
			 sl = (stopLoss+((stopLoss+5.0) - stopLoss)/4)+2.0;
			stopLossField.sendKeys(String.valueOf(sl));
			
		}
		return sl;
	}
	
	public void setTargetField(double target) {
		if (callTypeBuy.getAttribute("class").equals("selected")) {
			targetField.sendKeys(String.valueOf(target + 5.0));
		} else if (callTypeSell.getAttribute("class").equals("selected")) {
			targetField.sendKeys(String.valueOf(target - 5.0));
		}

	}
	
	public void setMinRangeField(double minRange) {
		if (callTypeBuy.getAttribute("class").equals("selected")) {
			minRangeField.sendKeys(String.valueOf(minRange - ((minRange+5.0) - minRange)/4));
			Assert.assertTrue(true);
		} else if (callTypeSell.getAttribute("class").equals("selected")) {
			minRangeField.sendKeys(String.valueOf(minRange + (minRange - (minRange-5.0))/4));
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

	}
	
	public void setMaxRangeField(double maxRange) {
		if (callTypeBuy.getAttribute("class").equals("selected")) {
			maxRangeField.sendKeys(String.valueOf(maxRange + ((maxRange+5.0) - maxRange)/4));
			Assert.assertTrue(true);
			// String []min= {"","maxRange - 10.0", };
		} else if (callTypeSell.getAttribute("class").equals("selected")) {
			maxRangeField.sendKeys(String.valueOf(maxRange - (maxRange - (maxRange-5.0))/4));
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
	}
	
	public void setQuantityField(String quantity) {
		quantityField.sendKeys(quantity);
	}
	
	public void getRiskRewardRatio() {
		double ratio = Double.parseDouble(riskRewardRatio.getText());
		if (ratio >= 1) {
			Assert.assertTrue(true);
		}

	}
	
	public void getTimeFrameIntraDay() {
		timeFrameIntraDay.click();
	}
	
	public String getRiskValueLow() {
		String text = riskValueLow.getText();
		riskValueLow.click();
		return text;
	}
	
	public void getCloseCallButton() {
		closeCallButton.click();
	}
	
	public void getPublishCallWhenThereISSufficientBalance() throws InterruptedException {
		Thread.sleep(2000);
		publishCall.click();
		if (equityMarketingTimeErrorMsg.getText().equalsIgnoreCase("Call given successfully.")) {
			Assert.assertTrue(true);
		} else {
			Thread.sleep(8000);
			getCloseCallButton();
			Assert.assertTrue(false);
		}
	}
	
	public void getPublishCallWhenNoWalletBalance() throws InterruptedException {
		/*
		 * Date currentDate = new Date(); String dateToStr =
		 * DateFormat.getTimeInstance(DateFormat.SHORT).format(currentDate);
		 * System.out.println("Date Format using getTimeInstance(DateFormat.SHORT): "
		 * +dateToStr)
		 */;
		Thread.sleep(2000);
		publishCall.click();
		if (equityMarketingTimeErrorMsg.getText().equalsIgnoreCase("Insufficient wallet amount")) {
			Thread.sleep(8000);
			getCloseCallButton();
			Assert.assertTrue(true);

		} else {
			Thread.sleep(8000);
			getCloseCallButton();
			Assert.assertTrue(false);
		}

	}
	
	public String getCallTypeBuyText()
	{
		return callTypeBuy.getText();
	}
	
	

}
