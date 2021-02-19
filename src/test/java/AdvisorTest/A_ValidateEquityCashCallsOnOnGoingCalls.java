package AdvisorTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Advisor.A_AdvisorDashBoardPage;
import PageObject_Advisor.A_EquityCashCallPage;
import PageObject_Advisor.A_EquityFutureCallPage;
import PageObject_Advisor.A_PickRightLandingPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;

public class A_ValidateEquityCashCallsOnOnGoingCalls extends Base {
	A_AdvisorDashBoardPage a;
	A_EquityCashCallPage c;
	DecimalFormat f;
	ArrayList<String> list=new ArrayList<String>();
	@Test(priority=1)
	public void v1() throws AWTException, InterruptedException
	{
		f = new DecimalFormat("##.00");
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
		h.toggleButton.click();
		h.getStartTrading();
		a = new A_AdvisorDashBoardPage(driver);
		a.getEquity();
		a.getEquityCash();
		a.createCall.click();
		 c=new A_EquityCashCallPage(driver);
		c.scripNameField.sendKeys("TVS");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		String scrip = c.EquityCashAutoSuggesions.get(0).getText();
		list.add(scrip);
		c.EquityCashAutoSuggesions.get(0).click();
		double cmp=c.getCmpValue();
	//	String lotText = c.lotSize.getText();
		c.callTypeBuy.click();
		String buyText=c.callTypeBuy.getText();
		c.marketPriceRadioButton.click();
		c.stopLossField.sendKeys(String.valueOf(cmp - (cmp * 0.14)));
		double target = cmp + (cmp * 0.16);
		c.targetField.sendKeys(String.valueOf(target));		
		String investment = c.investmentValue.getText().replace("\u20B9","").replace(",","");
		c.minRangeField.sendKeys(String.valueOf(cmp - (target - cmp)/4));
		c.maxRangeField.sendKeys(String.valueOf(cmp + (target - cmp)/4));
		c.quantityField.sendKeys("1");
		c.timeFrameIntraDay.click();
		String timeFrameText = c.timeFrameIntraDay.getText();
		c.riskValueLow.click();
		String lowRiskText = c.riskValueLow.getText();
		Thread.sleep(1000);
		c.publishCall.click();
		Assert.assertTrue(a.activeTitle.getText().equalsIgnoreCase("Active"));
		Assert.assertTrue(a.scriptNameInCall.getText().equalsIgnoreCase(scrip));
		System.out.println(a.RiskTextOnTheCall.getText());
		Assert.assertTrue(a.RiskTextOnTheCall.getText().contains(lowRiskText));
		Assert.assertTrue(timeFrameText.toLowerCase().replaceAll("\\s","").equals(a.timeFrameOnCall.getText().toLowerCase()));
		Assert.assertTrue(buyText.equalsIgnoreCase(a.callTypeOnCall.getText()));
		Assert.assertTrue(Double.parseDouble((a.stopLossOnCall.getText()))==Double.parseDouble(f.format(cmp - (cmp * 0.14))));
		Assert.assertTrue(Double.parseDouble((a.targetOnCall.getText()))==Double.parseDouble(f.format(target)));
	    Assert.assertTrue(a.lotSizeOnCall.getText().equalsIgnoreCase("*Calculation based on 1 Share"));
	    Thread.sleep(3000);
	    double cmpValue=Double.parseDouble(a.cmpValueOnCall.getText());
	    double entryAt=Double.parseDouble(a.entryAtOnCall.getText());
	   
	    String profitOrLoss=f.format((cmpValue-entryAt));
	//    System.out.println(profitOrLoss);
	    String profitOrLossPercent=f.format((Double.parseDouble(profitOrLoss)/entryAt)*100);
	//    System.out.println(profitOrLossPercent);
	/*    System.out.println(a.profirLossCalculationOnCall.getText());
	    String[] split = a.profirLossCalculationOnCall.getText().split("||");
	    System.out.println(split[0]);
	    System.out.println(Double.parseDouble(profitOrLoss));
	    System.out.println(split[1].replace("%",""));
	    System.out.println(Double.parseDouble(profitOrLossPercent));
	    Assert.assertTrue(Double.parseDouble(split[0])==Double.parseDouble(profitOrLoss));
	    Assert.assertTrue(Double.parseDouble(split[1].replace("%",""))==Double.parseDouble(profitOrLossPercent));
	    */
	    Assert.assertTrue(a.message.isDisplayed());
	    Assert.assertTrue(a.close.isDisplayed());
	    Assert.assertTrue(a.edit.isDisplayed());
	    String maxProfit = f.format(((Double.parseDouble(a.targetOnCall.getText())-Double.parseDouble(a.entryAtOnCall.getText()))/Double.parseDouble(a.entryAtOnCall.getText()))*100);
	    System.out.println(maxProfit);
	    System.out.println(a.maxProfitOnCall.getText());
	    Assert.assertTrue(a.viewCallActivity.getText().equalsIgnoreCase("View Call Activity"));
	    Assert.assertTrue(a.investorBought.getText().equalsIgnoreCase("0 Investor bought"));
	    Assert.assertTrue(a.unlockedAmount.getText().equalsIgnoreCase("\u20B9 00.00"));
	   
	    
	}
	
