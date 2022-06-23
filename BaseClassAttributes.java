package week6.day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import week6.day2.ReadColumnExcel;

public class BaseClassAttributes {
	
	public ChromeDriver driver;
	public String fileName;
	
	@BeforeMethod
	public void preCondition(){
		
		//set up chrome driver.
		WebDriverManager.chromedriver().setup();
		
		//Open the browser
		driver = new ChromeDriver();
		
		WebDriverManager.chromedriver().setup();
		// Open the browser
		

		// load the url
		driver.get("http://leaftaps.com/opentaps/control/login");

		// maximize
		driver.manage().window().maximize();
		WebElement eleUserName = driver.findElement(By.xpath("//input[@id='username']"));
		eleUserName.sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
	//	driver.findElement(By.linkText("CRM/SFA")).click();
	}

	
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	
	@DataProvider(name="getData")
	public String[][] fetchData() throws IOException {
		String[][] data = ReadColumnExcel.readData(fileName);
		return data;
	}
}
