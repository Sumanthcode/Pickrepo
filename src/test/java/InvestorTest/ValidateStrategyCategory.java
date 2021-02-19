package InvestorTest;


import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.CategorySelectionPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.OnBoardPage1;
import PageObject_Investor.OnBoardPage2;
import PageObject_Investor.PickRightHomePage;

public class ValidateStrategyCategory extends Base{
	
	@Test
	public void validateStrategycall()
	{
		String number = "7281435131";
		PickRightHomePage p = new PickRightHomePage(driver);
		p.getJoinAsinvestor();

		LoginOrSignUpPage l = new LoginOrSignUpPage(driver);
		l.getUseMobileNumber();
		l.getDropDown();
		l.setSearchField("India");
		l.getCountry();
		l.setMobileNumberField(number);
		l.getNextButton();
		EnterOtpPage e = new EnterOtpPage(driver);
		e.setOtp();
		e.getCheckBox(driver);
		e.getNextButton();
		OnBoardPage1 o = new OnBoardPage1(driver);
		o.getYesImNewToStock();
		OnBoardPage2 o2 = new OnBoardPage2(driver);
		o2.getHowItWorksNext();
		o2.checkTheWhatAreYouLookingForTitle();
		o2.getShortTerm();
		o2.getPickRightFeatureNext();
		
		//o2.getNext();
		o2.getBeginner();
		o2.getNotListedHere();
		HomePage h=new HomePage(driver);
		h.getStartTrading();
		CategorySelectionPage c=new CategorySelectionPage(driver);
	    c.getStrategyCall();
	//	c.getSkip(driver);
		c.getStrategyCalltitle();
		c.getNewCall();
	}

}
