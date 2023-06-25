package compaign.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class UploadFile {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
        WebElement a = driver.findElement(By.xpath("//p[text()='Campaigns']"));
        driver.executeScript("arguments[0].click();", a);
    	WebElement b = driver.findElement(By.xpath("//a[@title='Bootcamp']"));
		driver.executeScript("arguments[0].click();", b);
		 JavascriptExecutor js1=(JavascriptExecutor)driver;
			js1.executeScript("window.scrollBy(0,3000)");
			Thread.sleep(2000);
			WebElement e = driver.findElement(By.xpath("//input[@type='file']"));
			driver.executeScript("arguments[0].scrollIntoView(true)", e);  
		  e.sendKeys("C:\\Users\\keert\\Downloads\\XPath Cheat Sheet v1.1.pdf"); 
		 Thread.sleep(1000);
		  WebElement z = driver.findElement(By.xpath("//button[@title='Close this window']"));
		  driver.executeScript("arguments[0].click();", z);
			String actual_Result=driver.findElement(By.xpath("//span[@title='XPath Cheat Sheet v1.1']")).getText();
		     String  expected_Result=actual_Result ;
		     Assert.assertEquals(actual_Result,expected_Result);
		

	}

}
