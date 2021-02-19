package InvestorTest;

import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.PickRightHomePage;

public class ValidateChangeNumberFeature extends Base{
	
	@Test
	public void validateChangeNumber() {
		PickRightHomePage p = new PickRightHomePage(driver);
		p.getJoinAsinvestor();

		LoginOrSignUpPage l = new LoginOrSignUpPage(driver);
		l.getUseMobileNumber();
		l.getDropDown();
		l.setSearchField("India");
		l.getCountry();
		l.setMobileNumberField("9866773642");
		l.getNextButton();
		
		EnterOtpPage e = new EnterOtpPage(driver);
		
		e.getChangeNumber();
		p.getLoginOrSignUpTitle(driver);
	}
	
	


}
