package PageObject_Investor;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VideosPage {
	
	@FindBy(xpath="//input[@placeholder='Search Topic']")
	public WebElement searchTopicField;
	
	@FindBy(xpath="//a[text()='UPLOAD']")
	public WebElement upload;
	
	@FindBy(xpath="//input[@formcontrolname='title']")
	public WebElement titleField;
	
	@FindBy(xpath="//input[@formcontrolname='topic']")
	public WebElement topicField;
	
	@FindBy(xpath="//span[@class='mat-option-text' and contains(text(),'TC')]")
	public List<WebElement> topicOptions;
	
	@FindBy(xpath="//p[text()='Upload Video']")
	public WebElement uploadVideo;
	
	@FindBy(xpath="//span[text()='Upload']")
	public WebElement uploadv;
	
	@FindBy(xpath="//div[@class='f-r center between mb15']/h4")
	public List<WebElement> topicNames;
	
	@FindBy(xpath = "//div[@class='alert_heading']")
	public WebElement msg;
	
	@FindBy(xpath="//div[@class='f-r center between mb15']/h4")
	public List<WebElement> topics;
	
	@FindBy(xpath="//div[@class='f-r center between mb15']/a")
	public List<WebElement> viewAll;
	
	@FindBy(xpath="//div[@class='f-r center mr15']/img")
	public List<WebElement> likeImage;
	
	@FindBy(xpath="//div[@class='f-r center mr15']/p")
	public List<WebElement> likeCount;
	
	@FindBy(xpath="(//div[@class='f-r center mr15'])[2]/img")
	public List<WebElement> commentImage;
	
	@FindBy(xpath="//textarea[@id='commentText0']")
	public WebElement commentField;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement commentSendButton;
	
	@FindBy(xpath="(//div[@class='all-comments'])[1]//p")
	public List<WebElement> commentedText;
	
	@FindBy(xpath="//div[@class='f-r center reaction']/div[@class='f-r center']/p")
	public List<WebElement> commentCount;
	
	@FindBy(xpath = "//div[@class='name f-r column']/p")
	public WebElement userName;
	
	@FindBy(xpath = "//p[@class='desc']")
	public List<WebElement> videoTitle;
	
	@FindBy(xpath = "//div[@class='f-r center']/h5/following-sibling::h5")
	public List<WebElement> follow;
	
	@FindBy(xpath = "//div[@class='f-r between center reaction']//p[contains(text(),'Views')]")
	public List<WebElement> views;
	
	@FindBy(xpath="//div[@class='f-r between center reaction']//p[contains(text(),'Views')]/following-sibling::img")
	public List<WebElement> share;
	
	@FindBy(xpath="(//div[@class='f-r center scripwrap'])[1]/div/p")
	public List<WebElement> topFiveTopicInVideo;
	
	@FindBy(xpath="(//div[@class='f-r center scripwrap'])[1]/div")
	public List<WebElement> activeTopicInVideo;
	
	@FindBy(xpath="//video")
	public List<WebElement> allUploadedVideos;
	
	@FindBy(xpath="//div[@class='close']/img")
	public WebElement videoCloseButton;
	
	public VideosPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void getUpload()
	{
		upload.click();
	}
	
	public void setTitle(String tit)
	{
		titleField.sendKeys(tit);
	}
	
	public void setTopic(String t)
	{
		topicField.sendKeys(t);
	}
	
	public String getTopicOptions()
	{
		String selectedTopic=topicOptions.get(1).getText();
		topicOptions.get(1).click();
		return selectedTopic;
	}
	
	public void getUploadVideo()
	{
		uploadVideo.click();
	}
	
	public void getUploadv()
	{
		uploadv.click();
	}
	
	public void checkTopicName(String eTopicName)
	{
		
	//	Assert.assertTrue(topicName.getText().replace("#","").equalsIgnoreCase(eTopicName));
	}
	
	public void checkSuccessfullMsgDisplayed()
	{
		
		Assert.assertTrue(msg.getText().equalsIgnoreCase("Posts Created Successfully!"));
	}
	
	public void checkSearchTopicAndUploadObjectsAreDisplayed()
	{
		searchTopicField.isDisplayed();
		upload.isDisplayed();
	}

}
