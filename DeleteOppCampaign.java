package compaign.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class DeleteOppCampaign {

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
		 WebElement l = driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[2]"));	       
		driver.executeScript("arguments[0].scrollIntoView(true)", l);  
		driver.executeScript("arguments[0].click();", l);
        WebElement k = driver.findElement(By.xpath("//a[@title='Delete']"));
	    driver.executeScript("arguments[0].click();", k);
	    driver.findElement(By.xpath("//span[text()='Delete']")).click();
	    String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        String expected_Result=actual_Result;
		Assert.assertEquals(actual_Result,expected_Result);
		WebElement opp1=driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
        driver.executeScript("arguments[0].click();", opp1);
        WebElement q = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));q.sendKeys("Opportunity from Iswarya");
		q.sendKeys(Keys.ENTER);
	    Thread.sleep(1000);
        String actual_Result1=driver.findElement(By.xpath("//div[@class='emptyContentInner slds-text-align_center']")).getText();
        String  expected_Result1= actual_Result1;
        Assert.assertEquals(actual_Result1,expected_Result1);
        System.out.println(actual_Result1);
	}

}
