package AdvisorTest;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Advisor.A_AdvisorDashBoardPage;
import PageObject_Advisor.A_CommodityFutureCallPage;
import PageObject_Advisor.A_CreateCallPage;
import PageObject_Advisor.A_PickRightLandingPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;

public class A_ValidatePublishCommodityFutureCall extends Base{
	
	A_AdvisorDashBoardPage a;
	A_CreateCallPage c;
	A_CommodityFutureCallPage commodity;
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
		a.getCommodity();
		a.getCommodityFuture();
		a.getCreateCall();
		commodity=new A_CommodityFutureCallPage(driver);
		commodity.setScriptNameField("COPPER");
		
		scriptName=commodity.getCommodityFutureAutoSuggesions();
		double cmp = commodity.getCmpValue();
		commodity.getCallTypeBuy();
		commodity.getRecommendedPriceRadioButton();
		commodity.setRecommendedPriceField(String.valueOf(cmp+3.0));
		commodity.setStopLossFieldForFutre(cmp+3.0);
		commodity.setTargetField(cmp+3.0);
		
		commodity.setMinRangeField(cmp+3.0);
		commodity.setMaxRangeField(cmp+3.0);
		
		commodity.setQuantityField("1");
		commodity.getRiskRewardRatio();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,2000)");
		commodity.getTimeFrameIntraDay();
		commodity.getRiskValueLow();
	//	c.setAdvisorFeeField(advisorFee);
		commodity.getPublishCallWhenThereISSufficientBalance();
		
		
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
		commodity.setScriptNameField("COPPER");
		commodity=new A_CommodityFutureCallPage(driver);
		scriptName=commodity.getCommodityFutureAutoSuggesions();
		double cmp = commodity.getCmpValue();
		commodity.getCallTypeSell();
		commodity.getRecommendedPriceRadioButton();
		commodity.setRecommendedPriceField(String.valueOf(cmp+3.0));
		commodity.setStopLossFieldForFutre(cmp+3.0);
		commodity.setTargetField(cmp+3.0);
		
		commodity.setMinRangeField(cmp+3.0);
		commodity.setMaxRangeField(cmp+3.0);
		
		commodity.setQuantityField("1");
		commodity.getRiskRewardRatio();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,2000)");
		commodity.getTimeFrameIntraDay();
		commodity.getRiskValueLow();
	//	c.setAdvisorFeeField(advisorFee);
		commodity.getPublishCallWhenThereISSufficientBalance();
		
	}
	
	/*verify that call is created successfully with message when market price is given and call type is sell*/
	@Test(priority=4)
	public void validateSuccessfullCreationOfCall3() throws InterruptedException, AWTException
	{
		a.getCreateCall();
		commodity.setScriptNameField("COPPER");
		commodity=new A_CommodityFutureCallPage(driver);
		scriptName=commodity.getCommodityFutureAutoSuggesions();

		double cmp = commodity.getCmpValue();
		commodity.getCallTypeSell();
		commodity.getMarketPriceRadioButton();

		commodity.setMinRangeField(cmp);
		commodity.setMaxRangeField(cmp);
		commodity.setStopLossFieldForFutre(cmp);
		commodity.setTargetField(cmp);
		commodity.setQuantityField("1");
		commodity.getTimeFrameIntraDay();
		commodity.getRiskRewardRatio();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,2000)");
		commodity.getRiskValueLow();
		JavascriptExecutor j1 = (JavascriptExecutor) driver;
		j1.executeScript("window.scrollBy(0,2000)");
	//	c.setAdvisorFeeField(advisorFee);
		commodity.getPublishCallWhenThereISSufficientBalance();
	}
	/*verify that call is created successfully with message when market price is given and call type is buy*/
	@Test(priority=5)
	public void validateSuccessfullCreationOfCall4() throws InterruptedException, AWTException
	{
		a.getCreateCall();
		commodity.setScriptNameField("COPPER");
		commodity=new A_CommodityFutureCallPage(driver);
		scriptName=commodity.getCommodityFutureAutoSuggesions();

		double cmp = commodity.getCmpValue();
		commodity.getCallTypeBuy();
		commodity.getMarketPriceRadioButton();

		commodity.setMinRangeField(cmp);
		commodity.setMaxRangeField(cmp);
		commodity.setStopLossFieldForFutre(cmp);
		commodity.setTargetField(cmp);
		commodity.setQuantityField("1");
		commodity.getTimeFrameIntraDay();
		commodity.getRiskRewardRatio();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,2000)");
		commodity.getRiskValueLow();
		JavascriptExecutor j1 = (JavascriptExecutor) driver;
		j1.executeScript("window.scrollBy(0,2000)");
	//	c.setAdvisorFeeField(advisorFee);
		commodity.getPublishCallWhenThereISSufficientBalance();
	}
	

}
