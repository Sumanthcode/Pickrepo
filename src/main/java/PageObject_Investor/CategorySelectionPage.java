package PageObject_Investor;


import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CategorySelectionPage {

	@FindBy(xpath = "//div[@class='card equity']//div[@class='categories']/span")
	public List<WebElement> equityCategories;

	@FindBy(xpath = "//div[@class='card currency']//div[@class='categories']/span")
	public List<WebElement> currencyCategories;

	@FindBy(xpath = "//div[@class='card commodity']//div[@class='categories']/span")
	public List<WebElement> commodityCategories;

	@FindBy(xpath = "//div[@class='card strategy']//div[@class='categories']/span")
	public WebElement strategyCategories;
	
	@FindBy(xpath="//div[@class='card equity']//span[text()='Cash']")
	public WebElement equityCash;
	
	@FindBy(xpath="//div[@class='card equity']//span[text()='Futures']")
	public WebElement equityFutures;
	
	@FindBy(xpath="//div[@class='card equity']//span[text()='Options']")
	public WebElement equityOptions;
	
	@FindBy(xpath="//div[@class='card currency']//span[text()='Futures']")
	public WebElement currenciesFuture;
	
	@FindBy(xpath="//div[@class='card currency']//span[text()='Options']")
	public WebElement currenciesOption;
	
	@FindBy(xpath="//div[@class='card commodity']//span[text()='Futures']")
	public WebElement commodityFuture;
	
	@FindBy(xpath="//div[@class='card commodity']//span[text()='Options']")
	public WebElement commodityOption;
	
	@FindBy(xpath="//div[@class='card strategy']//span[text()='Strategies Call']")
	public WebElement strategyCall;
	
	
	
	@FindBy(xpath="//p[@class='callType ng-star-inserted']")
	public WebElement equityCashtitle;
	
	
	@FindBy(xpath="//p[text()='equity Future ']")
	public WebElement equityFuturestitle;
	
	@FindBy(xpath="//p[text()='equity Options ']")
	public WebElement equityOptionstitle;
	
	@FindBy(xpath="//p[text()='currency Future ']")
	public WebElement currencyFuturetitle;
	
	@FindBy(xpath="//p[text()='currency Options ']")
	public WebElement currencyOptiontitle;
	
	@FindBy(xpath="//p[text()='commodity Future ']")
	public WebElement commodityFuturetitle;
	
	@FindBy(xpath="//p[text()='commodity Options ']")
	public WebElement commodityOptiontitle;
	
	@FindBy(xpath="//p[text()='Strategic Calls ']")
	public WebElement strategyCalltitle;
	
	@FindBy(xpath="//span[@touranchor='new-calls']")
	public WebElement newCall;
	
	@FindBy(xpath="//span[text()='Skip']")
	public WebElement skip;
	
	/*@FindBy(xpath="//div[@class='card equity']//img[@class='tip']")
	public WebElement equityTip;*/

	public CategorySelectionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void getEquityCategories() {
		for (int i = 0; i < equityCategories.size(); i++) {

			Assert.assertTrue(equityCategories.get(i).getText().equals("Cash")
					|| equityCategories.get(i).getText().equals("Futures")
					|| equityCategories.get(i).getText().equals("Options"));

		}
	}

	public void getCurrencyCategories() {
		for (int i = 0; i < currencyCategories.size(); i++) {

			Assert.assertTrue(currencyCategories.get(i).getText().equals("Futures")
					|| currencyCategories.get(i).getText().equals("Options"));

		}
	}

	public void getCommodityCategories() {
		for (int i = 0; i < commodityCategories.size(); i++) {

			Assert.assertTrue(commodityCategories.get(i).getText().equals("Futures")
					|| commodityCategories.get(i).getText().equals("Options"));

		}
	}

	public void getStrategyCategories() {
		Assert.assertTrue(strategyCategories.getText().equals("Strategies Call"));
	}
	
	/*public void getEquityTip()
	{
		Actions action=new Actions(driver);
		action.moveToElement(equityTip).build().perform();
		
	}*/
	
	public void getEquityCash()
	{
		equityCash.click();
		
	}
	
	public void getEquityCashtitle()
	{
		
		Assert.assertTrue(equityCashtitle.getText().equalsIgnoreCase("equity Cash"));
	}
	
	public void getNewCall()
	{
		Assert.assertTrue(newCall.getAttribute("class").contains("active"));
	}
	
	public void getSkip(WebDriver driver)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(skip));		
		skip.click();
		
	}
	
	public void getEquityFutures()
	{
		equityFutures.click();
	}
	
	public void getEquityFuturestitle()
	{
		Assert.assertTrue(equityFuturestitle.getText().equalsIgnoreCase("Equity Future"));
	}
	
	public void getEquityOptions()
	{
		equityOptions.click();
	}
	
	public void getEquityOptionstitle()
	{
		System.out.println(equityOptionstitle.getText().equalsIgnoreCase("Equity Options"));
	}
	
	public void getCurrenciesFuture()
	{
		currenciesFuture.click();
	}
	
	public void getCurrencyFuturetitle() {
		Assert.assertTrue(currencyFuturetitle.getText().equalsIgnoreCase("Currency Future"));
	}
	
	public void getCurrenciesOption()
	{
		currenciesOption.click();
	}
	
	
	public void getCurrencyOptiontitle() {
		Assert.assertTrue(currencyOptiontitle.getText().equalsIgnoreCase("Currency Options"));
	}
	
	public void getCommodityFuture()
	{
		commodityFuture.click();
	}
	
	public void getCommodityFuturetitle() {
		Assert.assertTrue(commodityFuturetitle.getText().equalsIgnoreCase("Commodity Future"));
	}
	
	public void getCommodityOption()
	{
		commodityOption.click();
	}
	
	public void getCommodityOptiontitle() {
		Assert.assertTrue(commodityOptiontitle.getText().equalsIgnoreCase("Commodity Options"));
	}
	
	public void getStrategyCall()
	{
		strategyCall.click();
	}
	
	public void getStrategyCalltitle()
	{
		Assert.assertTrue(strategyCalltitle.getText().equalsIgnoreCase("Strategic Calls"));
	}

}
