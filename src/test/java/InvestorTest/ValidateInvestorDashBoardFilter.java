package InvestorTest;

import java.util.List;
import java.util.stream.Collectors;

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

public class ValidateInvestorDashBoardFilter extends Base{
	InvestorDashBoardPage i;
	@Test(priority=1)
	public void validateCallsInBuyRangeFilter() throws InterruptedException
	{
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
	//	driver.findElement(By.xpath("//button[contains(@class,'minimize')]")).click();
		CategorySelectionPage c = new CategorySelectionPage(driver);
		c.getEquityCash();
		i = new InvestorDashBoardPage(driver);
		Assert.assertTrue(i.callsInBuyRangeFilter.getAttribute("class").contains("active"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(!(i.newCalls.isEmpty()))
		{
			int f1Count = i.newCalls.size();
			while(true)
			{
				WebElement f = driver.findElement(By.xpath("(//app-investor-new-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.newCalls.size() == f1Count) {
					break;
				}
				f1Count = i.newCalls.size();
			}
			Assert.assertTrue(i.callsInBuyRangeFilterTitle.getText().replaceAll("[^0-9]","").equals(String.valueOf(f1Count)));
			List<String> efilteredList = i.callsInBuyRangeTitleOnCall.stream().map(s->s.getText()).filter(s->s.equalsIgnoreCase("Calls in Buy Range")).collect(Collectors.toList());
			List<String> aFilteredList = i.callsInBuyRangeTitleOnCall.stream().map(s->s.getText()).collect(Collectors.toList());
			Assert.assertEquals(aFilteredList,efilteredList);
			
		}
		else {
			Assert.assertTrue(i.callsInBuyRangeFilterTitle.getText().replaceAll("[^0-9]", "").equals("0"));
			Assert.assertTrue(i.callsInBuyRangeTitleOnCall.isEmpty());
		}
		
	
		
	}
	
	@Test(priority=2)
	public void validateSTBBTSTcallsFilter() throws InterruptedException
	{
		i.callsInBuyRangeFilterClose.click();
		i.STBTBTSTCallsFilter.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(!(i.newCalls.isEmpty()))
		{
			int f1Count = i.newCalls.size();
			while(true)
			{
				WebElement f = driver.findElement(By.xpath("(//app-investor-new-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.newCalls.size() == f1Count) {
					break;
				}
				f1Count = i.newCalls.size();
			}
			Assert.assertTrue(i.STBTBTSTFilterTitle.getText().replaceAll("[^0-9]","").equals(String.valueOf(f1Count)));
			List<String> efilteredList = i.timeFrameOnCalls.stream().map(s->s.getText()).filter(s->s.equalsIgnoreCase("Overnight Positional")).collect(Collectors.toList());
			List<String> aFilteredList = i.overNightPositionalTimeFrameOnCall.stream().map(s->s.getText()).collect(Collectors.toList());
			Assert.assertEquals(aFilteredList,efilteredList);
		
		}
		else {
			Assert.assertTrue(i.STBTBTSTFilterTitle.getText().replaceAll("[^0-9]","").equals("0"));
			Assert.assertTrue(i.overNightPositionalTimeFrameOnCall.isEmpty());
		}
	}
	
	@Test(priority=3)
	public void validateIntraDayCallsFilter() throws InterruptedException
	{
		i.STBTBTSTFilterClose.click();
		i.IntradayCallsFilter.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(!(i.newCalls.isEmpty()))
		{
			int f1Count = i.newCalls.size();
			while(true)
			{
				WebElement f = driver.findElement(By.xpath("(//app-investor-new-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.newCalls.size() == f1Count) {
					break;
				}
				f1Count = i.newCalls.size();
			}
			Assert.assertTrue(i.IntradayCallsFilter.getText().replaceAll("[^0-9]","").equals(String.valueOf(f1Count)));
			List<String> efilteredList = i.timeFrameOnCalls.stream().map(s->s.getText()).filter(s->s.equalsIgnoreCase("Intraday")).collect(Collectors.toList());
			List<String> aFilteredList = i.intraDayTimeFrametitlesOnCalls.stream().map(s->s.getText()).collect(Collectors.toList());
			Assert.assertEquals(aFilteredList,efilteredList);
		}
		else {
			Assert.assertTrue(i.IntradayCallsFilter.getText().replaceAll("[^0-9]","").equals("0"));
			Assert.assertTrue(i.intraDayTimeFrametitlesOnCalls.isEmpty());
		}
	}

	@Test(priority=4)
	public void validateMyAdvisorFilter() throws InterruptedException
	{
		i.IntradayCallsFilterClose.click();
		i.MyAdvisorCallsFilter.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(!(i.newCalls.isEmpty()))
		{
			int f1Count = i.newCalls.size();
			while(true)
			{
				WebElement f = driver.findElement(By.xpath("(//app-investor-new-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.newCalls.size() == f1Count) {
					break;
				}
				f1Count = i.newCalls.size();
			}
			
			List<String> efilteredList = i.followHeartIcon.stream().map(s->s.getAttribute("src")).filter(s->s.contains("red")).collect(Collectors.toList());
			List<String> aFilteredList = i.followHeartIcon.stream().map(s->s.getAttribute("src")).collect(Collectors.toList());
			Assert.assertEquals(aFilteredList, efilteredList);
		}
		else {
			Assert.assertTrue(i.followHeartIcon.isEmpty());
		}
	}
	

}
