package PageObject_Investor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContestPage {

	@FindBy(xpath="//div[contains(text(),'Predict')]/img")
	public WebElement predictNifty;
	
	@FindBy(xpath="//div[contains(text(),'Top Stock')]/img")
	public WebElement pickTopStock;
	
	@FindBy(xpath="//div[@class='f-r center between nifty']//div/h4")
	public WebElement todaysNiftyValue;
	
	@FindBy(xpath="//div[@class='f-r center history']/span")
	public WebElement historyWinnings;
	
	@FindBy(xpath="//app-nifty-contest-detail/div[contains(text(),'Open')]")
	public WebElement openForParticipationTitile;
	
	@FindBy(xpath="//app-nifty-contest-detail/div[contains(text(),'Closed')]")
	public WebElement recentlyClosedTitle;
	
	@FindBy(xpath="//app-nifty-contest-detail/div[contains(text(),'Closed')]/..//p[@class='mr10']")
	public WebElement leaderBoard;
	
	@FindBy(xpath="//app-nifty-contest-detail/div[contains(text(),'Open')]/..//div[@class='date f-r center column']/span")
	public WebElement dateForOpenForParticipation;
	
	@FindBy(xpath="//app-nifty-contest-detail/div[contains(text(),'Open')]/..//div[@class='date f-r center column']/span/following-sibling::span")
	public WebElement monthForOpenForParticipation;
	
	@FindBy(xpath="//app-nifty-contest-detail/div[contains(text(),'Closed')]/..//div[@class='date f-r center column']/span")
	public WebElement dateForRecentlyClosedContest;
	
	@FindBy(xpath="//app-nifty-contest-detail/div[contains(text(),'Closed')]/..//div[@class='date f-r center column']/span/following-sibling::span")
	public WebElement monthForRecentlyClosedContest;
	
	@FindBy(xpath="//app-nifty-contest-detail/div[contains(text(),'Open')]/..//input")
	public WebElement enterNiftyPriceField;
	
	@FindBy(xpath="//app-nifty-contest-detail/div[contains(text(),'Open')]/..//button")
	public WebElement addButton;
	
	@FindBy(xpath="//app-nifty-contest-detail/div[contains(text(),'Open')]/..//button")
	public WebElement editButton;
	
	@FindBy(xpath="//app-nifty-contest-detail/div[contains(text(),'Open')]/..//button")
	public WebElement updateButton;
	
	@FindBy(xpath = "//div[@class='alert_heading']")
	public WebElement msg;
	
	public ContestPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
}
