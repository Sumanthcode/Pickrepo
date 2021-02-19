package AdvisorTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Advisor.A_AdvisorDashBoardPage;
import PageObject_Advisor.A_EquityFutureCallPage;
import PageObject_Advisor.A_PickRightLandingPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;

public class A_ValidatePublishEquityFutureCall extends Base {
	A_AdvisorDashBoardPage a;
	A_EquityFutureCallPage c;
	String scriptName;
	/* verify that when user select the equity future, equity future page should display with title equity future call*/
	@Test(priority=1)
	public void validateEquityFutureTitle()
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
		a.getEquityFuture();
		a.getEquityFutureCallTitle();
	}
	/* verify that when clicked on create call, create call page isdisplayed with title create future cash call*/
	@Test(priority=2)
	public void validateCreateFutureCashCallTitle()
	{
		a.getCreateCall();
		a.getCreateFutureCashCallTitle();
	}
	/* verify that call is created successfully with message when recommended price is given and call type is buy
	 */
	String lowRiskText;
	double sl;
	@Test(priority=3)
	public void validateSuccessfullCreationOfCall1() throws InterruptedException, AWTException
	{
		
		c = new A_EquityFutureCallPage(driver);
		c.setscripNameField("TCS");
		scriptName=c.getEquityFutureAutoSuggesions();

		double cmp = c.getCmpValue();
		c.getCallTypeBuy();
		c.getRecommendedPriceRadioButton();
		c.setRecommendedPriceField(String.valueOf(cmp+3.0));
		sl=c.setStopLossFieldForFutre(cmp+3.0);
		c.setTargetField(cmp+3.0);
		
		c.setMinRangeField(cmp+3.0);
		c.setMaxRangeField(cmp+3.0);
		
		c.setQuantityField("1");
		c.getRiskRewardRatio();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,2000)");
		c.getTimeFrameIntraDay();
		lowRiskText=c.getRiskValueLow();
		System.out.println(lowRiskText);
	//	c.setAdvisorFeeField(advisorFee);
		c.getPublishCallWhenThereISSufficientBalance();
	}
	/* verify that created call is poplated in advisor dashboard verifying the name of the script and call is awaiting*/
	@Test(priority=4)
	public void validateCreatedAwaitingCallDisplayed()
	{
		a.getScriptNameInCall();// it will get the script name in advisor dashboard
	    a.checkCreatedCallScriptName(scriptName);
	    a.checkStatusOfCallAwaiting();
	    System.out.println(a.RiskTextOnTheCall.getText());
	    Assert.assertTrue(a.RiskTextOnTheCall.getText().equalsIgnoreCase(lowRiskText));
	    Assert.assertTrue(a.message.isDisplayed());
	    Assert.assertTrue(a.close.isDisplayed());
	    Assert.assertTrue(a.edit.isDisplayed());
	}
	
	@Test(priority=5)
	public void validateEditCall() throws AWTException, InterruptedException
	{
		a.edit.click();
		c.stopLossField.click();
		Thread.sleep(2000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		if(c.callTypeBuy.isSelected())
		{
			c.stopLossField.sendKeys(String.valueOf(sl-0.5));
			Assert.assertTrue(c.equityMarketingTimeErrorMsg.getText().equalsIgnoreCase("Price cannot be lesser than previous value"));
		}
		
		
		
	}
	/* verify that call is created successfully with message when recommended price is given and call type is sell
	 */
	@Test(priority=5,enabled=false)
	public void validateSuccessfullCreationOfCall2() throws InterruptedException, AWTException
	{
		a.getCreateCall();
		c.setscripNameField("TCS");
		scriptName=c.getEquityFutureAutoSuggesions();
		double cmp = c.getCmpValue();
		c.getCallTypeSell();
		c.getRecommendedPriceRadioButton();
		c.setRecommendedPriceField(String.valueOf(cmp+3.0));
		c.setStopLossFieldForFutre(cmp+3.0);
		c.setTargetField(cmp+3.0);
		
		c.setMinRangeField(cmp+3.0);
		c.setMaxRangeField(cmp+3.0);
		
		c.setQuantityField("1");
		c.getRiskRewardRatio();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,2000)");
		c.getTimeFrameIntraDay();
		c.getRiskValueLow();
	//	c.setAdvisorFeeField(advisorFee);
		c.getPublishCallWhenThereISSufficientBalance();
		
	}
	/*verify that call is created successfully with message when market price is given and call type is sell*/
	@Test(priority=6,enabled=false)
	public void validateSuccessfullCreationOfCall3() throws InterruptedException, AWTException
	{
		a.getCreateCall();
		c.setscripNameField("tcs");
		scriptName=c.getEquityFutureAutoSuggesions();

		double cmp = c.getCmpValue();
		c.getCallTypeSell();
		c.getMarketPriceRadioButton();

		c.setMinRangeField(cmp);
		c.setMaxRangeField(cmp);
		c.setStopLossFieldForFutre(cmp);
		c.setTargetField(cmp);
		c.setQuantityField("1");
		c.getTimeFrameIntraDay();
		c.getRiskRewardRatio();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,2000)");
		c.getRiskValueLow();
		JavascriptExecutor j1 = (JavascriptExecutor) driver;
		j1.executeScript("window.scrollBy(0,2000)");
	//	c.setAdvisorFeeField(advisorFee);
		c.getPublishCallWhenThereISSufficientBalance();
	}
	/*verify that call is created successfully with message when market price is given and call type is buy*/
	@Test(priority=7,enabled=false)
	public void validateSuccessfullCreationOfCall4() throws InterruptedException, AWTException
	{
		a.getCreateCall();
		c.setscripNameField("tcs");
		scriptName=c.getEquityFutureAutoSuggesions();

		double cmp = c.getCmpValue();
		c.getCallTypeBuy();
		c.getMarketPriceRadioButton();

		c.setMinRangeField(cmp);
		c.setMaxRangeField(cmp);
		c.setStopLossFieldForFutre(cmp);
		c.setTargetField(cmp);
		c.setQuantityField("1");
		c.getTimeFrameIntraDay();
		c.getRiskRewardRatio();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,2000)");
		c.getRiskValueLow();
		JavascriptExecutor j1 = (JavascriptExecutor) driver;
		j1.executeScript("window.scrollBy(0,2000)");
	//	c.setAdvisorFeeField(advisorFee);
		c.getPublishCallWhenThereISSufficientBalance();
	}
	
	
	
	
	
	
	

}
