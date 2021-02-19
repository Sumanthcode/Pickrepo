package InvestorTest;

import java.awt.AWTException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Investor.CategorySelectionPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.InvestorDashBoardPage;
import PageObject_Investor.LoginOrSignUpPage;
import PageObject_Investor.PickRightHomePage;

public class ValidateSorting extends Base {
	InvestorDashBoardPage i;
	
	@Test(priority = 1)
	public void validateFilterBySearchingAdvisor() throws InterruptedException, AWTException {
		PickRightHomePage p = new PickRightHomePage(driver);
		p.joinAsInvestor.click();
		LoginOrSignUpPage l = new LoginOrSignUpPage(driver);
		l.getUseMobileNumber();
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
		CategorySelectionPage c = new CategorySelectionPage(driver);
		/*
		 * if(driver.findElement(By.
		 * xpath("//button[@class='sc-htpNat minimizeButton-31FRu u-userLauncherColor sc-EHOje hssBvG']"
		 * )).isDisplayed()) { driver.findElement(By.
		 * xpath("//button[@class='sc-htpNat minimizeButton-31FRu u-userLauncherColor sc-EHOje hssBvG']"
		 * )).click(); }
		 */		c.equityCash.click();;
		i = new InvestorDashBoardPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		i.callsInBuyRangeFilterClose.click();
		if (!i.newCalls.isEmpty())
		{
			int f1Count = i.newCalls.size();
			while(true)
			{
				WebElement f = driver.findElement(By.xpath("(//app-investor-new-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.newCalls.size() == f1Count) {
					break;
				}
				f1Count = i.newCalls.size();
			}
			String advisorName = i.advisorNameOnCall.get(0).getText();
			String[] splited = advisorName.split("");
			for(int j=0;j<splited.length;j++)
			{
				i.searchFiled.sendKeys(splited[j]);
				Thread.sleep(500);
			}
			List<String> efilteredList = i.advisorNameOnCall.stream().map(s->s.getText()).filter(s->s.contains(advisorName)).collect(Collectors.toList());
			List<String> aFilteredList = i.advisorNameOnCall.stream().map(s->s.getText()).collect(Collectors.toList());
			Assert.assertEquals(aFilteredList, efilteredList);
			
		}
		else
		{
			Assert.assertTrue(i.newCalls.isEmpty());
		}
		i.searchFiled.clear();
		i.newCallHeader.click();
	}
	
//	@Test(priority=2)
	public void validateFilterBySearchingSripName() throws InterruptedException, AWTException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (!i.newCalls.isEmpty())
		{
			int f1Count = i.newCalls.size();
			while(true)
			{
				WebElement f = driver.findElement(By.xpath("(//app-investor-new-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.newCalls.size() == f1Count) {
					break;
				}
				f1Count = i.newCalls.size();
			}
		String scrip = i.scripNamesOnCall.get(0).getText();
		String[] splited = scrip.split("");
		for(int j=0;j<splited.length;j++)
		{
			i.searchFiled.sendKeys(splited[j]);
			Thread.sleep(1000);
		}
		
		Thread.sleep(2000);
		List<String> eFilteredList = i.scripNamesOnCall.stream().map(s->s.getText()).filter(s->s.contains(scrip)).collect(Collectors.toList());
		List<String> aFilteredList = i.scripNamesOnCall.stream().map(s->s.getText()).collect(Collectors.toList());
		eFilteredList.forEach(s->System.out.println(s));
		System.out.println("===============");
		aFilteredList.forEach(s->System.out.println(s));
		Assert.assertEquals(aFilteredList, eFilteredList);
		
		}
		else
		{
			Assert.assertTrue(i.newCalls.isEmpty());
		}
		
		i.searchFiled.clear();
		i.newCallHeader.click();
		
		
	}
	
	@Test(priority=3)
	public void sortByNewestLowTohigh() throws InterruptedException
	{
		i.sortAndFilter.click();
		i.NewestSortRadioButton.click();
		i.lowToHigh.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,800)");
		i.sortApplyButton.click();
		if (!i.newCalls.isEmpty())
		{
			int f1Count = i.newCalls.size();
			while(true)
			{
				WebElement f = driver.findElement(By.xpath("(//app-investor-new-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.newCalls.size() == f1Count) {
					break;
				}
				f1Count = i.newCalls.size();
			}
			
			List<String> eSortedList = i.callTimeOnCall.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
			List<String> aSortedList = i.callTimeOnCall.stream().map(s->s.getText()).collect(Collectors.toList());
			Assert.assertEquals(aSortedList, eSortedList);
		}
		else
		{
			Assert.assertTrue(i.newCalls.isEmpty());
		}
		
		
	}
	
	@Test(priority=4)
	public void sortByNewestHighToLow() throws InterruptedException
	{
		i.sortAndFilter.click();
		i.NewestSortRadioButton.click();
		i.highToLow.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,800)");
		i.sortApplyButton.click();
		if (!i.newCalls.isEmpty())
		{
			int f1Count = i.newCalls.size();
			while(true)
			{
				WebElement f = driver.findElement(By.xpath("(//app-investor-new-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.newCalls.size() == f1Count) {
					break;
				}
				f1Count = i.newCalls.size();
			}
			
			List<String> eSortedList = i.callTimeOnCall.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
			Collections.reverse(eSortedList);
			List<String> aSortedList = i.callTimeOnCall.stream().map(s->s.getText()).collect(Collectors.toList());
			Assert.assertEquals(aSortedList, eSortedList);
		}
		else
		{
			Assert.assertTrue(i.newCalls.isEmpty());
		}
		
		
	}
	
	@Test(priority=5)
	public void sortByRankLowToHigh() throws InterruptedException
	{
		i.sortAndFilter.click();
		i.rankSortRadioButton.click();
		i.lowToHigh.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,800)");
		i.sortApplyButton.click();
		if (!i.newCalls.isEmpty())
		{
			int f1Count = i.newCalls.size();
			while(true)
			{
				WebElement f = driver.findElement(By.xpath("(//app-investor-new-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.newCalls.size() == f1Count) {
					break;
				}
				f1Count = i.newCalls.size();
			}
			
			List<String> eSortedList = i.rankOnCall.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
			List<String> aSortedList = i.rankOnCall.stream().map(s->s.getText()).collect(Collectors.toList());
			Assert.assertEquals(aSortedList, eSortedList);
		}
		else
		{
			Assert.assertTrue(i.newCalls.isEmpty());
		}
		
		
	}
	
	@Test(priority=6)
	public void sortByRankHighToLow() throws InterruptedException
	{
		i.sortAndFilter.click();
		i.rankSortRadioButton.click();
		i.highToLow.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,800)");
		i.sortApplyButton.click();
		if (!i.newCalls.isEmpty())
		{
			int f1Count = i.newCalls.size();
			while(true)
			{
				WebElement f = driver.findElement(By.xpath("(//app-investor-new-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.newCalls.size() == f1Count) {
					break;
				}
				f1Count = i.newCalls.size();
			}
			
			List<String> eSortedList = i.rankOnCall.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
			Collections.reverse(eSortedList);
			List<String> aSortedList = i.rankOnCall.stream().map(s->s.getText()).collect(Collectors.toList());
			Assert.assertEquals(aSortedList, eSortedList);
		}
		else
		{
			Assert.assertTrue(i.newCalls.isEmpty());
		}
		
		
	}
	
//	@Test(priority=7)
	public void filterByLowRisk() throws InterruptedException
	{
		
		i.sortAndFilter.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,800)");
		i.lowRiskCheckBox.click();
		Thread.sleep(2000);
		Assert.assertTrue(i.lowRiskCheckBox.getAttribute("class").contains("dirty"));
		Assert.assertFalse(i.mediumRiskCheckBox.getAttribute("class").contains("dirty"));
		Assert.assertFalse(i.highRiskCheckBox.getAttribute("class").contains("dirty"));
	//	js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,500)");
		i.sortApplyButton.click();
		if (!i.newCalls.isEmpty())
		{
			int f1Count = i.newCalls.size();
			while(true)
			{
				WebElement f = driver.findElement(By.xpath("(//app-investor-new-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.newCalls.size() == f1Count) {
					break;
				}
				f1Count = i.newCalls.size();
			}
			
			List<String> eFiltereddList = i.riskOnCall.stream().map(s->s.getText()).filter(s->s.contains("Low")).collect(Collectors.toList());
			List<String> aFilteredList = i.riskOnCall.stream().map(s->s.getText()).collect(Collectors.toList());
			Assert.assertEquals(aFilteredList, eFiltereddList);
		}
		else
		{
			Assert.assertTrue(i.newCalls.isEmpty());
		}
		
		i.sortAndFilter.click();
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,500)");
		i.sortClearButton.click();
		
		
	}
	
//	@Test(priority=8)
	public void filterByMediumRisk() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		i.sortAndFilter.click();
		js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,800)");
		i.mediumRiskCheckBox.click();
		Thread.sleep(1000);
		Assert.assertFalse(i.lowRiskCheckBox.isSelected());
		Assert.assertTrue(i.mediumRiskCheckBox.isSelected());
		Assert.assertFalse(i.highRiskCheckBox.isSelected());
		js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,500)");
		i.sortApplyButton.click();
		if (!i.newCalls.isEmpty())
		{
			int f1Count = i.newCalls.size();
			while(true)
			{
				WebElement f = driver.findElement(By.xpath("(//app-investor-new-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.newCalls.size() == f1Count) {
					break;
				}
				f1Count = i.newCalls.size();
			}
			
			List<String> eFiltereddList = i.riskOnCall.stream().map(s->s.getText()).filter(s->s.contains("Medium")).collect(Collectors.toList());
			List<String> aFilteredList = i.riskOnCall.stream().map(s->s.getText()).collect(Collectors.toList());
			Assert.assertEquals(aFilteredList, eFiltereddList);
		}
		else
		{
			Assert.assertTrue(i.newCalls.isEmpty());
		}
		
		i.sortAndFilter.click();
		js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,500)");
		i.sortClearButton.click();
		
		
	}
	
