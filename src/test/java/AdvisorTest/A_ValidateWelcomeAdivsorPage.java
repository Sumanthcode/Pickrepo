package AdvisorTest;

import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Advisor.A_PickRightLandingPage;
import PageObject_Advisor.A_WelcomeAdvisorPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.LoginOrSignUpPage;

public class A_ValidateWelcomeAdivsorPage extends Base {
	A_PickRightLandingPage p;
	LoginOrSignUpPage l;
	EnterOtpPage e;
	A_WelcomeAdvisorPage w;
	String num="9957637489";
	
	/* verify that correct mobile number displayed */
	@Test(priority=1)
	public void validateMobileNumber()
	{
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
		e.getCheckBox();
		e.getNextButton();
		w=new A_WelcomeAdvisorPage(driver);
		w.getMobileNumber(num);
	}
	/* verify that when click on notification, notification page is displayed with titile Notifications*/
	@Test(priority=2)
	public void validateNotificationTitle()
	{
	
		w.getNotificationTitle();
		w.getCloseNotificationButton();
	}
	
	
	
	/* verify that notification page closes when clicked on close */
/*	@Test(priority=3)
	public void validateCloseNotification()
	{
		w.getCloseNotificationButton();
		w.notificationTitleAfterClose();
	}*/
	
	

}
