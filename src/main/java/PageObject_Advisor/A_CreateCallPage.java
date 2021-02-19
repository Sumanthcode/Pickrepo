package PageObject_Advisor;


import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class A_CreateCallPage {

	WebDriver driver;

	@FindBy(xpath = "//span[contains(text(),'COPPER')]")
	private List<WebElement> commodityFutureAutoSuggesions;

	

	

	
	@FindBy(xpath = "//span[text()='Buy']")
	private WebElement callTypeBuy;
	

	@FindBy(xpath = "//p[text()='Market Price']")
	private WebElement marketPriceRadioButton;
	
	@FindBy(xpath="//p[text()='Recommended Price']")
	private WebElement recommendedPriceRadioButton;
	
	@FindBy(xpath="//input[@formcontrolname='purchasePrice']")
	private WebElement recommendedPriceField;


	

	

	


	

	

	@FindBy(xpath = "//input[@formcontrolname='callPrice']")
	private WebElement advisorFeeField;

	@FindBy(xpath = "//input[@placeholder='Link']")
	private WebElement linkField;

	@FindBy(xpath = "//div[@formarrayname='newsUrl']/a")
	private WebElement addLink;

	@FindBy(xpath = "//textarea[@placeholder='Description']")
	private WebElement callDescription;

	


	
	
	
	
	
	@FindBy(xpath="//p[text()='Weekly']/span")
	private WebElement weeklyRadioButton;
	
	@FindBy(xpath="//p[text()='Monthly']/span")
	private WebElement monthlyRadioButton;
	
	@FindBy(xpath="//span[@class='error ng-star-inserted']")
	private WebElement thisScripIsNoAavaliableForWeekly;
	

	// @FindBy(xpath="")"Insufficient wallet amount "

	public A_CreateCallPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public void getCommodityFutureAutoSuggesions() {
		commodityFutureAutoSuggesions.get(0).click();
	}

	
	



	
	

	
	
	

	

	

	
	
	

	

	





	
	public void setAdvisorFeeField(double fee) {
		advisorFeeField.sendKeys(String.valueOf(fee));
	}

	/*
	 * public void setLinkField() { linkField.sendKeys(arg0); }
	 * 
	 * public void getAddLink() { addLink.click(); }
	 * 
	 * public void setCallDescription() { callDescription.sendKeys(); }
	 */

	

	


	

	
	
	
	
	public void setRecommendedPriceField(String d)
	{
		recommendedPriceField.sendKeys(String.valueOf(d));
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
// till here
	
	
	
	

	
	
	
	
	
	
	public void getWeeklyRadioButton()
	{
		
		weeklyRadioButton.click();
	}
	
	public void getMonthlyRadioButton()
	{
		monthlyRadioButton.click();
	}
	
	public boolean getThisScripIsNoAavaliableForWeeklyTitle()
	{
		return thisScripIsNoAavaliableForWeekly.getText().equalsIgnoreCase("This scrip is not avaliable for weekly");
	}
	

}
