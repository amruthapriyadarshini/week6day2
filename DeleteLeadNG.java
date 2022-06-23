package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLeadNG extends BaseClass{

	//ChromeDriver driver ;
	@Test(dataProvider = "getData")
	
	public void deleteLead(String num) throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("(//div[@class='x-panel-header'])[2]/a")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//li[3]/a")).click();
		driver.findElement(By.xpath("//ul[@class='x-tab-strip x-tab-strip-top']/li[2]//span[@class='x-tab-strip-text ']")).click();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("1");
		
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("");
		driver.findElement(By.xpath("((//table[@class='x-btn-wrap x-btn']//tr/td[2])//button[@type='button'])[7]")).click();
		Thread.sleep(2000);
		//Accessing the first resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[4]")).click();
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//li[3]/a")).click();
		driver.findElement(By.xpath("//div[@class='x-form-element']/input[@name='id']")).sendKeys(num);
		//Clicking Find leads buttons after deleting
		driver.findElement(By.xpath("((//td[@class='x-panel-btn-td'])[6]//tbody//td[2])//button")).click();
		Thread.sleep(1000);
		String strDisp = driver.findElement(By.xpath("//div[@class='x-panel-bbar']//table/following-sibling::div")).getText();
		System.out.println("Text is "+ strDisp);
		if(strDisp.equals("No records to display")) {
			System.out.println("successful deletion");
		}

		
	}
	
	@BeforeClass
	public void setData() {
		fileName = "DeleteLead";
	}
}