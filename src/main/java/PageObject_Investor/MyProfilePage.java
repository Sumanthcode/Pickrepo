package PageObject_Investor;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class MyProfilePage {
	
	@FindBy(xpath="//button[text()='Complete Profile']")
	private WebElement completeProfile;
	
	@FindBy(xpath="//input[@placeholder='Full Name']")
	private WebElement fullName;
	
	@FindBy(xpath="//div[@class='f-r column type']/button")
	private List<WebElement> brokerage;
	
	@FindBy(xpath="//input[@formcontrolname='panNo']")
	private WebElement panNo;
	
	@FindBy(xpath="//div[@class='f-r center b-type']/button")
	private List<WebElement> mostlyTradeIn;
	
	@FindBy(xpath="//span[@class='mat-slider-thumb-label-text']")
	private WebElement investmentCapitalValue;
	
	@FindBy(xpath="//select[@formcontrolname='typeOfTrader']")
	private WebElement typeOfTrader;
	
	@FindBy(xpath="//a[text()='Save']")
	private WebElement save;
	
	@FindBy(xpath="//div[@class='f-r mb30']//mat-icon")
	private WebElement mobileNumberEditIcon;
	
	
	public MyProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void getCompleteProfile()
	{
		completeProfile.click();
	}
	
	SoftAssert s;
	public void checkFullNameFieldIsEmpty()
	{
		 	s=new SoftAssert();
		s.assertFalse(fullName.getAttribute("class").contains("dirty"));
		s.assertAll();
	}
	
	public void checkBrokeragesAreNotSelected()
	{
		
		for(int i=0;i<brokerage.size();i++)
		{
			 s=new SoftAssert();
			s.assertFalse(brokerage.get(i).getAttribute("class").contains("active"));
			s.assertAll();
		
		}
		
	}
	
	public void checkPanNoFieldIsNotTouched()
	{
			s=new SoftAssert();
		s.assertFalse(panNo.getAttribute("class").contains("dirty"));
		s.assertAll();
	//	Assert.assertFalse(panNo.getAttribute("class").contains("dirty"));
	}
	
	public void checkMostlyTradeInOptionsAreNotSelected()
	{
		 s=new SoftAssert();
		for(int i=0;i<mostlyTradeIn.size();i++)
		{
			s.assertFalse(mostlyTradeIn.get(i).getAttribute("class").contains("active"));
			
		//	Assert.assertFalse(mostlyTradeIn.get(i).getAttribute("class").contains("active"));
		}
		s.assertAll();
	
	}
	
	public void checkInvestmentCapitalValue()
	{
		s=new SoftAssert();
		s.assertTrue(investmentCapitalValue.getText().replace("\u20B9","").equals("50000"));
		s.assertAll();
	//	Assert.assertTrue(investmentCapitalValue.getText().replace("\u20B9","").equals("50000"));
	}
	
	public void checkTypeOfTradersAreNotSected()
	{
		typeOfTrader.click();
		Select select=new Select(typeOfTrader);
		List<WebElement> u = select.getOptions();
		
		for(int i=0;i<u.size();i++)
		{
			Assert.assertFalse(u.get(i).isSelected());
		}
		 
	}
	
	public void checkSavebuttonIsNotEnabled()
	{
		Assert.assertTrue(save.getAttribute("class").contains("disabled"));
	}
	
	public void checkMobileNumberFieldEditIconIsdisplayed()
	{
		Assert.assertTrue(mobileNumberEditIcon.isDisplayed());
	}
	
	public void checkTypeOfTraderDropDownISSingleSelect()
	{
		Select select=new Select(typeOfTrader);
		Assert.assertFalse(select.isMultiple());
	}
	
	public void checkNameIsRequiresErrorMsg()
	{
		fullName.sendKeys("");
		brokerage.get(1).click();
		
	}
	
	
	
	

	
	
	
	

}
