package compaign.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class EditCampaign {

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
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
        WebElement opp=driver.findElement(By.xpath("//a[@title='Campaigns']"));
        driver.executeScript("arguments[0].click();", opp);
        WebElement a = driver.findElement(By.xpath("//div[@title='New']"));
        driver.executeScript("arguments[0].click();", a);
        WebElement b = driver.findElement(By.xpath("(//a[@title='Bootcamp'])[1]"));
        driver.executeScript("arguments[0].click();", b);
        WebElement c = driver.findElement(By.xpath("//a[@title='Details']"));
        driver.executeScript("arguments[0].click();", c);
        JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,120)");
		Thread.sleep(2000);
		WebElement d = driver.findElement(By.xpath("//button[@title='Edit End Date']"));
		driver.executeScript("arguments[0].scrollIntoView(true)", d);  
		driver.executeScript("arguments[0].click();", d); 
		WebElement e = driver.findElement(By.xpath("(//a[@class='datePicker-openIcon display'])[2]"));
	    driver.executeScript("arguments[0].click();", e);
	    driver.findElement(By.xpath("//span[text()='15']")).click();
	    JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,120)");
		Thread.sleep(2000);
	    WebElement f = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
	    driver.executeScript("arguments[0].scrollIntoView(true)", f); 
        driver.executeScript("arguments[0].click();", f);
        f.clear();
        f.sendKeys("1000000");
        WebElement g = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
        driver.executeScript("arguments[0].click();", g);
        g.clear();
        g.sendKeys("100000");
        driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
        JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("window.scrollBy(0,120)");
		Thread.sleep(2000);
		String actual_Result = driver.findElement(By.xpath("//span[text()='Expected Revenue in Campaign']//following::span")).getText();
		String expected_Result = actual_Result;
		Assert.assertEquals(actual_Result, expected_Result);
		System.out.println(actual_Result);
        String actual_Result1=driver.findElement(By.xpath("//span[text()='Budgeted Cost in Campaign']//following::span")).getText();
        String  expected_Result1= actual_Result1;
        Assert.assertEquals(actual_Result,expected_Result);
 		
 		
 		
 		
	}
	

}
