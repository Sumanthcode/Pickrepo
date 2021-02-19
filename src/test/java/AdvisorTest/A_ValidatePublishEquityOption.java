package AdvisorTest;

import java.awt.AWTException;
import org.testng.annotations.Test;
import Generic.Base;
import PageObject_Advisor.A_AdvisorDashBoardPage;
import PageObject_Advisor.A_EquityOptionCallPage;
import PageObject_Advisor.A_PickRightLandingPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;

public class A_ValidatePublishEquityOption extends Base {
	A_AdvisorDashBoardPage a;
	A_EquityOptionCallPage c;
	String scriptName;
	@Test(priority=1)
	public void validateSuccessfullCreationOfCall1() throws InterruptedException, AWTException
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
		a.getEquity();
		a.getEquityOption();
		a.getCreateCall();
		c = new A_EquityOptionCallPage(driver);
		c.setscripNameField("WIPRO");
		scriptName=c.getEquityOptionAutoSuggesions();
		c.getCallTypeBuy();
		if(c.getWeeklyRadioButton())
		{
			c.getMonthlyRadioButton();
			
		}
		c.getTypeCall();
		c.setStringPrice();
		Thread.sleep(2000);
		double cmp=c.getCmpValue();
		c.getRecommendedPriceRadioButton();
		c.setRecommendedPriceField(cmp+2.0);
		c.setStopLossFieldForOption(cmp+2.0);
		c.setTargetField(cmp+2.0);
		c.setMinRangeField(cmp+2.0);
		c.setMaxRangeField(cmp+2.0);
		c.getTimeFrameIntraDay();
		c.getRiskValueLow();
		c.getPublishCallWhenThereISSufficientBalance();

	}
	
	@Test(priority=2)
	public void validateCreatedAwaitingCallDisplayed()
	{
		a.getScriptNameInCall();// it will get the script name in advisor dashboard
	    a.checkCreatedCallScriptName(scriptName);
	    a.checkStatusOfCallAwaiting();
	}
	
	@Test(priority=3)
	public void validateSuccessfullCreationOfCall2() throws InterruptedException, AWTException
	{
		a.getCreateCall();
		c.setscripNameField("WIPRO");
		scriptName=c.getEquityOptionAutoSuggesions();
		c.getCallTypeBuy();
		if(c.getWeeklyRadioButton())
		{
			c.getMonthlyRadioButton();
			
		}
		c.getTypeCall();
		c.setStringPrice();
		Thread.sleep(2000);
		double cmp=c.getCmpValue();
		c.getMarketPriceRadioButton();
		c.setStopLossFieldForOption(cmp);
		c.setTargetField(cmp);
		c.setMinRangeField(cmp);
		c.setMaxRangeField(cmp);
		c.getTimeFrameIntraDay();
		c.getRiskValueLow();
		c.getPublishCallWhenThereISSufficientBalance();
		
	}
	
	@Test(priority=4)
	public void validateSuccessfullCreationOfCall3() throws InterruptedException, AWTException
	{
		a.getCreateCall();
		c.setscripNameField("WIPRO");
		scriptName=c.getEquityOptionAutoSuggesions();
		c.getCallTypeBuy();
		if(c.getWeeklyRadioButton())
		{
			c.getMonthlyRadioButton();
			
		}
		c.getTypePut();
		c.setStringPrice();
		Thread.sleep(2000);
		double cmp=c.getCmpValue();
		c.getRecommendedPriceRadioButton();
		c.setRecommendedPriceField(cmp+2.0);
		c.setStopLossFieldForOption(cmp+2.0);
		c.setTargetField(cmp+2.0);
		c.setMinRangeField(cmp+2.0);
		c.setMaxRangeField(cmp+2.0);
		c.getTimeFrameIntraDay();
		c.getRiskValueLow();
		c.getPublishCallWhenThereISSufficientBalance();
	}
	
	@Test(priority=5)
	public void validateSuccessfullCreationOfCall4() throws InterruptedException, AWTException
	{
		a.getCreateCall();
		c.setscripNameField("WIPRO");
		scriptName=c.getEquityOptionAutoSuggesions();
		c.getCallTypeBuy();
		if(c.getWeeklyRadioButton())
		{
			c.getMonthlyRadioButton();
			
		}
		c.getTypePut();
		c.setStringPrice();
		Thread.sleep(2000);
		double cmp=c.getCmpValue();
		c.getMarketPriceRadioButton();
		c.setStopLossFieldForOption(cmp);
		c.setTargetField(cmp);
		c.setMinRangeField(cmp);
		c.setMaxRangeField(cmp);
		c.getTimeFrameIntraDay();
		c.getRiskValueLow();
		c.getPublishCallWhenThereISSufficientBalance();
	}
	
	@Test(priority=6)
	public void validateSuccessfullCreationOfCall5() throws InterruptedException, AWTException
	{
		a.getCreateCall();
		c = new A_EquityOptionCallPage(driver);
		c.setscripNameField("WIPRO");
		scriptName=c.getEquityOptionAutoSuggesions();
		c.getCallTypeSell();
		if(c.getWeeklyRadioButton())
		{
			c.getMonthlyRadioButton();
			
		}
		c.getTypeCall();
		c.setStringPrice();
		Thread.sleep(2000);
		double cmp=c.getCmpValue();
		c.getRecommendedPriceRadioButton();
		c.setRecommendedPriceField(cmp+2.0);
		c.setStopLossFieldForOption(cmp+2.0);
		c.setTargetField(cmp+2.0);
		c.setMinRangeField(cmp+2.0);
		c.setMaxRangeField(cmp+2.0);
		c.getTimeFrameIntraDay();
		c.getRiskValueLow();
		c.getPublishCallWhenThereISSufficientBalance();

	}
	
	@Test(priority=7)
	public void validateSuccessfullCreationOfCall6() throws InterruptedException, AWTException
	{
		a.getCreateCall();
		c.setscripNameField("WIPRO");
		scriptName=c.getEquityOptionAutoSuggesions();
		c.getCallTypeSell();
		if(c.getWeeklyRadioButton())
		{
			c.getMonthlyRadioButton();
			
		}
		c.getTypeCall();
		c.setStringPrice();
		Thread.sleep(2000);
		double cmp=c.getCmpValue();
		c.getMarketPriceRadioButton();
		c.setStopLossFieldForOption(cmp);
		c.setTargetField(cmp);
		c.setMinRangeField(cmp);
		c.setMaxRangeField(cmp);
		c.getTimeFrameIntraDay();
		c.getRiskValueLow();
		c.getPublishCallWhenThereISSufficientBalance();
		
	}
	
	@Test(priority=8)
	public void validateSuccessfullCreationOfCall7() throws InterruptedException, AWTException
	{
		a.getCreateCall();
		c.setscripNameField("WIPRO");
		scriptName=c.getEquityOptionAutoSuggesions();
		c.getCallTypeSell();
		if(c.getWeeklyRadioButton())
		{
			c.getMonthlyRadioButton();
			
		}
		c.getTypePut();
		c.setStringPrice();
		Thread.sleep(2000);
		double cmp=c.getCmpValue();
		c.getRecommendedPriceRadioButton();
		c.setRecommendedPriceField(cmp+2.0);
		c.setStopLossFieldForOption(cmp+2.0);
		c.setTargetField(cmp+2.0);
		c.setMinRangeField(cmp+2.0);
		c.setMaxRangeField(cmp+2.0);
		c.getTimeFrameIntraDay();
		c.getRiskValueLow();
		c.getPublishCallWhenThereISSufficientBalance();
	}
	
	@Test(priority=9)
	public void validateSuccessfullCreationOfCall8() throws InterruptedException, AWTException
	{
		a.getCreateCall();
		c.setscripNameField("WIPRO");
		scriptName=c.getEquityOptionAutoSuggesions();
		c.getCallTypeSell();
		if(c.getWeeklyRadioButton())
		{
			c.getMonthlyRadioButton();
			
		}
		c.getTypePut();
		c.setStringPrice();
		Thread.sleep(2000);
		double cmp=c.getCmpValue();
		c.getMarketPriceRadioButton();
		c.setStopLossFieldForOption(cmp);
		c.setTargetField(cmp);
		c.setMinRangeField(cmp);
		c.setMaxRangeField(cmp);
		c.getTimeFrameIntraDay();
		c.getRiskValueLow();
		c.getPublishCallWhenThereISSufficientBalance();
	}
	
}
