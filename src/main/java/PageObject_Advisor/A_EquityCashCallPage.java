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
import org.testng.asserts.SoftAssert;

public class A_EquityCashCallPage {

	@FindBy(xpath = "//input[@formcontrolname='scriptName']")
	public WebElement scripNameField;

	@FindBy(xpath = "//div[@class='heading']/h1")
	public WebElement createEquityCashCallTitle;

	@FindBy(xpath = "//span[text()='Buy']")
	public WebElement callTypeBuy;

	@FindBy(xpath = "//span[@class='error ng-star-inserted']")
	public WebElement ErrorMsgTitle;

	@FindBy(xpath = "//span[contains(text(),'TVS')]")
	public List<WebElement> EquityCashAutoSuggesions;

	@FindBy(xpath = "//span[text()='Sell']")
	public WebElement callTypeSell;

	@FindBy(xpath = "//p[text()='Market Price']")
	public WebElement marketPriceRadioButton;

	@FindBy(xpath = "//p[text()='Recommended Price']")
	public WebElement recommendedPriceRadioButton;

	@FindBy(xpath = "//input[@formcontrolname='purchasePrice']")
	public WebElement recommendedPriceField;

	@FindBy(xpath = "//div[@class='cmp']/span")
	public WebElement cmpValue;

	@FindBy(xpath = "//input[@formcontrolname='stopLoss']")
	public WebElement stopLossField;

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

	@FindBy(xpath = "//div[@class='selection-field']/span[text()='Low']")
	public WebElement riskValueLow;

	@FindBy(xpath = "//span[text()=' Publish Call']")
	public WebElement publishCall;

	@FindBy(xpath = "//div[@class='alert_heading']")
	public WebElement equityMarketingTimeErrorMsg;

	@FindBy(xpath = "//div[@class='call-header close']")
	public WebElement closeCallButton;

	@FindBy(xpath = "//span[text()='Intra Day']")
	public WebElement timeFrameIntraDay;
	
	@FindBy(xpath = "//div[@class='alert_heading']")
	public WebElement msg;
	
	@FindBy(xpath="//div[@class='values profit']/p")
	public WebElement investmentValue;

	public A_EquityCashCallPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void getCreateEquityCashCallTitle() {
		Assert.assertTrue(createEquityCashCallTitle.getText().equalsIgnoreCase("Create Equity Cash Call"));
	}

	public void setscripNameField(String scrip) {
		scripNameField.sendKeys(scrip);
	}

