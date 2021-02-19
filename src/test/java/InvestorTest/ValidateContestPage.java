package InvestorTest;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic.Base;
import PageObject_Investor.ContestPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.OnBoardPage1;
import PageObject_Investor.OnBoardPage2;
import PageObject_Investor.PickRightHomePage;

public class ValidateContestPage extends Base{

	EnterOtpPage e;
	OnBoardPage2 o2;
	OnBoardPage1 o;
	HomePage h;
	ContestPage c;
	String number="8762196822";
	/*verify that contest is displayed in home page*/
	@Test(priority=1)
	public void validateContestInHomePage()
	{
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
		h=new HomePage(driver);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].scrollIntoView(true)",h.contest);
		Assert.assertTrue(h.contest.isDisplayed());
		Assert.assertTrue(h.participateButtonInTopStock.getText().equalsIgnoreCase("Participate"));
		Assert.assertTrue(h.participateButtonPredictNifty.getText().equalsIgnoreCase("Participate"));
		
	}
	/*verify that when user enter into contest, predict nifty contest should displayed*/ 
	@Test(priority=2)
	public void validatePredictNiftyInContestPage1()
	{
		h.contest.click();
		c=new ContestPage(driver);
		Assert.assertTrue(c.historyWinnings.getText().equalsIgnoreCase("History & Winnings"));
		Assert.assertTrue(c.predictNifty.getAttribute("src").contains("active"));
		Assert.assertFalse(c.pickTopStock.getAttribute("src").contains("active"));
		
	}
	/*verify that in predict nifty, current nifty price is displayed*/
	@Test(priority=3)
	public void validatePredictNiftyInContestPage2()
	{
		Assert.assertTrue(c.todaysNiftyValue.isDisplayed());
	}
	/*verify that open for participation is displayed with date and month*/
	@Test(priority=4)
	public void validatePredictNiftyInContestPage3()
	{
		Assert.assertTrue(c.openForParticipationTitile.getText().equalsIgnoreCase("Open For Participation"));
	/*	Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM");
		String strDate = formatter.format(date);*/
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		Date date1 = calendar.getTime();
		Format formatter1= new SimpleDateFormat("dd MMM");
		String tomDate = formatter1.format(date1);
		SoftAssert s=new SoftAssert();
		s.assertTrue(c.dateForOpenForParticipation.getText().equals(tomDate.split(" ")[0]));
		s.assertTrue(c.monthForOpenForParticipation.getText().equals(tomDate.split(" ")[1]));
		s.assertAll();
	}
	/*verify that when user dont enter value and clicks on add button, error msg is displayed*/
	@Test(priority=5)
	public void validatePleaseEnterTheValueErrorMsg1()
	{
		c.addButton.click();
		Assert.assertTrue(c.msg.getText().equalsIgnoreCase("Please Enter A Value."));
	}
	
	/*verify that when user try to  enter otherthan number value and clicks on add button, error msg is displayed*/
	@Test(priority=6)
	public void validatePleaseEnterTheValueErrorMsg2()
	{
		c.enterNiftyPriceField.sendKeys("gvd&$vdh");
		c.addButton.click();
		Assert.assertTrue(c.msg.getText().equalsIgnoreCase("Please Enter A Value."));
	}
	/*verify that user added nifty price successfully*/
	@Test(priority=7)
	public void validateAddingNiftyPrice() throws InterruptedException
	{
		c.enterNiftyPriceField.sendKeys(c.todaysNiftyValue.getText().replace(",",""));
		c.addButton.click();
		Thread.sleep(2000);
		Assert.assertTrue(c.msg.getText().equalsIgnoreCase("Joined Successfully."));
		Assert.assertTrue(c.editButton.getText().equalsIgnoreCase("Edit"));
	}
	
	@Test(priority=8)
	public void validateEditNiftyPrice() throws InterruptedException
	{
		c.editButton.click();
		Assert.assertTrue(c.updateButton.getText().equalsIgnoreCase("update"));
		c.enterNiftyPriceField.clear();
		Thread.sleep(2000);
		c.enterNiftyPriceField.sendKeys(c.todaysNiftyValue.getText().replace(",",""));
		c.updateButton.click();
		Assert.assertTrue(c.msg.getText().equalsIgnoreCase("Nifity Price Updated Successful"));
		Thread.sleep(1000);
		Assert.assertTrue(c.editButton.getText().equalsIgnoreCase("Edit"));
		
	}
	
	@Test(priority=9)
	public void validateRecentClosedContest()
	{
		Assert.assertTrue(c.recentlyClosedTitle.getText().equalsIgnoreCase("Recently Closed"));
		Assert.assertTrue(c.leaderBoard.getText().equalsIgnoreCase("Leaderboard"));
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		Date date1 = calendar.getTime();
		Format formatter1= new SimpleDateFormat("dd MMM");
		String tomDate = formatter1.format(date1);
		SoftAssert s=new SoftAssert();
		System.out.println(tomDate.split(" ")[0]);
		System.out.println(tomDate.split(" ")[1]);
		s.assertTrue(c.dateForRecentlyClosedContest.getText().equals(tomDate.split(" ")[0]));
		s.assertTrue(c.monthForRecentlyClosedContest.getText().equals(tomDate.split(" ")[1]));
		s.assertAll();
	}
	
//	@Test
	public void validateTopStockPage1()
	{
		c.pickTopStock.click();
		
	}
	
	
	
	
}
