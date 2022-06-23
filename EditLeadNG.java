package week6.day1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import week6.day2.ReadColumnExcel;

public class EditLeadNG extends BaseClass{

	//ChromeDriver driver ;
	@Test(dataProvider = "getData")
	public void editLead(String cname, String fname, String lname) throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		//Clicking Leads button
		driver.findElement(By.xpath("(//div[@class='x-panel-header'])[2]/a")).click();
		
		//Clicking Find Leads
		driver.findElement(By.xpath("//div[@class='frameSectionBody']//li[3]/a")).click();
		
		//Enter first name
		driver.findElement(By.xpath("(//div[@class='x-form-element']/input[@name='firstName'])[3]")).sendKeys(fname);
		
		//Cliking Find Leads button
		driver.findElement(By.xpath("(//td[@class='x-panel-btn-td']//tbody//td[2])[6]")).click();
		
		//Click on the first resulting lead
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		//Verify title of the page
		Thread.sleep(2000);
		String strTitle = driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_leads']")).getText();
		
		//Clicking Edit button
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[3]")).click();
		//Updating the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cname);
		//Clicking Update button
		driver.findElement(By.xpath("//td/input[@value='Update']")).click();
		//Confirm the changed name appears
		Thread.sleep(1000);
		String strName = driver.findElement(By.
				xpath("//div[@class='fieldgroup-title-bar']/following-sibling::div//tbody//td[2]/span[contains(text(),'Keane')]")).getText();
		System.out.println("Updated string "+strName);
		if(strName.contains("Keane")) {
			System.out.println("String updated");
		}


	}
	
	
	@BeforeClass
	public void setData() {
		fileName = "EditLead";
	}


}
