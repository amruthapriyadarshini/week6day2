package week6.day1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import week6.day2.ReadColumnExcel;
import week6.day2.ReadExcel;

public class CreateLeadNG extends BaseClass {

	@Test(dataProvider = "getData")
	public void createLead(String cname, String fname, String lname) {
	
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("aaa");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("CSE");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Dept creation");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("aaa@gmail.com");
		/*WebElement ddSource = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select ddOption = new Select(ddSource);
		ddOption.selectByValue("LEAD_CONFERENCE");*/
		
		WebElement ddGenState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select ddGenOption = new Select(ddGenState);
		ddGenOption.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		String title = driver.getTitle();
		System.out.println("Title is "+ title);
	}
	
	@BeforeClass
	public void setData() {
		fileName = "CreateLead";
	}
}
