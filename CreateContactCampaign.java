package compaign.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateContactCampaign {

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
        driver.findElement(By.xpath("//a[@title='New Contact']")).click();
		WebElement f = driver.findElement(By.xpath("//div[@class='salutation compoundTLRadius compoundTRRadius compoundBorderBottom form-element__row uiMenu']"));
		f.click();
		WebElement d = driver.findElement(By.xpath("//a[@title='Ms.']"));
	    driver.executeScript("arguments[0].click();", d);
	    WebElement g = driver.findElement(By.xpath("//input[@class='firstName compoundBorderBottom form-element__row input']"));
	    g.sendKeys("Iswarya");
	    Thread.sleep(2000);
	    WebElement h = driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']"));
	    h.sendKeys("Uppliappan");
	    Thread.sleep(2000);
	    WebElement i = driver.findElement(By.xpath("(//input[@class=' input'])[2]"));
	    i.sendKeys("9326584712");
	    WebElement j = driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand cuf-publisherShareButton undefined uiButton']"));
	    driver.executeScript("arguments[0].click();", j);
	    JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,120)");
		Thread.sleep(2000);
	    WebElement k = driver.findElement(By.xpath("//a[@title='Add Contacts']"));
	    driver.executeScript("arguments[0].scrollIntoView(true)", k); 
        driver.executeScript("arguments[0].click();", k);
        Thread.sleep(3000);
        WebElement m = driver.findElement(By.xpath("//input[@title='Search Contacts']"));
        driver.executeScript("arguments[0].click();", m);
        
        WebElement l = driver.findElement(By.xpath("(//div[@title='Iswarya Uppliappan'])[1]"));
	    driver.executeScript("arguments[0].click();", l);
	    
	    WebElement n = driver.findElement(By.xpath("//button[text()='Next']"));
	    driver.executeScript("arguments[0].click();", n);
	    
	    WebElement o = driver.findElement(By.xpath("//button[text()='Submit']"));
	    driver.executeScript("arguments[0].click();", o);
	    
	    JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,350)");
		Thread.sleep(2000);
	    WebElement p = driver.findElement(By.xpath("(//span[@class='view-all-label'])[3]"));
	    driver.executeScript("arguments[0].scrollIntoView(true)", p); 
        driver.executeScript("arguments[0].click();", p);
        
        String actual_Result=driver.findElement(By.xpath("(//a[@title='Iswarya Uppliappan'])[1]")).getText();
        String  expected_Result= actual_Result;
        Assert.assertEquals(actual_Result,expected_Result);
        System.out.println(" Created Contact under campaign is " + actual_Result);
        
        WebElement q = driver.findElement(By.xpath("//a[@title='Contacts']"));
	    driver.executeScript("arguments[0].click();", q);
	    
	    WebElement r = driver.findElement(By.xpath("//input[@name='Contact-search-input']"));
        r.sendKeys("Iswarya Uppliappan");
	    r.sendKeys(Keys.ENTER);
        
	    String actual_Result1=driver.findElement(By.xpath("(//a[@title='Iswarya Uppliappan'])[1]")).getText();
        String  expected_Result1= actual_Result1;
        Assert.assertEquals(actual_Result1,expected_Result1);
        System.out.println(" Created Contact is " + actual_Result);
	    
	}

}
