package InvestorTest;

import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.CategorySelectionPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.InvestorDashBoardPage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.OnBoardPage1;
import PageObject_Investor.OnBoardPage2;
import PageObject_Investor.PickRightHomePage;

public class ValidateRiskProfileQuestionAndAnswer extends Base {
	EnterOtpPage e;
	OnBoardPage2 o2;
	OnBoardPage1 o;
	InvestorDashBoardPage i;
	HomePage h;
	String number="8557281220";
	@Test
	public void successfullCreationOfRiskProfile() throws InterruptedException
	{
		PickRightHomePage p = new PickRightHomePage(driver);
		p.getJoinAsinvestor();

		LoginOrSignUpPage l = new LoginOrSignUpPage(driver);
		l.getUseMobileNumber();
		l.getDropDown();
		l.setSearchField("India");
		l.getCountry();
		l.setMobileNumberField(number);
		l.getNextButton();
		e = new EnterOtpPage(driver);
		e.setOtp();
		e.getCheckBox(driver);
		e.getNextButton();
	/*	o = new OnBoardPage1(driver);
		o.getYesImNewToStock();
		o2 = new OnBoardPage2(driver);
		o2.getHowItWorksNext();
		o2.checkTheWhatAreYouLookingForTitle();
		o2.getShortTerm();
		o2.getPickRightFeatureNext();
		o2.getBeginner();
		o2.getParters();
		o2.getNotListedHere();*/
		h=new HomePage(driver);
		h.startTrading.click();
		CategorySelectionPage c=new CategorySelectionPage(driver);
		c.equityCash.click();
		i=new InvestorDashBoardPage(driver);
//		c.getSkip(driver);
		i.riskProfile.click();
		for(int j=1;j<=7;j++)
		{
			if(j==7)
			{
				
				if(!(i.panNumberField.getAttribute("class").contains("dirty")))
				{
					i.panNumberField.sendKeys("GGJPA9875H");
					i.riskProfileSubmit.click();
				}
				else{
					i.riskProfileSubmit.click();
				}
				break;
			}
			Thread.sleep(1000);
			i.riskProfileAnswerRadioButton.get(1).click();
			i.riskProfileNextButton.click();
		}
		
		
		
		
		
		
	}

}
