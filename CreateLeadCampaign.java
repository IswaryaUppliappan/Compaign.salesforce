package compaign.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateLeadCampaign {

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
		WebElement l = driver.findElement(By.xpath("//a[@title='Add Leads']"));
		driver.executeScript("arguments[0].scrollIntoView(true)", l);  
		driver.executeScript("arguments[0].click();", l); 
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,120)");
		Thread.sleep(2000);
		WebElement c = driver.findElement(By.xpath("//span[@title='New Lead']"));
		driver.executeScript("arguments[0].scrollIntoView(true)", c);  
		driver.executeScript("arguments[0].click();", c); 
		driver.findElement(By.xpath("//input[@title='Search Leads']")).click();
		WebElement d=driver.findElement(By.xpath("//div[@class='salutation compoundTLRadius compoundTRRadius compoundBorderBottom form-element__row uiMenu']"));
	   d.click();
	    WebElement e = driver.findElement(By.xpath("(//a[text()='Mr.'])[1]"));
	    driver.executeScript("arguments[0].click();", e);  
	    WebElement f = driver.findElement(By.xpath("//input[@class='firstName compoundBorderBottom form-element__row input']"));
	    f.sendKeys("Iswarya");
	    WebElement g = driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']"));
	    g.sendKeys("Uppliappan");
	    WebElement h = driver.findElement(By.xpath("(//input[@class=' input'])[3]"));
	    h.sendKeys("Testleaf");
	    driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
	    WebElement i = driver.findElement(By.xpath("//button[text()='Next']"));
	    driver.executeScript("arguments[0].click();", i);
	    WebElement j = driver.findElement(By.xpath("//button[text()='Submit']"));
	    String actual_Result=driver.findElement(By.xpath("//div[@class='slds-theme--success slds-notify--toast slds-notify slds-notify--toast forceToastMessage']")).getText();
        String  expected_Result= actual_Result;
        Assert.assertEquals(actual_Result,expected_Result);
        System.out.println(actual_Result);
        WebElement z = driver.findElement(By.xpath("//a[@title='Leads']"));
        driver.executeScript("arguments[0].click();", z);
        WebElement k = driver.findElement(By.xpath("//input[@name='Lead-search-input']"));
        k.sendKeys("Iswarya Uppliappan");
        k.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        String actual_Result1=driver.findElement(By.xpath("//a[@title='Iswarya Uppliappan']")).getText();
        String  expected_Result1= actual_Result1;
        Assert.assertEquals(actual_Result1,expected_Result1);
        System.out.println(actual_Result1);
	}

}
