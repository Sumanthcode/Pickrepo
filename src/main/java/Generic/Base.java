package Generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

public class Base {

	public WebDriver driver;
	public Properties prop;

//	@Parameters({"Browser","Url"})
	@BeforeClass
	public WebDriver initiateBrowser() throws IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Selenium Automation\\PickrightAutomation\\src\\main\\java\\Generic\\global.properties");
		prop.load(fis);
		String browse = prop.getProperty("browser");

		if (browse.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver(option);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));

		} else if (browse.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new ChromeDriver(option);
		} else if (browse.equalsIgnoreCase("internetexplorer")) {
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new ChromeDriver(option);
		}

		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;

	}

//	@AfterClass
	public void closeTest() {
		driver.close();
	}

}
