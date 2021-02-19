package AdvisorTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Advisor.A_AdvisorDashBoardClosedCallPage;
import PageObject_Advisor.A_AdvisorDashBoardPage;
import PageObject_Advisor.A_PickRightLandingPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;

public class A_ValidateAdvisorDashBoardClosedcallPage extends Base {

	A_AdvisorDashBoardPage a;

	/* verify that all the call in the closed calls page should be closed */
	@Test
	public void validateClosedCallTitle() throws InterruptedException {
		A_PickRightLandingPage p = new A_PickRightLandingPage(driver);
		p.getJoinAsAdvisor();
		LoginOrSignUpPage l = new LoginOrSignUpPage(driver);
		l.getDropDown();
		l.setSearchField("India");
		l.getCountry();
		l.setMobileNumberField("6360245606");
		l.getNextButton();
		EnterOtpPage e = new EnterOtpPage(driver);
		e.setOtp();
		e.getNextButton();
		HomePage h = new HomePage(driver);
		h.getStartTrading();
		a = new A_AdvisorDashBoardPage(driver);
		a.getClosedCall();
		/*
		 * Actions a=new Actions(driver); a.moveToElement(driver.findElement(By.
		 * xpath("//div[@class='call-row f-r column full ng-star-inserted']")));
		 */
		// EventFiringWebDriver ev=new EventFiringWebDriver(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		int count=0;
		List<WebElement> f1 = driver
				.findElements(By.xpath("(//app-closed-calls)"));
		int f1Count = f1.size();
		// WebElement f = driver.findElement(By.xpath("(//app-closed-calls)[last()]"));
		// js.executeScript("arguments[0].scrollIntoView(true)",f);
		// js.executeScript("window.scrollTo(0, document.body.scrollHight)");
		// js.executeScript("document.querySelector('.data-content').scrollBy(0,800)");//working

		while (true) {

				WebElement f = driver.findElement(By.xpath("(//app-closed-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(3000);
				List<WebElement> f2 = driver
						.findElements(By.xpath("(//div[@class='call-row f-r column full ng-star-inserted'])"));
			if (f2.size() == f1Count) {
				break;
			}
			
			f1Count = f2.size();
			

			// WebElement f = driver.findElement(By.xpath("(//app-closed-calls)[last()]"));

			// js.executeScript("document.querySelector('.data-content').scrollBy(0,800)");;//working
			// js.executeScript("arguments[0].scrollIntoView(true)",f);
			// js.executeScript("window.scrollTo(0, document.body.scrollHight)");
		}
		System.out.println(f1Count);

		// A_AdvisorDashBoardClosedCallPage a1=new
		// A_AdvisorDashBoardClosedCallPage(driver);
		// a1.getAllCallsStatusTitle();
	}

}
