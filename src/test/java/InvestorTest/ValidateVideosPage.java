package InvestorTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import Generic.Base;
import PageObject_Investor.DiscussionBoardPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.PickRightHomePage;
import PageObject_Investor.VideosPage;

public class ValidateVideosPage extends Base {
	EnterOtpPage e;
	DiscussionBoardPage d;
	VideosPage v;
	String number="6360245606";
	String videoTitle="Video test";

	
	/* verify that when user clicks on videos, page displayed search topic, upload feature*/
	@Test(priority=1)
	public void validateSeachTopicAndUpdateIsDisplayed()
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
	//	e.getCheckBox(driver);
		e.getNextButton();
		HomePage h=new HomePage(driver);
		h.getVideos(driver);
		 v=new VideosPage(driver);
	//	 v.checkSearchTopicAndUploadObjectsAreDisplayed();
		Assert.assertTrue(v.searchTopicField.isDisplayed());
		Assert.assertTrue(v.upload.isDisplayed());
		 
		
	}
	
	/* verify that video is successfully uploaded to the right topic and sorted*/
	@Test(priority=2)
	public void validateSuccessfullVideoUpload() throws IOException, InterruptedException, AWTException
	{
		
		/*v.getUpload();
		v.setTitle("test");
		v.setTopic("test");
		String s = v.getTopicOptions();
		System.out.println(s);
		v.getUploadVideo();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\AutoITScript\\videoupload.exe");
		Thread.sleep(4000);
		v.getUploadv();
		v.checkSuccessfullMsgDisplayed();
		v.checkTopicName(s);*/
		v.upload.click();
		v.titleField.sendKeys(videoTitle);
		v.topicField.sendKeys("TCS");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		WebDriverWait wait2=new WebDriverWait(driver,10);
		wait2.until(ExpectedConditions.visibilityOfAllElements(v.topicOptions));
		String selectedTopic = v.topicOptions.get(5).getText();
		v.topicOptions.get(5).click();
		v.uploadVideo.click();
		Thread.sleep(4000);
		Runtime.getRuntime().exec("C:\\AutoITScript\\videoupload.exe");
		Thread.sleep(3000);
		v.uploadv.click();
		Thread.sleep(2000);
		WebDriverWait wait1=new WebDriverWait(driver,20);
		wait1.until(ExpectedConditions.elementToBeClickable(v.topicNames.get(0)));
		Assert.assertTrue(v.msg.getText().equalsIgnoreCase("Posts Created Successfully!"));
		System.out.println(selectedTopic);
		Thread.sleep(10000);
		List<String> etopFiveTopic = v.topics.stream().map(s->s.getText()).limit(5).collect(Collectors.toList());
		String efirsttopic = v.topicNames.get(0).getText();
		Thread.sleep(3000);
		Assert.assertTrue(v.topicNames.get(0).getText().replace("#","").equalsIgnoreCase(selectedTopic));
		Assert.assertTrue(v.allUploadedVideos.get(0).isDisplayed());
		Assert.assertTrue(v.likeImage.get(0).isDisplayed());
		Assert.assertFalse(v.likeImage.get(0).getAttribute("src").contains("red-heart"));
		Assert.assertTrue(v.likeCount.get(0).getText().equals("0"));
		Assert.assertTrue(v.commentImage.get(0).isDisplayed());
		Assert.assertTrue(v.commentCount.get(0).getText().equals("0"));
		v.viewAll.get(0).click();
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(v.allUploadedVideos.get(0)));
		v.allUploadedVideos.get(0).click();
		WebDriverWait wait3=new WebDriverWait(driver,30);
		wait3.until(ExpectedConditions.visibilityOfAllElements(v.topFiveTopicInVideo));
		Assert.assertTrue(v.videoTitle.get(0).getText().equalsIgnoreCase(videoTitle));
		Assert.assertTrue(v.follow.get(0).isDisplayed());
	/*	System.out.println(v.follow.get(0).getText());
		if(v.follow.get(0).getText().equalsIgnoreCase("+ Follow"))
		{
			v.follow.get(0).click();
			driver.navigate().refresh();
			v.allUploadedVideos.get(0).click();
			WebDriverWait wait4=new WebDriverWait(driver,20);
			wait4.until(ExpectedConditions.visibilityOf(v.follow.get(0)));
			System.out.println(v.follow.get(0).getText());
			Assert.assertTrue(v.follow.get(0).getText().equalsIgnoreCase("Unfollow"));
		}
		if(v.follow.get(0).getText().equalsIgnoreCase("Unfollow"))
		{
			v.follow.get(0).click();
		    driver.navigate().refresh(); 
		    v.allUploadedVideos.get(0).click();
		    WebDriverWait wait4=new WebDriverWait(driver,20);
			wait4.until(ExpectedConditions.visibilityOf(v.follow.get(0)));
		    System.out.println(v.follow.get(0).getText());
			Assert.assertTrue(v.follow.get(0).getText().equalsIgnoreCase("+ Follow"));
		}*/
		Assert.assertTrue(v.views.get(0).isDisplayed());
		Assert.assertTrue(v.share.get(0).isDisplayed());
		List<String> atopFiveTopicsInVideo = v.topFiveTopicInVideo.stream().map(s->s.getText()).collect(Collectors.toList());
		Assert.assertEquals(atopFiveTopicsInVideo, etopFiveTopic);
		Assert.assertTrue(v.topFiveTopicInVideo.get(0).getText().equalsIgnoreCase(efirsttopic));
		Assert.assertTrue(v.activeTopicInVideo.get(0).getAttribute("class").contains("active"));
		String cmt="very good";
		v.commentField.sendKeys(cmt);
		v.commentSendButton.click();
	//	Thread.sleep(5000);
		WebDriverWait wait5=new WebDriverWait(driver,10);
		wait5.until(ExpectedConditions.visibilityOfAllElements(v.commentedText));
		System.out.println(v.commentedText.get(0).getText());
		Assert.assertTrue(v.commentedText.get(0).getText().equals(cmt));
		int comments = v.commentedText.size();
		System.out.println(comments);
		v.videoCloseButton.click();
		d=new DiscussionBoardPage(driver);
		d.back.click();
		WebDriverWait wait4=new WebDriverWait(driver,10);
		wait4.until(ExpectedConditions.visibilityOfAllElements(v.topicNames));
		Thread.sleep(3000);
		Assert.assertTrue(v.commentCount.get(0).getText().equals(String.valueOf(comments)));
		
	
	}
	
	
	
	
	

}
