package InvestorTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.FivePaisaPage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.OnBoardPage1;
import PageObject_Investor.OnBoardPage2;
import PageObject_Investor.PickRightHomePage;

public class ValidateLoginThroughFivePaisa extends Base{
	
	@Test
	public void validateLoginThroughFivePaisa() throws InterruptedException
	{
		PickRightHomePage p = new PickRightHomePage(driver);
		p.getJoinAsinvestor();
		FivePaisaPage f=new FivePaisaPage(driver);
		f.getFivePaisa();
		f.setEmail("sanjay.san7878@gmail.com");
		f.setPassword("Pickright@1212");
		f.setDate("03271994");
		f.getSubmit();
		LoginOrSignUpPage l=new LoginOrSignUpPage(driver);
		Thread.sleep(2000);
		l.getDropDown();
		l.setSearchField("India");
		l.getCountry();
		l.setMobileNumberField("9984672564");
	//	Thread.sleep(2000);
		l.getNextButton();
		EnterOtpPage e = new EnterOtpPage(driver);
		driver.findElement(By.xpath("//input[contains(@id,'otp_0')]")).sendKeys("3");
		driver.findElement(By.xpath("//input[contains(@id,'otp_1')]")).sendKeys("4");
		driver.findElement(By.xpath("//input[contains(@id,'otp_2')]")).sendKeys("6");
		driver.findElement(By.xpath("//input[contains(@id,'otp_3')]")).sendKeys("5");
		e.getCheckBox();
		e.getNextButton();
		OnBoardPage1 o1 = new OnBoardPage1(driver);
		o1.getYesImNewToStock();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,500)");
		OnBoardPage2 o2 = new OnBoardPage2(driver);
		o2.getHowItWorksNext();
		o2.getShortTerm();
		o2.getPickRightFeatureNext();
		o2.getBeginner();
		o2.getStartTradingTitle();
		
	}

}
