package InvestorTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.PickRightHomePage;

public class ValidatePickrightHome extends Base {
	PickRightHomePage home;

	/*
	 * verify that page conatains the titile
	 * "Investing and trading made simple. India's Best Investment Advisors platform"
	 */
	@Test(priority = 2)
	public void valiadteLandingPageTitle() {
		Assert.assertTrue(home.pickRightHomePageTitle.getText()
				.equalsIgnoreCase("Investing and trading made simple. India's Best Investment Advisors platform."));

	}

	

	/* verify that where user landing on crt page with crt URL */
	@Test(priority = 1)
	public void testUrl() throws InterruptedException {
		home=new PickRightHomePage(driver);
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://stage-web.pickright.co.in/";
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	/*
	 * veriy that page contains Login/Signup as a Investor and join as Financial
	 * advisor button
	 */
	@Test(priority = 3)
	public void validateMainLinks() {
		Assert.assertTrue(home.joinAsInvestor.isDisplayed());
		Assert.assertTrue(home.joinAsAFinancialAdvisorButton.isDisplayed());

	}

	/*
	 * verify when we click on join as investor login page should display with title
	 * "login/signup  as an investor"
	 */
	@Test(priority = 4)
	public void validateLoginSignUpTitle() {
		
		home.joinAsInvestor.click();
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(home.loginOrSignUpTitle));
		Assert.assertTrue(home.loginOrSignUpTitle.getText().equalsIgnoreCase("Login/Sign Up"));

	}

	@Test(priority = 5)
	public void validateAsAInvestorTitle() {
		Assert.assertTrue(home.asAInvestorOrAdvisorTitle.getText().equalsIgnoreCase("As an investor"));
	}

}
