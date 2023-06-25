package compaign.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class DeleteCampaign {

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
        WebElement b = driver.findElement(By.xpath("(//a[@title='Bootcamp'])[1]"));
        driver.executeScript("arguments[0].click();", b);
        WebElement c = driver.findElement(By.xpath("(//span[@class='view-all-label'])[1]"));
        driver.executeScript("arguments[0].click();", c);
        WebElement d = driver.findElement(By.xpath("((//div[@class='forceVirtualActionMarker forceVirtualAction'])/parent::span)[3]"));
        d.click();
        WebElement k = driver.findElement(By.xpath("//a[@title='Delete']"));
	    driver.executeScript("arguments[0].click();", k);
	    driver.findElement(By.xpath("//span[text()='Delete']")).click();
        String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		String expected_Result="Record was deleted.";
		Assert.assertEquals(actual_Result,expected_Result);
	}

}
