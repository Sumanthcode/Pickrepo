package InvestorTest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.OnBoardPage1;
import PageObject_Investor.OnBoardPage2;
import PageObject_Investor.PickRightHomePage;
import PageObject_Investor.TradeSmartPage;

public class ValidateLoginThroughTradeSmartBroker extends Base {

	@Test
	public void validateLoginThroughTradeSmart() throws InterruptedException {
		PickRightHomePage p = new PickRightHomePage(driver);
		p.getJoinAsinvestor();
		TradeSmartPage td = new TradeSmartPage(driver);
		
		td.getTradeSmart();
		
		LoginOrSignUpPage l=new LoginOrSignUpPage(driver); 
		String w = driver.getWindowHandle();
		String parentTitle = driver.switchTo().window(w).getTitle();

		Set<String> windows = driver.getWindowHandles();
		for (String s : windows) {
			
			if (!parentTitle.equals(driver.switchTo().window(s).getTitle())) {
				driver.switchTo().window(s);
				driver.navigate().refresh();
				td.setClientId("YAPS652");
				td.setPassword("Aarna$1212");
				td.getSignIn();

				td.setDigitBirthDate("1983");
				td.getSignIn();
				driver.findElement(By.xpath("//div[@class='ng-tns-c10-1']")).click();
				td.getAppCentre();
				td.getCreateNewApp();
				td.setAppName("TestApp");
				td.getSubmit();

			}

		}
		String[] t = td.getAppDetails();
		driver.switchTo().window(w);
		td.setUID("YAPS652");
		td.setAppId(t[0]);
		td.setAppSecuritykey(t[1]);
		td.setPassKey(t[2]);
		td.getTradeSubmit();
	//	l.getWelcomeUserTitle();
		Thread.sleep(2000);
		l.getDropDown();
		l.setSearchField("India");
		l.getCountry();
		l.setMobileNumberField("9972672564");
		Thread.sleep(2000);
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
