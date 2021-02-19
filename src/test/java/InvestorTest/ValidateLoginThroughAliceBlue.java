package InvestorTest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.AliceBluePage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.OnBoardPage1;
import PageObject_Investor.OnBoardPage2;
import PageObject_Investor.PickRightHomePage;

public class ValidateLoginThroughAliceBlue extends Base {
	
	@Test
	public void validateLoginThroughAliceBlue()
	{
		PickRightHomePage p = new PickRightHomePage(driver);
		p.getJoinAsinvestor();
		AliceBluePage a=new AliceBluePage(driver);
		a.getAliceBlue();
		LoginOrSignUpPage l=new LoginOrSignUpPage(driver);
		String w = driver.getWindowHandle();
		String parentTitle = driver.switchTo().window(w).getTitle();
		
		Set<String> windows = driver.getWindowHandles();
		for (String s : windows) {
			
			if (!parentTitle.equals(driver.switchTo().window(s).getTitle())) {
				driver.switchTo().window(s);
				a.setClientId("AB077479");
				a.setPassword("Naman$12123");
				a.getSignIn();
				a.setAns1("test");
				a.setAns2("test");
				a.getSignIn();
				String url = driver.getCurrentUrl().replace("pickright.in","stage-web.pickright.co.in");
				driver.get(url);
				l.getDropDown();
				l.setSearchField("India");
				l.getCountry();
				l.setMobileNumberField("9734029364");
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
				/*o1.getYesImNewToStock();
				JavascriptExecutor j = (JavascriptExecutor) driver;
				j.executeScript("window.scrollBy(0,500)");*/
				OnBoardPage2 o2 = new OnBoardPage2(driver);
			/*	o2.getHowItWorksNext();
				o2.getShortTerm();
				o2.getPickRightFeatureNext();
				o2.getBeginner();*/
				o2.getStartTradingTitle();
				
				
				
			}
		}
		
	}

}
