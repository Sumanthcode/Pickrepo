package InvestorTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class ZerodaLogin {
	
	@Test
	public void login() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://stage-admin.pickright.co.in/");
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("info@pickright.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pickright@1212");
		driver.findElement(By.xpath("//button[@class='submit-button width--100 mat-raised-button mat-accent']")).click();
		driver.findElement(By.xpath("//span[@class='nav-link-title ng-tns-c21-7 ng-star-inserted']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Kite')]")).click();
		driver.findElement(By.xpath("//button[@class='indigo mat-stroked-button']")).click();
//		WebDriverWait wait=new WebDriverWait(driver,5);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='User ID']")));
		driver.findElement(By.xpath("//input[@id='userid']")).sendKeys("XF7047");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("victory@1212");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//input[@id='pin']")).sendKeys("121212");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		String url = driver.getCurrentUrl().replace("https://admin.pickright.in","http://stage-admin.pickright.co.in");
		driver.get(url);
		
		
	}

}
