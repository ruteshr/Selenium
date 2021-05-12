package mySeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTest1 {
	WebDriver driver=null;
	
	@BeforeTest
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://facebook.com");
		Thread.sleep(2000);
	}
	
	@Test
	public void testcase1(){
		
		driver.findElement(By.name("email")).sendKeys("abc@example.com");
		driver.findElement(By.name("login")).click();
		String pwderr=driver.findElement(By.className("_9ay7")).getText();
		System.out.println("Testcase 1 :"+pwderr);
		
		//WebDriverWait wait=new WebDriverWait(driver,20);
		/*
		WebElement lastname=wait.until(ExpectedConditions.elementToBeClickable(By.name("lname")));
		lastname.sendKeys("B");
				//----------- Use the above OR below two line ----------
		*/
//		wait.until(ExpectedConditions.elementToBeClickable(By.name("lname")));
//		driver.findElement(By.name("lname")).sendKeys("B");	
				
	}
	@Test
	public void testcase2() {
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("pass")).clear();
		driver.findElement(By.name("email")).sendKeys("abc@example.com");
		driver.findElement(By.name("pass")).sendKeys("123");
		driver.findElement(By.name("login")).click();
		String nameerr=driver.findElement(By.className("_9ay7")).getText();
		System.out.println("Testcase 2 :"+nameerr);
	}
	@Test
	public void testcase3() {
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("pass")).sendKeys("123");
		driver.findElement(By.name("login")).click();
		String nameerr=driver.findElement(By.className("_9ay7")).getText();
		System.out.println("Testcase 2 :"+nameerr);
	}
	
	@AfterTest
	public void closing() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}

}
