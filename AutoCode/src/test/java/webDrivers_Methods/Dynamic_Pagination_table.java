package webDrivers_Methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_Pagination_table {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.ecomdeveloper.com/demo/admin/index.php");
		driver.manage().window().maximize();
		
		// Login
		
		driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demoadmin");
		
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demopass");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// Dashboard
		
		driver.findElement(By.xpath("//li[@id='menu-customer']")).click();
		
		driver.findElement(By.xpath("//ul[@id='collapse9']//li[1]")).click();
		
		// Showing 1 to 20 of 906 (46 Pages)

		String text = driver.findElement(By.xpath("//div[contains(text(),'Showing')]")).getText();
		int total_pages = Integer.parseInt((text).substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
		
		System.out.println(total_pages);
		
		// Clicking on Every page
		
		for (int i =0; i<=total_pages; i++) {
			
			if (i>1) {
				
				WebElement active_pages = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+i+"]"));
				active_pages.click();
				
			}
			
		// Reading data from the table
			
	        int row = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
	    
	        for(int q = 1; q<=row; q++) {
	    	
	        String Customer_name =	driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+q+"]/td[2]")).getText();
     	    String EmailID =	driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+q+"]/td[3]")).getText();
    	    String status =	driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+q+"]/td[5]")).getText();

	    
	         System.out.println(Customer_name+"\t"+EmailID+"\t"+status);	    
	    }
					
		}
		
	}
}

