package Test_Project.Test_Project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

/*
 * Open a Chrome Browser
 * Load URL "http://www.google.com
 * print the title
 */

public class Liberis_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		
		WebDriver driver = (WebDriver) new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.liberis.com/");
		
		System.out.println("PAGE TITLE is : " + driver.getTitle());
		String ExpectTitle = "Become A Partner | Liberis";
		Map<Integer, String> options = new HashMap<Integer, String>();
		options.put(1, "I'm a Broker");
		options.put(2, "I'm an ISO");
		options.put(3, "I'm a Strategic Partner");
		String Error = "Please select a type of partner";
		int n =1;
		try {
			Thread.sleep(3000);
			WebElement wb = driver.findElement(By.xpath("//a[contains(text(),\"Get a Demo\")]"));
			wb.click();
			String nowTitle = driver.getTitle();
			System.out.println("PAGE TITLE is : " + nowTitle );
			Assert.assertEquals(ExpectTitle, nowTitle);
			
			List <WebElement> li = driver.findElements(By.xpath("//div/h4[contains(text(),\"Type of\")]/following-sibling::div/div"));
			
			for(WebElement    ele    : li) {
				String hrefstr = ele.getText();
				System.out.println("OPtions are  : "+ hrefstr);		
			
				System.out.println(options.get(n));
				String str = options.get(n);
				n++;
				Assert.assertEquals(str,hrefstr);
			}
			
			driver.findElement(By.xpath("//a[contains(text(),\"Get a demo\") and contains(@href,\"#0\")]")).click();
		String error = 	driver.findElement(By.xpath("//div/h4[contains(text(),\"Type of\")]/following-sibling::div[2]")).getText();
		System.out.println(error);
		
		Assert.assertEquals(Error, error);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
		
		
		

	}

}
