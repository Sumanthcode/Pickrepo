package AdvisorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Advisor.A_LoginSignUpPage;
import PageObject_Advisor.A_PickRightLandingPage;
import PageObject_Investor.LoginOrSignUpPage;

public class A_ValidateLoginPage extends Base {
	LoginOrSignUpPage l;
	//validate the Login page is displayed when we click on join as advisor
	@Test(priority=1)
	public void validateLoginSignUpTitle()
	{
		A_PickRightLandingPage p=new A_PickRightLandingPage(driver);
		p.getJoinAsAdvisor();
		A_LoginSignUpPage l=new A_LoginSignUpPage(driver);
		l.getloginSignUpTitle();
	}
	
	@Test(priority=2)
	public void validateDefaultCountryCode()
	{
		l = new LoginOrSignUpPage(driver);
		l.getDefaultCountryCode();
	}
	
	@Test(dataProvider ="testdata",priority=3)
	public void test(String number) {
		
		l.getDropDown();
		l.setSearchField("India");
		l.getCountry();
		l.setMobileNumberField(number);
		l.getMobileNumberField();
		l.getErrorMessage(driver);
		
	}

	@DataProvider(name ="testdata")
	public String[][] data() {
		String[][] a = new String[4][1];

		a[0][0] = "-7+7557";
		a[1][0] = "79543";
		a[2][0] = "@%6gfy";
		a[3][0] = "9876755644";

		return a;

	}
	
	
	/* validate when clicked on next enter otp page is displayed or not*/
	@Test(priority=4)
	public void validateEnterOtpTitle()
	{
		l.setMobileNumberField1();
		l.getNextButton();
		l.getEnterOtpTitle();
		
	}
	


}