	@Test(priority=2,enabled=true,expectedExceptions = NoSuchElementException.class)
	public void v2() throws InterruptedException, AWTException
	{
		a.createCall.click();
		c.scripNameField.sendKeys("TVS");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		String scrip = c.EquityCashAutoSuggesions.get(1).getText();
		list.add(scrip);
		c.EquityCashAutoSuggesions.get(1).click();
		double cmp=c.getCmpValue();
	//	String lotText = c.lotSize.getText();
		c.callTypeBuy.click();
		String buyText=c.callTypeBuy.getText();
		c.recommendedPriceRadioButton.click();
		double rp=cmp+2.0;
		c.recommendedPriceField.sendKeys(String.valueOf(rp));
		c.stopLossField.sendKeys(String.valueOf(rp - (rp * 0.14)));
		double target = rp + (rp * 0.16);
		c.targetField.sendKeys(String.valueOf(target));		
		String investment = c.investmentValue.getText().replace("\u20B9","").replace(",","");
		c.minRangeField.sendKeys(String.valueOf(rp - (target - rp)/4));
		c.maxRangeField.sendKeys(String.valueOf(rp + (target - rp)/4));
		c.quantityField.sendKeys("1");
		c.timeFrameIntraDay.click();
		String timeFrameText = c.timeFrameIntraDay.getText();
		c.riskValueLow.click();
		String lowRiskText = c.riskValueLow.getText();
		Thread.sleep(1000);
		c.publishCall.click();
		Thread.sleep(1000);
		Assert.assertTrue(a.awaitingTitle.getText().equalsIgnoreCase("Awaiting"));
		Assert.assertTrue(a.scriptNameInCall.getText().equalsIgnoreCase(scrip));
		System.out.println(a.RiskTextOnTheCall.getText());
		Assert.assertTrue(a.RiskTextOnTheCall.getText().contains(lowRiskText));
		Assert.assertTrue(timeFrameText.toLowerCase().replaceAll("\\s","").equals(a.timeFrameOnCall.getText().toLowerCase()));
		Assert.assertTrue(buyText.equalsIgnoreCase(a.callTypeOnCall.getText()));
		Assert.assertTrue(Double.parseDouble((a.entryAtOnCall.getText()))==rp);
		Assert.assertTrue(Double.parseDouble((a.stopLossOnCall.getText()))==Double.parseDouble(f.format(rp - (rp * 0.14))));
		Assert.assertTrue(Double.parseDouble((a.targetOnCall.getText()))==Double.parseDouble(f.format(target)));
	    Assert.assertTrue(a.lotSizeOnCall.getText().equalsIgnoreCase("*Calculation based on 1 Share"));
	    Assert.assertFalse(a.profirLossCalculationOnCall.isDisplayed());
	    Assert.assertTrue(a.message.isDisplayed());
	    Assert.assertTrue(a.close.isDisplayed());
	    Assert.assertTrue(a.edit.isDisplayed());
	    String maxProfit = f.format(((Double.parseDouble(a.targetOnCall.getText())-Double.parseDouble(a.entryAtOnCall.getText()))/Double.parseDouble(a.entryAtOnCall.getText()))*100);
	    System.out.println(maxProfit);
	    System.out.println(a.maxProfitOnCall.getText());
	    Assert.assertTrue(a.viewCallActivity.getText().equalsIgnoreCase("View Call Activity"));
	    Assert.assertTrue(a.investorBought.getText().equalsIgnoreCase("0 Investor bought"));
	    Assert.assertTrue(a.unlockedAmount.getText().equalsIgnoreCase("\u20B9 00.00"));
	}
	
