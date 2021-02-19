package PageObject_Investor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OnBoardPage1 {

	@FindBy(xpath = "//div[@class='name f-r column']/p")
	private WebElement investorMobileNumber;

	@FindBy(xpath = "//div[@class='mat-menu-trigger user f-r center']//img")
	private WebElement profileImage;

	@FindBy(xpath = "//div[@class='option f-r center']")
	private WebElement notificationIcon;

	@FindBy(xpath = "//div[@class='notification-header']/h4")
	private WebElement notificationTitle;
	
	 @FindBy(xpath="//h2[text()='How it works?']")
	 private WebElement howItWorks;
	 
	 @FindBy(xpath="//h2[@class='mb40 size24 ng-star-inserted']")
	 private WebElement areYouNewToTheStockTitle;
	 
	 @FindBy(xpath="//img[@src='assets/new-images/icon-close.svg']")
		private WebElement closeNotificationButton;

	/*
	 * @FindBy(xpath = "//div[@class='question-block ng-star-inserted']/div")
	 * private List<WebElement> areYouNewToStock;
	 */

	@FindBy(xpath = "//div[contains(text(),'Yes')]")
	private WebElement yesImNewToStock;

	@FindBy(xpath = "//div[contains(text(),'No')]")
	private WebElement noIHaveDoneItBefore;
	
	@FindBy(xpath="//img[@src='assets/new-images/left-arrow-icon.svg']")
	private WebElement back;

	public OnBoardPage1(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void getInvestorMobileNumber(String number) {
		Assert.assertTrue(investorMobileNumber.getText().equals(number));
	}

	public void getProfileImage() {
		Assert.assertTrue(profileImage.getTagName().equals("img"));
	}

	public void getNotification() {
		notificationIcon.click();

	}
	
	public void getNotificationTitle()
	{
		Assert.assertTrue(notificationTitle.getText().equals("Notifications"));
	}
	
	public void getCloseNotificationButton() {
		closeNotificationButton.click();
		
	}
	
	public void yesImNewToStockIsSelectedOrNot()
	{
		Assert.assertTrue(yesImNewToStock.getAttribute("class").contains("selected"));
	}
	
	

	/*public void getAreYouNewToStock() {
		Scanner s = new Scanner(System.in);
		System.out.println("ARE YOU NEW TO STOCK?");
		String ans = s.next();
		if (yesImNewToStock.getText().contains(ans)) {
			yesImNewToStock.click();
			Assert.assertTrue(yesImNewToStock.getAttribute("class").contains("selected"));
		} else if (noIHaveDoneItBefore.getText().contains(ans)) {
			noIHaveDoneItBefore.click();
			Assert.assertTrue(noIHaveDoneItBefore.getAttribute("class").contains("selected"));

		}
	}*/
	
	
	
	
/*	public void getYesImNewToStock()
	{
		if(areYouNewToTheStockTitle.isDisplayed()) {
		yesImNewToStock.click();
		Assert.assertTrue(yesImNewToStock.getAttribute("class").contains("selected"));
		Assert.assertTrue(howItWorks.getText().equalsIgnoreCase("How it works?"));
		}
		
	}*/
	
	public void getYesImNewToStockTitle()
	{
		Assert.assertTrue(yesImNewToStock.getText().equalsIgnoreCase("Yes, I'm new to stocks"));
	}
	
	public void getNoIHaveDoneItBeforeTitle()
	{
		Assert.assertTrue(noIHaveDoneItBefore.getText().equalsIgnoreCase("No, I have done it before"));
	}
	
	public void getYesImNewToStock()
	{
		yesImNewToStock.click();
	}
	
	public void getBack()
	{
		back.click();
	}
	
	public void getNoIHaveDoneItBefore()
	{
		noIHaveDoneItBefore.click();
	}

}
