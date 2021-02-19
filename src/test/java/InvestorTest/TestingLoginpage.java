package InvestorTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.PickRightHomePage;

public class TestingLoginpage extends Base {
	LoginOrSignUpPage l;
	PickRightHomePage h1;
	
	
	//validate default country +91 is displayed 
	@Test(priority=1)
	public void validateDefaultCountryCode()
	{
		h1 = new PickRightHomePage(driver);
		//h1.getJoinAsinvestor();
		h1.joinAsInvestor.click();
		l = new LoginOrSignUpPage(driver);
		//l.getUseMobileNumber();
		l.useMobileNumber.click();
		
		l.getDefaultCountryCode();
	}
	
	/* verify that phone num is required msg displayed when we dont enter the mobile number*/
	@Test(priority=2)
	public void validatePhoneNumberIsRequiredMsg()
	{
		l.getDropDown();
		l.setSearchField("India");
		l.getCountry();
		l.getPhoneNumberRequiredMsgTitle();
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

	/*verify Enter otp page is displayed with Title enter otp when i click on next*/
	@Test(priority=5)
	public void validateEnterOTPTitle()
	{
		
		l.setMobileNumberField("9876755646");
		l.getNextButton();
		l.getEnterOtpTitle();
	}

}
