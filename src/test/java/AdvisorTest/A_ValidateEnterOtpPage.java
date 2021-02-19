package AdvisorTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Advisor.A_LoginSignUpPage;
import PageObject_Advisor.A_PickRightLandingPage;
import PageObject_Advisor.A_WelcomeAdvisorPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.LoginOrSignUpPage;


public class A_ValidateEnterOtpPage extends Base {

	String num="9982741899";
	EnterOtpPage e;
	A_PickRightLandingPage p;
	LoginOrSignUpPage l;

	/* validate whether resend OTP button appears after 1 min */
	@Test(priority = 1)
	public void validateResendOtpButtonAfterOneMin() {
		p = new A_PickRightLandingPage(driver);
		p.getJoinAsAdvisor();

		l = new LoginOrSignUpPage(driver);
		l.getDropDown();
		l.setSearchField("India");
		l.getCountry();
		l.setMobileNumberField(num);
		l.getNextButton();

		e = new EnterOtpPage(driver);
		// e.getEnterOtpTitle();
		e.setOtp();
		e.getResendOtpButton(driver);

	}

	/*
	 * verify that before clicking on check box next button is disabled and after
	 * clicking on check box next button is enabled
	 */

	@Test(priority = 2)
	public void validateNextButtonEnabledOrNot() {
		e.getCheckBox(driver);

	}

	/* verify referral code field is empty */
	@Test(priority = 3)
	public void validateReferralFieldIsEmpty() {
		e.getReferralCodeField();
	}

	/* verify that user should navigate back to login page  when clicked on change number*/
	@Test(priority=4)
	public void validateChangeNumber() {
		e.getChangeNumber();
		A_LoginSignUpPage l1 = new A_LoginSignUpPage(driver);
		l1.getloginSignUpTitle();
		l.getDropDown();
		l.setSearchField("India");
		l.getCountry();
		l.setMobileNumberField(num);
		l.getNextButton();
		

	}
	/* verify that next button is not enabled when we remove one otp number in the otp field*/
	@Test(priority=5)
	public void validateNextButtonIsNotEnabledOndeletingOneOTPNumber() throws InterruptedException
	{
		e.setOtp();
		e.getCheckBox();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@id,'otp_3')]")).clear();
		
		e.getCheckBox();
		e.nextButtonEnabledOrDisabledOnRemovingOneNumberInOtp();
		
	}
	
	
	@Test(priority=6)
	public void validateWelcomeAdvisorPage()
	{
		driver.findElement(By.xpath("//input[contains(@id,'otp_3')]")).sendKeys("5");
		e.getNextButton();
		A_WelcomeAdvisorPage w=new A_WelcomeAdvisorPage(driver);
		w.getWelcomeAdvisortitle();
		
	}
	
	/* verify the welcome page is not displayed with the invalid otp*/
	/*@Test(priority=6)
	public void validateWelComeAdvisorTitleNotDisplayed()
	{
		e.getNextButton();
		A_WelcomeAdvisorPage w=new A_WelcomeAdvisorPage(driver);
		w.welcomeAdvisorIsDisplayedOrNOtWheninvalidOTP();
		
	}*/
	

}
