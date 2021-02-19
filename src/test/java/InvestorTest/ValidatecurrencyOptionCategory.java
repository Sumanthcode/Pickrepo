package InvestorTest;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.CategorySelectionPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.PickRightHomePage;

public class ValidatecurrencyOptionCategory extends Base{

	@Test
	public void validateCurrencyOption() {
	String number = "6360245606";
	PickRightHomePage p = new PickRightHomePage(driver);
	p.getJoinAsinvestor();

	LoginOrSignUpPage l = new LoginOrSignUpPage(driver);
	l.getUseMobileNumber();
	l.getDropDown();
	l.setSearchField("India");
	l.getCountry();
	l.setMobileNumberField(number);
	l.getNextButton();
	EnterOtpPage e = new EnterOtpPage(driver);
	e.setOtp();
//	e.getCheckBox(driver);
	e.getNextButton();
/*	OnBoardPage1 o = new OnBoardPage1(driver);
	o.getYesImNewToStock();
	OnBoardPage2 o2 = new OnBoardPage2(driver);
	o2.getHowItWorksNext();
	o2.checkTheWhatAreYouLookingForTitle();
	o2.getShortTerm();
	o2.getPickRightFeatureNext();
	o2.getBeginner();
	o2.getNotListedHere();*/
	HomePage h=new HomePage(driver);
	WebDriverWait wait1=new WebDriverWait(driver,5);
	wait1.until(ExpectedConditions.visibilityOf(h.startTrading));
	h.getStartTrading();
	CategorySelectionPage c=new CategorySelectionPage(driver);
	WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOf(c.currenciesOption));
    c.getCurrenciesOption();
//	c.getSkip(driver);
	c.getCurrencyOptiontitle();
	c.getNewCall();
	}
}
