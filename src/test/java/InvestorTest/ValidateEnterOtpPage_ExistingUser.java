package InvestorTest;

import org.openqa.selenium.NoSuchElementException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;

import PageObject_Investor.PickRightHomePage;

public class ValidateEnterOtpPage_ExistingUser extends Base {
	EnterOtpPage e;
	String num="6360245606";
	@Test(priority=1,expectedExceptions = NoSuchElementException.class)
	public void validateCheckBoxIsDisplayed()
	{
		PickRightHomePage p = new PickRightHomePage(driver);
		p.getJoinAsinvestor();
		LoginOrSignUpPage l = new LoginOrSignUpPage(driver);
		l.getUseMobileNumber();
		l.getDropDown();
		l.setSearchField("India");
		l.getCountry();
		l.setMobileNumberField(num);
		l.getNextButton();
		e=new EnterOtpPage(driver);
		e.setOtp();
		//e.isCheckBoxIsDisplayed();
		Assert.assertFalse(e.checkBox.isDisplayed());
		
	}
	
	@Test(priority=2,expectedExceptions = NoSuchElementException.class)
	public void validateReferralCodeFieldIsDisplayed()
	{
		//e.isReferalCodeFieldDisplayed();
		Assert.assertFalse(e.referralCodeField.isDisplayed());
		
	}
	
	@Test(priority=3)
	public void validateHomePageWithStartTradingTitle()
	{
		/*e.getNextButton();
		OnBoardPage2 o2=new OnBoardPage2(driver);
		o2.getStartTradingTitle();*/
		//OnBoardPage2 o2=new OnBoardPage2(driver);
		e.nextButton.click();
		HomePage h=new HomePage(driver);
		Assert.assertTrue(h.startTrading.isDisplayed());
		
	}
	
	

}
