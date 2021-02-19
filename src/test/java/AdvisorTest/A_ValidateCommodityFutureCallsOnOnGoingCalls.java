package AdvisorTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Advisor.A_AdvisorDashBoardPage;
import PageObject_Advisor.A_CommodityFutureCallPage;
import PageObject_Advisor.A_CurrencyFutureCallPage;
import PageObject_Advisor.A_PickRightLandingPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;

public class A_ValidateCommodityFutureCallsOnOnGoingCalls extends Base {
	A_CommodityFutureCallPage c;
	A_AdvisorDashBoardPage a;
	DecimalFormat f;
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
		h.getStartTrading();
		a = new A_AdvisorDashBoardPage(driver);
		a.getCommodity();
		a.commodityFuture.click();
		a.getCreateCall();
		c=new A_CommodityFutureCallPage(driver);
		c.setScriptNameField("COPPER");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		String scrip = c.commodityFutureAutoSuggesions.get(1).getText();
		c.commodityFutureAutoSuggesions.get(1).click();
		double cmp=c.getCmpValue();
		String lotText = c.lotSize.getText();
		c.callTypeBuy.click();
		String buyText=c.callTypeBuy.getText();
		c.marketPriceRadioButton.click();
		c.stopLossField.sendKeys(String.valueOf(cmp-3.0));
		c.targetField.sendKeys(String.valueOf(cmp +5.0));		
		String investment = c.investmentValue.getText().replace("\u20B9","").replace(",","");
		double minRange=(cmp - ((cmp+5.0) - cmp)/4)+0.01;
		double maxRange=(cmp + ((cmp+5.0) - cmp)/4)-0.01;
		c.minRangeField.sendKeys(String.valueOf(minRange));
		c.maxRangeField.sendKeys(String.valueOf(maxRange));
		c.quantityField.sendKeys("1");
		c.timeFrameIntraDay.click();
		String timeFrameText = c.timeFrameIntraDay.getText();
		c.riskValueLow.click();
		String lowRiskText = c.riskValueLow.getText();
		Thread.sleep(2000);
		c.publishCall.click();
		Assert.assertTrue(a.activeTitle.getText().equalsIgnoreCase("Active"));
		Assert.assertTrue(a.scriptNameInCall.getText().equalsIgnoreCase(scrip));
		Assert.assertTrue(a.RiskTextOnTheCall.getText().contains(lowRiskText));
		Assert.assertTrue(timeFrameText.toLowerCase().replaceAll("\\s","").equals(a.timeFrameOnCall.getText().toLowerCase()));
		Assert.assertTrue(buyText.equalsIgnoreCase(a.callTypeOnCall.getText()));
		Assert.assertTrue(a.entryAtOnCall.isDisplayed());
		Assert.assertTrue(Double.parseDouble((a.stopLossOnCall.getText()))==Double.parseDouble(f.format(cmp-3.0)));
		Assert.assertTrue(Double.parseDouble((a.targetOnCall.getText()))==Double.parseDouble(f.format(cmp+5.0)));
		Assert.assertTrue(Double.parseDouble(a.approxInvestmentValueOnCall.getText().replace(",",""))==Double.parseDouble(investment));
	    Assert.assertTrue(a.lotSizeOnCall.getText().equalsIgnoreCase("*Calculation based on "+lotText));
	    double lot=Double.parseDouble(a.lotSizeOnCall.getText().split("=")[1].split(" ")[1]);
	    double cmpValue=Double.parseDouble(a.cmpValueOnCall.getText());
	    double entryAt=Double.parseDouble(a.entryAtOnCall.getText());
	    double investmentValue=Double.parseDouble(a.approxInvestmentValueOnCall.getText().replace(",",""));
	    double profitOrLoss=Double.parseDouble(f.format((cmpValue-entryAt)*lot));
	    double profitOrLossPercent=Double.parseDouble(f.format(((profitOrLoss)/investmentValue)*100));
	    Assert.assertTrue(a.message.isDisplayed());
	    Assert.assertTrue(a.close.isDisplayed());
	    Assert.assertTrue(a.edit.isDisplayed());
	    double toc = Double.parseDouble(a.targetOnCall.getText());
	    double eoc = Double.parseDouble(a.entryAtOnCall.getText());
	    String maxProfit =(f.format((((toc-eoc)*lot)/investmentValue)*100));
	    System.out.println(maxProfit);
	    System.out.println(a.maxProfitOnCall.getText().replace(" ","").replaceAll("[a-zA-Z]","").replace("%",""));
	    Assert.assertTrue(Double.parseDouble(a.maxProfitOnCall.getText().replace(" ","").replaceAll("[a-zA-Z]","").replace("%",""))==Double.parseDouble(maxProfit));
	    Assert.assertTrue(a.viewCallActivity.getText().equalsIgnoreCase("View Call Activity"));
	    Assert.assertTrue(a.investorBought.getText().equalsIgnoreCase("0 Investor bought"));
	    Assert.assertTrue(a.unlockedAmount.getText().equalsIgnoreCase("\u20B9 00.00"));
		
	}
	
	@Test(priority=2)
	public void v2() throws InterruptedException, AWTException
	{
		a.getCreateCall();
		c.setScriptNameField("COPPER");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		String scrip = c.commodityFutureAutoSuggesions.get(1).getText();
		c.commodityFutureAutoSuggesions.get(1).click();
		double cmp=c.getCmpValue();
		String lotText = c.lotSize.getText();
		c.callTypeBuy.click();
		String buyText=c.callTypeBuy.getText();
		c.recommendedPriceRadioButton.click();
		double rp = cmp+2.0;
		c.recommendedPriceField.sendKeys(String.valueOf(rp));
		c.stopLossField.sendKeys(String.valueOf(rp-3.0));
		c.targetField.sendKeys(String.valueOf(rp +5.0));		
		String investment = c.investmentValue.getText().replace("\u20B9","").replace(",","");
		double minRange=(rp - ((rp+5.0) - rp)/4)+0.01;
		double maxRange=(rp + ((rp+5.0) - rp)/4)-0.01;
		c.minRangeField.sendKeys(String.valueOf(minRange));
		c.maxRangeField.sendKeys(String.valueOf(maxRange));
		c.quantityField.sendKeys("1");
		c.timeFrameIntraDay.click();
		String timeFrameText = c.timeFrameIntraDay.getText();
		c.riskValueLow.click();
		String lowRiskText = c.riskValueLow.getText();
		Thread.sleep(2000);
		c.publishCall.click();
		Assert.assertTrue(a.awaitingTitle.getText().equalsIgnoreCase("Awaiting"));
		Assert.assertTrue(a.scriptNameInCall.getText().equalsIgnoreCase(scrip));
		Assert.assertTrue(a.RiskTextOnTheCall.getText().contains(lowRiskText));
		Assert.assertTrue(timeFrameText.toLowerCase().replaceAll("\\s","").equals(a.timeFrameOnCall.getText().toLowerCase()));
		Assert.assertTrue(buyText.equalsIgnoreCase(a.callTypeOnCall.getText()));
		Assert.assertTrue(a.entryAtOnCall.isDisplayed());
		Assert.assertTrue(Double.parseDouble((a.stopLossOnCall.getText()))==Double.parseDouble(f.format(rp-3.0)));
		Assert.assertTrue(Double.parseDouble((a.targetOnCall.getText()))==Double.parseDouble(f.format(rp+5.0)));
		Assert.assertTrue(Double.parseDouble(a.approxInvestmentValueOnCall.getText().replace(",",""))==Double.parseDouble(investment));
	    Assert.assertTrue(a.lotSizeOnCall.getText().equalsIgnoreCase("*Calculation based on "+lotText));
	    double lot=Double.parseDouble(a.lotSizeOnCall.getText().split("=")[1].split(" ")[1]);
	    double cmpValue=Double.parseDouble(a.cmpValueOnCall.getText());
	    double entryAt=Double.parseDouble(a.entryAtOnCall.getText());
	    double investmentValue=Double.parseDouble(a.approxInvestmentValueOnCall.getText().replace(",",""));
	    double profitOrLoss=Double.parseDouble(f.format((cmpValue-entryAt)*lot));
	    double profitOrLossPercent=Double.parseDouble(f.format(((profitOrLoss)/investmentValue)*100));
	    try
	    {
	    	Assert.assertFalse(a.profirLossCalculationOnCall.isDisplayed());
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	    Assert.assertTrue(a.message.isDisplayed());
	    Assert.assertTrue(a.close.isDisplayed());
	    Assert.assertTrue(a.edit.isDisplayed());
	    double toc = Double.parseDouble(a.targetOnCall.getText());
	    double eoc = Double.parseDouble(a.entryAtOnCall.getText());
	    String maxProfit =(f.format((((toc-eoc)*lot)/investmentValue)*100));
	    System.out.println(maxProfit);
	    System.out.println(a.maxProfitOnCall.getText());
	    System.out.println(a.maxProfitOnCall.getText().replace(" ","").replaceAll("[a-zA-Z]","").replace("%",""));
	    Assert.assertTrue(Double.parseDouble(a.maxProfitOnCall.getText().replace(" ","").replaceAll("[a-zA-Z]","").replace("%",""))==Double.parseDouble(maxProfit));
	    Assert.assertTrue(a.viewCallActivity.getText().equalsIgnoreCase("View Call Activity"));
	    Assert.assertTrue(a.investorBought.getText().equalsIgnoreCase("0 Investor bought"));
	    Assert.assertTrue(a.unlockedAmount.getText().equalsIgnoreCase("\u20B9 00.00"));
	}
	
	@Test(priority=3)
	public void v3() throws AWTException, InterruptedException
	{
		a.getCreateCall();
		c=new A_CommodityFutureCallPage(driver);
		c.setScriptNameField("COPPER");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		String scrip = c.commodityFutureAutoSuggesions.get(1).getText();
		c.commodityFutureAutoSuggesions.get(1).click();
		double cmp=c.getCmpValue();
		String lotText = c.lotSize.getText();
		c.callTypeSell.click();
		String sellText=c.callTypeSell.getText();
		c.marketPriceRadioButton.click();
		c.stopLossField.sendKeys(String.valueOf(cmp+3.0));
		c.targetField.sendKeys(String.valueOf(cmp -5.0));		
		String investment = c.investmentValue.getText().replace("\u20B9","").replace(",","");
		double minRange=cmp + (cmp -(cmp-5.0))/4;
		double maxRange=(cmp - (cmp -(cmp-5.0))/4)+0.01;
		c.minRangeField.sendKeys(String.valueOf(minRange));
		c.maxRangeField.sendKeys(String.valueOf(maxRange));
		c.quantityField.sendKeys("1");
		c.timeFrameIntraDay.click();
		String timeFrameText = c.timeFrameIntraDay.getText();
		c.riskValueLow.click();
		String lowRiskText = c.riskValueLow.getText();
		Thread.sleep(2000);
		c.publishCall.click();
		Assert.assertTrue(a.activeTitle.getText().equalsIgnoreCase("Active"));
		Assert.assertTrue(a.scriptNameInCall.getText().equalsIgnoreCase(scrip));
		Assert.assertTrue(a.RiskTextOnTheCall.getText().contains(lowRiskText));
		Assert.assertTrue(timeFrameText.toLowerCase().replaceAll("\\s","").equals(a.timeFrameOnCall.getText().toLowerCase()));
		Assert.assertTrue(sellText.equalsIgnoreCase(a.callTypeOnCall.getText()));
		Assert.assertTrue(a.entryAtOnCall.isDisplayed());
		Assert.assertTrue(Double.parseDouble((a.stopLossOnCall.getText()))==Double.parseDouble(f.format(cmp+3.0)));
		Assert.assertTrue(Double.parseDouble((a.targetOnCall.getText()))==Double.parseDouble(f.format(cmp-5.0)));
		Assert.assertTrue(Double.parseDouble(a.approxInvestmentValueOnCall.getText().replace(",",""))==Double.parseDouble(investment));
	    Assert.assertTrue(a.lotSizeOnCall.getText().equalsIgnoreCase("*Calculation based on "+lotText));
	    double lot=Double.parseDouble(a.lotSizeOnCall.getText().split("=")[1].split(" ")[1]);
	    double cmpValue=Double.parseDouble(a.cmpValueOnCall.getText());
	    double entryAt=Double.parseDouble(a.entryAtOnCall.getText());
	    double investmentValue=Double.parseDouble(a.approxInvestmentValueOnCall.getText().replace(",",""));
	    double profitOrLoss=Double.parseDouble(f.format((cmpValue-entryAt)*lot));
	    double profitOrLossPercent=Double.parseDouble(f.format(((profitOrLoss)/investmentValue)*100));
	    Assert.assertTrue(a.message.isDisplayed());
	    Assert.assertTrue(a.close.isDisplayed());
	    Assert.assertTrue(a.edit.isDisplayed());
	    double toc = Double.parseDouble(a.targetOnCall.getText());
	    double eoc = Double.parseDouble(a.entryAtOnCall.getText());
	    String maxProfit =(f.format((((eoc-toc)*lot)/investmentValue)*100));
	    System.out.println(maxProfit);
	    System.out.println(a.maxProfitOnCall.getText());
	    System.out.println(a.maxProfitOnCall.getText().replace(" ","").replaceAll("[a-zA-Z]","").replace("%",""));
	    Assert.assertTrue(Double.parseDouble(a.maxProfitOnCall.getText().replace(" ","").replaceAll("[a-zA-Z]","").replace("%",""))==Double.parseDouble(maxProfit));
	    Assert.assertTrue(a.viewCallActivity.getText().equalsIgnoreCase("View Call Activity"));
	    Assert.assertTrue(a.investorBought.getText().equalsIgnoreCase("0 Investor bought"));
	    Assert.assertTrue(a.unlockedAmount.getText().equalsIgnoreCase("\u20B9 00.00"));
		
	}
	
	@Test(priority=4)
	public void v4() throws InterruptedException, AWTException
	{
		a.getCreateCall();
		c=new A_CommodityFutureCallPage(driver);
		c.setScriptNameField("COPPER");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		String scrip = c.commodityFutureAutoSuggesions.get(1).getText();
		c.commodityFutureAutoSuggesions.get(1).click();
		double cmp=c.getCmpValue();
		String lotText = c.lotSize.getText();
		c.callTypeSell.click();
		String sellText=c.callTypeSell.getText();
		c.recommendedPriceRadioButton.click();
		double rp = cmp+2.0;
		c.recommendedPriceField.sendKeys(String.valueOf(rp));
		c.stopLossField.sendKeys(String.valueOf(rp+3.0));
		c.targetField.sendKeys(String.valueOf(rp -5.0));		
		String investment = c.investmentValue.getText().replace("\u20B9","").replace(",","");
		double minRange=rp + (rp -(rp-5.0))/4;
		double maxRange=(rp - (rp -(rp-5.0))/4)+0.01;
		c.minRangeField.sendKeys(String.valueOf(minRange));
		c.maxRangeField.sendKeys(String.valueOf(maxRange));
		c.quantityField.sendKeys("1");
		c.timeFrameIntraDay.click();
		String timeFrameText = c.timeFrameIntraDay.getText();
		c.riskValueLow.click();
		String lowRiskText = c.riskValueLow.getText();
		Thread.sleep(2000);
		c.publishCall.click();
		Assert.assertTrue(a.awaitingTitle.getText().equalsIgnoreCase("Awaiting"));
		Assert.assertTrue(a.scriptNameInCall.getText().equalsIgnoreCase(scrip));
		Assert.assertTrue(a.RiskTextOnTheCall.getText().contains(lowRiskText));
		Assert.assertTrue(timeFrameText.toLowerCase().replaceAll("\\s","").equals(a.timeFrameOnCall.getText().toLowerCase()));
		Assert.assertTrue(sellText.equalsIgnoreCase(a.callTypeOnCall.getText()));
		Assert.assertTrue(a.entryAtOnCall.isDisplayed());
		Assert.assertTrue(Double.parseDouble((a.stopLossOnCall.getText()))==Double.parseDouble(f.format(rp+3.0)));
		Assert.assertTrue(Double.parseDouble((a.targetOnCall.getText()))==Double.parseDouble(f.format(rp-5.0)));
		Assert.assertTrue(Double.parseDouble(a.approxInvestmentValueOnCall.getText().replace(",",""))==Double.parseDouble(investment));
	    Assert.assertTrue(a.lotSizeOnCall.getText().equalsIgnoreCase("*Calculation based on "+lotText));
	    double lot=Double.parseDouble(a.lotSizeOnCall.getText().split("=")[1].split(" ")[1]);
	    double cmpValue=Double.parseDouble(a.cmpValueOnCall.getText());
	    double entryAt=Double.parseDouble(a.entryAtOnCall.getText());
	    double investmentValue=Double.parseDouble(a.approxInvestmentValueOnCall.getText().replace(",",""));
	    double profitOrLoss=Double.parseDouble(f.format((cmpValue-entryAt)*lot));
	    double profitOrLossPercent=Double.parseDouble(f.format(((profitOrLoss)/investmentValue)*100));
	    try
	    {
	    	Assert.assertFalse(a.profirLossCalculationOnCall.isDisplayed());
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	    Assert.assertTrue(a.message.isDisplayed());
	    Assert.assertTrue(a.close.isDisplayed());
	    Assert.assertTrue(a.edit.isDisplayed());
	    double toc = Double.parseDouble(a.targetOnCall.getText());
	    double eoc = Double.parseDouble(a.entryAtOnCall.getText());
	    String maxProfit =(f.format((((eoc-toc)*lot)/investmentValue)*100));
	    System.out.println(maxProfit);
	    System.out.println(a.maxProfitOnCall.getText());
	    System.out.println(a.maxProfitOnCall.getText().replace(" ","").replaceAll("[a-zA-Z]","").replace("%",""));
	    Assert.assertTrue(Double.parseDouble(a.maxProfitOnCall.getText().replace(" ","").replaceAll("[a-zA-Z]","").replace("%",""))==Double.parseDouble(maxProfit));
	    Assert.assertTrue(a.viewCallActivity.getText().equalsIgnoreCase("View Call Activity"));
	    Assert.assertTrue(a.investorBought.getText().equalsIgnoreCase("0 Investor bought"));
	    Assert.assertTrue(a.unlockedAmount.getText().equalsIgnoreCase("\u20B9 00.00"));
		
	}

}
