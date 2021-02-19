package InvestorTest;

import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.OnBoardPage1;
import PageObject_Investor.OnBoardPage2;
import PageObject_Investor.PickRightHomePage;

public class ValidateSelectFromBelowDematAccountsPage extends Base {
	EnterOtpPage e;
	OnBoardPage2 o2;
	OnBoardPage1 o;
	String number="9837783365";
	/* verify that select below demat accounts options*/
	@Test(priority=1)
	public void validateSelectFromBelowDematAccountsOptions()
	{
		PickRightHomePage p = new PickRightHomePage(driver);
		p.getJoinAsinvestor();

		LoginOrSignUpPage l = new LoginOrSignUpPage(driver);
		l.getUseMobileNumber();
		l.getDropDown();
		l.setSearchField("India");
		l.getCountry();
		l.setMobileNumberField(number);
		l.getNextButton();
		e = new EnterOtpPage(driver);
		e.setOtp();
		e.getCheckBox();
		e.getNextButton();
		o = new OnBoardPage1(driver);
		o.getYesImNewToStock();
		o2 = new OnBoardPage2(driver);
		o2.getHowItWorksNext();
		o2.getShortTerm();
		o2.getPickRightFeatureNext();
		o2.getBeginner();
		o2.getParters();
	}
	/* verify that when user select the any option, home page with title start trading title should display*/
	@Test(priority=2)
	public void validateHomePageWithStartTradingTitle()
	{
		o2.getNotListedHere();
		o2.getStartTradingTitle();
	}

}
