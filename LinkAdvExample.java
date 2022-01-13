package com.Java.SeleniumAdvn;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;;

public class LinkAdvExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"L:\\PrgrmngLang\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//in "driver.get()" - we cannot use refresh, forward and back
		driver.navigate().to("http://www.leafground.com/pages/Link.html");
		
		WebElement homePageLink1=driver.findElement(By.linkText("Go to Home Page"));
		homePageLink1.click();
		driver.navigate().back();
		System.out.println("After Back :"+ driver.getTitle());
		
		WebElement whereToGo=driver.findElement(By.partialLinkText("Find where"));
		String where=whereToGo.getAttribute("href");
		System.out.println("This link is going to : "+where);
		
		WebElement brokenLink=driver.findElement(By.partialLinkText("Verify"));
		brokenLink.click();
		String title=driver.getTitle();
		if(title.contains("404"))
			System.out.println("Link is broken");
		else
			System.out.println("Link is not broken");
		driver.navigate().back();
		
		WebElement homePageLink2=driver.findElement(By.linkText("Go to Home Page"));
		homePageLink2.click();
		driver.navigate().back();
		
		List<WebElement> totalLink=driver.findElements(By.tagName("a"));
		int linkCount=totalLink.size();
		System.out.println("Number of Links : "+linkCount);
	}

}
