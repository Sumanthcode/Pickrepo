package InvestorTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import Generic.Base;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.PickRightHomePage;

public class ValidateEnterOtpPage extends Base {
	EnterOtpPage e;
	LoginOrSignUpPage l;
	PickRightHomePage p;
	String num="9982341899";
	/* validate whether resend OTP button appears after 1 min */
	@Test(priority = 1)
	public void validateResendOtpButtonAfterOneMin() {
		 p = new PickRightHomePage(driver);
		p.getJoinAsinvestor();

		l = new LoginOrSignUpPage(driver);
		l.getUseMobileNumber();
		l.getDropDown();
		l.setSearchField("India");
		l.getCountry();
		l.setMobileNumberField(num);
		l.getNextButton();

		e = new EnterOtpPage(driver);
		//e.getEnterOtpTitle();
		e.setOtp();
		e.getResendOtpButton(driver);

	}


	/*
	 * verify that before clicking on check box next button is disabled and after
	 * clicking on check box next button is enabled
	 */
	@Test(priority = 3)
	public void validateCheckBox() {
		e.getCheckBox(driver);
	}
	
	/* verify referral code field is empty */
	@Test(priority = 4)
	public void validateReferralFieldIsEmpty() {
		e.getReferralCodeField();
	}
	
	/* verify that user should navigate back to login page  when clicked on change number*/
	@Test(priority=5)
	public void validateChangeNumber() {
		e.getChangeNumber();
	    p.getLoginOrSignUpTitle(driver);
		l.getDropDown();
		l.setSearchField("India");
		l.getCountry();
		l.setMobileNumberField(num);
		l.getNextButton();
	}
	
	/* verify that next button is not enabled when we remove one otp number in the otp field*/
	@Test(priority=6)
	public void validateNextButtonIsNotEnabledOndeletingOneOTPNumber()
	{
		e.setOtp();
		e.getCheckBox();
		driver.findElement(By.xpath("//input[contains(@id,'otp_3')]")).clear();
		e.getCheckBox();
		e.getCheckBox();
		e.nextButtonEnabledOrDisabledOnRemovingOneNumberInOtp();
		
		
	}
    /* verify onboard page with title "are u new the stock?" is displayed when click on next button*/
	@Test(priority = 7)
	public void validateAreYouNewToTheStockTitle() {
		e.otp.get(3).sendKeys("5");
		e.getCheckBox();
		e.getNextButton();
		HomePage h=new HomePage(driver);
		Assert.assertTrue(h.startTrading.isDisplayed());
	//	e.getAreYouNewToTheStockTitle();
	}

	

}
