package InvestorTest;

import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.MyProfilePage;
import PageObject_Investor.OnBoardPage1;
import PageObject_Investor.OnBoardPage2;
import PageObject_Investor.PickRightHomePage;

public class ValidateMyProfile extends Base{
	EnterOtpPage e;
	OnBoardPage2 o2;
	OnBoardPage1 o;
	HomePage h;
	MyProfilePage m;
	String number="9837783364";
	@Test(priority=1)
	public void validation1()
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
	//	e.getCheckBox(driver);
		e.getNextButton();
	/*	o = new OnBoardPage1(driver);
		o.getYesImNewToStock();
		o2 = new OnBoardPage2(driver);
		o2.getHowItWorksNext();
		o2.checkTheWhatAreYouLookingForTitle();
		o2.getShortTerm();
		o2.getPickRightFeatureNext();
		o2.getBeginner();
		o2.getParters();
		o2.getNotListedHere(); */
		h=new HomePage(driver);  
		h.getDropDown();
		h.getMyProfile();
		 m=new MyProfilePage(driver);
		m.getCompleteProfile();
		m.checkFullNameFieldIsEmpty();
		m.checkBrokeragesAreNotSelected();
		m.checkPanNoFieldIsNotTouched();
		m.checkInvestmentCapitalValue();
		m.checkTypeOfTradersAreNotSected();
		m.checkTypeOfTradersAreNotSected();
		m.checkSavebuttonIsNotEnabled();
		
	}
	
	@Test(priority=2)
	public void validateTypeOfTradersDropISSingleSelect()
	{
		m.checkTypeOfTraderDropDownISSingleSelect();
	}
	
	@Test(priority=3)
	public void validateNameIsRequiredErrorMsg()
	{
		m.checkNameIsRequiresErrorMsg();
	}
	
	
	

}
