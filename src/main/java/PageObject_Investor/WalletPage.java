package PageObject_Investor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class WalletPage {

	@FindBy(xpath = "//img[@src='assets/new-images/wallet.svg']")
	private WebElement wallet;

	@FindBy(xpath = "//p[@class='title']")
	private WebElement walletTitle;

	@FindBy(xpath = "//div[@class='totalBalance']/h3")
	private WebElement totalWalletBalance;

	@FindBy(xpath = "//input[@type='number']")
	private WebElement enterAmountField;

	@FindBy(id = "recharge-wallet")
	private WebElement addCash;

	@FindBy(xpath = "//iframe[@src='https://api.razorpay.com/v1/checkout/public']")
	private WebElement iframe;

	@FindBy(xpath = "//div[@class='email-field']//div[@class='elem svelte-43m0zu invalid mature']")
	private WebElement email;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement enterEmail;

	@FindBy(xpath = "//div[@class='button']")
	private WebElement proceed;

	@FindBy(xpath = "//button[@method='netbanking']")
	private WebElement netBanking;

	@FindBy(xpath = "//label[@for='bank-radio-UTIB']/div")
	private WebElement bank;

	@FindBy(xpath = "//div[@class='button']")
	private WebElement pay;

	@FindBy(xpath = "//button[@class='success']")
	private WebElement success;

	@FindBy(xpath = "//div[@class='addMoney']/p")
	private WebElement passbook;

	@FindBy(xpath = "//h2[@class='headerMat']")
	private WebElement passBookTransactionTitle;

	@FindBy(xpath = "(//tr[@class='mat-row cdk-row ng-star-inserted'])[1]/td[@class='mat-cell cdk-cell nowrap cdk-column-date mat-column-date ng-star-inserted']")
	private WebElement transactionDate;

	@FindBy(xpath = "(//tr[@class='mat-row cdk-row ng-star-inserted'])[1]/td[@class='mat-cell cdk-cell cdk-column-desc mat-column-desc ng-star-inserted']")
	private WebElement transactionDescription;

	@FindBy(xpath = "(//tr[@class='mat-row cdk-row ng-star-inserted'])[1]/td[@class='mat-cell cdk-cell nowrap cdk-column-amt mat-column-amt ng-star-inserted']")
	private WebElement transactionAmount;

	@FindBy(xpath = "(//tr[@class='mat-row cdk-row ng-star-inserted'])[1]/td[@class='mat-cell cdk-cell nowrap cdk-column-type mat-column-type ng-star-inserted']/span")
	private WebElement transactionType;

	@FindBy(xpath = "(//tr[@class='mat-row cdk-row ng-star-inserted'])[1]/td[@class='mat-cell cdk-cell nowrap cdk-column-status mat-column-status ng-star-inserted']/span")
	private WebElement transactionStatus;

	@FindBy(xpath = "//div[@class='alert-container ng-star-inserted']")
	private WebElement invalidValueErrorMessage;

	@FindBy(xpath = "//img[@src='assets/new-images/icon-close.svg']")
	private WebElement transactionCloseButton;

	@FindBy(xpath = "//div[@class='auto-add-money1']//span")
	private List<WebElement> amountOptions;
	
	@FindBy(id="calls-menu")
	private WebElement callMenu;
	
	

	public WalletPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void getWallet() {
		wallet.click();
	}

	public void getWalletTitle() {
		Assert.assertTrue(walletTitle.getText().equalsIgnoreCase("My Wallet"));
	}

	double totalwalletbalance;

	public void getTotalWalletBalance() {
		if (totalWalletBalance.getText().length() < 6) {
			totalwalletbalance = Double.parseDouble(totalWalletBalance.getText().replace("\u20B9", ""));
		} else
			totalwalletbalance = Double
					.parseDouble(totalWalletBalance.getText().replace("\u20B9", "").replace(",", ""));

		System.out.println(totalwalletbalance);

	}

	public void setEnterAmountField(String amount) {

		enterAmountField.sendKeys(amount);

	}

	public boolean getAddCash(WebDriver driver) throws InterruptedException {
		addCash.click();
		Thread.sleep(2000);

		if (!iframe.isDisplayed() && invalidValueErrorMessage.isDisplayed()) {
			// Assert.assertTrue(true);
			SoftAssert soft = new SoftAssert();
			soft.assertTrue(false);
			enterAmountField.clear();
			soft.assertAll();
			return false;

		} else
			return true;

	}

	public void setEmail(String e, WebDriver driver) throws InterruptedException {

		if (iframe.isDisplayed()) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(iframe));

			driver.switchTo().frame(iframe);
			Thread.sleep(2000);

			enterEmail.sendKeys(e);
		}
	}

	public void getProceed() {
		proceed.click();
	}

	public void getNetBanking() {
		netBanking.click();
	}

	public void getBank() {
		bank.click();
	}

	public void getPay() {
		pay.click();
	}

	public void getSuccess() {
		success.click();
	}

	public void afterAddingCash(double amountTobeadded) throws InterruptedException {
		System.out.println(amountTobeadded);
		System.out.println(totalwalletbalance);
		double result = amountTobeadded + totalwalletbalance;

		Thread.sleep(2000);
		double afteraddingAmountToTheWallet = Double
				.parseDouble(totalWalletBalance.getText().replace("\u20B9", "").replace(",", ""));

		if (afteraddingAmountToTheWallet == result) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

	}

	public void getPassBook() throws InterruptedException {
		passbook.click();
		Thread.sleep(2000);
		//
		Assert.assertTrue(passBookTransactionTitle.getText().equalsIgnoreCase("Passbook Transactions"));
		System.out.println(passBookTransactionTitle.getText());
	}

	public void getTransactionCloseButton() {
		transactionCloseButton.click();
	}

	public void getWalletRechargedTransactionDetails(String amount) {
		System.out.println("get wallet recharged details" + Double.parseDouble(amount));

		Date currentDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, yyyy");
		String strDate = formatter.format(currentDate);
		Assert.assertTrue(transactionDate.getText().equalsIgnoreCase(strDate));
		Assert.assertTrue(transactionDescription.getText().equalsIgnoreCase("Wallet Recharged"));
		System.out.println(Double.parseDouble(transactionAmount.getText().replace("\u20B9", "").replace(",", "")));
		// Assert.assertTrue(transactionAmount.getText().replace("\u20B9",
		// "").replace(",","").equals(amount));
		if (Double.parseDouble(transactionAmount.getText().replace("\u20B9", "").replace(",", "")) == Double
				.parseDouble(amount)) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

		Assert.assertTrue(transactionType.getText().equalsIgnoreCase("CREDIT"));

	}

	public String getAmountOptions() {
		for (int i = 0; i < amountOptions.size(); i++) {
			if (amountOptions.get(i).getText().replace("\u20B9", "").equals("500")
					|| amountOptions.get(i).getText().replace("\u20B9", "").equals("1500")
					|| amountOptions.get(i).getText().replace("\u20B9", "").equals("2000")) {
				Assert.assertTrue(true);

			} else
				Assert.assertTrue(false);

		}
		amountOptions.get(0).click();
		return amountOptions.get(0).getText().replace("\u20B9", "");

	}
	
	
	
	public void afterPerchasingCall(double callAmount) throws InterruptedException
	{
		System.out.println(callAmount);
		double result = totalwalletbalance - callAmount ;
		Thread.sleep(2000);
		System.out.println(totalWalletBalance.getText().replace("\u20B9", "").replace(",", ""));
		double afterPerchasingCallWalletBallance = Double
				.parseDouble(totalWalletBalance.getText().replace("\u20B9", "").replace(",", ""));

		if (afterPerchasingCallWalletBallance == result) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		
	}
	
	public void getCallMenu(WebDriver driver)
	{
	    Actions action=new Actions(driver);
	    action.moveToElement(callMenu).build().perform();
	    driver.findElement(By.xpath("(//span[text()='Future'])[1]")).click();
	}
	
	public void transactionDetailsAfterCreatingCall(double amt,String scripName)
	{
		Date currentDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, yyyy");
		String strDate = formatter.format(currentDate);
		Assert.assertTrue(transactionDate.getText().equalsIgnoreCase(strDate));
		Assert.assertTrue(transactionDescription.getText().equalsIgnoreCase("Given call "+scripName));
		if(Double.parseDouble(transactionAmount.getText().replace("\u20B9", "").replace(",", "")) == amt)
		{
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
		Assert.assertTrue(transactionType.getText().equalsIgnoreCase("DEBIT"));
		Assert.assertTrue(transactionStatus.getText().equalsIgnoreCase("confirmed"));
		
		
	}

}
