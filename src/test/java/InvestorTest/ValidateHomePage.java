package InvestorTest;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.DiscussionBoardPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.OnBoardPage1;
import PageObject_Investor.OnBoardPage2;
import PageObject_Investor.PickRightHomePage;

public class ValidateHomePage extends Base {
	EnterOtpPage e;
	OnBoardPage2 o2;
	OnBoardPage1 o;
	HomePage h;
	String number="6360245606";
	//verify that when user select the script in market watch, selected script is displayed with msg
	@Test(priority=1)
	public void validateSelectedScriptName()
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
		e.getNextButton();
		h=new HomePage(driver);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(h.startTrading));
		j.executeScript("arguments[0].scrollIntoView(true)",h.marketWatchscriptSearch);
		h.marketWatchscriptSearch.sendKeys("WIP");
		String seleted = h.autoSuggesion.get(0).getText();
		h.autoSuggesion.get(0).click();
		Assert.assertTrue(h.selectedScrip.get(0).getText().contains(seleted));
		Assert.assertTrue(h.msg.getText().equalsIgnoreCase("Instrument Added successfully!"));
	}
	/*verify that when user click on scrip name it is redirecting to discussion board*/
	@Test(priority=2)
	public void validateTopicPageOnClickingTheScrip()
	{
		String scripNameOnMarketWatch = h.selectedScrip.get(0).getText();
		h.selectedScrip.get(0).click();
		DiscussionBoardPage d=new DiscussionBoardPage(driver);
		Assert.assertTrue(scripNameOnMarketWatch.contains(d.topicNameInsideTheDiscussion.getText().replace("#","")));
		d.back.click();
	}
	
	/* verify that when user mousehover on the script, depth and delete option is displayed*/
	@Test(priority=3)
	public void validateDepthAndDeleteObjectOnMousehover() throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].scrollIntoView(true)",h.marketWatchscriptSearch);
		
		Actions action = new Actions(driver);
		action.moveToElement(h.selectedScrip.get(0)).build().perform();
		Assert.assertTrue(h.depth.isDisplayed());
	}
	/* verify that when user click on depth, depth is opened with the title "market depth" tile is displayed*/ 
	@Test(priority=4,expectedExceptions = NoSuchElementException.class)
	public void validateMarketDepthTitle()
	{
		h.depth.click();
		Assert.assertTrue(h.marketDepthTitle.getText().equalsIgnoreCase("Market Depth"));
		h.depth.click();
		Assert.assertFalse(h.marketDepthTitle.isDisplayed());
	}
	/* verify that when user delete the script, script is deleted successfully*/
	@Test(priority=5)
	public void validateDeleteScript()
	{
		h.delete.click();
		//Assert.assertFalse(h.selectedScrip.get(0).isDisplayed());
		Assert.assertTrue(h.msg.getText().equalsIgnoreCase("Removed successfully!"));
	}
	
	/* verify that user can add only 10 script and after adding more than 10, error msg is displayed*/
	@Test(priority=7)
	public void validateNumberOfScriptCanAdd() throws InterruptedException
	{
		h.marketWatchscriptSearch.sendKeys("WIP");
		int count = 0;
		for (int i = 0; i < h.autoSuggesion.size(); i++) {
			if (count <= 10) {
				h.autoSuggesion.get(i).click();
				Thread.sleep(1000);
				h.marketWatchscriptSearch.sendKeys("WIP");
				count++;

			} else {
				break;
			}
		}
		h.marketWatchscriptSearch.clear();
		Assert.assertTrue(h.selectedScrip.size()==10);
		Assert.assertTrue(h.msg.getText().equalsIgnoreCase("you can add only 10 scripts."));
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		int n=h.selectedScrip.size();
	
		for(int i=0;i<n;i++)
		{
			Thread.sleep(1000);
			action.moveToElement(h.selectedScrip.get(0)).moveToElement(h.delete).click().build().perform();
		}
		

	}
	
	/*verify that dashboard page conatains top 3 dicussion topics name*/
	@Test(priority=8)
	public void validateDiscussionTopic()
	{
	    JavascriptExecutor j=(JavascriptExecutor)driver;
	    j.executeScript("arguments[0].scrollIntoView(true)",h.discussion);
	    h.discussion.click();
	    DiscussionBoardPage d=new DiscussionBoardPage(driver);
	    List<String> eList = d.listOftopic.stream().map(s->s.getText()).limit(3).collect(Collectors.toList());
	    driver.navigate().back();
	    j.executeScript("arguments[0].scrollIntoView(true)",h.discussionBoard);
	    List<String> aList = h.topThreeDiscussion.stream().map(s->s.getText()).collect(Collectors.toList());
	    Assert.assertEquals(aList, eList);
	    
	}
	
	
	/* verify that dropdown conatains my profile, referrals, Blogs, Rewards, Setting, Logout*/
//	@Test(priority=8)
	public void validateDropDownOptions() throws InterruptedException
	{
		Thread.sleep(5000);
		h.getDropDown();
		h.checkDropDownOptions();
	}
	
	
	



}
