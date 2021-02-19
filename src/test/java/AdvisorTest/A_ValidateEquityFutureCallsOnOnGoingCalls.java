package AdvisorTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import org.testng.Assert;
import org.testng.annotations.Test;

import Generic.Base;
import PageObject_Advisor.A_AdvisorDashBoardPage;
import PageObject_Advisor.A_EquityFutureCallPage;
import PageObject_Advisor.A_PickRightLandingPage;
import PageObject_Investor.EnterOtpPage;
import PageObject_Investor.HomePage;
import PageObject_Investor.LoginOrSignUpPage;

public class A_ValidateEquityFutureCallsOnOnGoingCalls extends Base {
	A_AdvisorDashBoardPage a;
	A_EquityFutureCallPage c;
	 DecimalFormat f ;
	@Test(priority=1)
	public void validateCallName() throws InterruptedException, AWTException
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
		a.getEquity();
		a.getEquityFuture();
		a.createCall.click();
		 c=new A_EquityFutureCallPage(driver);
		c.scripNameField.sendKeys("MARI");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		String scrip = c.EquityFutureAutoSuggesions.get(1).getText();
		c.EquityFutureAutoSuggesions.get(1).click();
		double cmp=c.getCmpValue();
		String lotText = c.lotSize.getText();
		c.callTypeBuy.click();
		String buyText=c.getCallTypeBuyText();
		c.marketPriceRadioButton.click();
		c.stopLossField.sendKeys(String.valueOf(cmp-3.0));
		c.targetField.sendKeys(String.valueOf(cmp +5.0));		
		String investment = c.investmentValue.getText().replace("\u20B9","").replace(",","");
		double cmp1=c.getCmpValue();
		c.minRangeField.sendKeys(String.valueOf(cmp1 - ((cmp1+5.0) - cmp1)/4));
		double cmp2=c.getCmpValue();
		c.maxRangeField.sendKeys(String.valueOf(cmp2 + ((cmp2+5.0) - cmp2)/4));
		c.quantityField.sendKeys("1");
		c.timeFrameIntraDay.click();
		String timeFrameText = c.timeFrameIntraDay.getText();
		c.riskValueLow.click();
		String lowRiskText = c.riskValueLow.getText();
		Thread.sleep(1000);
		c.publishCall.click();
		Thread.sleep(2000);
		Assert.assertTrue(a.activeTitle.getText().equalsIgnoreCase("Active"));
		Assert.assertTrue(a.scriptNameInCall.getText().equalsIgnoreCase(scrip));
		Assert.assertTrue(a.RiskTextOnTheCall.getText().contains(lowRiskText));
		Assert.assertTrue(timeFrameText.toLowerCase().replaceAll("\\s","").equals(a.timeFrameOnCall.getText().toLowerCase()));
		Assert.assertTrue(buyText.equalsIgnoreCase(a.callTypeOnCall.getText()));
		System.out.println(Double.parseDouble((a.stopLossOnCall.getText())));
		System.out.println(Double.parseDouble(f.format(cmp-3.0)));
		Assert.assertTrue(Double.parseDouble((a.stopLossOnCall.getText()))==Double.parseDouble(f.format(cmp-3.0)));
		Assert.assertTrue(Double.parseDouble((a.targetOnCall.getText()))==Double.parseDouble(f.format(cmp+5.0)));
		Assert.assertTrue(Double.parseDouble(a.approxInvestmentValueOnCall.getText().replace(",",""))==Double.parseDouble(investment));
	    Assert.assertTrue(a.lotSizeOnCall.getText().equalsIgnoreCase("*Calculation based on "+lotText));
	    double lot=Double.parseDouble(a.lotSizeOnCall.getText().split("=")[1].replaceAll("[^0-9]", ""));
	    double cmpValue=Double.parseDouble(a.cmpValueOnCall.getText());
	    double entryAt=Double.parseDouble(a.entryAtOnCall.getText());
	    double investmentValue=Double.parseDouble(a.approxInvestmentValueOnCall.getText().replace(",",""));
	    
