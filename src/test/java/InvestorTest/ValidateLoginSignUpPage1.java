package InvestorTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.PickRightHomePage;

public class ValidateLoginSignUpPage1 extends Base{

	LoginOrSignUpPage l;
	/*verify that user has a option to login by mobile number, google and brokers*/
	@Test(priority=1)
	public void v1()
	{
		PickRightHomePage p=new PickRightHomePage(driver);
		p.joinAsInvestor.click();
		l=new LoginOrSignUpPage(driver);
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(l.loginOrSignUpTitle));
		l.useMobileNumber.click();
		Assert.assertTrue(l.mobileNumberField.isDisplayed());
		Assert.assertTrue(l.loginWithMobileNumberTitle.getText().equalsIgnoreCase("Log In with Mobile Number"));
		l.back.click();
	}
	
	@Test(priority=2)
	public void v2() throws AWTException
	{
		String s[]={"Alice Blue","Master Trust","Trade Smart","5 Paisa"};
		List<String> elist = Arrays.asList(s);
		List<String> aList = l.brokers.stream().map(a->a.getText()).collect(Collectors.toList());
		Assert.assertEquals(aList, elist);
	//	String con = Keys.chord(Keys.CONTROL,Keys.ENTER);
	
		
	}
}
