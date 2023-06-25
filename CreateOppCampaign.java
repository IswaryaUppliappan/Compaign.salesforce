package compaign.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateOppCampaign {

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
        WebElement b = driver.findElement(By.xpath("(//a[@title='Bootcamp'])[1]"));
        driver.executeScript("arguments[0].click();", b);
        JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,120)");
		Thread.sleep(2000);
		WebElement l = driver.findElement(By.xpath("(//div[@title='New'])[2]"));
		driver.executeScript("arguments[0].scrollIntoView(true)", l);  
		driver.executeScript("arguments[0].click();", l); 
        WebElement p = driver.findElement(By.xpath("//input[@name='Name']"));
        p.sendKeys("Opportunity from Iswarya");
        WebElement d = driver.findElement(By.xpath("//input[@name='CloseDate']"));
        d.sendKeys("6/18/2023");
        WebElement drop = driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click')])[2]"));
        driver.executeScript("arguments[0].click();", drop);
        driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
        driver.findElement(By.xpath("//button[text()='Save']")).click(); 
        Thread.sleep(2000);
        String actual_Result=driver.findElement(By.xpath("//a[@title='Opportunity from Iswarya']")).getText();
        String  expected_Result= actual_Result;
        Assert.assertEquals(actual_Result,expected_Result);
        System.out.println(actual_Result);
        WebElement opp1=driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
        driver.executeScript("arguments[0].click();", opp1);
        WebElement q = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));q.sendKeys("Opportunity from Iswarya");
		q.sendKeys(Keys.ENTER);
	    Thread.sleep(1000);
        String actual_Result1=driver.findElement(By.xpath("//a[@title='Opportunity from Iswarya']")).getText();
        String  expected_Result1= actual_Result1;
        Assert.assertEquals(actual_Result1,expected_Result1);
        System.out.println(actual_Result1);
	}

}
