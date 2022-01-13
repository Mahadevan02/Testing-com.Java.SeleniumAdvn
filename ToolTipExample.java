package com.Java.SeleniumAdvn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTipExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "L:\\PrgrmngLang\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/tooltip.html");
		
		
		WebElement name= driver.findElement(By.id("age"));
		String tooltipText=name.getAttribute("title");
		System.out.println(tooltipText);
		//driver.findElement(By.id("age")).click();
		
		Actions action=new Actions(driver);
		action.moveToElement(name).build().perform();
	}

}
