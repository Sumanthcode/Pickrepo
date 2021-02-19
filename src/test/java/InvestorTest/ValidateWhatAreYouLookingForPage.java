package InvestorTest;

import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.OnBoardPage1;
import PageObject_Investor.OnBoardPage2;
import PageObject_Investor.PickRightHomePage;

public class ValidateWhatAreYouLookingForPage extends Base {
	OnBoardPage2 o2;
	EnterOtpPage e;
	OnBoardPage1 o;
	String number = "9596595901";
	
	/* verify that what are u looking for question has two options long term and short term*/
	@Test(priority=1)
	public void validateLongTermANdShortTermTradingTitle()
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
		o2.getLongTermTradingTitle();
		o2.getShortTermTradingTitle();
	}
	
	/* verify that when user clicks back arrow, it should navigates to the page contains title How it works, training links, founder notes*/
	@Test(priority=2)
	public void validateBackArrowNavigatesToThePageContainsHowItWorksTrainingLinks()
	{
		System.out.println("hgh");
		o.getBack();
		o2.getHowItWork();
		o2.getTrainingLinksTitle();
		o2.getFoundersNotesTitle();
		o2.getHowItWorksNext();
	}
	
	/* verify that when user clicks on long term, user navigate to the page contains Explore short term trading title*/
	@Test(priority=3)
	public void validateExploreShortTermTradingTitle()
	{
		o2.getLongTerm();
		o2.getExploreShortTermTradingTitle();
		o.getBack();
	}
	
	/* verify that
	@Test(priority=4)
	public void validateBackArrowNavigatesToThePageContainsWhatAreYouLookingFor()
	{
		o.getBack();
		o2.checkTheWhatAreYouLookingForTitle();
		
	}*/
	/* verify user navigate to the page contains pickright feature title when clicks on short term*/
	@Test(priority=4)
	public void validatePickRightFeatureTitle()
	{
		o2.getShortTerm();
		o2.getPickRightFeatureTitle();
	}
	
	

}
