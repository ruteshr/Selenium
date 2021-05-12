import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebTest2 {
	WebDriver driver=null;
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
		
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("msedge")) {
			
			System.setProperty("webdriver.edge.driver", "C:\\Selenium\\Drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		
	}
	
	@Test
	public void testcase(){
		driver.get("https://facebook.com");
		String pwderr=driver.getTitle();
		System.out.println("Title :"+pwderr);
				
	}
	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
}
// testng.xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">

<suite name="verify facebook homepage">
	<parameter name="browser" value="msedge"></parameter>
	<test name="facebook homepage">
		<classes>
			<class name="mySeleniumProject.WebTest2">
			</class>
		</classes>
	</test>

</suite>