	@Test(priority=3,enabled=true)
	public void v3() throws AWTException, InterruptedException
	{
		a.createCall.click();
		c.scripNameField.sendKeys("TVS");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		String scrip = c.EquityCashAutoSuggesions.get(1).getText();
		list.add(scrip);
		c.EquityCashAutoSuggesions.get(1).click();
		double cmp=c.getCmpValue();
	//	String lotText = c.lotSize.getText();
		c.callTypeSell.click();
		String sellText=c.callTypeSell.getText();
		c.marketPriceRadioButton.click();
		c.stopLossField.sendKeys(String.valueOf(cmp + (cmp * 0.14)));
		double target = cmp - (cmp * 0.16);
		c.targetField.sendKeys(String.valueOf(target));
		String investment = c.investmentValue.getText().replace("\u20B9","").replace(",","");
		c.minRangeField.sendKeys(String.valueOf(cmp + (cmp-target)/4));
		c.maxRangeField.sendKeys(String.valueOf(cmp - (cmp-target)/4));
		c.quantityField.sendKeys("1");
	//	c.timeFrameIntraDay.click();
		String timeFrameText = c.timeFrameIntraDay.getText();
		c.riskValueLow.click();
		String lowRiskText = c.riskValueLow.getText();
		Thread.sleep(1000);
		c.publishCall.click();
		Thread.sleep(1000);
		Assert.assertTrue(a.activeTitle.getText().equalsIgnoreCase("Active"));
		Assert.assertTrue(a.scriptNameInCall.getText().equalsIgnoreCase(scrip));
		System.out.println(a.RiskTextOnTheCall.getText());
		Assert.assertTrue(a.RiskTextOnTheCall.getText().contains(lowRiskText));
		Assert.assertTrue(timeFrameText.toLowerCase().replaceAll("\\s","").equals(a.timeFrameOnCall.getText().toLowerCase()));
		Assert.assertTrue(sellText.equalsIgnoreCase(a.callTypeOnCall.getText()));
		Assert.assertTrue(Double.parseDouble((a.stopLossOnCall.getText()))==Double.parseDouble(f.format(cmp + (cmp * 0.14))));
		Assert.assertTrue(Double.parseDouble((a.targetOnCall.getText()))==Double.parseDouble(f.format(target)));
		Assert.assertTrue(a.lotSizeOnCall.getText().equalsIgnoreCase("*Calculation based on 1 Share"));
		Thread.sleep(3000);
		double cmpValue=Double.parseDouble(a.cmpValueOnCall.getText());
	    double entryAt=Double.parseDouble(a.entryAtOnCall.getText());
	    String profitOrLoss=f.format((entryAt-cmpValue));
	    String profitOrLossPercent=f.format((Double.parseDouble(profitOrLoss)/entryAt)*100);
	 /*   String[] split = a.profirLossCalculationOnCall.getText().split("||");
	    Assert.assertTrue(Double.parseDouble(split[0])==Double.parseDouble(profitOrLoss));
	    Assert.assertTrue(Double.parseDouble(split[1].replace("%",""))==Double.parseDouble(profitOrLossPercent));
	    */
	    Assert.assertTrue(a.message.isDisplayed());
	    Assert.assertTrue(a.close.isDisplayed());
	    Assert.assertTrue(a.edit.isDisplayed());
	    String maxProfit = f.format(((Double.parseDouble(a.entryAtOnCall.getText())-Double.parseDouble(a.targetOnCall.getText()))/Double.parseDouble(a.entryAtOnCall.getText()))*100);
	    System.out.println(maxProfit);
	    System.out.println(a.maxProfitOnCall.getText());
	    Assert.assertTrue(a.maxProfitOnCall.getText().equalsIgnoreCase("Max Profit "+maxProfit+"%"));
	    Assert.assertTrue(a.viewCallActivity.getText().equalsIgnoreCase("View Call Activity"));
	    Assert.assertTrue(a.investorBought.getText().equalsIgnoreCase("0 Investor bought"));
	    Assert.assertTrue(a.unlockedAmount.getText().equalsIgnoreCase("\u20B9 00.00"));
	}
	