	    String profitOrLoss=f.format((cmpValue-entryAt)*lot);
	//    System.out.println(profitOrLoss);
	    String profitOrLossPercent=f.format((Double.parseDouble(profitOrLoss)/investmentValue)*100);
//	    System.out.println(profitOrLossPercent);
	//    Assert.assertTrue(a.profirLossCalculationOnCall.getText().equalsIgnoreCase(profitOrLoss+" || "+profitOrLossPercent+"%" ));
	    Assert.assertTrue(a.message.isDisplayed());
	    Assert.assertTrue(a.close.isDisplayed());
	    Assert.assertTrue(a.edit.isDisplayed());
	    double toc = Double.parseDouble(a.targetOnCall.getText());
	    double eoc = Double.parseDouble(a.entryAtOnCall.getText());
	    String maxProfit =f.format((((toc-eoc)*lot)/investmentValue)*100);
	    Assert.assertTrue(Double.parseDouble(a.maxProfitOnCall.getText().replaceAll("[a-zA-Z]","").replace("%",""))==Double.parseDouble(maxProfit));

	}
	
//	@Test(priority=2,enabled=true)
	public void v2() throws AWTException, InterruptedException
	{
		a.createCall.click();
		c.scripNameField.sendKeys("MARI");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		String scrip = c.EquityFutureAutoSuggesions.get(1).getText();
		c.EquityFutureAutoSuggesions.get(1).click();
		double cmp=c.getCmpValue();
		String lotText = c.lotSize.getText();
		c.callTypeBuy.click();
		String buyText=c.getCallTypeBuyText();
		c.recommendedPriceRadioButton.click();
		double rp= cmp+2.0;
		c.recommendedPriceField.sendKeys(String.valueOf(rp));
		c.stopLossField.sendKeys(String.valueOf(rp-3.0));
		c.targetField.sendKeys(String.valueOf(rp +5.0));
		String investment = c.investmentValue.getText().replace("\u20B9","").replace(",","");
		c.minRangeField.sendKeys(String.valueOf(rp - ((rp+5.0) - rp)/4));
		c.maxRangeField.sendKeys(String.valueOf(rp + ((rp+5.0) - rp)/4));
		c.quantityField.sendKeys("1");
		c.timeFrameIntraDay.click();
		String timeFrameText = c.timeFrameIntraDay.getText();
		c.riskValueLow.click();
		String lowRiskText = c.riskValueLow.getText();
		Thread.sleep(1000);
		c.publishCall.click();
		Assert.assertTrue(a.awaitingTitle.getText().equalsIgnoreCase("Awaiting"));
		Assert.assertTrue(a.scriptNameInCall.getText().equalsIgnoreCase(scrip));
		Assert.assertTrue(a.RiskTextOnTheCall.getText().contains(lowRiskText));
		Assert.assertTrue(timeFrameText.toLowerCase().replaceAll("\\s","").equals(a.timeFrameOnCall.getText().toLowerCase()));
		Assert.assertTrue(buyText.equalsIgnoreCase(a.callTypeOnCall.getText()));
		Assert.assertTrue(Double.parseDouble((a.entryAtOnCall.getText()))==rp);
		Assert.assertTrue(Double.parseDouble((a.stopLossOnCall.getText()))==rp-3.0);
		Assert.assertTrue(Double.parseDouble((a.targetOnCall.getText()))==rp+5.0);
		System.out.println(Double.parseDouble(a.approxInvestmentValueOnCall.getText().replace(",","")));
		System.out.println(Double.parseDouble(investment));
		Assert.assertTrue(Double.parseDouble(a.approxInvestmentValueOnCall.getText().replace(",",""))==Double.parseDouble(investment));
	    Assert.assertTrue(a.lotSizeOnCall.getText().equalsIgnoreCase("*Calculation based on "+lotText));
	    double investmentValue=Double.parseDouble(a.approxInvestmentValueOnCall.getText().replace(",",""));
	    double lot=Double.parseDouble(a.lotSizeOnCall.getText().split("=")[1].replaceAll("[^0-9]", ""));
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
	    String maxProfit =f.format((((toc-eoc)*lot)/investmentValue)*100);
	    System.out.println(a.maxProfitOnCall.getText());
	    System.out.println(Double.parseDouble(a.maxProfitOnCall.getText().replaceAll("[a-zA-Z]","").replace("%","")));
	    System.out.println(Double.parseDouble(maxProfit));
	//    Assert.assertTrue(Double.parseDouble(a.maxProfitOnCall.getText().replaceAll("[a-zA-Z]","").replace("%",""))==Double.parseDouble(maxProfit));
		
	}
	
