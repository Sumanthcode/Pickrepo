package InvestorTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic.Base;
import PageObject_Investor.DiscussionBoardPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.PickRightHomePage;
import PageObject_Investor.VideosPage;

public class ValidatediscussionBoardPage extends Base {

	EnterOtpPage e;
	DiscussionBoardPage d;
	HomePage h;
	String number="6360245606";
	String topicName="Test db105";
	String topicDesc="Hello, this is for testing";
	/* verify that topic created successfully in the my topic page */
	@Test(priority=1,enabled=true)
	public void validateSuccessfullCreationOfDiscussion() throws InterruptedException
	{
		
		/*PickRightHomePage p = new PickRightHomePage(driver);
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
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(1500,0)");
		h.getDiscussionBoard();
		d=new DiscussionBoardPage(driver);
		d.getCreate();
		d.setTitleField(topicName);
		d.setDescriptionField(topicDesc);
		d.getCreateNewTopicSendButton();
		d.checkDiscussionIsCreatedSuccessfully(topicName,topicDesc);*/
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
		h=new HomePage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(1500,0)");
		h.discussion.click();
		d=new DiscussionBoardPage(driver);
		WebDriverWait wait=new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.visibilityOf(d.create));
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(d.recentDiscussed.getAttribute("class").equals("active"));
		sa.assertFalse(d.recentTopic.getAttribute("class").equals("active"));
		sa.assertFalse(d.myTopic.getAttribute("class").equals("active"));
		d.create.click();
		d.titleField.sendKeys(topicName);
		d.descriptionField.sendKeys(topicDesc);
		d.createNewTopicSendButton.click();
		Thread.sleep(2000);
		Assert.assertTrue(d.msg.getText().equalsIgnoreCase("Topic Created Successfully!"));
		d.myTopic.click();
		sa.assertTrue(d.myTopic.getAttribute("class").equals("active"));
		sa.assertTrue(d.createdTopic.getText().replace("#","").equalsIgnoreCase(topicName));
		sa.assertTrue(d.createdTopicDescription.getText().equalsIgnoreCase(topicDesc));
		sa.assertTrue(d.outsidePostCountTitle.getText().equalsIgnoreCase("0 Posts"));
		sa.assertTrue(d.userName.getText().equalsIgnoreCase(d.userNameOnTopic.getText()));
		d.recentTopic.click();
		sa.assertTrue(d.recentTopic.getAttribute("class").equals("active"));
		sa.assertTrue(d.createdTopic.getText().replace("#","").equalsIgnoreCase(topicName));
		sa.assertTrue(d.createdTopicDescription.getText().equalsIgnoreCase(topicDesc));
		sa.assertTrue(d.outsidePostCountTitle.getText().equalsIgnoreCase("0 Posts"));
		sa.assertAll();
	}
	
	
	/*verify that pdf file is uploaded successfully with time of upload and follow button*/
	@Test(priority=2,enabled=true)
	public void validateSuccessfullDocUpload() throws InterruptedException, IOException
	{
		/*d.getMyTopic();
		
		d.getanyDiscussion();
		d.getAttach();
		
		d.getDocument();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\AutoITScript\\fileupload.exe");
		Thread.sleep(3000);
		d.getSend();
		d.checkDocIsUploaded();*/
		d.myTopic.click();
		d.anyDiscussion.click();
//		SoftAssert sa=new SoftAssert();
		Assert.assertTrue(d.posts.getAttribute("class").equals("active"));
		Assert.assertFalse(d.videosSection.getAttribute("class").equals("active"));
		Assert.assertTrue(d.insidePostCountTitle.getText().equalsIgnoreCase("0 Posts"));
		d.attach.click();
		d.document.click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\AutoITScript\\fileupload.exe");
		Thread.sleep(3000);
		d.send.click();
		Assert.assertTrue(d.msg.getText().equalsIgnoreCase("Posts Created Successfully!"));
		Assert.assertTrue(d.documentObject.isDisplayed());
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy,hh:mma");
		String strDate = formatter.format(date);
		Assert.assertTrue(d.date.getText().equals(strDate));
		Assert.assertTrue(d.follow.isDisplayed());
		Assert.assertTrue(d.like.isDisplayed());
		Assert.assertFalse(d.likeImage.getAttribute("src").contains("red"));
		Assert.assertTrue(d.like.getText().equals("0"));
		Assert.assertTrue(d.comment.isDisplayed());
		Assert.assertTrue(d.comment.getText().equals("0"));
		Assert.assertTrue(d.postCount.size()==Integer.parseInt(d.insidePostCountTitle.getText().split(" ")[0]));
		
		
		
	}
	/* verify that image is uploaded successfully with description */
	@Test(priority=3,enabled=true)
	public void validateSuccessfullImageUpload() throws InterruptedException, IOException
	{
		
		/*d.getAttach();
		d.getImage();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\AutoITScript\\Imageupload.exe");
		Thread.sleep(3000);
		d.setPostInput("just for testing");
		d.getSend();
		d.checkImageIsUploadedWithDescription(driver);*/
		d.attach.click();
		d.image.click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\AutoITScript\\Imageupload.exe");
		Thread.sleep(3000);
		d.postInput.sendKeys("just for testing");
		d.send.click();
		Assert.assertTrue(d.msg.getText().equalsIgnoreCase("Posts Created Successfully!"));
		WebDriverWait wait=new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.visibilityOf(d.imageObject));
		Assert.assertTrue(d.imageObject.isDisplayed());
		Assert.assertTrue(d.description.getText().equalsIgnoreCase("just for testing"));
		Assert.assertTrue(d.postCount.size()==Integer.parseInt(d.insidePostCountTitle.getText().split(" ")[0]));
		
		
	}
	
	/* verify that recently created topic with post is displayed in recent discussed page as a first topic*/
	@Test(priority=5,enabled=true)
	public void validateCreatedTopicNameAndPostAndPostCountInRecentDiscussedPage()
	{
		
	//	d.checkTopicNameAndPostAndPostCountInRecentDiscussed(topicName,topicDesc);
		Assert.assertTrue(d.createdTopic.getText().replace("#","").equalsIgnoreCase(topicName));
		d.anyDiscussion.click();
        Assert.assertTrue(d.postCount.size()==Integer.parseInt(d.insidePostCountTitle.getText().split(" ")[0]));
        int videoCountInPostSection = d.uploadedVideoInPostSection.size();
        d.videosSection.click();
        Assert.assertTrue(d.anyVideo.size()==videoCountInPostSection);
        d.back.click();
        
	}
	
	/*verify the posts and posts countin recent discussed page*/
