package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class AttributesTesting extends BaseClassAttributes {

		@Test(priority = -1)
			public void createLead() throws InterruptedException{
			driver.findElement(By.linkText("CRM/SFA")).click();
			
			 driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
			 driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaaf");
			 driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Amrutha");
			 driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("T");
			 driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("aaa");
			 driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys("CSE");
			 driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys("desc");
			 driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("bbb@gmail.com");
			WebElement ddSource = driver.findElement(By.id("createLeadForm_dataSourceId")); 
			Select ddOption = new Select(ddSource); ddOption.selectByValue("LEAD_CONFERENCE");
			 driver.findElement(By.xpath("//input[@name='submitButton']")).click();
			 String title = driver.getTitle(); System.out.println("Title is "+ title); 
			
		}
		@Test(priority = 0,dependsOnMethods = "createLead")
		public void deleteLead() throws InterruptedException{
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
			driver.findElement(By.xpath("//div[@class='x-form-element']/input[@name='id']")).sendKeys("12663");
			//Clicking Find leads buttons after deleting
			driver.findElement(By.xpath("((//td[@class='x-panel-btn-td'])[6]//tbody//td[2])//button")).click();
			Thread.sleep(1000);
			String strDisp = driver.findElement(By.xpath("//div[@class='x-panel-bbar']//table/following-sibling::div")).getText();
			System.out.println("Text is "+ strDisp);
			if(strDisp.equals("No records to display")) {
				System.out.println("successful deletion");
			}
		}
		@Test(enabled=false)
		public void duplicateLead() throws InterruptedException {
			driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
			driver.findElement(By.xpath("(//div[@class='x-panel-header'])[2]/a")).click();
			driver.findElement(By.xpath("//div[@class='frameSectionBody']//li[3]/a")).click();
			driver.findElement(By.xpath("//ul[@class='x-tab-strip x-tab-strip-top']/li[3]//span[@class='x-tab-strip-text ']")).click();
			driver.findElement(By.xpath("//div[@class='x-form-element']/input[@name='emailAddress']")).sendKeys("aaa@gmail.com");
			driver.findElement(By.xpath("(//td[@class='x-panel-btn-td']//tbody//td[2])[6]//button[@type='button']")).click();
			//Accessing the first element 
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
			//Clicking Duplicate lead
			driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[1]")).click();
			//how to verify as 'duplicate lead'
			Thread.sleep(2000);
			String strTitle = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
			System.out.println("Title is "+ strTitle);
			driver.findElement(By.xpath("//div[@class='frameSectionBody']//li[2]/a")).click();
			//Confirm the duplicated lead name is same as captured name
			if(strTitle.equals("Duplicate Lead"))
			{
				System.out.println("Its a duplicate lead");
			}
			else {
				System.out.println("Not a duplicate lead");
			}
			
		}


	}


