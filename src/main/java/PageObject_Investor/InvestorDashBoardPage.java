package PageObject_Investor;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InvestorDashBoardPage {
	
	@FindBy(xpath="//app-investor-new-calls")
	public List<WebElement> newCalls;
	
	@FindBy(xpath="//div[@class='no-records ng-star-inserted']/span")
	public WebElement noCallsMsg;
	
	@FindBy(xpath="(//app-investor-closed-calls)")
	public List<WebElement> closedCalls;
	
	@FindBy(xpath="//span[@touranchor='new-calls']")
	public WebElement newCallHeader;
	
	@FindBy(xpath="//div[@class='callsCount']/p")
	public WebElement allCallTitle;
	
	@FindBy(xpath="//div[@class='action-part']/p")
	public WebElement callName;
	
	@FindBy(xpath="//span[@touranchor='my-calls']")
	public WebElement myCallHeader;	
	
	@FindBy(xpath="//app-investor-my-calls")
	public List<WebElement> myCalls;
	
	@FindBy(xpath="//span[@touranchor='watch-calls']")
	public WebElement watchListHeader;	
	
	@FindBy(xpath="//app-investor-watch-calls")
	public List<WebElement> watchListCalls;
	
	
	@FindBy(xpath="//img[@src='assets/new-images/short-term.svg']")
	public WebElement investorDashBoard;
	
	@FindBy(xpath="(//span[@class='mat-button-wrapper']//span[@class='ng-star-inserted'])[1]")
	public WebElement callAmount;
	
	@FindBy(xpath="//div[@class='risk-profile-dialog']/h3")
	public WebElement riskProfilingTitle;
	
	@FindBy(xpath="//button[@class='mat-focus-indicator riskProfile mat-button mat-button-base']")
	public WebElement startRiskProfile;
	
	@FindBy(xpath="//div[@class='profile-question-container']//div[@class='ques']/span")
	public WebElement whatIsYourAgeGroup;
	
	@FindBy(xpath="//span[@touranchor='closed-calls']")
	public WebElement closedCallHeader;
	
	@FindBy(xpath="(//div[@class='filter-types ng-star-inserted']/div)[1]")
	public WebElement callsInBuyRangeFilter;
	
	@FindBy(xpath="(//div[@class='filter-types ng-star-inserted']/div/span)[1]")
	public WebElement callsInBuyRangeFilterTitle;
	
	@FindBy(xpath="//div[@class='filter-types ng-star-inserted']//mat-icon/following-sibling::mat-icon")
	public WebElement callsInBuyRangeFilterClose;
	
	@FindBy(xpath="//div[@class='status ng-star-inserted']/span/following-sibling::span")
	public List<WebElement> callsInBuyRangeTitleOnCall;
	
	@FindBy(xpath="(//div[@class='filter-types ng-star-inserted']/div)[2]")
	public WebElement STBTBTSTCallsFilter;
	
	@FindBy(xpath="(//div[@class='filter-types ng-star-inserted']/div/span)[2]")
	public WebElement STBTBTSTFilterTitle;
	
	@FindBy(xpath="(//div[@class='filter-types ng-star-inserted']/div/mat-icon)")
	public WebElement STBTBTSTFilterClose;
	
	@FindBy(xpath="(//div[@class='filter-types ng-star-inserted']/div/span)[3]")
	public WebElement IntradayCallsFilter;
	
	@FindBy(xpath="(//div[@class='filter-types ng-star-inserted']/div/mat-icon)")
	public WebElement IntradayCallsFilterClose;
	
	@FindBy(xpath="//div[@class='adv-detail']/h2")
	public List<WebElement> advisorNameOnCall;
	
	@FindBy(xpath="//div[@class='option ng-star-inserted']/img")
	public List<WebElement> followHeartIcon;
	
	@FindBy(xpath="(//div[@class='filter-types ng-star-inserted']/div/span)[5]")
	public WebElement MyAdvisorCallsFilter;
	
	@FindBy(xpath="//img[@src='assets/new-images/call-alert.svg']")
	public WebElement alertIcon;
	
	@FindBy(xpath="//img[@src='assets/new-images/home.svg']")
	public WebElement homeIcon;
	
	@FindBy(xpath="//span[@class='close']")
	public List<WebElement> closedCallStatusTitle;
	
	@FindBy(xpath="//div[@class='notice-card ng-star-inserted']")
	public WebElement riskProfile;
	
	@FindBy(xpath="//span[text()='Skip']")
	public WebElement skip;
	
	@FindBy(xpath="//mat-radio-group/div/div")
	public List<WebElement> riskProfileAnswerRadioButton;
	
	@FindBy(xpath="//button/span[text()=' Next']")
	public WebElement riskProfileNextButton;
	
	@FindBy(xpath="//input[@formcontrolname='panNo']")
	public WebElement panNumberField;
	
	@FindBy(xpath = "//div[@class='alert_heading']")
	public WebElement msg;
	
	@FindBy(xpath="//div[@class='time mb10']//span")
	public List<WebElement> timeFrameOnCalls;
	
	@FindBy(xpath="//div[@class='time mb10']//span[text()='Intraday']")
	public List<WebElement> intraDayTimeFrametitlesOnCalls;
	
	@FindBy(xpath="//div[@class='time mb10']//span[text()='Overnight Positional']")
	public List<WebElement> overNightPositionalTimeFrameOnCall;
	
	@FindBy(xpath="(//div[@class='actions'])[2]/button/following-sibling::button")
	public WebElement riskProfileSubmit;
	
	@FindBy(xpath="//div[@touranchor='filters']")
	public WebElement sortAndFilter;
	
	@FindBy(xpath="//div[@class='input-grp']/input")
	public WebElement searchFiled;
	
	@FindBy(xpath="//div[@class='scrip']/p")
	public List<WebElement> scripNamesOnCall;
	
	@FindBy(xpath="//div[@class='sort-type ng-star-inserted']/span")
	public WebElement lowToHigh;
	
	@FindBy(xpath="//div[@class='sort-type ng-star-inserted']/span/following-sibling::span")
	public WebElement highToLow;
	
	@FindBy(xpath="//label[text()='Newest ']/span")
	public WebElement NewestSortRadioButton;
	
	@FindBy(xpath="//label[text()='Rank ']/span")
	public WebElement rankSortRadioButton;
	
	@FindBy(xpath="//label[text()='Intraday ']/span")
	public WebElement intradayFilterRadioButton;
	
	@FindBy(xpath="//label[text()='Expire in 1 week ']/span")
	public WebElement expiryIn1WeekFilterRadioButton;
	
	@FindBy(xpath="//label[text()='Expire in 1 Month ']/span")
	public WebElement expiryIn1MonthFilterRadioButton;
	
	@FindBy(xpath="//label[contains(text(),'4')]/span")
	public WebElement fourStarAndAboveCheckBox;
	
	@FindBy(xpath="//label[contains(text(),'3')]/span")
	public WebElement threeStarAndAboveCheckBox;
	
	@FindBy(xpath="//label[contains(text(),'Low')]/span")
	public WebElement lowRiskCheckBox;
	
	@FindBy(xpath="//label[contains(text(),'Low')]/input")
	public WebElement lowRiskCheckBox1;
	
	@FindBy(xpath="//label[contains(text(),'Medium')]/input")
	public WebElement mediumRiskCheckBox;
	
	@FindBy(xpath="//label[contains(text(),'High')]/input")
	public WebElement highRiskCheckBox;
	
	@FindBy(xpath="//a[@class='apply']")
	public WebElement sortApplyButton;
	
	@FindBy(xpath="//a[@class='clear']")
	public WebElement sortClearButton;
	
	@FindBy(xpath="//div[@class='callTime']/span")
	public List<WebElement> callTimeOnCall;
	
	@FindBy(xpath="//div[@class='rating ng-star-inserted']/p/following-sibling::p")
	public List<WebElement> rankOnCall;
	
	@FindBy(xpath="//div[@class='value f-r align-start']/img")
	public List<WebElement> ratingOnCall;
	
	@FindBy(xpath="//div[@class='risk-time']")
	public List<WebElement> riskOnCall;

	public InvestorDashBoardPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	public void checkNewCallsCount()
	{
		int n=newCalls.size();
		String s=newCallHeader.getText();
		int d = Integer.parseInt(s.replaceAll("[^0-9]",""));
		if(d==n)
		{
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
	}
	
	public String getCallAmount()
	{
		
		String Amount=callAmount.getText().replace("\u20B9","");
		
		return Amount;
	}
	
	public void getCall()
	{
		callAmount.click();
	}
	
	public void getRiskProfilingTitle()
	{
		Assert.assertTrue(riskProfilingTitle.getText().equalsIgnoreCase("Risk Profiling"));
	}
	
	public void getStartRiskProfile()
	{
		startRiskProfile.click();
	}
	
	public void getWhatIsYourAgeGroup()
	{
		Assert.assertTrue(whatIsYourAgeGroup.getText().equalsIgnoreCase("What is your age group?"));
	}
	
	public void getInvestorDashBoard()
	{
		investorDashBoard.click();
	}
	
	public void getClosedCall()
	{
		closedCallHeader.click();
	}
	
	public void checkNewCallHeaderIsActive()
	{
		Assert.assertTrue(newCallHeader.getAttribute("class").contains("active"));
	}
	
	public void getNewCallTitle()
	{
		Assert.assertTrue(allCallTitle.getText().equalsIgnoreCase("new Calls"));
	}
	
	public void getMyCall()
	{
		myCallHeader.click();
	}
	
	public void checkMyCallHeaderIsActiveAfterTheClick()
	{
		Assert.assertTrue(myCallHeader.getAttribute("class").contains("active"));
	}
	
	public void getMyCallTitle()
	{
		Assert.assertTrue(allCallTitle.getText().equalsIgnoreCase("my Calls"));
	}
	
	public void getMycall()
	{
		myCallHeader.click();
	}
	
	public void checkClosedCallHeaderIsActiveAfterTheClick()
	{
		Assert.assertTrue(closedCallHeader.getAttribute("class").contains("active"));
	}
	
	public void getClosedCallTitle()
	{
		Assert.assertTrue(allCallTitle.getText().equalsIgnoreCase("closed Calls"));
	}
	
	public void getWatchList()
	{
		watchListHeader.click();
	}
	
	public void checkWatchListHeaderIsActiveAfterTheClick()
	{
		Assert.assertTrue(watchListHeader.getAttribute("class").contains("active"));
	}
	
	public void getWatchListTitle()
	{
		Assert.assertTrue(allCallTitle.getText().equalsIgnoreCase("watchlist"));
	}
	
	public void checkCallsInBuyRangeFilterIsActive()
	{
		Assert.assertTrue(callsInBuyRangeFilter.getAttribute("class").contains("active"));
	}
	
	public void getAlertIcon()
	{
		alertIcon.click();
	}
	
	public String  getEquityOptionTitle()
	{
		return callName.getText();
	}
	
	
 
	
	
	
	
	

}
