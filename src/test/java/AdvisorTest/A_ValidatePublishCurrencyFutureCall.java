package AdvisorTest;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Advisor.A_AdvisorDashBoardPage;
import PageObject_Advisor.A_CreateCallPage;
import PageObject_Advisor.A_CurrencyFutureCallPage;
import PageObject_Advisor.A_PickRightLandingPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;

public class A_ValidatePublishCurrencyFutureCall extends Base{
	A_AdvisorDashBoardPage a;
	A_CreateCallPage c;
	A_CurrencyFutureCallPage currency;
	String scriptName;
	/* verify that call is created successfully with message when recommended price is given and call type is buy
	 */
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
		a.getCurrency();
		a.getCurrencyFuture();
		a.getCreateCall();
		currency=new A_CurrencyFutureCallPage(driver);
		currency.setScriptNameField("USD");
		
		scriptName=currency.getCurrencyFutureAutoSuggesions();
		double cmp = currency.getCmpValue();
		currency.getCallTypeBuy();
		currency.getRecommendedPriceRadioButton();
		currency.setRecommendedPriceField(String.valueOf(cmp+3.0));
		currency.setStopLossFieldForFutre(cmp+3.0);
		currency.setTargetField(cmp+3.0);
		
		currency.setMinRangeField(cmp+3.0);
		currency.setMaxRangeField(cmp+3.0);
		
		currency.setQuantityField("1");
		currency.getRiskRewardRatio();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,2000)");
		currency.getTimeFrameIntraDay();
		currency.getRiskValueLow();
	//	c.setAdvisorFeeField(advisorFee);
		currency.getPublishCallWhenThereISSufficientBalance();
		
		
	}
	/* verify that created call is poplated in advisor dashboard verifying the name of the script and call is awaiting*/
	@Test(priority=2)
	public void validateCreatedAwaitingCallDisplayed()
	{
		a.getScriptNameInCall();// it will get the script name in advisor dashboard
	    a.checkCreatedCallScriptName(scriptName);
	    a.checkStatusOfCallAwaiting();
	}
	/* verify that call is created successfully with message when recommended price is given and call type is sell
	 */
	@Test(priority=3)
	public void validateSuccessfullCreationOfCall2() throws InterruptedException, AWTException 
	{
		a.getCreateCall();
		currency.setScriptNameField("USD");
		currency=new A_CurrencyFutureCallPage(driver);
		scriptName=currency.getCurrencyFutureAutoSuggesions();
		double cmp = currency.getCmpValue();
		currency.getCallTypeSell();
		currency.getRecommendedPriceRadioButton();
		currency.setRecommendedPriceField(String.valueOf(cmp+3.0));
		currency.setStopLossFieldForFutre(cmp+3.0);
		currency.setTargetField(cmp+3.0);
		
		currency.setMinRangeField(cmp+3.0);
		currency.setMaxRangeField(cmp+3.0);
		
		currency.setQuantityField("1");
		currency.getRiskRewardRatio();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,2000)");
		currency.getTimeFrameIntraDay();
		currency.getRiskValueLow();
	//	c.setAdvisorFeeField(advisorFee);
		currency.getPublishCallWhenThereISSufficientBalance();
		
	}
	
	/*verify that call is created successfully with message when market price is given and call type is sell*/
	@Test(priority=4)
	public void validateSuccessfullCreationOfCall3() throws InterruptedException, AWTException
	{
		a.getCreateCall();
		
		currency.setScriptNameField("USD");
		currency=new A_CurrencyFutureCallPage(driver);
		scriptName=currency.getCurrencyFutureAutoSuggesions();

		double cmp = currency.getCmpValue();
		currency.getCallTypeSell();
		currency.getMarketPriceRadioButton();

		currency.setMinRangeField(cmp);
		currency.setMaxRangeField(cmp);
		currency.setStopLossFieldForFutre(cmp);
		currency.setTargetField(cmp);
		currency.setQuantityField("1");
		currency.getTimeFrameIntraDay();
		currency.getRiskRewardRatio();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,2000)");
		currency.getRiskValueLow();
		JavascriptExecutor j1 = (JavascriptExecutor) driver;
		j1.executeScript("window.scrollBy(0,2000)");
	//	c.setAdvisorFeeField(advisorFee);
		currency.getPublishCallWhenThereISSufficientBalance();
	}
	/*verify that call is created successfully with message when market price is given and call type is buy*/
	@Test(priority=5)
	public void validateSuccessfullCreationOfCall4() throws InterruptedException, AWTException
	{
		a.getCreateCall();
		
		currency.setScriptNameField("USD");
		currency=new A_CurrencyFutureCallPage(driver);
		scriptName=currency.getCurrencyFutureAutoSuggesions();

		double cmp = currency.getCmpValue();
		currency.getCallTypeBuy();
		currency.getMarketPriceRadioButton();

		currency.setMinRangeField(cmp);
		currency.setMaxRangeField(cmp);
		currency.setStopLossFieldForFutre(cmp);
		currency.setTargetField(cmp);
		currency.setQuantityField("1");
		currency.getTimeFrameIntraDay();
		currency.getRiskRewardRatio();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,2000)");
		currency.getRiskValueLow();
		JavascriptExecutor j1 = (JavascriptExecutor) driver;
		j1.executeScript("window.scrollBy(0,2000)");
	//	c.setAdvisorFeeField(advisorFee);
		currency.getPublishCallWhenThereISSufficientBalance();
	}
	
	

}
