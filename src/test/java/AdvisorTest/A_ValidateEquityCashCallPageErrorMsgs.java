package AdvisorTest;

import java.awt.AWTException;

import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Advisor.A_AdvisorDashBoardPage;
import PageObject_Advisor.A_EquityCashCallPage;
import PageObject_Advisor.A_PickRightLandingPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;




public class A_ValidateEquityCashCallPageErrorMsgs extends Base{
	A_AdvisorDashBoardPage a;
	A_EquityCashCallPage c;
	/* validate that Create Equity Cash Call title is displayed when we select equity cash call*/
	@Test(priority=1)
	public void validateCreateEquityCashCallTitle()
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
		a.getEquityCash();
		a.getCreateCall();
		c=new A_EquityCashCallPage(driver);
		c.getCreateEquityCashCallTitle();
	}
	/*verify that error msg is displayed when we dont give scrip name*/
	@Test(priority=2)
	public void validateScripNameIsRequiredErrorMsg()
	{
		c.getScripNameIsRequiredErrorMsgTitle();
	}
	
	/*verify Buy is selected when we click on it*/
	@Test(priority=3)
	public void validateBuyIsSelectedOrNot()
	{
		c.checkBuyIsSelectedOrNot();
	}
	
	/*verify that error msg is displayed when we dont give recommanded price*/
	@Test(priority=4)
	public void validatePriceIsRequireErrorMsgInRecommandedPriceField() throws InterruptedException, AWTException
	{
		c.setscripNameField("INANI");
		c.getEquityCashAutoSuggesions();
		c.getCallTypeSell();
		c.getRecommendedPriceRadioButton();
		c.setRecommendedPriceField("");
		c.getCallTypeBuy();
		c.getPriceIsRequiredErrorMsgWhenWeLeftRecommendedPriceBlank();
	}
	
	/*verify that error msg is displayed when we enter stop loss more than entry price when Call type buy is selected*/
	@Test(priority=6)
	public void validateStopLossMustbeSmallerThanCMPErrorMsgInStopLossField() throws InterruptedException, AWTException 
	{
		
		double cmp=c.getCmpValue();
		c.getStopLossMustbeSmallerThanCMPErrorMsgBuyType(cmp+1);
	}
	
	/*verify that error msg is displayed when we dont give stop loss price when Call type buy is selected*/
	@Test(priority=5)
	public void validateStopLossIsRequiredErrorMsg() throws InterruptedException
	{
		c.getMarketPriceRadioButton();
		double cmp=c.getCmpValue();
		c.getStopLossIsRequiredErrorMsg("",cmp+3);
		
	}
	
	/*verify that error msg is displayed when we dont give target price when Call type buy is selected*/
	@Test(priority=7)
	public void validateTargetIsRequiredErrorMsg() throws InterruptedException 
	{
		double cmp=c.getCmpValue();
		c.getTargetIsRequiredErrorMsgBuyType(cmp-3.0);
	}
	
	/*verify that when user enter the target <= price, error msg is displayed when call type buy is selected*/
	@Test(priority=8)
	public void validateTargetMustBeGreaterThanPriceErroMsg() throws InterruptedException
	{
		double cmp=c.getCmpValue();
		c.getTargetMustBeGreaterThanPriceErroMsgBuyType(cmp);
		
	}
	
	/*validate error msg is displayed when we left the min range blank and when Market price is selected*/
	@Test(priority=9)
	public void validateMinEntryRangeRequiredErrorMsgInMinRangeField() throws InterruptedException
	{
		double cmp=c.getCmpValue();
		c.getMinEntryRangeIsRequiredErrorMsgWhenMinRangeFieldBlank(cmp+3.0,"","");
		
	}
	
	@Test(priority=10)
	public void validateMaxEntryRangeRequiredErrorMsgInMaxRangeField() throws InterruptedException
	{
		double cmp=c.getCmpValue();
		c.getMaxEntryRangeIsRequiredErrorMsgWhenMaxRangeFieldBlank((cmp - ((cmp+3.0-cmp)/4))+0.5);
	}
	
	
	
	/*verify that error msg is displayed when we enter the min range more more than market price when marketprice is selected and call type is buy*/
	@Test(priority=12)
	public void validateMinRangeCannotBeGreaterThanMarketPriceErrorMsg() throws InterruptedException
	{
		double cmp=c.getCmpValue();
		c.getMinRangeCannotBeGreaterThanMarketPriceErrorMsg((cmp + ((cmp+3.0-cmp)/4))-0.5,cmp+2.0);
		
	}
	
	/*verify that error msg is displayed when we enter the max range less than market price when marketrice is selected and call type is buy*/
	@Test(priority=11)
	public void validateMaxRangeCannotBeLesserThanMarketPriceErrorMsg() throws InterruptedException
	{
		
		double cmp=c.getCmpValue();
		c.getMaxRangeMaxRangeCannotBeLesserThanMarketPriceErrorMs(cmp-2.0);
		
	}
	
	/*verify that error msg is displayed when we enter stop loss greater than min range when call type buy is selected*/
	@Test(priority=13)
	public void validateStopLossMustBeLessThanMinEntryRangeErrorMsg() throws InterruptedException
	{
		double cmp=c.getCmpValue();
		double minRange=cmp - ((cmp+3.0-cmp)/4)+0.5;
		c.getStopLossMustBeLessThanMinEntryRangeErrorMsg(minRange,minRange+0.1);
	}
	
	/*verify that error msg is displayed when we enter target lesser than max range when call type buy is selected*/
	@Test(priority=14)
	public void validateTargetMustBeGreaterThanMaxEntryRangeErrorMsg() throws InterruptedException
	{
		double cmp=c.getCmpValue();
		double target=(cmp + ((cmp+3.0-cmp)/4)-0.6);
		c.getTargetMustBeGreaterThanMaxEntryRangeErrorMsg(cmp-3.0,target,(cmp-((target-cmp)/4)), (cmp+((target-cmp)/4)));
	}
	
	/*verify that error msg is displayed when risk reward ratio is less than 1 and click on publish when call type buy is selected*/
	@Test(priority=15)
	public void validateCallRiskRatioNeedsToBeMoreThanOneErrorMsg() 
	{
		c.getRiskValueLow();
		c.getPublishCall();
		c.getCallRiskRatioNeedsToBeMoreThanOneErrorMsg();
	}
	
	


}
