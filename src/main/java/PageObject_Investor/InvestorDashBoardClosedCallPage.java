package PageObject_Investor;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InvestorDashBoardClosedCallPage {
//	WebDriver driver;
	
	@FindBy(xpath="//span[@class='close']")
	private List<WebElement> closedCallStatusTitle;
	
	@FindBy(xpath="(//div[@class='call-row-wrap ng-star-inserted'])[1]")
	private WebElement closedCallCards;
	public InvestorDashBoardClosedCallPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	public void getAllClosedCallTitle()
	{
		int n=closedCallStatusTitle.size();
		
		if(closedCallCards.isDisplayed())
		{
			for(int i=0;i<n;i++)
			{
				Assert.assertTrue(closedCallStatusTitle.get(i).getText().equalsIgnoreCase("Closed"));
			}
		}
		
		else
			System.out.println("no calls");
		
		


	}

}
