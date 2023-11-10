package test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import config.PropertiesFile;
import org.openqa.selenium.support.ui.Select;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.StringSelection;
import org.openqa.selenium.interactions.Actions;



import java.time.Duration;

public class Project {


	public static WebDriver driver=null;
	public static String browsername=null;

	public static void main(String[] args) throws InterruptedException, AWTException {

		String projectpath = System.getProperty("user.dir"); 
		PropertiesFile.getProperties();

		if(browsername.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}	

		// Open Google Forms login page //Add your google form page url & modify as per your project
		driver.get("");
		driver.manage().window().maximize();

		//Email
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("");
		//user ID/Name
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("");


		//SysTest(driver);
		SIT(driver);
		//UAT(driver);
		uploadFile(driver);

		// Close the WebDriver
		Thread.sleep(5000);
		driver.quit();
		System.out.println("The payload has been successfully executed!");
	}


	public static void SysTest(WebDriver driver) throws InterruptedException  {
		//Service URL
		driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[1]")).click();

		//Consumer Key
		driver.findElement(By.cssSelector("div[aria-label='SysTest, response for 5498-asd4-as6d-6549'] div[class='AB7Lab Id5V1']")).click();

		//Environment
		driver.findElement(By.cssSelector("label[for='i31'] span[class='aDTYNe snByac OvPDhc OIC90c']")).click();

		//Transaction Data Type:
		driver.findElement(By.xpath("(//div[contains(@class,'uHMk6b fsHoPb')])[4]")).click();

		//Transaction Data Type:      
		driver.findElement(By.cssSelector(".MocG8c.HZ3kWc.mhLiyf.LMgvRb.KKjvXb.DEh1R")).click();
		Thread.sleep(1000);
		//Selecting transaction type:
		driver.findElement(By.xpath("(//span[@class='vRMGwf oJeWuf'])[6]")).click();		

	}

	public static void SIT(WebDriver driver) throws InterruptedException {
		//Service URL
		driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[2]")).click();

		//Consumer Key
		driver.findElement(By.cssSelector("div[aria-label='SIT, response for 5498-asd4-as6d-6549'] div[class='AB7Lab Id5V1']")).click();

		//Environment
		driver.findElement(By.xpath("(//div[@class='AB7Lab Id5V1'])[8]")).click();

		//Template Selector ID:
		driver.findElement(By.xpath("(//div[contains(@class,'uHMk6b fsHoPb')])[5]")).click();

		//Transaction Data Type:      
		driver.findElement(By.cssSelector(".MocG8c.HZ3kWc.mhLiyf.LMgvRb.KKjvXb.DEh1R")).click();
		Thread.sleep(1000);
		//Selecting transaction type:
		driver.findElement(By.xpath("(//span[@class='vRMGwf oJeWuf'])[6]")).click();

	}    

	public static void UAT(WebDriver driver) {
		//Service URL
		driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[3]")).click();

		//Consumer Key
		driver.findElement(By.cssSelector("div[aria-label='UAT, response for 5498-asd4-as6d-6549'] div[class='AB7Lab Id5V1']")).click();

		//Environment
		driver.findElement(By.xpath("(//span[normalize-space()='UAT'])[1]")).click();

		//Template Selector ID
		driver.findElement(By.xpath("(//div[contains(@class,'uHMk6b fsHoPb')])[6]")).click();

		//Transaction Data Type:      
		driver.findElement(By.cssSelector(".MocG8c.HZ3kWc.mhLiyf.LMgvRb.KKjvXb.DEh1R")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		//Selecting transaction type:
		driver.findElement(By.xpath("(//span[@class='vRMGwf oJeWuf'])[6]")).click();


	}

	public static void uploadFile(WebDriver driver) {
		// File upload
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Test1.txt");

		//submit
		driver.findElement(By.xpath("(//span[contains(text(),'Submit')])[1]")).click();

	}
}