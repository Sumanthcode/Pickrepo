package PageObject_Investor;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DiscussionBoardPage {

	@FindBy(xpath = "(//div[@class='f-r f1 column align-start']/h2)[1]")
	public WebElement anyDiscussion;
	
	@FindBy(xpath = "//div[@class='f-r f1 column align-start']/h2")
	public List<WebElement> listOftopic;
	
	@FindBy(xpath = "//div[@class='f-r center']/h4")
	public WebElement topicNameInsideTheDiscussion;;
	

	@FindBy(xpath = "//video[@id='allVideoplayer']")
	public List<WebElement> anyVideo;

	@FindBy(xpath = "//img[@src='assets/new-images/icon-attachment.svg']")
	public WebElement attach;

	@FindBy(xpath = "//button[text()=' Document ']")
	public WebElement document;

	@FindBy(xpath = "//div[@class='action f-r center']")
	public WebElement send;

	@FindBy(xpath = "//div[@class='media-file f-r full mb10 ng-star-inserted']/a")
	public WebElement documentObject;

	@FindBy(xpath = "//div[@class='alert_heading']")
	public WebElement msg;
	
	@FindBy(xpath="//span[@class='error ng-star-inserted']")
	public WebElement error;

	@FindBy(xpath = "//button[text()=' Image ']")
	public WebElement image;

	@FindBy(xpath = "//button[text()='Video ']")
	public WebElement video;

	@FindBy(xpath = "//input[@formcontrolname='title']")
	public WebElement videoTitleField;

	@FindBy(xpath = "//p[@class='desc']")
	public WebElement videoTitle;

	@FindBy(xpath = "//div[@class='f-r center c-center upload ng-star-inserted']/p")
	public WebElement uploadVideo;

	@FindBy(xpath = "//div[@class='videoPlayer']")
	public List<WebElement> uploadedVideoInPostSection;

	@FindBy(xpath = "//div[@class='tab f-r center ng-star-inserted']/span/following-sibling::span")
	public WebElement videosSection;

	@FindBy(xpath = "//div[@class='f-r center between']/button/following-sibling::button")
	public WebElement upload;

	@FindBy(xpath = "//button[@class='mat-focus-indicator cancel mat-button mat-button-base']/span")
	public WebElement videoCancelButton;

	@FindBy(id = "postInput")
	public WebElement postInput;

	@FindBy(xpath = "(//div[@class='f-r f1 full column align-start'])[1]/div[@class='media-file f-r full mb10 ng-star-inserted']/img")
	public WebElement imageObject;

	@FindBy(xpath = "//div[@class='desc mb10 ng-star-inserted']")
	public WebElement description;

	@FindBy(xpath = "//a[contains(text(),'Create')]")
	public WebElement create;

	@FindBy(xpath = "//img[@class='back']")
	public WebElement back;

	@FindBy(xpath = "//input[@formcontrolname='title']")
	public WebElement titleField;

	@FindBy(xpath = "//textarea[@formcontrolname='desc']")
	public WebElement descriptionField;

	@FindBy(xpath = "//button[@type='button']")
	public WebElement createNewTopicSendButton;

	@FindBy(xpath = "//div[@class='tab f-r center']/span/following-sibling::span[text()='My Topic']")
	public WebElement myTopic;

	@FindBy(xpath = "//div[@class='tab f-r center']/span/following-sibling::span[text()='Recent Topic']")
	public WebElement recentTopic;

	@FindBy(xpath = "//div[@class='tab f-r center']/span")
	public WebElement recentDiscussed;

	@FindBy(xpath = "//div[@class='f-r f1 column align-start']/h2")
	public WebElement createdTopic;

	@FindBy(xpath = "//div[@class='f-r f1 column align-start']/p")
	public WebElement createdTopicDescription;

	@FindBy(xpath = "//div[@class='name f-r column']/p")
	public WebElement userName;

	@FindBy(xpath = "//div[@class='name']")
	public WebElement userNameOnTopic;

	@FindBy(xpath = "//div[@class='f-r center']/span")
	public WebElement date;

	@FindBy(xpath = "//div[@class='list-item topicData ng-star-inserted']/span")
	public WebElement insidePostCountTitle;

	@FindBy(xpath = "(//div[@class='f-r f1 column align-start'])[1]/span")
	public WebElement outsidePostCountTitle;

	@FindBy(xpath = "//div[@class='list-item f-r center full ng-star-inserted']")
	public List<WebElement> postCount;

	@FindBy(xpath = "//span[text()='Posts']")
	public WebElement posts;

	@FindBy(xpath = "//div[@class='close']")
	public WebElement close;
	
	@FindBy(xpath="//a[@class='close-btn']")
	public WebElement topicCloseButton;

	@FindBy(xpath = "//a[@class='close-btn']")
	public WebElement createTopicCloseButton;

	@FindBy(xpath = "//div[@class='f-r column full']/a")
	public WebElement follow;
	
	@FindBy(xpath="//div[@class='f-r f1 full column align-start']/div[@class='l-c f-r center']/div")
	public WebElement like;
	
	@FindBy(xpath="//div[@class='f-r f1 full column align-start']/div[@class='l-c f-r center']/div/img")
	public WebElement likeImage;
	
	@FindBy(xpath="//div[@class='f-r f1 full column align-start']/div[@class='l-c f-r center']/div/following-sibling::div")
	public WebElement comment;
	
	@FindBy(xpath="//div[@class='f-r column full']//h6[text()='Sumanth investor']")
	public List<WebElement> listOfUsers;

	public DiscussionBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void getanyDiscussion() {
		anyDiscussion.click();
	}

	public void getAttach() {
		attach.click();
	}

	public void getDocument() {
		document.click();

	}

	public void getSend() {
		send.click();
	}

	public void getUpload() {
		upload.click();
	}

	public void checkDocIsUploaded() {

		Assert.assertTrue(posts.getAttribute("class").equals("active"));
		Assert.assertTrue(documentObject.isDisplayed());
		Assert.assertTrue(msg.getText().equalsIgnoreCase("Posts Created Successfully!"));
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy, hh:mma");
		String strDate = formatter.format(d);
		System.out.println(strDate);
		System.out.println(date.getText());
		Assert.assertTrue(date.getText().equals(strDate));
		Assert.assertTrue(follow.isDisplayed());

	}

	public void getImage() {
		image.click();
	}

	public void getVideo() {
		video.click();
	}

	public void setVideoTitleField(String t) {
		videoTitleField.sendKeys(t);
	}

	public void getVideoCancelButton() {
		videoCancelButton.click();
	}

	public void setPostInput(String input) {
		postInput.sendKeys(input);
	}

	public void checkImageIsUploadedWithDescription(WebDriver driver) {
		Assert.assertTrue(posts.getAttribute("class").equals("active"));
		WebDriverWait wait1 = new WebDriverWait(driver, 3);
		wait1.until(ExpectedConditions.visibilityOf(imageObject));
		Assert.assertTrue(imageObject.isDisplayed());
		Assert.assertTrue(msg.getText().equalsIgnoreCase("Posts Created Successfully!"));
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(description));
		Assert.assertTrue(description.getText().equalsIgnoreCase("just for testing"));
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy, hh:mma");
		String strDate = formatter.format(d);
		System.out.println(strDate);
		System.out.println(date.getText());
		Assert.assertTrue(date.getText().equals(strDate));

	}

	public void getMyTopic() {
		myTopic.click();
	}

	public void getBack() {
		back.click();
	}

	public void getCreate() {
		create.click();
	}

	public void setTitleField(String t) {
		titleField.sendKeys(t);
	}

	public void setDescriptionField(String d) {
		descriptionField.sendKeys(d);
	}

	public void getCreateNewTopicSendButton() {
		createNewTopicSendButton.click();
	}

	public void checkDiscussionIsCreatedSuccessfully(String eTopic, String eDesc) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(msg.getText().equalsIgnoreCase("Topic Created Successfully!"));
		Thread.sleep(3000);
		myTopic.click();
		Thread.sleep(2000);
		Assert.assertTrue(myTopic.getAttribute("class").equalsIgnoreCase("active"));
		System.out.println(eTopic);
		System.out.println(createdTopic.getText().replace("#", ""));
		Thread.sleep(2000);
		Assert.assertTrue(createdTopic.getText().replace("#", "").equalsIgnoreCase(eTopic));
		Assert.assertTrue(createdTopicDescription.getText().equalsIgnoreCase(eDesc));

	}

	public void checkRecenttopicNameInRecentTopicPage(String eTopic, String eDesc) {
		recentTopic.click();
		Assert.assertTrue(recentTopic.getAttribute("class").equals("active"));
		Assert.assertTrue(createdTopic.getText().replace("#", "").equalsIgnoreCase(eTopic));
		Assert.assertTrue(createdTopicDescription.getText().equalsIgnoreCase(eDesc));

	}

	public void checkUserNameAndNumberOfPostBeforeCreatingPost() {
		String expectedUserName = userName.getText();
		String actualUserName = userNameOnTopic.getText();
		Assert.assertEquals(expectedUserName, actualUserName);
		/*
		 * Date d = new Date(); SimpleDateFormat formatter = new
		 * SimpleDateFormat("dd MMM yyyy, hh:mm a"); String strDate =
		 * formatter.format(d); System.out.println(strDate);
		 * System.out.println(date.getText());
		 * Assert.assertTrue(date.getText().equals(strDate));
		 */
		Assert.assertTrue(outsidePostCountTitle.getText().equalsIgnoreCase("0 Posts"));

	}

	public void checkPostCountAfterPostsCreation() {

		Assert.assertTrue(posts.getAttribute("class").equals("active"));
		String count = String.valueOf(postCount.size());
		Assert.assertTrue(insidePostCountTitle.getText().contains(count));
		back.click();
		// myTopic.click();
		Assert.assertTrue(outsidePostCountTitle.getText().contains(count));

	}

	public void checkTopicNameAndPostAndPostCountInRecentDiscussed(String eTopic, String eDesc) {

		Assert.assertTrue(recentDiscussed.getAttribute("class").equals("active"));
		Assert.assertTrue(createdTopic.getText().replace("#", "").equalsIgnoreCase(eTopic));
		Assert.assertTrue(createdTopicDescription.getText().equalsIgnoreCase(eDesc));
		anyDiscussion.click();
		Assert.assertTrue(posts.getAttribute("class").equals("active"));
		Assert.assertTrue(imageObject.isDisplayed());
		Assert.assertTrue(description.getText().equalsIgnoreCase("just for testing"));
		Assert.assertTrue(documentObject.isDisplayed());
		String count = String.valueOf(postCount.size());
		Assert.assertTrue(insidePostCountTitle.getText().contains(count));
		back.click();
		// myTopic.click();
		Assert.assertTrue(outsidePostCountTitle.getText().contains(count));

	}

