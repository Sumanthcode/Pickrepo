package AdvisorTest;

import java.awt.AWTException;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Generic.Base;
import PageObject_Advisor.A_AdvisorDashBoardPage;
import PageObject_Advisor.A_EquityCashCallPage;
import PageObject_Advisor.A_PickRightLandingPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.InvestorDashBoardPage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.WalletPage;

public class A_ValidateWallet extends Base{
	WalletPage w;
	@Test(priority=1)
	public void validateMyWalletTitle()
	{
		A_PickRightLandingPage p=new A_PickRightLandingPage(driver);
		p.getJoinAsAdvisor();
		LoginOrSignUpPage l = new LoginOrSignUpPage(driver);
		l.getDropDown();
		l.setSearchField("India");
		l.getCountry();
		l.setMobileNumberField("6360245606");
		l.getNextButton();
		EnterOtpPage e = new EnterOtpPage(driver);
		e.setOtp();
		e.getNextButton();
		HomePage h = new HomePage(driver);
		h.getStartTrading();
		//a.getSkip();
		w = new WalletPage(driver);
		//validate that when clicked on wallet icon, wallet page is displayed
		w.getWallet();
		//validate the my wallet title 
		w.getWalletTitle();
		
	}
	
	@Test(dataProvider = "testAmount", priority = 2)
	public void validateWalletRecharge(String amount) throws InterruptedException, AWTException {

		w.getTotalWalletBalance();
		System.out.println(amount);

		w.setEnterAmountField(amount);

		// Validate the wallet recharge is successfull for the amount 10, 500000
		if (w.getAddCash(driver)) {

			w.setEmail("balankoppasumanth@gmail.com", driver);
			w.getProceed();
			w.getNetBanking();
			w.getBank();
			w.getPay();
			String win = driver.getWindowHandle();
			String parent = driver.switchTo().window(win).getTitle();
			Set<String> windows = driver.getWindowHandles();
			for (String s : windows) {
				if (!parent.equals(driver.switchTo().window(s).getTitle())) {
					driver.switchTo().window(s);
					w.getSuccess();
				}
			}

			driver.switchTo().window(win);
			Thread.sleep(3000);

			w.afterAddingCash(Double.parseDouble(amount)); // Validate the passboo transaction title is displayed when
															// we click on View passbook transaction
			w.getPassBook(); // validate the successfully recharged amount is populated is the passbook along
								// with the Date, description, type, status
			w.getWalletRechargedTransactionDetails(amount);
			w.getTransactionCloseButton();

		}

	}
	
	String d[][];

	@DataProvider(name = "testAmount")
	public String[][] setTestAmount() {
		d = new String[5][1];
		d[0][0] = "10.00";
		d[1][0] = "00.00";
		d[2][0] = "20.35";
		d[3][0] = "500000.00";
		d[4][0] = "500001.00";

		return d;

	}
	
	@Test(priority = 3)
	public void validateWelletRechargeWithGivenAmountOption() throws InterruptedException {
		String amount = w.getAmountOptions(); // validate amount options contains 500, 1500, 2000
		w.getTotalWalletBalance();
		w.getAddCash(driver);
		w.setEmail("balankoppasumanth@gmail.com", driver);
		w.getProceed();
		w.getNetBanking();
		w.getBank();
		w.getPay();
		String win = driver.getWindowHandle();
		String parent = driver.switchTo().window(win).getTitle();
		Set<String> windows = driver.getWindowHandles();
		for (String s : windows) {
			if (!parent.equals(driver.switchTo().window(s).getTitle())) {
				driver.switchTo().window(s);
				w.getSuccess();
			}
		}

		driver.switchTo().window(win);
		Thread.sleep(3000);

		w.afterAddingCash(Double.parseDouble(amount)); 
		w.getPassBook();
		w.getWalletRechargedTransactionDetails(amount);
		w.getTransactionCloseButton();

	}
	
	@Test(priority=4)
	public void validateWalletAfterCreatingCall() throws InterruptedException, AWTException
	{
		w.getTotalWalletBalance();
		InvestorDashBoardPage i=new InvestorDashBoardPage(driver);
		i.getInvestorDashBoard();
		A_AdvisorDashBoardPage a=new A_AdvisorDashBoardPage(driver);
			a.getEquity();
			a.getEquityCash();
			a.getCreateCall();
			A_EquityCashCallPage c=new A_EquityCashCallPage(driver);
			c.setscripNameField("INANI");
		/*
		 * Thread.sleep(2000); Robot r=new Robot(); r.keyPress(KeyEvent.VK_BACK_SPACE);
		 */
			String scripName=c.getEquityCashAutoSuggesions();
			
					
			double cmp=c.getCmpValue();
			c.getCallTypeSell();
			c.getMarketPriceRadioButton();
			
			c.setMinRangeField(cmp);
			c.setMaxRangeField(cmp);
			c.setStopLossField(cmp);
			c.setTargetField(cmp);
			c.setQuantityField("1");
			c.getRiskRewardRatio();
			JavascriptExecutor j=(JavascriptExecutor)driver;
			j.executeScript("window.scrollBy(0,2000)");
			c.getRiskValueLow();
			//c.setAdvisorFeeField(55.0);
			c.getPublishCallWhenThereISSufficientBalance();
			w.getWallet();
			w.afterPerchasingCall(5.00);
			w.getPassBook();
			w.transactionDetailsAfterCreatingCall(5.00,scripName );
		//	w.getPassBook();
			
		//	w.getWalletRechargedTransactionDetails("5.00");
	}


	

}
