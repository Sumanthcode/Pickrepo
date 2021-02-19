package AdvisorTest;

import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Advisor.A_AdvisorProfilePage;
import PageObject_Advisor.A_PickRightLandingPage;
import PageObject_Advisor.A_WelcomeAdvisorPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.LoginOrSignUpPage;

public class A_ValidateAdvisorProfilePage extends Base {

	A_PickRightLandingPage p;
	LoginOrSignUpPage l;
	EnterOtpPage e;
	A_WelcomeAdvisorPage w;
	String num="9957635481";
	/* verify that when user dont provide the full name, error msg shd display*/
	@Test
	public void test1() 
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
		//e.getEnterOtpTitle();
		e.setOtp();
	//	e.getCheckBox();
		e.getNextButton();
		w=new A_WelcomeAdvisorPage(driver);
		w.getCompleteProfile(driver);
		A_AdvisorProfilePage a=new A_AdvisorProfilePage(driver);
		a.setFullName("");
		a.getNISMCertificateButton();		
		a.getNameIsRequiredErrorMsg();
		
	}
}
