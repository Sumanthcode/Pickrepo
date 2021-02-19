package InvestorTest;



import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.OnBoardPage2;
import PageObject_Investor.PickRightHomePage;

public class ValidateLoginWithGoogle_ExistingUser extends Base {

	LoginOrSignUpPage l;
	PickRightHomePage h1;
	OnBoardPage2 o2;
	
	@Test(priority=1)
	public void validateSignInGoogleAccountTitle()
	{
		h1 = new PickRightHomePage(driver);
		h1.joinAsInvestor.click();
		l = new LoginOrSignUpPage(driver);
		l.continueWithGoogle.click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Sign in – Google accounts"));
	}
	@Test(priority=2)
	public void successfullLoginWithGoogle()
	{
		l.emailField.sendKeys("sumanth@pickright.in");
		l.next.click();
		WebDriverWait wait=new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.visibilityOf(l.passwordField));
		l.passwordField.sendKeys("Nishanth@1998");
		l.next.click();
		HomePage h=new HomePage(driver);
		Assert.assertTrue(h.startTrading.isDisplayed());
		
		
	}
}
