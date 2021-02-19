package InvestorTest;

import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.AlertPage;
import PageObject_Investor.CategorySelectionPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.InvestorDashBoardPage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.PickRightHomePage;

public class ValidateAlertPage extends Base {
	InvestorDashBoardPage i;
	AlertPage a;

	/*
	 * verify select category section has Future,Option,Currency Options,Currency
	 * Future,Commodity Options,Commodity Future,Any options
	 */
	@Test(priority = 1)
	public void validateSelectCategoryOptions() {
		PickRightHomePage p = new PickRightHomePage(driver);
		p.getJoinAsinvestor();
		LoginOrSignUpPage l = new LoginOrSignUpPage(driver);
		l.getUseMobileNumber();
		l.getDropDown();
		l.setSearchField("India");
		l.getCountry();
		l.setMobileNumberField("6360245606");
		l.getNextButton();
		EnterOtpPage e = new EnterOtpPage(driver);
		e.setOtp();
		e.getNextButton();
		HomePage h = new HomePage(driver);
		h.getStartTrading();
		CategorySelectionPage c = new CategorySelectionPage(driver);
		c.getEquityCash();
		i = new InvestorDashBoardPage(driver);
		i.getAlertIcon();
		a = new AlertPage(driver);
		a.getCreateAlertButton();
		a.checkSelectCategoryOptions();

	}

	/* verify that popular scrip section has NIFTY and BANKNIFTY options */
	@Test(priority = 2)
	public void validatePopularScripsOptions() {
		a.checkPopularScripsOptions();
	}

	/*
	 * verify that when user click on create alert without selecting category and
	 * scrip, error msg displayed please select atleast one category
	 */
	@Test(priority = 3)
	public void validatePleaseSelectAtleastOneCategoryErrorMsg() {
		a.checkPleaseSelectAtleastOneCategoryErrorMsg();
	}

	/*
	 * verify that when user click on create aalert without selecting scrip, error
	 * msg is displayed please select a script
	 */
	@Test(priority = 4)
	public void validatePleaseSelectAScriptErrorMsg() {
		a.checkPleaseSelectAScriptErrorMsg();
	}

	/*
	 * verify successfull creation of alert when user select category and popular
	 * scrip
	 */
	@Test(priority = 5)
	public void validateSuccessfullCreationOfPopularScripAlertWithMsg() throws InterruptedException {

		String scripName = a.getNifty();
		Thread.sleep(2000);
		a.checkAlertAddedSuccessfullyMsg();
		a.checkSuccessfullyAddedPopularScripAlertDetails(scripName);

	}

	/*
	 * verify successfull creation of alert when user select category and scrip from
	 * the scrip field
	 */
	@Test(priority = 6)
	public void validateSuccessfullCreationOfScripAlertWithMsg() throws InterruptedException {
		a.getCreateAlertButton();
		String aCategory = a.getSelectCategory();
		a.setScripField("TCS");
		String scrip = a.getScripAutoSugessions();
		a.getCreateAlert();
		Thread.sleep(2000);
		a.checkAlertAddedSuccessfullyMsg();
		a.checkSuccessfullyAddedScripAlertDetails(aCategory, scrip);

	}

	/*
	 * verify that when user try to add scrip alert which is already there, error
	 * msg is displayed
	 */
	@Test(priority = 7)
	public void validateScriptAlreadyExistsErrorMsg() throws InterruptedException {
		a.getCreateAlertButton();
		a.getSelectCategory();
		a.setScripField("TCS");
		a.getScripAutoSugessions();
		a.getCreateAlert();
		Thread.sleep(2000);
		a.checkScriptAlreadyExistsErrorMsg();

	}

	/* verify when user click on cancel buuton, user navigate back to alerts page */
	@Test(priority = 8)
	public void validateCancelButton() {
		a.getCancelButton();
		a.checkMyAlertTitle();
	}

	@Test(priority=9)
	public void V() {
		String aCat=a.getAddedAlertCategory();
		a.getViewCalls();
		i.checkNewCallHeaderIsActive();
		String eCat = i.getEquityOptionTitle();
		a.checkCategoryNameOnClickingViewCalls(eCat,aCat);

	}
	/*
	 * verify that category and scripts are not selected when we enter the create
	 * alert page
	 */

}
