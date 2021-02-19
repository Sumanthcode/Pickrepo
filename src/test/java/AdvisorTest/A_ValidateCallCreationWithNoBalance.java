package AdvisorTest;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Advisor.A_AdvisorDashBoardPage;
import PageObject_Advisor.A_EquityCashCallPage;
import PageObject_Advisor.A_EquityFutureCallPage;
import PageObject_Advisor.A_PickRightLandingPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;

public class A_ValidateCallCreationWithNoBalance extends Base{
	A_AdvisorDashBoardPage a;
	
	String scriptName;
	//double advisorFee=50.0;
	// validate the call is not successfully created when there is insufficient
		// balance and verify the error msg is displayed
		@Test(priority = 1)
		public void validateUnSuccessfullCreationOfEquityCashCall() throws InterruptedException, AWTException {
			A_PickRightLandingPage p = new A_PickRightLandingPage(driver);
			p.getJoinAsAdvisor();
			LoginOrSignUpPage l = new LoginOrSignUpPage(driver);
			l.getDropDown();
			l.setSearchField("India");
			l.getCountry();
			l.setMobileNumberField("9611589337");
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
			A_EquityCashCallPage c = new A_EquityCashCallPage(driver);
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
//			c.setAdvisorFeeField(advisorFee);
			c.getPublishCallWhenNoWalletBalance();
		}
		
		@Test(priority=2)
		public void validateUnSuccessfullCreationOfEquityFutureCall() throws InterruptedException, AWTException
		{
			a.getEquity();
			a.getEquityFuture();
			a.getCreateCall();
			A_EquityFutureCallPage ef=new A_EquityFutureCallPage(driver);
			ef.setscripNameField("TCS");
			ef.getEquityFutureAutoSuggesions();

			double cmp = ef.getCmpValue();
			ef.getCallTypeBuy();
			ef.getRecommendedPriceRadioButton();
			ef.setRecommendedPriceField(String.valueOf(cmp+3.0));
			ef.setStopLossFieldForFutre(cmp+3.0);
			ef.setTargetField(cmp+3.0);
			
			ef.setMinRangeField(cmp+3.0);
			ef.setMaxRangeField(cmp+3.0);
			
			ef.setQuantityField("1");
			ef.getRiskRewardRatio();
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("window.scrollBy(0,2000)");
			ef.getTimeFrameIntraDay();
			ef.getRiskValueLow();
		//	c.setAdvisorFeeField(advisorFee);
			ef.getPublishCallWhenNoWalletBalance();
		}
		
		


}
