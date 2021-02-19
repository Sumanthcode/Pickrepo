package PageObject_Investor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Scanner;


public class OnBoardPage2 {
	
	 @FindBy(xpath="//h2[text()='How it works?']")
	 private WebElement howItWorks;
	 
	 @FindBy(xpath="//h2[text()='Training Links']")
	 private WebElement trainingLinksTitle;
	 
	 @FindBy(xpath="//h2[text()='Founders Note']")
	 private WebElement foundersNotesTitle;
	 

	@FindBy(id = "slidevideoplayer")
	private WebElement howItWorksVideo;

	@FindBy(xpath = "//a[@class='link']")
	private List<WebElement> trainingLinks;

	@FindBy(xpath = "//button[@class='nxt-btn ng-star-inserted']")
	private WebElement howItWorksNext;
	
	@FindBy(xpath = "//button[@class='nxt-btn ng-star-inserted']")
	private WebElement pickRightFeatureNext;

	@FindBy(xpath = "//h2[@class='mb40 size24 ng-star-inserted']")
	private WebElement whatAreYouLookingfor;

	@FindBy(xpath = "//div[contains(text(),'Long')]")
	private WebElement longTerm;
	
	@FindBy(xpath="//button[@class='nxt-btn ng-star-inserted']")
	private WebElement exploreShortTermTrading;
	
	@FindBy(xpath="//h2[text()='Launching Soon']")
	private WebElement launchingSoon;

	@FindBy(xpath = "//div[contains(text(),'Short')]")
	private WebElement shortTerm;
	
	@FindBy(xpath="//h2[text()='Pickright Features']")
	private WebElement pickRightFeature;

	@FindBy(xpath = "//h2[@class='mb40 size24 ng-star-inserted']")
	private WebElement howWouldYouCategoriseyourself;

	@FindBy(xpath = "//div[text()=' Beginner']")
	private WebElement beginner;

	@FindBy(xpath = "//div[text()=' Intermediate']")
	private WebElement intermediate;

	@FindBy(xpath = "//div[text()=' Expert']")
	private WebElement expert;
	
	@FindBy(xpath="//div[@class='question-block ng-star-inserted']//div")
	private List<WebElement> howWouldYouCategoriseyourselfOptions;

	@FindBy(xpath = "//h2[@class='mb40 size24']")
	private WebElement selectFromBelowDematAccounts;

	@FindBy(xpath = "//ul[@class='partner']/li/a")
	private List<WebElement> partners;

	@FindBy(xpath = "//h2[text()=' Start Trading ']")
	private WebElement startTrading;

	@FindBy(xpath = "//h2[@class='mr10']")
	private WebElement advisorPrediction;

	@FindBy(xpath = "//div[@class='sub-heading f-r center between mb15']/h2")
	private WebElement topNews;
	
	@FindBy(xpath="//h2[@class='mb40 size24']")
	private WebElement selectFromBelowDematAccountsTitle;
	
	@FindBy(xpath="//img[@src='assets/new-images/left-arrow-icon.svg']")
	private WebElement back;

