package com.Java.SeleniumAdvn;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "L:\\PrgrmngLang\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Window.html");
		
		String oldWindow=driver.getWindowHandle();
		
		WebElement firstButton=driver.findElement(By.id("home"));
		firstButton.click();
		
		Set<String> handles=driver.getWindowHandles();
		
		for (String newWindow : handles) {
			driver.switchTo().window(newWindow);
		}
		
		WebElement editBox=driver.findElement(By.
				xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[1]/a/img"));
		editBox.click();
		driver.close();
		
		driver.switchTo().window(oldWindow);//to the parent Window
		
		WebElement openMultiple = driver.findElement(By.
				xpath("/html/body/div/div/div[3]/section/div[2]/div/div/button"));
		openMultiple.click();
		int numberofWindows=driver.getWindowHandles().size();
		System.out.println("Number of Windows Opened : "+numberofWindows);
		
		WebElement dontCloseMe =driver.findElement(By.id("color"));
		dontCloseMe.click();
		Set<String> newWindowHandles=driver.getWindowHandles();
		for (String allWindows : newWindowHandles) {
			if (!allWindows.equals(oldWindow)) {
				driver.switchTo().window(allWindows);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		//driver.quit();
	}
}
