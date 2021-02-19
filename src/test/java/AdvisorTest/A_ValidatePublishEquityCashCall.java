package AdvisorTest;

import java.awt.AWTException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import Generic.Base;
import PageObject_Advisor.A_AdvisorDashBoardPage;
import PageObject_Advisor.A_EquityCashCallPage;
import PageObject_Advisor.A_PickRightLandingPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;

public class A_ValidatePublishEquityCashCall extends Base {
	A_AdvisorDashBoardPage a;
	A_EquityCashCallPage c;
	String scriptName;
	double advisorFee=50.0;
	

	/* validate the call is successfully created when there is sufficient balance
	   and call type is Sell and selected market price and verify the successful msg
	   is displayed*/
	@Test(priority=1)
	public void validateSuccessfullCreationOfEquityCashCall() throws AWTException, InterruptedException {

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
		a.getEquityCash();
		a.getCreateCall();
		c = new A_EquityCashCallPage(driver);
		c.setscripNameField("INANI");
		scriptName=c.getEquityCashAutoSuggesions();

		double cmp = c.getCmpValue();
		c.getCallTypeSell();
		c.getMarketPriceRadioButton();

		c.setMinRangeField(cmp);
		c.setMaxRangeField(cmp);
		c.setStopLossField(cmp);
		c.setTargetField(cmp);
		c.setQuantityField("1");
		c.getRiskRewardRatio();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,2000)");
		c.getRiskValueLow();
		JavascriptExecutor j1 = (JavascriptExecutor) driver;
		j1.executeScript("window.scrollBy(0,2000)");
	//	c.setAdvisorFeeField(advisorFee);
		c.getPublishCallWhenThereISSufficientBalance();

	}
	
	/* Validate Created calls are displayed in the onGoing calls page*/
	@Test(priority=2)
	public void validateCreatedActiveCallDisplayed()
	{
		a.getScriptNameInCall();
	    a.checkCreatedCallScriptName(scriptName);
	    a.checkStatusOfCallActive();
	    Assert.assertTrue(a.message.isDisplayed());
	    Assert.assertTrue(a.close.isDisplayed());
	    Assert.assertTrue(a.edit.isDisplayed());
	}
	
	@Test(priority=3)
	public void validateEditCall()
	{
		a.edit.click();
		
	}

	// validate the call is successfully created when there is sufficient balance
	// and call type is Buy and selected market price and verify the successful msg
	// is displayed
	@Test(priority = 3,enabled=false)
	public void validateSuccessfullCreationOfEquityCashCallBuyType() throws InterruptedException, AWTException {
		a.getCreateCall();
		c = new A_EquityCashCallPage(driver);
		c.setscripNameField("INANI");
		c.getEquityCashAutoSuggesions();

		double cmp = c.getCmpValue();
		c.getCallTypeBuy();

		c.getMarketPriceRadioButton();

		c.setMinRangeField(cmp);
		c.setMaxRangeField(cmp);
		c.setStopLossField(cmp);
		c.setTargetField(cmp);
		c.setQuantityField("1");
		c.getRiskRewardRatio();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,2000)");
		c.getTimeFrameIntraDay();
		c.getRiskValueLow();
	//	c.setAdvisorFeeField(advisorFee);
		c.getPublishCallWhenThereISSufficientBalance();
	}
	
	/* validate the call is successfully created when there is sufficient balance
	   and call type is buy and selected recommended price and verify the successful msg*/
	@Test(priority=4,enabled=false)
	public void validateSuccessfulCreationOfCallWithRecommendedPrice() throws  AWTException, InterruptedException
	{
		a.getCreateCall();
		c.setscripNameField("INANI");
		c.getEquityCashAutoSuggesions();

		double cmp = c.getCmpValue();
		c.getCallTypeBuy();
		c.getRecommendedPriceRadioButton();
		c.setRecommendedPriceField(String.valueOf(cmp+3.0));
		c.setMinRangeField(cmp+3.0);
		c.setMaxRangeField(cmp+3.0);
		c.setStopLossField(cmp+3.0);
		c.setTargetField(cmp+3.0);
		c.setQuantityField("1");
		c.getRiskRewardRatio();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,2000)");
		c.getTimeFrameIntraDay();
		c.getRiskValueLow();
	//	c.setAdvisorFeeField(advisorFee);
		c.getPublishCallWhenThereISSufficientBalance();

	}
	
	@Test(priority=5,enabled=false)
	public void validateCreatedAwaitingCallDisplayed()
	{
		a.getScriptNameInCall();
	    a.checkCreatedCallScriptName(scriptName);
	    a.checkStatusOfCallAwaiting();
	}
	/* validate the call is successfully created when there is sufficient balance
	   and call type is Sell and selected recommended price and verify the successful msg*/
	@Test(priority=6,enabled=false)
	public void validateSuccessfulCreationOfCallWithRecommendedPriceSellType() throws InterruptedException, AWTException
	{
		a.getCreateCall();
		c.setscripNameField("INANI");
		c.getEquityCashAutoSuggesions();

		double cmp = c.getCmpValue();
		c.getCallTypeSell();
		c.getRecommendedPriceRadioButton();
		c.setRecommendedPriceField(String.valueOf(cmp+3.0));
		c.setMinRangeField(cmp+3.0);
		c.setMaxRangeField(cmp+3.0);
		c.setStopLossField(cmp+3.0);
		c.setTargetField(cmp+3.0);
		c.setQuantityField("1");
		c.getRiskRewardRatio();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,2000)");
	//	c.getTimeFrameIntraDay();
		c.getRiskValueLow();
	//	c.setAdvisorFeeField(advisorFee);
		c.getPublishCallWhenThereISSufficientBalance();
	}

	// verify call is not created after market time and selected market price and
	// displays error msg
	@Test(priority = 7,enabled=false)
	public void validateUnsuccessfulCreationOfCallAfterMarketTime() throws InterruptedException, AWTException {
		a.getCreateCall();
		c.setscripNameField("INANI");
		c.getEquityCashAutoSuggesions();

		double cmp = c.getCmpValue();
		c.getCallTypeSell();
		c.getMarketPriceRadioButton();

		c.setMinRangeField(cmp);
		c.setMaxRangeField(cmp);
		c.setStopLossField(cmp);
		c.setTargetField(cmp);
		c.setQuantityField("1");
		c.getRiskRewardRatio();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,2000)");
		c.getRiskValueLow();
//		c.setAdvisorFeeField(advisorFee);
		c.getPublishCallWhenMarketTimeIsGotOver();
	}
	
	/*validate time frame intraday is selected default for equity cash call with call type Sell*/
	@Test(priority=8,enabled=false)
	public void validateDefaultTimeFrameforEquityCashCallIIsIntradayWhenCallTypeIsSell() throws InterruptedException, AWTException
	{
		a.getCreateCall();
		c.setscripNameField("INANI");
		c.getEquityCashAutoSuggesions();

		double cmp = c.getCmpValue();
		c.getCallTypeSell();
		c.getMarketPriceRadioButton();

		c.setMinRangeField(cmp);
		c.setMaxRangeField(cmp);
		c.setStopLossField(cmp);
		c.setTargetField(cmp);
		c.setQuantityField("1");
		c.checkIntradayTimeFrameIsSelected();
		
	}
	
	
	
	

}