	@Test(priority=4,enabled=true,expectedExceptions = NoSuchElementException.class)
	public void v4() throws InterruptedException, AWTException
	{
		a.createCall.click();
		c.scripNameField.sendKeys("TVS");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		String scrip = c.EquityCashAutoSuggesions.get(1).getText();
		list.add(scrip);
		c.EquityCashAutoSuggesions.get(1).click();
		double cmp=c.getCmpValue();
	//	String lotText = c.lotSize.getText();
		c.callTypeSell.click();
		String sellText=c.callTypeSell.getText();
		c.recommendedPriceRadioButton.click();
		double rp = cmp+2.0;
		c.recommendedPriceField.sendKeys(String.valueOf(rp));
		c.stopLossField.sendKeys(String.valueOf(rp + (rp * 0.14)));
		double target = rp - (rp * 0.16);
		c.targetField.sendKeys(String.valueOf(target));
		String investment = c.investmentValue.getText().replace("\u20B9","").replace(",","");
		c.minRangeField.sendKeys(String.valueOf(rp + (rp-target)/4));
		c.maxRangeField.sendKeys(String.valueOf(rp - (rp-target)/4));
		c.quantityField.sendKeys("1");
	//	c.timeFrameIntraDay.click();
		String timeFrameText = c.timeFrameIntraDay.getText();
		c.riskValueLow.click();
		String lowRiskText = c.riskValueLow.getText();
		Thread.sleep(1000);
		c.publishCall.click();
		Thread.sleep(1000);
		Assert.assertTrue(a.awaitingTitle.getText().equalsIgnoreCase("Awaiting"));
		Assert.assertTrue(a.scriptNameInCall.getText().equalsIgnoreCase(scrip));
		System.out.println(a.RiskTextOnTheCall.getText());
		Assert.assertTrue(a.RiskTextOnTheCall.getText().contains(lowRiskText));
		Assert.assertTrue(timeFrameText.toLowerCase().replaceAll("\\s","").equals(a.timeFrameOnCall.getText().toLowerCase()));
		Assert.assertTrue(sellText.equalsIgnoreCase(a.callTypeOnCall.getText()));
		Assert.assertTrue(Double.parseDouble((a.entryAtOnCall.getText()))==rp);
		Assert.assertTrue(Double.parseDouble((a.stopLossOnCall.getText()))==Double.parseDouble(f.format(rp + (rp * 0.14))));
		Assert.assertTrue(Double.parseDouble((a.targetOnCall.getText()))==Double.parseDouble(f.format(target)));
		Assert.assertTrue(a.lotSizeOnCall.getText().equalsIgnoreCase("*Calculation based on 1 Share"));
		Assert.assertFalse(a.profirLossCalculationOnCall.isDisplayed());
		Assert.assertTrue(a.message.isDisplayed());
	    Assert.assertTrue(a.close.isDisplayed());
	    Assert.assertTrue(a.edit.isDisplayed());
	    String maxProfit = f.format(((Double.parseDouble(a.entryAtOnCall.getText())-Double.parseDouble(a.targetOnCall.getText()))/Double.parseDouble(a.entryAtOnCall.getText()))*100);
	    System.out.println(maxProfit);
	    System.out.println(a.maxProfitOnCall.getText());
	//    Assert.assertTrue(a.maxProfitOnCall.getText().equalsIgnoreCase("Max Profit "+maxProfit+"%"));
	    Assert.assertTrue(a.viewCallActivity.getText().equalsIgnoreCase("View Call Activity"));
	    Assert.assertTrue(a.investorBought.getText().equalsIgnoreCase("0 Investor bought"));
	    Assert.assertTrue(a.unlockedAmount.getText().equalsIgnoreCase("\u20B9 00.00"));
	   
	   
	}

}
