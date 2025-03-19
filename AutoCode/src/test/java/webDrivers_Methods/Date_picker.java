package webDrivers_Methods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Date_picker {
	
	
	static void FutureDate(WebDriver driver, String year, String month, String date ) {
		
		
		while (true) {
			
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear	= driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText(); 
			
			if (currentMonth.equals(month) && currentYear.equals(year)) {
				
				break;
				
			}
				
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				
				
			}
			
			List<WebElement> date2 = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
					
				for(WebElement dt : date2) {
					
					if(dt.getText().equals(date)) {
						dt.click();
						break;
					}
				}
				
//				for(int i =1; i<date2.size(); i++) {
//					
//					if(date2.get(i).getText().equals(date)) {
//						
//				        date2.get(i).click();
//						
//					}
//				}
//				
	}
				
	  static void PastDate(WebDriver driver, String year, String month, String date ) {
		  
		  
		  while (true) {
				
				String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
				String currentYear	= driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText(); 
				
				if (currentMonth.equals(month) && currentYear.equals(year)) {
					
					break;
					
				}
					
					driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
					
					
				}
				
				List<WebElement> date2 = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
						
					for(WebElement dt : date2) {
						
						if(dt.getText().equals(date)) {
							dt.click();
							break;
						}
					}
					
//					for(int i =1; i<date2.size(); i++) {
//						
//						if(date2.get(i).getText().equals(date)) {
//							
//					        date2.get(i).click();
//							
//						}
//					}
//					
	  }
		  
	  	
				
		

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		//Switch to iframe
		driver.switchTo().frame(0);
		
		//Using sendKey
//		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("29/05/1999");
		
		//Method 2 : Using date picker
		//Expected date
		

		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		//FutureDate(driver, "2026","May","29");
		PastDate(driver, "1999", "May", "29");
		
	}	

}