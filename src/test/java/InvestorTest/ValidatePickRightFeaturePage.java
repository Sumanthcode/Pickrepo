package InvestorTest;

import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.OnBoardPage1;
import PageObject_Investor.OnBoardPage2;
import PageObject_Investor.PickRightHomePage;

public class ValidatePickRightFeaturePage extends Base{
	EnterOtpPage e;
	OnBoardPage1 o;
	OnBoardPage2 o2;
	String number="9792817664";
	@Test(priority=1)
	public void validateBackArrowNavigateToThePageContainsWhatAreYouLookingForTitle() throws InterruptedException
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
		o.getBack();
        Thread.sleep(4000);
		o2.checkTheWhatAreYouLookingForTitle();
		o2.getShortTerm();
	}
	
	/* verify How would you categorise yourself title when user click on next button*/
	@Test(priority=2)
	public void validateHowWouldYouCategoriseYourSelfTitle()
	{
		
		o2.getPickRightFeatureNext();
		driver.navigate().refresh();
		o2.CheckHowWouldYouCategoriseYourselfTitle();
	}
	
	

}
