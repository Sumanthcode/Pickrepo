package InvestorTest;

import java.awt.AWTException;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Generic.Base;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.InvestorDashBoardPage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.PickRightHomePage;
import PageObject_Investor.WalletPage;

public class ValidateWallet_ExistingUser extends Base {
	WalletPage w;

	@Test(priority = 1)
	public void validateMyWalletTitle() {

		PickRightHomePage p = new PickRightHomePage(driver);
		p.getJoinAsinvestor();
		LoginOrSignUpPage l = new LoginOrSignUpPage(driver);
		l.getUseMobileNumber();
		l.getDropDown();
		l.setSearchField("India");
		l.getCountry();
		l.setMobileNumberField("6360245606");
		l.getNextButton();
		EnterOtpPage e = new EnterOtpPage(driver);
		driver.findElement(By.xpath("//input[contains(@id,'otp_0')]")).sendKeys("3");
		driver.findElement(By.xpath("//input[contains(@id,'otp_1')]")).sendKeys("4");
		driver.findElement(By.xpath("//input[contains(@id,'otp_2')]")).sendKeys("6");
		driver.findElement(By.xpath("//input[contains(@id,'otp_3')]")).sendKeys("5");
		e.getNextButton();
		/*
		 * OnBoardPage1 o1 = new OnBoardPage1(driver); o1.getYesImNewToStock();
		 * JavascriptExecutor j = (JavascriptExecutor) driver;
		 * j.executeScript("window.scrollBy(0,500)"); OnBoardPage2 o2 = new
		 * OnBoardPage2(driver); o2.getNext(); o2.getShortTerm(); o2.getNext();
		 * o2.getBeginner(); o2.getParters();
		 */
		HomePage h = new HomePage(driver);
		h.getStartTrading();
		/*
		 * CategorySelectionPage c = new CategorySelectionPage(driver);
		 * c.getEquityCash();
		 */
		// c.getSkip(driver);
		w = new WalletPage(driver);
		//validate that when clicked on wallet icon, wallet page is displayed
		w.getWallet();
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

	// validate the wallet recharge using given amount options.
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
	//validate the wallet balance when we perchase the call
	@Test(priority=4)
	public void validateTransactionAfterPurchasingCall() throws NumberFormatException, InterruptedException
	{
		w.getTotalWalletBalance();
		w.getCallMenu(driver);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,500)");
		InvestorDashBoardPage i=new InvestorDashBoardPage(driver);
		String callAmount=i.getCallAmount();
		i.getCall();
		w.getWallet();
		
	//	w.getPassBook();
		w.afterPerchasingCall(Double.parseDouble(callAmount));
		
		
		
		
	}

}