//	@Test(priority=9)
	public void filterByHighRisk() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		i.sortAndFilter.click();
		js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,800)");
		i.highRiskCheckBox.click();
		Thread.sleep(1000);
		Assert.assertFalse(i.lowRiskCheckBox.isSelected());
		Assert.assertFalse(i.mediumRiskCheckBox.isSelected());
		Assert.assertTrue(i.highRiskCheckBox.isSelected());
		js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,500)");
		i.sortApplyButton.click();
		if (!i.newCalls.isEmpty())
		{
			int f1Count = i.newCalls.size();
			while(true)
			{
				WebElement f = driver.findElement(By.xpath("(//app-investor-new-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.newCalls.size() == f1Count) {
					break;
				}
				f1Count = i.newCalls.size();
			}
			
			List<String> eFiltereddList = i.riskOnCall.stream().map(s->s.getText()).filter(s->s.contains("High")).collect(Collectors.toList());
			List<String> aFilteredList = i.riskOnCall.stream().map(s->s.getText()).collect(Collectors.toList());
			Assert.assertEquals(aFilteredList, eFiltereddList);
		}
		else
		{
			Assert.assertTrue(i.newCalls.isEmpty());
		}
		
		i.sortAndFilter.click();
		js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,500)");
		i.sortClearButton.click();
		
		
	}
	
	@Test(priority=10)
	public void filterByIntraday() throws InterruptedException
	{
		
		i.sortAndFilter.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.mat-dialog-container.ng-tns-c37-12.ng-trigger.ng-trigger-dialogContainer.ng-star-inserted').scrollBy(0,800)");
		i.intradayFilterRadioButton.click();
		i.sortApplyButton.click();
		if (!i.newCalls.isEmpty())
		{
			int f1Count = i.newCalls.size();
			while(true)
			{
				WebElement f = driver.findElement(By.xpath("(//app-investor-new-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.newCalls.size() == f1Count) {
					break;
				}
				f1Count = i.newCalls.size();
			}
			
			List<String> eFilteredList = i.timeFrameOnCalls.stream().map(s->s.getText()).filter(s->s.contains("Intraday")).collect(Collectors.toList());
			List<String> aFilteredList = i.timeFrameOnCalls.stream().map(s->s.getText()).collect(Collectors.toList());
			eFilteredList.forEach(s->System.out.println(s));
			System.out.println("===============");
			aFilteredList.forEach(s->System.out.println(s));
			Assert.assertEquals(aFilteredList, eFilteredList);
		}
		else
		{
			Assert.assertTrue(i.newCalls.isEmpty());
		}
		
		i.sortAndFilter.click();
		Thread.sleep(2000);
	//	js.executeScript("document.querySelector('.mat-dialog-container.ng-tns-c37-12.ng-trigger.ng-trigger-dialogContainer.ng-star-inserted').scrollTo(0,800)");
		js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,800)");
		i.sortClearButton.click();
		
	}
	
	@Test(priority=11)
	public void filterByExpiryInOneWeek() throws InterruptedException
	{
		
		i.sortAndFilter.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
	//	js.executeScript("document.querySelector('.mat-dialog-container.ng-tns-c37-12.ng-trigger.ng-trigger-dialogContainer.ng-star-inserted').scrollTo(0,800)");
		js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,800)");
		i.expiryIn1WeekFilterRadioButton.click();
		i.sortApplyButton.click();
		if (!i.newCalls.isEmpty())
		{
			int f1Count = i.newCalls.size();
			while(true)
			{
				WebElement f = driver.findElement(By.xpath("(//app-investor-new-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.newCalls.size() == f1Count) {
					break;
				}
				f1Count = i.newCalls.size();
			}
			
			List<String> eFilteredList = i.timeFrameOnCalls.stream().map(s->s.getText()).filter(s->s.contains("7 Days Left")).collect(Collectors.toList());
			List<String> aFilteredList = i.timeFrameOnCalls.stream().map(s->s.getText()).collect(Collectors.toList());
			eFilteredList.forEach(s->System.out.println(s));
			System.out.println("===============");
			aFilteredList.forEach(s->System.out.println(s));
			Assert.assertEquals(aFilteredList, eFilteredList);
		}
		else
		{
			Assert.assertTrue(i.newCalls.isEmpty());
		}
		
		i.sortAndFilter.click();
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,800)");
		i.sortClearButton.click();
		
		
	}
	
	@Test(priority=12)
	public void filterByExpiryInOneMonth() throws InterruptedException
	{
		
		i.sortAndFilter.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
	//	js.executeScript("document.querySelector('.mat-dialog-container.ng-tns-c37-12.ng-trigger.ng-trigger-dialogContainer.ng-star-inserted').scrollBy(0,800)");
		js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,800)");
		i.expiryIn1MonthFilterRadioButton.click();
		i.sortApplyButton.click();
		if (!i.newCalls.isEmpty())
		{
			int f1Count = i.newCalls.size();
			while(true)
			{
				WebElement f = driver.findElement(By.xpath("(//app-investor-new-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.newCalls.size() == f1Count) {
					break;
				}
				f1Count = i.newCalls.size();
			}
			
			List<String> eFilteredList = i.timeFrameOnCalls.stream().map(s->s.getText()).filter(s->s.contains("30 Days Left")).collect(Collectors.toList());
			List<String> aFilteredList = i.timeFrameOnCalls.stream().map(s->s.getText()).collect(Collectors.toList());
			eFilteredList.forEach(s->System.out.println(s));
			System.out.println("===============");
			aFilteredList.forEach(s->System.out.println(s));
			Assert.assertEquals(aFilteredList, eFilteredList);
		}
		else
		{
			Assert.assertTrue(i.newCalls.isEmpty());
		}
		
		i.sortAndFilter.click();
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,800)");
		i.sortClearButton.click();
		
		
	}
	
	
	@Test(priority=13)
	public void filterByRatingAboveFour() throws InterruptedException
	{
		i.myCallHeader.click();
		Thread.sleep(1000);
		i.myCallHeader.click();
		i.sortAndFilter.click();
		i.fourStarAndAboveCheckBox.click();
//		Assert.assertTrue(i.fourStarAndAboveCheckBox.isSelected());
//		Assert.assertFalse(i.threeStarAndAboveCheckBox.isSelected());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,800)");
		i.sortApplyButton.click();
		if (!i.newCalls.isEmpty())
		{
			int f1Count = i.newCalls.size();
			while(true)
			{
				WebElement f = driver.findElement(By.xpath("(//app-investor-new-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.newCalls.size() == f1Count) {
					break;
				}
				f1Count = i.newCalls.size();
			}
			
			List<Double> eFilteredList = i.ratingOnCall.stream().map(s->Double.parseDouble(s.getText())).filter(s->s>=4.0).collect(Collectors.toList());
			
			List<Double> aFilteredList = i.rankOnCall.stream().map(s->Double.parseDouble(s.getText())).collect(Collectors.toList());
			eFilteredList.forEach(s->System.out.println(s));
			System.out.println("===============");
			aFilteredList.forEach(s->System.out.println(s));
			Assert.assertEquals(aFilteredList, eFilteredList);
		}
		else
		{
			Assert.assertTrue(i.newCalls.isEmpty());
		}
		
		
		
		
	}
	
	@Test(priority=14)
	public void filterByRatingAboveThree() throws InterruptedException
	{
		i.myCallHeader.click();
		i.sortAndFilter.click();
		i.fourStarAndAboveCheckBox.click();
//		Assert.assertFalse(i.fourStarAndAboveCheckBox.isSelected());
		i.threeStarAndAboveCheckBox.click();
//		Assert.assertTrue(i.threeStarAndAboveCheckBox.isSelected());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.cdk-overlay-pane.filter-app-popup').scrollBy(0,800)");
		i.sortApplyButton.click();
		if (!i.newCalls.isEmpty())
		{
			int f1Count = i.newCalls.size();
			while(true)
			{
				WebElement f = driver.findElement(By.xpath("(//app-investor-new-calls)[last()]"));
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true)", f);
				Thread.sleep(2000);
				if (i.newCalls.size() == f1Count) {
					break;
				}
				f1Count = i.newCalls.size();
			}
			
			List<Double> eFilteredList = i.ratingOnCall.stream().map(s->Double.parseDouble(s.getText())).filter(s->s>=3.0).collect(Collectors.toList());
			
			List<Double> aFilteredList = i.rankOnCall.stream().map(s->Double.parseDouble(s.getText())).collect(Collectors.toList());
			eFilteredList.forEach(s->System.out.println(s));
			System.out.println("===============");
			aFilteredList.forEach(s->System.out.println(s));
			Assert.assertEquals(aFilteredList, eFilteredList);
		}
		else
		{
			Assert.assertTrue(i.newCalls.isEmpty());
		}
		
		
	}
	

	
	
	
	
	

}
