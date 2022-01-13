package com.Java.SeleniumAdvn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImageInteractionExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"L:\\PrgrmngLang\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Image.html");
		
		WebElement firstImage= driver.findElement(
				By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/img"));
		firstImage.click();
		//driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[4]/a")).click();
		driver.navigate().back();
		System.out.println("After Back : "+ driver.getTitle());
		
		WebElement brokenImage=driver.findElement(
				By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/img"));
		if(brokenImage.getAttribute("naturalWidth").equals("0"))
			System.out.println("broken");
		else
			System.out.println("not broken");
		
		WebElement thirdImage=driver.findElement(
				By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div/div/img"));
		thirdImage.click();

	}

}
