package InvestorTest;

import org.testng.annotations.*;
import Generic.Base;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.OnBoardPage1;
import PageObject_Investor.OnBoardPage2;
import PageObject_Investor.PickRightHomePage;

public class ValidatingOnboardPage2 extends Base{
	OnBoardPage2 o2;
	OnBoardPage1 o;
	EnterOtpPage e;
	
	@Test(priority=1)
	public void validateHowItWorksTitleAndVideo() {
		String number = "9181885901";
		PickRightHomePage p = new PickRightHomePage(driver);
		p.getJoinAsinvestor();

		LoginOrSignUpPage l = new LoginOrSignUpPage(driver);
		l.getUseMobileNumber();
		l.getDropDown();
		l.setSearchField("India");
		l.getCountry();
		l.setMobileNumberField(number);
		l.getNextButton();
		e = new EnterOtpPage(driver);
		e.setOtp();
		e.getCheckBox();
		e.getNextButton();
		 o = new OnBoardPage1(driver);
		o.getYesImNewToStock();
		o2 = new OnBoardPage2(driver);
		o2.getHowItWork();
		o2.getHowItWorksVideo();

	}
	
    @Test(priority=2)
	public void validateTestLinks()
	{
		o2.getTrainingLinks();
	}
	
    /* verify that when clicks on back arrow user navigates to page contains are u new to stock*/
	@Test(priority=3)
	public void validateBackArrowNavigateToThePageContainsAreUNewToStock()
	{
		o.getBack();
		e.getAreYouNewToTheStockTitle();
		o.getYesImNewToStock();
		
	}
	
	/*verify that when click on next button, user navigates to the page contains what are u looking for? title*/
	@Test(priority=4)
	public void validateWhatAreYoulookingForTitle()
	{
		o2.getHowItWorksNext();
		o2.checkTheWhatAreYouLookingForTitle();
	}
	

	
	/*
	 * @Test(priority=5) public void validateHowWouldYouCategoriseYourselfTitle() {
	 * o2.getPickRightFeatureNext(); o2.CheckHowWouldYouCategoriseYourselfTitle(); }
	 * 
	 * @Test(priority=6) public void validateHowWouldYouCategoriseYourselfAns() {
	 * o2.getHowWouldYouCategoriseYourself(); }
	 * 
	 * @Test(priority=7) public void validateSelectFromBelowDematAccountsTitle() {
	 * o2.checkSelectFromBelowDematAccountsTitle(); }
	 * 
	 * @Test(priority=8) public void valiadteDematAccountTypes() { o2.getParters();
	 * }
	 * 
	 * @Test(priority=9) public void validateStartTradingtitle() {
	 * o2.getStartTradingTitle(); }
	 * 
	 * @Test(priority=10) public void validateAdvisorPredictionTitle() {
	 * o2.getAdvisorPrediction(); }
	 * 
	 * @Test(priority=11) public void validateTopNewsTitle() { o2.getTopNews(); }
	 */
}
