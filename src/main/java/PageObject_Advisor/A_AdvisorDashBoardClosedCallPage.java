package PageObject_Advisor;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class A_AdvisorDashBoardClosedCallPage {
	
	@FindBy(xpath="//span[@class='close']")
	private List<WebElement> statusOfCalls;
	
	public  A_AdvisorDashBoardClosedCallPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void getAllCallsStatusTitle()
	{
		System.out.println(statusOfCalls.size());
		for(int i=0;i<statusOfCalls.size();i++)
		{
			Assert.assertTrue(statusOfCalls.get(i).getText().equalsIgnoreCase("Closed"));
		}
	}

}