//	@Test(priority=3,enabled=true)
	public void v3() throws InterruptedException, AWTException
	{
		a.createCall.click();
		 c=new A_EquityFutureCallPage(driver);
		c.scripNameField.sendKeys("MARI");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		String scrip = c.EquityFutureAutoSuggesions.get(1).getText();
		c.EquityFutureAutoSuggesions.get(1).click();
		double cmp=c.getCmpValue();
		String lotText = c.lotSize.getText();
		c.callTypeSell.click();
		String sellText=c.callTypeSell.getText();
		c.marketPriceRadioButton.click();
		c.stopLossField.sendKeys(String.valueOf(cmp+3.0));
		c.targetField.sendKeys(String.valueOf(cmp - 5.0));
		String investment = c.investmentValue.getText().replace("\u20B9","").replace(",","");
	//	double cmp1=c.getCmpValue();
		c.minRangeField.sendKeys(String.valueOf(cmp + (cmp - (cmp-5.0))/4));
	//	double cmp2=c.getCmpValue();
		c.maxRangeField.sendKeys(String.valueOf(cmp - (cmp - (cmp-5.0))/4));
		c.quantityField.sendKeys("1");
		c.timeFrameIntraDay.click();
		String timeFrameText = c.timeFrameIntraDay.getText();
		c.riskValueLow.click();
		String lowRiskText = c.riskValueLow.getText();
		Thread.sleep(1000);
		c.publishCall.click();
		Thread.sleep(2000);
		Assert.assertTrue(a.activeTitle.getText().equalsIgnoreCase("Active"));
		Assert.assertTrue(a.scriptNameInCall.getText().equalsIgnoreCase(scrip));
		Assert.assertTrue(a.RiskTextOnTheCall.getText().contains(lowRiskText));
		Assert.assertTrue(timeFrameText.toLowerCase().replaceAll("\\s","").equals(a.timeFrameOnCall.getText().toLowerCase()));
		Assert.assertTrue(sellText.equalsIgnoreCase(a.callTypeOnCall.getText()));
		Assert.assertTrue(Double.parseDouble((a.entryAtOnCall.getText()))==cmp);
		Assert.assertTrue(Double.parseDouble((a.stopLossOnCall.getText()))==cmp+3.0);
		Assert.assertTrue(Double.parseDouble((a.targetOnCall.getText()))==cmp-5.0);
		System.out.println(Double.parseDouble(a.approxInvestmentValueOnCall.getText().replace(",","")));
		System.out.println(Double.parseDouble(investment));
		Assert.assertTrue(Double.parseDouble(a.approxInvestmentValueOnCall.getText().replace(",",""))==Double.parseDouble(investment));
	    Assert.assertTrue(a.lotSizeOnCall.getText().equalsIgnoreCase("*Calculation based on "+lotText));
	    Thread.sleep(3000);
	    double lot=Double.parseDouble(a.lotSizeOnCall.getText().split("=")[1].replaceAll("[^0-9]", ""));
	    double cmpValue=Double.parseDouble(a.cmpValueOnCall.getText());
	    double entryAt=Double.parseDouble(a.entryAtOnCall.getText());
	    double investmentValue=Double.parseDouble(a.approxInvestmentValueOnCall.getText().replace(",",""));
	    String profitOrLoss=f.format((entryAt-cmpValue)*lot);
	//    System.out.println(profitOrLoss);
	    String profitOrLossPercent=f.format((Double.parseDouble(profitOrLoss)/investmentValue)*100);
	 //   System.out.println(profitOrLossPercent);
	 //   Assert.assertTrue(a.profirLossCalculationOnCall.getText().equalsIgnoreCase(profitOrLoss+" || "+profitOrLossPercent+"%" ));
	    Assert.assertTrue(a.message.isDisplayed());
	    Assert.assertTrue(a.close.isDisplayed());
	    Assert.assertTrue(a.edit.isDisplayed());
	    String maxProfit = f.format((((Double.parseDouble(a.entryAtOnCall.getText())-Double.parseDouble(a.targetOnCall.getText()))*lot)/investmentValue)*100);
	    System.out.println(a.maxProfitOnCall.getText());
	    System.out.println(Double.parseDouble(a.maxProfitOnCall.getText().replaceAll("[a-zA-Z]","").replace("%","")));
	    System.out.println(Double.parseDouble(maxProfit));
	    Assert.assertTrue(Double.parseDouble(a.maxProfitOnCall.getText().replaceAll("[a-zA-Z]","").replace("%",""))==Double.parseDouble(maxProfit));
	}
	
	@Test(priority=4,enabled=true)
	public void v4() throws InterruptedException, AWTException
	{
		a.createCall.click();
		c.scripNameField.sendKeys("MARI");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		String scrip = c.EquityFutureAutoSuggesions.get(1).getText();
		c.EquityFutureAutoSuggesions.get(1).click();
		double cmp=c.getCmpValue();
		String lotText = c.lotSize.getText();
		c.callTypeSell.click();
		String sellText=c.callTypeSell.getText();
		c.recommendedPriceRadioButton.click();
		double rp= cmp+2.0;
		c.recommendedPriceField.sendKeys(String.valueOf(rp));
		c.stopLossField.sendKeys(String.valueOf(rp+3.0));
		c.targetField.sendKeys(String.valueOf(rp - 5.0));
		String investment = c.investmentValue.getText().replace("\u20B9","").replace(",","");
		c.minRangeField.sendKeys(String.valueOf(rp + (rp -(rp-5.0))/4));
		c.maxRangeField.sendKeys(String.valueOf(rp - (rp-(rp-5.0))/4));
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
		Assert.assertTrue(a.RiskTextOnTheCall.getText().contains(lowRiskText));
		Assert.assertTrue(timeFrameText.toLowerCase().replaceAll("\\s","").equals(a.timeFrameOnCall.getText().toLowerCase()));
		Assert.assertTrue(sellText.equalsIgnoreCase(a.callTypeOnCall.getText()));
		Assert.assertTrue(Double.parseDouble((a.entryAtOnCall.getText()))==rp);
		Assert.assertTrue(Double.parseDouble((a.stopLossOnCall.getText()))==rp+3.0);
		Assert.assertTrue(Double.parseDouble((a.targetOnCall.getText()))==rp-5.0);
		System.out.println(Double.parseDouble(a.approxInvestmentValueOnCall.getText().replace(",","")));
		System.out.println(Double.parseDouble(investment));
		Assert.assertTrue(Double.parseDouble(a.approxInvestmentValueOnCall.getText().replace(",",""))==Double.parseDouble(investment));
	    Assert.assertTrue(a.lotSizeOnCall.getText().equalsIgnoreCase("*Calculation based on "+lotText));
	    double investmentValue=Double.parseDouble(a.approxInvestmentValueOnCall.getText().replace(",",""));
	    double lot=Double.parseDouble(a.lotSizeOnCall.getText().split("=")[1].replaceAll("[^0-9]", ""));
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
	    double eoc = Double.parseDouble(a.entryAtOnCall.getText());
	    double toc = Double.parseDouble(a.targetOnCall.getText());
	    String maxProfit = f.format((((eoc-toc)*lot)/investmentValue)*100);
	    System.out.println(a.maxProfitOnCall.getText());
	    System.out.println(Double.parseDouble(a.maxProfitOnCall.getText().replaceAll("[a-zA-Z]","").replace("%","")));
	    System.out.println(Double.parseDouble(maxProfit));
	//    Assert.assertTrue(Double.parseDouble(a.maxProfitOnCall.getText().replaceAll("[a-zA-Z]","").replace("%",""))==Double.parseDouble(maxProfit));	}
}
}
