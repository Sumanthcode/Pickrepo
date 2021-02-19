package InvestorTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.CategorySelectionPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.InvestorDashBoardPage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.PickRightHomePage;

public class ValidateInvestorDashBoard extends Base {
	InvestorDashBoardPage i;

	/*
	 * verify that once user enter the investor Dashboard new call header is active
	 * and title is new calls and Call in buy range filter is active
	 */
	@Test(priority = 1)
	public void validateNewCallPage() throws InterruptedException {
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
		e.setOtp();
		e.getNextButton();
		HomePage h = new HomePage(driver);
		h.getStartTrading();
		CategorySelectionPage c = new CategorySelectionPage(driver);
		c.getEquityCash();
		i = new InvestorDashBoardPage(driver);
		Assert.assertTrue(i.callsInBuyRangeFilter.getAttribute("class").contains("active"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		i.callsInBuyRangeFilterClose.click();
		if (!i.newCalls.isEmpty()) {
			int f1Count = i.newCalls.size();
			while (true) {

				WebElement f = driver.findElement(By.xpath("(//app-investor-new-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.newCalls.size() == f1Count) {
					break;
				}

				f1Count = i.newCalls.size();
			}
			System.out.println("newcalls "+f1Count);
			System.out.println(i.newCallHeader.getText().replaceAll("[^0-9]", ""));
			Assert.assertTrue(i.newCallHeader.getText().replaceAll("[^0-9]", "").equals(String.valueOf(f1Count)));

		} else {
			
			Assert.assertTrue(i.newCallHeader.getText().replaceAll("[^0-9]", "").equals("0"));
		}
	
	}

	/*
	 * verify that when user clicks on mycalls, mycalls header is active and title
	 * is my calls
	 */

	@Test(priority = 2)
	public void validateMyCallPage() throws InterruptedException {
		i.myCallHeader.click();
		Assert.assertTrue(i.myCallHeader.getAttribute("class").contains("active"));
		Assert.assertTrue(i.allCallTitle.getText().equalsIgnoreCase("my Calls"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (!i.myCalls.isEmpty()) {
			int f1Count = i.myCalls.size();
			while (true) {

				WebElement f = driver.findElement(By.xpath("(//app-investor-my-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.myCalls.size() == f1Count) {
					break;
				}

				f1Count = i.myCalls.size();
			}
			System.out.println("mycalls "+f1Count);
			System.out.println(i.myCallHeader.getText().replaceAll("[^0-9]", ""));
			Assert.assertTrue(i.myCallHeader.getText().replaceAll("[^0-9]", "").equals(String.valueOf(f1Count)));

		} else {

			Assert.assertTrue(i.myCallHeader.getText().replaceAll("[^0-9]", "").equals("0"));

		}

	}

	/*
	 * verify that when user clicks on closed calls, closed calls header is active
	 * and title is closed calls
	 */
	@Test(priority = 3)
	public void validateClosedCallHeaderAndTitle() {
		i.closedCallHeader.click();
		Assert.assertTrue(i.closedCallHeader.getAttribute("class").contains("active"));
		Assert.assertTrue(i.allCallTitle.getText().equalsIgnoreCase("closed Calls"));
	}

	/*
	 * verify that when user clicks on watch list, watchlist header is active and
	 * title is watchlist
	 */
	@Test(priority = 4)
	public void validateWatchListHeaderAndTitle() throws InterruptedException {
		i.watchListHeader.click();
		Assert.assertTrue(i.watchListHeader.getAttribute("class").contains("active"));
		Assert.assertTrue(i.allCallTitle.getText().equalsIgnoreCase("watchlist"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (!i.watchListCalls.isEmpty()) {
			int f1Count = i.watchListCalls.size();
			while (true) {

				WebElement f = driver.findElement(By.xpath("(//app-investor-watch-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.watchListCalls.size() == f1Count) {
					break;
				}

				f1Count = i.watchListCalls.size();
			}
			System.out.println("watchList "+f1Count);
			System.out.println(i.watchListHeader.getText().replaceAll("[^0-9]", ""));
			Assert.assertTrue(i.watchListHeader.getText().replaceAll("[^0-9]", "").equals(String.valueOf(f1Count)));

		} else {

			Assert.assertTrue(i.watchListHeader.getText().replaceAll("[^0-9]", "").equals("0"));

		}
	}

	/* verify that closed call count is showing correctly on closed call header */
	@Test(priority = 5)
	public void validateTotalClosedCallCount() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		i.closedCallHeader.click();
		Thread.sleep(1000);
		if (!i.closedCalls.isEmpty()) {
			List<WebElement> f1 = driver.findElements(By.xpath("(//app-investor-closed-calls)"));
			int f1Count = f1.size();

			while (true) {

				WebElement f = driver.findElement(By.xpath("(//app-investor-closed-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				List<WebElement> f2 = driver.findElements(By.xpath("(//app-investor-closed-calls)"));
				if (f2.size() == f1Count) {
					break;
				}

				f1Count = f2.size();
			}
			System.out.println("closedcalls "+f1Count);
			System.out.println(i.closedCallHeader.getText().replaceAll("[^0-9]", ""));
			Assert.assertTrue(i.closedCallHeader.getText().replaceAll("[^0-9]", "").equals(String.valueOf(f1Count)));
			
		} else
			Assert.assertTrue(i.closedCallHeader.getText().replaceAll("[^0-9]", "").equals("0"));

	}
/*verify that all call status in the closed call section is Closed*/
	@Test(priority = 6)
	public void validateClosedCallsStatusTitle() {
		
		for (int j = 0; j < i.closedCallStatusTitle.size(); j++) {
			Assert.assertTrue(i.closedCallStatusTitle.get(j).getText().equalsIgnoreCase("Closed"));
		}
	}

	

}