	public OnBoardPage2(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void getHowItWork() {
		
		Assert.assertTrue(howItWorks.getText().equalsIgnoreCase("How it works?"));
	}
	
	public void getTrainingLinksTitle()
	{
		System.out.println(trainingLinksTitle.getText());
		Assert.assertTrue(trainingLinksTitle.getText().equalsIgnoreCase("Training Links"));
		
		
	}
	
	public void getFoundersNotesTitle()
	{
		System.out.println(foundersNotesTitle.getText());
		Assert.assertTrue(foundersNotesTitle.getText().equalsIgnoreCase("Founders Note"));
	}
	
	public void getHowItWorksVideo()
	{
		Assert.assertTrue(howItWorksVideo.getTagName().equals("video"));
	}

	public void getTrainingLinks() {

		for (int i = 0; i < trainingLinks.size(); i++) {
			System.out.println(trainingLinks.get(i).getText());
			if (trainingLinks.get(i).getText().equals("https://zerodha.com/varsity")) {
				Assert.assertTrue(true);
			} else if (trainingLinks.get(i).getText()
					.equals("https://www.niftytradingacademy.com/free-technical-analysis-training/")) {
				Assert.assertTrue(true);
			} else if (trainingLinks.get(i).getText().equals("https://upstox.com/learning-center")) {
				Assert.assertTrue(true);
			} else
				Assert.assertTrue(false);
		}
	}

	public void checkTheWhatAreYouLookingForTitle() {
		
		Assert.assertTrue(whatAreYouLookingfor.getText().equals("What are you looking for?"));
		
	}

	/*public void getWhatAreYouLookingFor() {
		Scanner s = new Scanner(System.in);
		System.out.println("What are you lokking for? Long term or Short term");
		String ans = s.next();
		if (longTerm.getText().contains(ans)) {
			longTerm.click();
			Assert.assertTrue(longTerm.getAttribute("class").contains("selected"));
			Assert.assertTrue(launchingSoon.getText().equalsIgnoreCase("Launching Soon"));
		} else if (shortTerm.getText().contains(ans)) {
			shortTerm.click();
			Assert.assertTrue(shortTerm.getAttribute("class").contains("selected"));
			Assert.assertTrue(pickRightFeature.getText().equalsIgnoreCase("Pickright Features"));

		}
	}*/
	
	public void getLongTermTradingTitle()
	{
		Assert.assertTrue(longTerm.getText().equalsIgnoreCase("Long Term Trading"));
	}
	
	public void getLongTerm()
	{
		longTerm.click();
	}
	
	public void getShortTermTradingTitle()
	{
		Assert.assertTrue(shortTerm.getText().equalsIgnoreCase("Short Term Trading"));
	}
	public void getShortTerm()
	{
		
		shortTerm.click();
	//	Assert.assertTrue(shortTerm.getAttribute("class").contains("selected"));
		
		
	}
	
	public void getExploreShortTermTradingTitle()
	{
		Assert.assertTrue(exploreShortTermTrading.getText().equalsIgnoreCase("Explore Short Term Trading"));
	}
	
	public void getPickRightFeatureTitle()
	{
		Assert.assertTrue(pickRightFeature.getText().equalsIgnoreCase("Pickright Features"));
	}
	
	public void getHowItWorksNext()
	{
		
		
		howItWorksNext.click();
		
	}
	
	public void getPickRightFeatureNext()
	{

		pickRightFeatureNext.click();
		
	}

	public void CheckHowWouldYouCategoriseYourselfTitle() {
		
		howWouldYouCategoriseyourself.getText().equals("How would you categorise yourself?");
		
	}
	
	public void getBeginnerTitle()
	{
		Assert.assertTrue(beginner.getText().equalsIgnoreCase("Beginner"));
	}
	
	public void getIntermediateTitle()
	{
		Assert.assertTrue(intermediate.getText().equalsIgnoreCase("Intermediate"));
	}
	
	public void getExpert()
	{
		Assert.assertTrue(expert.getText().equalsIgnoreCase("Expert"));
	}
	
	public void validateSelectFromBelowDematAccountsTitleForThreeOptions()
	{
		int n=howWouldYouCategoriseyourselfOptions.size();
		for(int i=0;i<n;i++)
		{
			howWouldYouCategoriseyourselfOptions.get(i).click();
			Assert.assertTrue(selectFromBelowDematAccounts.getText().equals("Select from below Demat accounts"));
			back.click();
			
			
		}
		
	}

	public void getHowWouldYouCategoriseYourself() {
		Scanner s = new Scanner(System.in);
		System.out.println("How would you categorise yourself? Beginner or Intermediate or Expert");
		String ans = s.next();
		if (beginner.getText().contains(ans)) {
			beginner.click();
			Assert.assertTrue(beginner.getAttribute("class").contains("selected"));
		} else if (intermediate.getText().contains(ans)) {
			intermediate.click();
			Assert.assertTrue(intermediate.getAttribute("class").contains("selected"));

		} else if (expert.getText().contains(ans)) {
			expert.click();
			Assert.assertTrue(expert.getAttribute("class").contains("selected"));
		}

	}
	
	public void getBeginner()
	{
		
		beginner.click();
		
	}

	public void checkSelectFromBelowDematAccountsTitle() {
		Assert.assertTrue(selectFromBelowDematAccounts.getText().equals("Select from below Demat accounts"));
	}

	public void getParters() {
		/*Scanner s = new Scanner(System.in);
		System.out.println(
				"Select the any demat account-Zerodha,Alice Blue,Master Trust,Trade Smart,5 Paisa,No, I don't have Demat account,Not listed here");
		String account = s.next();*/
		
		for (int i = 0; i < partners.size(); i++) {

			if (partners.get(i).getText().contains("Zerodha")) {

				Assert.assertTrue(true);
			} else if (partners.get(i).getText().contains("Alice Blue")) {

				Assert.assertTrue(true);

			} else if (partners.get(i).getText().contains("Master Trust")) {

				Assert.assertTrue(true);

			} else if (partners.get(i).getText().contains("Trade Smart")) {

				Assert.assertTrue(true);

			} else if (partners.get(i).getText().contains("5 Paisa")) {

				Assert.assertTrue(true);

			} else if (partners.get(i).getText().contains("No, I don't have Demat account")) {

				Assert.assertTrue(true);

			} else if (partners.get(i).getText().contains("Not listed here")) {

				Assert.assertTrue(true);
				//partners.get(i).click();

			} else
				Assert.assertTrue(false);
		}
		

	}
	public void getNotListedHere()
	{
		partners.get(6).click();
	}

	public void getStartTradingTitle() {
		Assert.assertTrue(startTrading.getText().equalsIgnoreCase("Start Trading"));
	}

	public void getAdvisorPrediction() {
		Assert.assertTrue(advisorPrediction.getText().equals("Advisor Prediction"));
	}

	public void getTopNews() {
		topNews.getText().equals("Top News");
	}

}
