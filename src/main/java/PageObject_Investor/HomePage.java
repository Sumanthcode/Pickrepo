package PageObject_Investor;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	
	

	@FindBy(xpath = "//div[@class='start-trading mb20']/h2")
	public WebElement startTrading;

	@FindBy(xpath = "//div[@class='card equity']/h2")
	public WebElement equity;

	@FindBy(xpath = "//div[@class='card currency']/h2")
	public WebElement currencies;

	@FindBy(xpath = "//div[@class='card commodity']/h2")
	public WebElement commodity;

	@FindBy(xpath = "//div[@class='card strategy']/h2")
	public WebElement strategy;

	@FindBy(xpath = "//div[@class='card equity']//span[text()='Cash']")
	public WebElement equityCash;

	@FindBy(xpath = "//div[@class='mat-menu-trigger user f-r center']/mat-icon")
	public WebElement profileDropDown;

	@FindBy(xpath = "//button[text()=' Logout ']")
	public WebElement logOut;

	@FindBy(xpath = "//input[@placeholder='Search Scrip to add']")
	public WebElement marketWatchscriptSearch;

	@FindBy(xpath = "//span[@class='mat-option-text']/span[contains(text(),'WIP')]")
	public List<WebElement> autoSuggesion;

	@FindBy(xpath = "//div[@class='script-name']")
	public List<WebElement> selectedScrip;

	@FindBy(xpath = "//div[@class='depth']")
	public WebElement depth;

	@FindBy(xpath = "//div[@class='delete']")
	public WebElement delete;

	@FindBy(xpath = "//div[@class='f-r full column list-item ng-star-inserted']//h3[text()='Market Depth']")
	public WebElement marketDepthTitle;

	@FindBy(xpath = "//div[@class='alert_heading']")
	public WebElement msg;
	
	@FindBy(xpath="//div[@class='mat-menu-trigger user f-r center']//mat-icon")
	public WebElement dropdown;
	
	@FindBy(xpath="//div[@class='mat-menu-content ng-tns-c81-5']/button")
	public List<WebElement> dropDownOptions;
	
	@FindBy(xpath="//button[text()=' My Profile ']")
	public WebElement myProfile;
	
	@FindBy(xpath="//div[@class='f-r full center between ng-star-inserted']")
	public List<WebElement> scripts;
	
	@FindBy(xpath="//p[contains(text(),'Discuss')]")
	public WebElement discussion;
	
	@FindBy(xpath="//p[contains(text(),'Videos')]")
	public WebElement videos;
	
	@FindBy(xpath="//div[@class='contest-wrap mb20']//mat-icon")
	public WebElement contest;
	
	@FindBy(xpath="(//div[@class='f-r center c-title ng-star-inserted'])[1]")
	public WebElement pickTopStock;
	
	@FindBy(xpath="(//div[@class='f-r center c-title ng-star-inserted'])[2]")
	public WebElement predictNifty;
	
	@FindBy(xpath="//div[@class='contest-box f-r column stock ng-star-inserted']//div[@class='action f-r column']/button")
	public WebElement participateButtonInTopStock;
	
	@FindBy(xpath="//div[@class='contest-box f-r column nifty ng-star-inserted']//div[@class='action f-r column']/button")
	public WebElement participateButtonPredictNifty;
	
	@FindBy(xpath="//div[@class='togglr-btn']")
	public WebElement toggleButton;
	
	@FindBy(xpath="//div[@class='sub-heading f-r center between mb25']/h2")
	public WebElement discussionBoard;
	
	@FindBy(xpath="//div[@class='discussions']//h3")
	public List<WebElement> topThreeDiscussion;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void getStartTrading() {
		startTrading.click();

	}

	public void getCategoryTitles() {
		Assert.assertTrue(equity.getText().equals("Equity"));
		Assert.assertTrue(currencies.getText().equals("Currencies"));
		Assert.assertTrue(commodity.getText().equals("Commodity"));
		Assert.assertTrue(strategy.getText().equals("Strategy"));
	}

	public void getProfileDropDown() {
		profileDropDown.click();
	}

	public void getLogOut() {
		logOut.click();
	}

	public void setScriptSearch(String scripName) {
		marketWatchscriptSearch.sendKeys(scripName);
	}

	public void getOneAutoSuggesion() {
		autoSuggesion.get(0).click();
	}

	public void addScripts() {
		int count = 1;
		for (int i = 0; i < autoSuggesion.size(); i++) {
			if (count <= 11) {
				autoSuggesion.get(i).click();
				setScriptSearch("TCS");
				count++;

			} else {
				break;
			}

		}

	}

	public void getMsgTitleWhenMoreThan10callAdded() {
		Assert.assertTrue(msg.getText().equalsIgnoreCase("you can add only 10 scripts."));
	}

	// public void
	public void getSelectedScrip() {
	//	Assert.assertTrue(selectedScrip.getText().contains("TCS"));
	}

	public void getMsgTitleAfterSelectingScript() {
		Assert.assertTrue(msg.getText().equalsIgnoreCase("Instrument Added successfully!"));
	}

	public void getDepthISDisplayed(WebDriver driver) {
		Actions action = new Actions(driver);
//		action.moveToElement(selectedScrip).build().perform();
		Assert.assertTrue(depth.isDisplayed());
	}

	public void getDeleteIsDisplayed() {
		Assert.assertTrue(delete.isDisplayed());
	}

	public void getMarketDepthTitle(WebDriver driver) {
		depth.click();
		Assert.assertTrue(marketDepthTitle.getText().equalsIgnoreCase("Market Depth"));
		depth.click();
		// System.out.println(driver.findElement(By.xpath("//div[@class='depth-data f-r
		// column full ng-star-inserted']")).isDisplayed());
		try {
			Assert.assertFalse(marketDepthTitle.isDisplayed());
		} catch (Exception e) {
			System.out.println("Exxception handled");
		}

	}

	public void checkScriptIsDeleted(WebDriver driver) {
		Actions action = new Actions(driver);
	//	action.moveToElement(selectedScrip).build().perform();
		delete.click();
		try {
		//	Assert.assertTrue(selectedScrip.isDisplayed());
		} catch (Exception e) {
			System.out.println("Exception handled");
		
		}

	}

	public void getMsgAfterDeleteScript() {
		Assert.assertTrue(msg.getText().equalsIgnoreCase("Removed successfully!"));
	}
	
	public void getDropDown()
	{
		dropdown.click();
	}
	
	public void getMyProfile()
	{
		myProfile.click();
	}
	
	public void checkDropDownOptions()
	{
		String a[]= {"My Profile","Referrals","Blogs","Rewards","Settings","Logout"};
		
		for(int i=0;i<dropDownOptions.size();i++)
		{
			Assert.assertTrue(dropDownOptions.get(i).getText().equalsIgnoreCase(a[i]));
		}
	}
	
	public void getDiscussionBoard()
	{
		discussion.click();
	}
	
	public void getVideos(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("arguments[0].scrollIntoView(true);", videos);
		videos.click();
	}
	
	

}
