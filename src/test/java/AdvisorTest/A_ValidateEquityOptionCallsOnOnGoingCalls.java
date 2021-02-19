package AdvisorTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Advisor.A_AdvisorDashBoardPage;
import PageObject_Advisor.A_EquityFutureCallPage;
import PageObject_Advisor.A_EquityOptionCallPage;
import PageObject_Advisor.A_PickRightLandingPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;

public class A_ValidateEquityOptionCallsOnOnGoingCalls extends Base{
	A_AdvisorDashBoardPage a;
	A_EquityOptionCallPage c;
	@Test
	public void v1() throws AWTException
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
		a.equityOption.click();
		a.createCall.click();
		c = new A_EquityOptionCallPage(driver);
		c.scripNameField.sendKeys("WIPRO");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		c.EquityOptionAutoSuggesions.get(0).getText();
		c.EquityOptionAutoSuggesions.get(0).click();
		c.callTypeBuy.click();
		if(c.getWeeklyRadioButton())
		{
			c.getMonthlyRadioButton();
			
		}
		c.typeCall.click();
		
		
	}

}
