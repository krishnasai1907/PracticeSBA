package Practice.PracticeSBA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//Main class to start the Test
public class MainTest {
	WebDriver driver;
	@BeforeMethod//pre condition Annotation
	public void setUp() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Krishna\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(PropertyFile.getUrl("url"));
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
	}
	
	@Test//Main Test
	public void TestRun() throws Exception
	{
		LoginPage login=new LoginPage(driver);
		login.getLogin(ReadExcel.getData(0, 0, 0),ReadExcel.getData(0, 0, 1));
		
	}
	@AfterMethod//post condition Annotation
	public void teadDown()
	{
		driver.close();
	}
	
}
