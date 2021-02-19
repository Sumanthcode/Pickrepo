package PageObject_Investor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PickRightHomePage {
	public WebDriver driver;

	@FindBy(xpath = "//div[@class='login-button']/button")
	public WebElement joinAsInvestor;

	@FindBy(xpath = "//button[@routerlink='/advisor/signup']")
	public WebElement joinAsAFinancialAdvisorButton;

	@FindBy(xpath = "//div[@class='box ng-star-inserted']/h2")
	public WebElement loginOrSignUpTitle;

	@FindBy(xpath = "//div[@class='content']/h1")
	public WebElement pickRightHomePageTitle;

	@FindBy(xpath = "//span[@class='scope ng-star-inserted']")
	public WebElement asAInvestorOrAdvisorTitle;

	public PickRightHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getJoinAsinvestor() {

		joinAsInvestor.click();
	}

	public void getLoginOrSignUpTitle(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='box ng-star-inserted']/h2")));
		Assert.assertTrue(loginOrSignUpTitle.getText().equalsIgnoreCase("Login/Sign Up"));
		// Assert.assertTrue(asA.getText().equalsIgnoreCase("As an investor"));
	}

	public void getPickRightHomePageTitle() {
		Assert.assertTrue(pickRightHomePageTitle.getText()
				.equalsIgnoreCase("Investing and trading made simple. India's Best Investment Advisors platform."));
	}

}
