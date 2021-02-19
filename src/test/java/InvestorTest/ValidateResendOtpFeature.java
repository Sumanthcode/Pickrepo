package InvestorTest;

import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.PickRightHomePage;

public class ValidateResendOtpFeature extends Base{
	
	EnterOtpPage e;
	@Test
	public void checkResendOtpButtonApppeared()
	{
		
		PickRightHomePage p = new PickRightHomePage(driver);
		p.getJoinAsinvestor();

		LoginOrSignUpPage l = new LoginOrSignUpPage(driver);
		l.getUseMobileNumber();
		l.getDropDown();
		l.setSearchField("India");
		l.getCountry();
		l.setMobileNumberField("9822167386");
		l.getNextButton();
		e=new EnterOtpPage(driver);
		e.getResendOtpButton(driver);
		//e.setOtp();
		
	}
	
	/*@Test
	public void checkinvalidOtpErrorMessage()
	{
		e.getOtpErrorMessage();
	}*/
	
	

}
