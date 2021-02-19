package AdvisorTest;



import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Advisor.A_AdvisorDashBoardPage;
import PageObject_Advisor.A_EquityCashCallPage;
import PageObject_Advisor.A_PickRightLandingPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;

public class A_ValidateAdvisorDashBoard extends Base{
	A_AdvisorDashBoardPage a;
	A_EquityCashCallPage c;
	/* verify that when user clicks on start giving advice, advisor dashboard page should display with equity cash tab is active*/
	@Test(priority=1)
	public void validateEquityCashIsActive()
	{
		A_PickRightLandingPage p = new A_PickRightLandingPage(driver);
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
		a = new A_AdvisorDashBoardPage(driver);
		a.checkEquityCashHeaderIsActive();
		a.getEquityCashHeadingTitle();
	}
	
	@Test(priority=2)
	public void validateEquityCashCallTitle()
	{
		a.getEquityCashCallTitle();
	}
	
	@Test(priority=3)
	public void validateOnGoingCallsIsActive()
	{
		a.checkOnGoingCallsTabIsActive();
	}
	
	@Test(priority=4)
	public void validateCreateEquityCAshCallTitle()
	{
		a.getCreateCall();
		a.getCreateEquityCashCallTitle();
		c=new A_EquityCashCallPage(driver);
		c.getCloseCallButton();
	}
	
	@Test(priority=5)
	public void v()
	{
		a.getEquity();
		a.getEquityFuture();
		a.getEquityFutureHeadingAfterSelection();
		a.getEquityFutureCallTitle();
	}
	
	@Test(priority=6)
	public void v1()
	{
		a.getCreateCall();
		a.getCreateFutureCashCallTitle();
		c.getCloseCallButton();
		
	}
	
	@Test(priority=7)
	public void v2()
	{
		a.getEquity();
		a.getEquityOption();
		a.getEquityOptionHeadingAfterSelection();
		a.getEquityOptionCallTitle();
	}
	
	@Test(priority=8)
	public void v3()
	{
		a.getCreateCall();
		a.getCreateOptionCashCallTitle();
		c.getCloseCallButton();
	}
	
	@Test(priority=9)
	public void v4()
	{
		a.getCurrency();
		a.getCurrencyFuture();
		a.getCurrencyFutureHeadingAfterSelection();
		a.getCurrencyFutureCallTitle();
	}
	
	@Test(priority=10)
	public void validate()
	{
		a.getCreateCall();
		a.getCreateCurrencyFutureCallTitle();
		c.getCloseCallButton();
	}
	
	
	@Test(priority=11)
	public void v5()
	{
		a.getCurrency();
		a.getCurrencyOption();
		a.getCurrencyOptionHeadingAfterSelection();
		a.getCurrencyOptionCallTitle();
	}
	
	@Test(priority=12)
	public void v6()
	{
		a.getCreateCall();
		a.getCreateCurrencyOptionCallTitle();
		c.getCloseCallButton();
		
	}
	
	@Test(priority=13)
	public void v7()
	{
		a.getCommodity();
		a.getCommodityFuture();
		a.getCommodityFutureHeadingAfterSelection();
		a.getCommodityFutureCallTitle();
		
	}
	
	@Test(priority=14)
	public void v8()
	{
		a.getCreateCall();
		a.getCreateCommodityFutureCallTitle();
		c.getCloseCallButton();
	}
	
	@Test(priority=15)
	public void v9()
	{
		a.getCommodity();
		a.getCommodityOption();
		a.getCommodityOptionHeadingAfterSelection();
		a.getCommodityOptionCallTitle();
	}
	
	@Test(priority=16)
	public void v10()
	{
		a.getCreateCall();
		a.getCreateCommodityOptionCallTitle();
		c.getCloseCallButton();
	}
	
	@Test(priority=17)
	public void v11()
	{
		a.getStrategy();
		a.getStrategyHeadingAfterSelection();
		a.getStrategyCallTitle();
		
	}
	
	@Test(priority=18)
	public void v12()
	{
		a.getCreateCall();
		a.getCreateStrategyCallTitle();
		c.getCloseCallButton();
	}
	
	
	
	
	
	
	
	

}
