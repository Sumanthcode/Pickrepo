package PageObject_Investor;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AlertPage {
	
	@FindBy(xpath="//button[@class='alert-button']")
	public WebElement createAlertButton;
	
	@FindBy(xpath="//span[text()='Create Alert']")
	public WebElement createAlert;
	
	@FindBy(xpath="(//div[@class='call-type'])[1]/span")
	public List<WebElement> selectCategoryOptions;
	
	@FindBy(xpath="(//div[@class='call-type'])[2]/span")
	public List<WebElement> popularScripsOptions;
	
	@FindBy(xpath="//div[@class='alert_heading']")
	public WebElement msg;
	
	@FindBy(xpath="(//div[@class='table-row ng-star-inserted']//p)[1]")
	public WebElement scripName;
	
	@FindBy(xpath="(//div[@class='table-row ng-star-inserted']//p)[2]")
	public WebElement category;
	
	@FindBy(xpath="(//div[@class='table-row ng-star-inserted']//p)[3]")
	public WebElement callsAvailable;;
	
	@FindBy(xpath="//div[@class='text']/a")
	public WebElement viewCalls;
	
	@FindBy(xpath="//input")
	public WebElement scripField;
	
	@FindBy(xpath="//span[contains(text(),'TCS')]")
	public List<WebElement> scripAutoSugessions;
	
	@FindBy(xpath="//span[text()='Cancel']")
	public WebElement cancelButton;
	
	@FindBy(xpath="//section[@class='table']/h3")
	public WebElement myAlertTitle;
	
	
	public AlertPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void getCreateAlertButton()
	{
		createAlertButton.click();
	}
	
	public void getCreateAlert()
	{
		createAlert.click();
	}
	
	public void checkSelectCategoryOptions()
	{
		String op[]= {"Future","Options","Currency Options","Currency Future","Commodity Options","Commodity Future","Any"};
		for(int i=0;i<selectCategoryOptions.size();i++)
		{
			Assert.assertTrue(selectCategoryOptions.get(i).getText().equalsIgnoreCase(op[i]));
		}
	}
	
	public void checkPopularScripsOptions()
	{
		String op[]= {"NIFTY","BANKNIFTY"};
		for(int i=0;i<popularScripsOptions.size();i++)
		{
			Assert.assertTrue(popularScripsOptions.get(i).getText().equalsIgnoreCase(op[i]));
		}
	}
	
	
	
	public void checkPleaseSelectAtleastOneCategoryErrorMsg()
	{
		for(int i=0;i<selectCategoryOptions.size();i++)
		{
			Assert.assertTrue(!selectCategoryOptions.get(i).getAttribute("class").equals("active"));
		}
		for(int i=0;i<popularScripsOptions.size();i++)
		{
			Assert.assertTrue(!popularScripsOptions.get(i).getAttribute("class").equals("active"));
		}
		createAlert.click();
	    Assert.assertTrue(msg.getText().equalsIgnoreCase("Please Select Atleast One Category."));
	}
	
	public void checkPleaseSelectAScriptErrorMsg()
	{
		selectCategoryOptions.get(0).click();
		Assert.assertTrue(selectCategoryOptions.get(0).getAttribute("class").equals("active"));
		for(int i=0;i<popularScripsOptions.size();i++)
		{
			Assert.assertTrue(!popularScripsOptions.get(i).getAttribute("class").equals("active"));
		}
		createAlert.click();
		Assert.assertTrue(msg.getText().equalsIgnoreCase("Please Select A Script."));
		
	}
	
	public void checkAlertAddedSuccessfullyMsg()
	{
		Assert.assertTrue(msg.getText().equalsIgnoreCase("Alert Added Successful."));
		
	}
	
	public String getSelectCategory()
	{
		String aCategory=selectCategoryOptions.get(1).getText();
		selectCategoryOptions.get(1).click();
		return aCategory;
		
	}
	
	public String  getNifty()
	{
		String aScrip=popularScripsOptions.get(0).getText();
		popularScripsOptions.get(0).click();
		return aScrip;
	}
	
	public void checkSuccessfullyAddedPopularScripAlertDetails(String aScrip)
	{
		Assert.assertTrue(scripName.getText().equalsIgnoreCase(aScrip));
		Assert.assertTrue(category.getText().equalsIgnoreCase("ANY"));
		Assert.assertTrue(callsAvailable.getText().equalsIgnoreCase("00"));
		Assert.assertTrue(viewCalls.getText().equalsIgnoreCase("View Calls"));
	}
	
	public void setScripField(String scrip)
	{
		scripField.sendKeys(scrip);
	}
	
	public String getScripAutoSugessions()
	{
		String aScrip=scripAutoSugessions.get(0).getText();
		scripAutoSugessions.get(0).click();
		return aScrip;
	}
	
	public void checkSuccessfullyAddedScripAlertDetails(String aCategory,String aScrip)
	{
		Assert.assertTrue(scripName.getText().equalsIgnoreCase(aScrip));
		Assert.assertTrue(category.getText().equalsIgnoreCase(aCategory));
		Assert.assertTrue(callsAvailable.getText().equalsIgnoreCase("00"));
		Assert.assertTrue(viewCalls.getText().equalsIgnoreCase("View Calls"));
	}
	
	public void checkScriptAlreadyExistsErrorMsg()
	{
		Assert.assertTrue(msg.getText().equalsIgnoreCase("Script Already Exists!"));
	}
	
	public void getCancelButton()
	{
		cancelButton.click();
	}
	
	public void checkMyAlertTitle()
	{
		Assert.assertTrue(myAlertTitle.isDisplayed());
	}
	
	public void getViewCalls()
	{
		viewCalls.click();
	}
	
	public void checkCategoryNameOnClickingViewCalls(String eCat,String aCat)
	{
		Assert.assertTrue(eCat.equalsIgnoreCase("Equity "+aCat));
		
	}
	
	public String getAddedAlertCategory()
	{
		return category.getText();
	}
	

}