/*	@Test(priority=9,enabled=false)
	public void validatePostAndPostCountInRecentDiscussedPage()
	{
		d.getanyDiscussion();
		d.checkImageAndDocUploadedWithDescriptionInRecentDiscussedPage();
		d.checkPostCountAfterPostsCreation();
		
	}*/
	/* verify that post are uploaded in recent topic page and verify the count as well*/
	@Test(priority=6,enabled=true)
	public void validatePostAndPostCountInRecentTopicPage()
	{
//		d.checkPostCountAndPostUploadedWithDescriptionInRecentTopic(topicName, topicDesc);
		d.recentTopic.click();
		Assert.assertTrue(d.createdTopic.getText().replace("#","").equalsIgnoreCase(topicName));
		d.anyDiscussion.click();
        Assert.assertTrue(d.postCount.size()==Integer.parseInt(d.insidePostCountTitle.getText().split(" ")[0]));
        int videoCountInPostSection = d.uploadedVideoInPostSection.size();
        d.videosSection.click();
        Assert.assertTrue(d.anyVideo.size()==videoCountInPostSection);
        d.back.click();
		
	}
	
	/* verify video is uploaded successfully with title in both post and videos section with sorted*/
	@Test(priority=4,enabled=true)
	public void validateVideoUploadedWithDescription() throws IOException, InterruptedException
	{
		//d.checkVideoUploadedSuccessfullyInPostAndVideoSection("testing");
		d.attach.click();
		d.video.click();
		d.videoTitleField.sendKeys("testing");
		d.uploadVideo.click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\AutoITScript\\videoupload.exe");
		Thread.sleep(3000);
		d.upload.click();
		while(true)
		{
			if(d.upload.getAttribute("class").contains("disabled"))
			{
				continue;
			}
			else
				break;
		}
		Assert.assertTrue(d.uploadedVideoInPostSection.get(0).isDisplayed());
		Assert.assertTrue(d.postCount.size()==Integer.parseInt(d.insidePostCountTitle.getText().split(" ")[0]));
		int videoCountInPostSection = d.uploadedVideoInPostSection.size();
		d.videosSection.click();
		d.anyVideo.get(0).click();
		Assert.assertTrue(d.videoTitle.getText().equalsIgnoreCase("testing"));
		Thread.sleep(3000);
		d.close.click();
	    Assert.assertTrue(d.anyVideo.size()==videoCountInPostSection);
	    d.back.click();
	   
	    
		
	}
	/* verify that video is populated in videos page under the topic */
	@Test(priority=7,enabled=true)
	public void validateVideoinVideosPage()
	{
		driver.navigate().back();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",h.videos);
		WebDriverWait wait1=new WebDriverWait(driver,3);
		wait1.until(ExpectedConditions.visibilityOf(h.videos));
		h.videos.click();
		VideosPage v=new VideosPage(driver);
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(v.topics.get(0)));
		Assert.assertTrue(v.topics.get(0).getText().replace("#","").equalsIgnoreCase(topicName));
		v.viewAll.get(0).click();
		Assert.assertTrue(d.videosSection.getAttribute("class").equals("active"));
		d.anyVideo.get(0).click();
		Assert.assertTrue(d.videoTitle.getText().equalsIgnoreCase("testing"));
		d.close.click();
		driver.navigate().back();
		driver.navigate().back();
		
		
		
	}
	
	/* verify that when user try to create topic title which is already exists, title already exist error msg is displayed*/
	@Test(priority =8,enabled=true)
	public void validateTopicTitleAlreadyExistsErrorMsg()
	{
		/*d.getCreate();
		d.setTitleField(topicName);
		d.getCreateNewTopicSendButton();
		d.getTitleAlreadyExistsErrorMsgTitle();*/
		h.discussion.click();
		d.create.click();
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(d.createNewTopicSendButton));
		d.titleField.sendKeys(topicName);
		d.descriptionField.sendKeys(topicDesc);
		d.createNewTopicSendButton.click();
		WebDriverWait wait1=new WebDriverWait(driver,20);
		wait1.until(ExpectedConditions.visibilityOf(d.msg));
		d.msg.getText().equalsIgnoreCase("Title Already Exists!");
		d.topicCloseButton.click();
		
		
		
	}
	
	/* verify that while uploading video without title, title is required error msg is displayed*/
	@Test(priority=9,enabled=true)
	public void validateTitleIsRequiredErrorMsgInTopicCreation()
	{
		/*d.getanyDiscussion();
		d.getAttach();
		d.getVideo();
		d.getUpload();
		d.getTitleIsRequiredErrorMsgTitle();*/
		d.create.click();
		d.titleField.click();
		d.createNewTopicSendButton.click();
		Assert.assertTrue(d.error.getText().equalsIgnoreCase("Title Is Required."));
		d.topicCloseButton.click();
		
		
	}
	
	@Test(priority=10,enabled=true)
	public void validateTitleIsRequiredErrorMsgInVideoUpload()
	{
		d.anyDiscussion.click();
		d.attach.click();
		d.video.click();
		d.upload.click();
		Assert.assertTrue(d.msg.getText().equalsIgnoreCase("Title Is Required"));
		d.videoCancelButton.click();
		
	}

	
	/* verify that while uploading video without video, Upload video error msg is displayed*/
	@Test(priority=11,enabled=true)
	public void validateUploadVideoErrorMsg()
	{
		/*d.setVideoTitleField("hello");
		d.getUpload();
		d.getUploadAVideoErrorMsgTitle();*/
		d.attach.click();
		d.video.click();
		d.videoTitleField.sendKeys("Hello");
		d.upload.click();
		Assert.assertTrue(d.msg.getText().equalsIgnoreCase("Upload A Video"));
		d.videoCancelButton.click();
	}
	/* verify that when clicks on cancel video button, topic page is displayed*/
	@Test(priority=12,enabled=true)
	public void validateTopicPageAfterCancelVideo()
	{
		/*d.getVideoCancelButton();
		d.checkClickOnCancelButtonShowsTopicPage();*/
		d.attach.click();
		d.video.click();
		d.videoCancelButton.click();
		d.back.click();
		Assert.assertTrue(d.create.isDisplayed());
	}
	
