package webDrivers_Methods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Date_picker2 {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//input[@id='txtDate']")).click();
		
        WebElement month = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		
        Select Dropdown_month = new Select(month);
        Dropdown_month.selectByVisibleText("May");
        
        WebElement year = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		
        Select Dropdown_year = new Select(year);
        Dropdown_year.selectByVisibleText("2015");
        
        		
        	List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
        		
            for (int i =0; i<dates.size(); i++) {

        	if(dates.get(i).getText().equals("29")) {
        		
        		dates.get(i).click();
        	}
        	
        	}
        }
        
        
		
	}