/*	public void checkImageAndDocUploadedWithDescriptionInRecentDiscussedPage() {
		Assert.assertTrue(posts.getAttribute("class").equals("active"));
		Assert.assertTrue(imageObject.isDisplayed());
		Assert.assertTrue(description.getText().equalsIgnoreCase("just for testing"));
		Assert.assertTrue(documentObject.isDisplayed());
	}*/

	public void checkPostCountAndPostUploadedWithDescriptionInRecentTopic(String eTopic, String eDesc) {
		recentTopic.click();
		Assert.assertTrue(recentTopic.getAttribute("class").equals("active"));
		Assert.assertTrue(createdTopic.getText().replace("#", "").equalsIgnoreCase(eTopic));
		Assert.assertTrue(createdTopicDescription.getText().equalsIgnoreCase(eDesc));
		anyDiscussion.click();
		Assert.assertTrue(imageObject.isDisplayed());
		Assert.assertTrue(description.getText().equalsIgnoreCase("just for testing"));
		Assert.assertTrue(documentObject.isDisplayed());
		String count = String.valueOf(postCount.size());
		Assert.assertTrue(insidePostCountTitle.getText().contains(count));
		back.click();
		recentTopic.click();
		Assert.assertTrue(outsidePostCountTitle.getText().contains(count));

	}

	public void checkVideoUploadedSuccessfullyInPostAndVideoSection(String title)
			throws IOException, InterruptedException {
		recentDiscussed.click();
		anyDiscussion.click();
		attach.click();
		video.click();
		videoTitleField.sendKeys(title);
		uploadVideo.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\AutoITScript\\videoupload.exe");
		Thread.sleep(4000);
		upload.click();
		Assert.assertTrue(msg.getText().equalsIgnoreCase("Posts Created Successfully!"));
		Assert.assertTrue(posts.getAttribute("class").equals("active"));
		Assert.assertTrue(uploadedVideoInPostSection.get(0).isDisplayed());
		videosSection.click();
		Assert.assertTrue(videosSection.getAttribute("class").equals("active"));
		anyVideo.get(0).click();
		Assert.assertTrue(videoTitle.getText().equalsIgnoreCase(title));
		Thread.sleep(3000);
		close.click();
		back.click();
	}

	public void getTitleAlreadyExistsErrorMsgTitle() {
		Assert.assertTrue(msg.getText().equalsIgnoreCase("Title Already Exists!"));
		createTopicCloseButton.click();
	}

	public void getTitleIsRequiredErrorMsgTitle() {
		Assert.assertTrue(msg.getText().equalsIgnoreCase("Title Is Required"));
	}

	public void getUploadAVideoErrorMsgTitle() {
		Assert.assertTrue(msg.getText().equalsIgnoreCase("Upload A Video"));
	}

	public void checkClickOnCancelButtonShowsTopicPage() {

		Assert.assertTrue(posts.isDisplayed());
		Assert.assertTrue(videosSection.isDisplayed());
		back.click();
	}

}
