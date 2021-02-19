package InvestorTest;

import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.OnBoardPage1;
import PageObject_Investor.OnBoardPage2;
import PageObject_Investor.PickRightHomePage;

public class ValidatingOnboardPage1 extends Base {
	OnBoardPage1 o;
	OnBoardPage2 o2;
	String number = "9885770629";
	/* verify crt mobile number is displayed*/
	@Test(priority = 1)
	public void checkInvestorMobileNumber() {
		
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
		e.getCheckBox();
		e.getNextButton();
		o = new OnBoardPage1(driver);
		o.getInvestorMobileNumber(number);

	}
    /* verify notification page opens with the title "notification" when we click on notification icon*/
	@Test(priority = 2)
	public void notificationTitleValidation() {
		o.getNotification();
		o.getNotificationTitle();
		o.getCloseNotificationButton();
	}
	
	
	/* verify that for question are u new to the stock, has two options that is Yes, im new to the stock and No, i have done it before*/
	@Test(priority=3)
	public void validateOptionsgivenForAreYouNewToStock()
	{
		o.getYesImNewToStockTitle();
		o.getNoIHaveDoneItBeforeTitle();
	}
	/*verify that page contains how it works, training links, founder notes title when clicks on yes im new to stock */
	@Test(priority=4)
	public void validateHowItWorksAndTrainingLinksAndFounderNotesTitleForYes()
	{
		o.getYesImNewToStock();
		o2=new OnBoardPage2(driver);
		o2.getHowItWork();
		o2.getTrainingLinksTitle();
		o2.getFoundersNotesTitle();
		
	}
	
	/* verify that when i come back from how it works page selected option shd be selected*/
	@Test(priority=5)
	public void validateYesImNewToStockIsSelectedOrNot()
	{
		o.getBack();
		o.yesImNewToStockIsSelectedOrNot();
		
	}
	
/*	@Test
	public void validateBackArrowNavigateToThePageContainsAreUNewToStock()
	{
		
	}*/
	/*verify that page contains how it works, training links, founder notes title when clicks on No,i have done it before */
	@Test(priority=6)
	public void validateHowItWorksAndTrainingLinksAndFounderNotesTitleForNo()
	{
		o.getNoIHaveDoneItBefore();
		o2.getHowItWork();
		o2.getTrainingLinksTitle();
		o2.getFoundersNotesTitle();
		
		
	}
	
	
	
	

	/*@Test(priority = 2)
	public void areYouNewToStockValidation() {
		o.getAreYouNewToStock();
	}*/
	
	/*@Test
	public void HowItWorksTitle()
	{
		o.getYesImNewToStock();
	}*/
	
	

}
