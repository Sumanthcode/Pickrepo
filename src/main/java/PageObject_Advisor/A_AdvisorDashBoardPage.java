package PageObject_Advisor;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class A_AdvisorDashBoardPage {
	WebDriver driver;
	
	@FindBy(xpath="(//div[@class='dashboard-tab f-r ng-star-inserted']/div)[1]")
	public WebElement activeHeaderEquity;
	
	@FindBy(xpath="(//div[@class='dashboard-tab f-r ng-star-inserted']/div)[2]")
	public WebElement activeHeaderCurrency;
	
	@FindBy(xpath="//div[@touranchor='ongoing-calls']")
	public WebElement ongoingCalls;
	
	@FindBy(xpath="(//div[@class='dashboard-tab f-r ng-star-inserted']/div)[3]")
	public WebElement activeHeaderCommodity;
	
	@FindBy(xpath="(//div[@class='dashboard-tab f-r ng-star-inserted']/div)[4]")
	public WebElement activeHeaderStrategy;
	
	@FindBy(xpath="//a[text()='Future']")
	public WebElement commodityFuture;
	
	@FindBy(xpath="//a[text()='Option']")
	public WebElement commodityOption;
	
	@FindBy(xpath="//button[@type='button']")
	public WebElement createCall;
	
	/*@FindBy(xpath="//div[text()=' Equity Cash ']")
	public WebElement equity;*/
	
	/*@FindBy(xpath="//div[text()=' Currency  ']")
	public WebElement currency;*/
	
	@FindBy(xpath="//a[text()='Future']")
	public WebElement currencyFuture;
	
	@FindBy(xpath="//a[text()='Option']")
	public WebElement currencyOption;
	
	@FindBy(xpath="//a[text()='Cash']")
	public WebElement equityCash;
	
	@FindBy(xpath="//a[text()='Future']")
	public WebElement equityFuture;
	
	@FindBy(xpath="//div[@class='f-r column ng-star-inserted']/h2")
	public WebElement equityCashCallTitle;
	
	@FindBy(xpath="//div[@class='f-r column ng-star-inserted']/h2")
	public WebElement equityFutureCallTitle;
	
	@FindBy(xpath="//div[@class='f-r column ng-star-inserted']/h2")
	public WebElement equityOptionCallTitle;
	
	@FindBy(xpath="//div[@class='f-r column ng-star-inserted']/h2")
	public WebElement currencyFutureCallTitle;
	
	@FindBy(xpath="//div[@class='f-r column ng-star-inserted']/h2")
	public WebElement currencyOptionCallTitle;
	
	@FindBy(xpath="//div[@class='f-r column ng-star-inserted']/h2")
	public WebElement commodityFutureCallTitle;
	
	@FindBy(xpath="//div[@class='f-r column ng-star-inserted']/h2")
	public WebElement commodityOptionCallTitle;
	
	@FindBy(xpath="//div[@class='f-r column ng-star-inserted']/h2")
	public WebElement strategyCallTitle;
	
	@FindBy(xpath="//a[text()='Option']")
	public WebElement equityOption;
	
	
	@FindBy(xpath="//div[@class='heading']/h1")
	public WebElement createEquityCashCallTitle;
	
	@FindBy(xpath="//div[@class='heading']/h1")
	public WebElement createFutureCashCallTitle;
	
	@FindBy(xpath="//div[@class='heading']/h1")
	public WebElement createOptionCashCallTitle;
	
	@FindBy(xpath="//div[@class='heading']/h1")
	public WebElement createCurrencyFutureCallTitle;
	
	@FindBy(xpath="//div[@class='heading']/h1")
	public WebElement createCurrencyOptionCallTitle;
	
	@FindBy(xpath="//div[@class='heading']/h1")
	public WebElement createCommodityFutureCallTitle;
	
	@FindBy(xpath="//div[@class='heading']/h1")
	public WebElement createCommodityOptionCallTitle;
	
	@FindBy(xpath="//div[@class='heading']/h1")
	public WebElement createStrategyCallTitle;
	
	
	
	@FindBy(xpath="(//app-ongoing-calls)[1]//div[@class='scrip-name']")
	public WebElement scriptNameInCall;
	
	@FindBy(xpath="(//app-ongoing-calls)[1]//span[text()='Active']")
	public WebElement activeTitle;
	
	@FindBy(xpath="(//app-ongoing-calls)[1]//span[text()='Awaiting']")
	public WebElement awaitingTitle;
	
	@FindBy(xpath="(//div[@class='skip']/p)[1]")
	public WebElement skip;
	
	
	@FindBy(xpath="//div[@touranchor='closed-calls']")
	public WebElement closedCall;
	
	@FindBy(xpath="//mat-card[@class='mat-card mat-focus-indicator tourDialog ng-tns-c81-3 ng-star-inserted']")
	public WebElement x;
	
	@FindBy(xpath="(//app-ongoing-calls)[1]//button[1]")
	public WebElement message;
	
	@FindBy(xpath="(//app-ongoing-calls)[1]//button[2]")
	public WebElement close;
	
	@FindBy(xpath="(//app-ongoing-calls)[1]//button[3]")
	public WebElement edit;
	
	@FindBy(xpath="(//app-ongoing-calls)[1]//div[@class='risk-time']")
	public WebElement RiskTextOnTheCall;
	
	@FindBy(xpath="(//app-ongoing-calls)[1]//div[@class='f-r mb10 labl ng-star-inserted']")
	public WebElement timeFrameOnCall;
	
	@FindBy(xpath="(//app-ongoing-calls)[1]//span[@class='call-type']")
	public WebElement callTypeOnCall;
	
	@FindBy(xpath="((//app-ongoing-calls)[1]//div[@class='f-r wrap']//div[@class='value ng-star-inserted'])[1]")
	public WebElement entryAtOnCall;
	
	@FindBy(xpath="((//app-ongoing-calls)[1]//div[@class='f-r column price w60 mb20'])[2]/div/following-sibling::div")
	public WebElement stopLossOnCall;
	
	@FindBy(xpath="((//app-ongoing-calls)[1]//div[@class='f-r column price w60 mb20'])[3]/div/following-sibling::div")
	public WebElement targetOnCall;
	
	@FindBy(xpath="(//app-ongoing-calls)[1]//div[@class='f-r']/div")
	public WebElement approxInvestmentValueOnCall;
	
	@FindBy(xpath="(//app-ongoing-calls)[1]//p[@class='calculation-based ng-star-inserted']")
	public WebElement lotSizeOnCall;
	
	@FindBy(xpath="(//app-ongoing-calls)[1]//div[@class='f-r center end']/div/following-sibling::div")
	public WebElement cmpValueOnCall;
	
	@FindBy(xpath="(//app-ongoing-calls)[1]//div[@class='f-r center calculation profit-per ng-star-inserted']")
	public WebElement profirLossCalculationOnCall;
	
	@FindBy(xpath="(//app-ongoing-calls)[1]//div[@class='profit ng-star-inserted']")
	public WebElement maxProfitOnCall;
	
	@FindBy(xpath="(//app-ongoing-calls)[1]//a")
	public WebElement viewCallActivity;
	
	@FindBy(xpath="(//app-ongoing-calls)[1]//div[@class='f-r column']/h3")
	public WebElement investorBought;
	
	@FindBy(xpath="(//app-ongoing-calls)[1]//div[@class='f-r column']/h2")
	public WebElement unlockedAmount;
	
	public A_AdvisorDashBoardPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void checkEquityCashHeaderIsActive()
	{
		Assert.assertTrue(activeHeaderEquity.getAttribute("class").contains("active"));
	}
	
	public void getEquityCashHeadingTitle()
	{
		Assert.assertTrue(activeHeaderEquity.getText().equalsIgnoreCase("Equity Cash"));
	}
	
	public void getEquityFutureHeadingAfterSelection()
	{
		Assert.assertTrue(activeHeaderEquity.getText().equalsIgnoreCase("Equity future"));
	}
	
	public void getEquityOptionHeadingAfterSelection()
	{
		Assert.assertTrue(activeHeaderEquity.getText().equalsIgnoreCase("Equity option"));
	}
	
	public void getCurrencyFutureHeadingAfterSelection()
	{
		Assert.assertTrue(activeHeaderCurrency.getText().equalsIgnoreCase("Currency future"));
	}
	
	public void getCurrencyOptionHeadingAfterSelection()
	{
		Assert.assertTrue(activeHeaderCurrency.getText().equalsIgnoreCase("Currency option"));
	}
	
	public void getCommodityFutureHeadingAfterSelection()
	{
		Assert.assertTrue(activeHeaderCommodity.getText().equalsIgnoreCase("Commodity future"));
	}
	
	public void getCommodityOptionHeadingAfterSelection()
	{
		Assert.assertTrue(activeHeaderCommodity.getText().equalsIgnoreCase("Commodity option"));
	}
	

	public void getStrategyHeadingAfterSelection()
	{
		Assert.assertTrue(activeHeaderStrategy.getText().equalsIgnoreCase("Strategy"));
	}
	
	public void checkOnGoingCallsTabIsActive()
	{
		Assert.assertTrue(ongoingCalls.getAttribute("class").contains("active"));
	}
	public void getCommodity()
	{
		activeHeaderCommodity.click();
	}
	
	public void getCommodityFuture()
	{
		commodityFuture.click();
	}
	
	public void getCommodityOption()
	{
		commodityOption.click();
	}
	
	public void getStrategy()
	{
		activeHeaderStrategy.click();
	}
	
	public void getCreateCall()
	{
		createCall.click();
	}
	
	public void getEquity()
	{
		activeHeaderEquity.click();
	}
	
	public void getCurrency()
	{
		activeHeaderCurrency.click();
	}
	
	public void getCurrencyFuture()
	{	
		currencyFuture.click();
	}
	
	public void getCurrencyOption()
	{
		currencyOption.click();
	}
	
	
	public void getEquityCash()
	{
		equityCash.click();
	}
	
	public void getEquityFuture()
	{
		equityFuture.click();
	}
	
	public void getEquityOption()
	{
		equityOption.click();
	}
	
	public void getEquityCashCallTitle()
	{
		Assert.assertTrue(equityCashCallTitle.getText().equalsIgnoreCase("Equity cash Call"));
	}
	
	public void getEquityFutureCallTitle()
	{
		Assert.assertTrue(equityFutureCallTitle.getText().equalsIgnoreCase("Equity future Call"));
	}
	
	public void getEquityOptionCallTitle()
	{
		Assert.assertTrue(equityOptionCallTitle.getText().equalsIgnoreCase("Equity options Call"));
	}
	
	public void getCurrencyFutureCallTitle()
	{
		Assert.assertTrue(currencyFutureCallTitle.getText().equalsIgnoreCase("Currency future Call"));
	}
	public void getCurrencyOptionCallTitle()
	{
		Assert.assertTrue(currencyOptionCallTitle.getText().equalsIgnoreCase("Currency option Call"));
	}
	
	public void getCommodityFutureCallTitle()
	{
		Assert.assertTrue(commodityFutureCallTitle.getText().equalsIgnoreCase("Commodity future Call"));
	}
	
	public void getCommodityOptionCallTitle()
	{
		Assert.assertTrue(commodityOptionCallTitle.getText().equalsIgnoreCase("Commodity option Call"));
	}
	
	public void getStrategyCallTitle()
	{
		Assert.assertTrue(strategyCallTitle.getText().equalsIgnoreCase("Strategy Call"));
	}
	
	
	
	public void getCreateEquityCashCallTitle()
	{
		Assert.assertTrue(createEquityCashCallTitle.getText().equalsIgnoreCase("Create Equity Cash Call"));
	}
	
	public void getCreateFutureCashCallTitle()
	{
		Assert.assertTrue(createFutureCashCallTitle.getText().equalsIgnoreCase("Create Future Cash Call"));
	}
	
	public void getCreateOptionCashCallTitle()
	{
		Assert.assertTrue(createOptionCashCallTitle.getText().equalsIgnoreCase("Create Options Cash Call"));
	}
	
	public void getCreateCurrencyFutureCallTitle()
	{
		Assert.assertTrue(createCurrencyFutureCallTitle.getText().equalsIgnoreCase("Create Future Currency Call"));
	}
	
	public void getCreateCurrencyOptionCallTitle()
	{
		Assert.assertTrue(createCurrencyOptionCallTitle.getText().equalsIgnoreCase("Create Options Currency Call"));
	}
	
	public void getCreateCommodityFutureCallTitle()
	{
		Assert.assertTrue(createCommodityFutureCallTitle.getText().equalsIgnoreCase("Create Future Commodity Call"));
	}
	
	public void getCreateCommodityOptionCallTitle()
	{
		Assert.assertTrue(createCommodityOptionCallTitle.getText().equalsIgnoreCase("Create Options Commodity Call"));
	}
	
	public void getCreateStrategyCallTitle()
	{
		Assert.assertTrue(createStrategyCallTitle.getText().equalsIgnoreCase("Create Strategic Call"));
	}
	
	
	String scriptName;
	public void getScriptNameInCall()
	{
		 scriptName=scriptNameInCall.getText();
	}
	
	public void checkCreatedCallScriptName(String aScriptName)
	{
		
		Assert.assertEquals(scriptName, aScriptName);
	}
	
	public void checkStatusOfCallActive()
	{
		Assert.assertTrue(activeTitle.getText().equalsIgnoreCase("Active"));
		
	}
	
	public void checkStatusOfCallAwaiting()
	{
		Assert.assertTrue(awaitingTitle.getText().equalsIgnoreCase("Awaiting"));
	}
	
/*	public void checkFutureCallComponents(String EntryAt, String aScriptName)
	{
		
		if(EntryAt=="Market Price")
		{
			Assert.assertTrue(activeTitle.getText().equalsIgnoreCase("Active"));
			Assert.assertEquals(scriptName, aScriptName);
			
		}
	}*/
	public void getSkip()
	{
		if(x.isDisplayed())
		{
			skip.click();
		}
		
	}
	
	public void getClosedCall()
	{
		closedCall.click();
	}
	
	
	
	
	
	
	
}
