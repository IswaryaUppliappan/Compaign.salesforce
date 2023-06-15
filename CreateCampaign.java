package compaign.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateCampaign {

	public static void main(String[] args) {
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
        WebElement b = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        driver.executeScript("arguments[0].click();", b);
        b.sendKeys("Bootcamp");
        String text = b.getText();
        WebElement c = driver.findElement(By.xpath("(//input[@class=' input'])[2]"));
        c.sendKeys("6/12/2023");
        WebElement d = driver.findElement(By.xpath("(//a[@class='datePicker-openIcon display'])[2]"));
        driver.executeScript("arguments[0].click();", d);
        driver.findElement(By.xpath("//span[text()='13']")).click();
        driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
        String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        String  expected_Result= "Campaign \"Bootcamp\" was created.";
        Assert.assertEquals(actual_Result,expected_Result);
        
        

	}

}