//	@Test(enabled=true)
	public void validatePostCountInDiscussionBoardAndUserprofilePage() throws InterruptedException
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
		h=new HomePage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(1500,0)");
		h.discussion.click();
		d=new DiscussionBoardPage(driver);
		WebDriverWait wait=new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.visibilityOf(d.create));
		int count=0;
		
		//(//div[@class='f-r f1 column align-start']/h2)[last()]
		
		Thread.sleep(2000);
		List<WebElement> newList = driver.findElements(By.xpath("(//div[@class='f-r f1 column align-start']/h2)"));
		int size1 = newList.size();
		
		while(true)
		{
			int a=0;
			for(int i=a;i<d.listOftopic.size();i++)
			{
				d.listOftopic.get(i).click();
				Thread.sleep(1000);
				d.back.click();
				System.out.println(i);
			}
			
			
			
			WebElement w = driver.findElement(By.xpath("(//div[@class='f-r f1 column align-start']/h2)[last()]"));
			Thread.sleep(1000);
			js.executeScript("arguments[0].scrollIntoView(true)", w);
			Thread.sleep(3000);
			List<WebElement> newList2 = driver.findElements(By.xpath("(//div[@class='f-r f1 column align-start']/h2)"));
			if(newList2.size()==size1)
			{
				break;
			}
			size1=newList2.size();
			
		}
		
		
		
		
		
		
		//System.out.println(d.listOftopic.size());
		/*for(int i=d.listOftopic.size()-1;i>=0;i--)
		{
			System.out.println(d.listOftopic.get(i).getText());
			d.listOftopic.get(i).click();
			count= count+d.listOfUsers.size();
			d.back.click();
		
		}*/
		
		//System.out.println(count);
	
		
	}
}
