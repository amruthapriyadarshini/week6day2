package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactNG extends BaseClass{
	//ChromeDriver driver;
	
	@Test(dataProvider = "getData")
	public void createContact(String fname,String lname,String email) {
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("(//div[@class='x-panel-header'])[3]/a")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//li[2]")).click();
		driver.findElement(By.id("firstNameField")).sendKeys(fname);
		driver.findElement(By.id("lastNameField")).sendKeys(lname);
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("aaa");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("lll");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("CSE");
		//driver.findElement(By.xpath("//input[@id='createContactForm_departmentName']")).sendKeys("ddd");
		driver.findElement(By.xpath("//textarea[@id='createContactForm_description']")).sendKeys("desc");
		driver.findElement(By.xpath("//input[@id='createContactForm_primaryEmail']")).sendKeys(email);
		WebElement ddGenState =driver.findElement(By.xpath("//select[@id='createContactForm_generalStateProvinceGeoId']")); 
		Select	 ddGenOption = new Select(ddGenState);
				 ddGenOption.selectByVisibleText("New York");
	
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[1]")).click();
		driver.findElement(By.xpath("//textarea[@id='updateContactForm_description']")).clear();
		driver.findElement(By.xpath("//textarea[@id='updateContactForm_importantNote']")).sendKeys("note");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		System.out.println("Title is "+driver.getTitle());
				
	}
	
	@BeforeClass
	public void setData() {
		fileName = "Contact";
	}
}