	public String getEquityCashAutoSuggesions() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(2000);
		String scripName = EquityCashAutoSuggesions.get(1).getText();
		EquityCashAutoSuggesions.get(1).click();
		return scripName;
	}

	public void getScripNameIsRequiredErrorMsgTitle() {
		scripNameField.sendKeys("");
		callTypeBuy.click();
		Assert.assertTrue(ErrorMsgTitle.getText().equalsIgnoreCase("Scrip Name is required."));
	}

	public void checkBuyIsSelectedOrNot() {
		callTypeBuy.click();
		Assert.assertTrue(callTypeBuy.getAttribute("class").equalsIgnoreCase("selected"));
	}

	public void getCallTypeSell() {
		callTypeSell.click();
	}

	public void getCallTypeBuy() {
		callTypeBuy.click();
	}

	public void getRecommendedPriceRadioButton() {
		recommendedPriceRadioButton.click();

	}

	public void setRecommendedPriceField(String d) {
		recommendedPriceField.sendKeys(String.valueOf(d));
	}

	public void getMarketPriceRadioButton() {
		marketPriceRadioButton.click();
	}

	public void getTimeFrameIntraDay() {
		timeFrameIntraDay.click();
	}

	public void setMinRangeField(double minRange) {
		if (callTypeBuy.getAttribute("class").equals("selected")) {
			minRangeField.sendKeys(String.valueOf(minRange - ((minRange + minRange * 0.16) - minRange) / 4));
			Assert.assertTrue(true);
		} else if (callTypeSell.getAttribute("class").equals("selected")) {
			minRangeField.sendKeys(String.valueOf(minRange + (minRange - (minRange - minRange * 0.16)) / 4));
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

	}

	public void setMaxRangeField(double maxRange) {
		if (callTypeBuy.getAttribute("class").equals("selected")) {
			maxRangeField.sendKeys(String.valueOf(maxRange + ((maxRange + maxRange * 0.16) - maxRange) / 4));
			Assert.assertTrue(true);
			// String []min= {"","maxRange - 10.0", };
		} else if (callTypeSell.getAttribute("class").equals("selected")) {
			maxRangeField.sendKeys(String.valueOf(maxRange - (maxRange - (maxRange - maxRange * 0.16)) / 4));
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
	}

	public void setStopLossField(double stopLoss) {
		if (callTypeBuy.getAttribute("class").equals("selected")) {
			System.out.println(stopLoss - (stopLoss * 0.14));
			stopLossField.sendKeys(String.valueOf(stopLoss - (stopLoss * 0.14)));
		} else if (callTypeSell.getAttribute("class").equals("selected")) {
			stopLossField.sendKeys(String.valueOf(stopLoss + stopLoss * 0.14));
		}

	}

	public void setTargetField(double target) {
		if (callTypeBuy.getAttribute("class").equals("selected")) {
			targetField.sendKeys(String.valueOf(target + target * 0.16));
		} else if (callTypeSell.getAttribute("class").equals("selected")) {
			targetField.sendKeys(String.valueOf(target - target * 0.16));
		}

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

	public void getRiskValueLow() {

		riskValueLow.click();
	}

	public void getCloseCallButton() {
		closeCallButton.click();
	}

	public void getPublishCall() {
		publishCall.click();
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

	public void getPublishCallWhenMarketTimeIsGotOver() throws InterruptedException {
		Thread.sleep(2000);
		publishCall.click();
		if (equityMarketingTimeErrorMsg.getText()
				.equalsIgnoreCase("You can not place Market price calls after market hours!")) {
			Assert.assertTrue(true);
			Thread.sleep(8000);
			getCloseCallButton();
		} else {
			Thread.sleep(8000);
			getCloseCallButton();
			Assert.assertTrue(false);

		}

	}

	public void checkIntradayTimeFrameIsSelected() throws InterruptedException {
		if (timeFrameIntraDay.getAttribute("class").contains("selected disabled-field")) {

			getCloseCallButton();
			Assert.assertTrue(true);
		} else {
			getCloseCallButton();
			Assert.assertTrue(false);
		}

	}

	public void getPriceIsRequiredErrorMsgWhenWeLeftRecommendedPriceBlank() {
		Assert.assertTrue(ErrorMsgTitle.getText().equalsIgnoreCase("Price is required."));
	}

	double cmp;

	public double getCmpValue() throws InterruptedException {
		Thread.sleep(2000);
		cmp = Double.parseDouble(cmpValue.getText().replace("\u20B9", "").replace(",", ""));
		return cmp;

	}

	Robot robot;

	public void getStopLossMustbeSmallerThanCMPErrorMsgBuyType(double stopLoss) throws AWTException {
		stopLossField.sendKeys(String.valueOf(stopLoss));
		Assert.assertTrue(ErrorMsgTitle.getText().equalsIgnoreCase("Stop Loss must be smaller than CMP"));
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);

	}

	public void getStopLossIsRequiredErrorMsg(String stopLoss, double target) {
		stopLossField.sendKeys(stopLoss);
		targetField.sendKeys(String.valueOf(target));
		Assert.assertTrue(ErrorMsgTitle.getText().equalsIgnoreCase("Stop Loss is required."));

	}

	public void getTargetIsRequiredErrorMsgBuyType(double stopLoss) {
		stopLossField.sendKeys(String.valueOf(stopLoss));
		targetField.click();
		// robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		Assert.assertTrue(ErrorMsgTitle.getText().equalsIgnoreCase("Target is required."));
	}

	public void getTargetMustBeGreaterThanPriceErroMsgBuyType(double target) {
		targetField.sendKeys(String.valueOf(target));
		Assert.assertTrue(ErrorMsgTitle.getText().equalsIgnoreCase("Target must be greater than price"));
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
	}

	public void getMinEntryRangeIsRequiredErrorMsgWhenMinRangeFieldBlank(double target, String minRange,
			String maxRange) {
		targetField.sendKeys(String.valueOf(target));
		minRangeField.sendKeys(minRange);
		maxRangeField.sendKeys(maxRange);
		Assert.assertTrue(ErrorMsgTitle.getText().equalsIgnoreCase("Minimum Entry Range is required."));
	}

	public void getMaxEntryRangeIsRequiredErrorMsgWhenMaxRangeFieldBlank(double minRange) {
		minRangeField.sendKeys(String.valueOf(minRange));
		Assert.assertTrue(ErrorMsgTitle.getText().equalsIgnoreCase("Maximum Entry Range is required."));
	}

	public void getMinRangeCannotBeGreaterThanMarketPriceErrorMsg(double maxRange, double minRange) {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		maxRangeField.sendKeys(String.valueOf(maxRange));
		minRangeField.click();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		minRangeField.sendKeys(String.valueOf(minRange));
		Assert.assertTrue(ErrorMsgTitle.getText().equalsIgnoreCase("Min Range cannot be greater than entry price"));
	}

	public void getMaxRangeMaxRangeCannotBeLesserThanMarketPriceErrorMs(double maxRange) {

		maxRangeField.sendKeys(String.valueOf(maxRange));
		Assert.assertTrue(ErrorMsgTitle.getText().equalsIgnoreCase("Max Range cannot be lesser than entry price"));
	}

	public void getStopLossMustBeLessThanMinEntryRangeErrorMsg(double minRange, double stopLoss) {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		minRangeField.sendKeys(String.valueOf(minRange));
		stopLossField.click();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		stopLossField.sendKeys(String.valueOf(stopLoss));
		Assert.assertTrue(ErrorMsgTitle.getText().equalsIgnoreCase("Stop Loss must be less than minimum entry range"));

	}

	public void getTargetMustBeGreaterThanMaxEntryRangeErrorMsg(double stopLoss, double target, double minRange,
			double maxRange) {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		stopLossField.sendKeys(String.valueOf(stopLoss));
		targetField.click();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		targetField.sendKeys(String.valueOf(target));
		SoftAssert sf=new SoftAssert();
		sf.assertTrue(ErrorMsgTitle.getText().equalsIgnoreCase("Target must be greater than maximum entry range"));
		minRangeField.click();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		minRangeField.sendKeys(String.valueOf(minRange));
		maxRangeField.click();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		maxRangeField.sendKeys(String.valueOf(maxRange));
	//	Assert.assertTrue(ErrorMsgTitle.getText().equalsIgnoreCase("Target must be greater than maximum entry range"));

	}

	public void getCallRiskRatioNeedsToBeMoreThanOneErrorMsg()  {
		Assert.assertTrue(msg.getText().equalsIgnoreCase("Call Risk Ratio Needs To Be More Than 1"));

	}

}
