package InvestorTest;

import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.CategorySelectionPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.InvestorDashBoardClosedCallPage;
import PageObject_Investor.InvestorDashBoardPage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.PickRightHomePage;

public class ValidateInvestorDashBoardClosedCallPage extends Base{
	
	@Test
	public void validateAllClosedCallStatusTitle()
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
		CategorySelectionPage c=new CategorySelectionPage(driver);
		c.getEquityCash();
		InvestorDashBoardPage i=new InvestorDashBoardPage(driver);
		i.getClosedCall();
		InvestorDashBoardClosedCallPage i1=new InvestorDashBoardClosedCallPage(driver);
		i1.getAllClosedCallTitle();
	}

}
