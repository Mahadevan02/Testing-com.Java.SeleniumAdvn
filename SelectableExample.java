package com.Java.SeleniumAdvn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectableExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "L:\\PrgrmngLang\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/selectable.html");
		
		List<WebElement> selectable=driver.findElements(By.
				xpath("//*[@id=\"selectable\"]/li"));
		int listSize=selectable.size();
		System.out.println(listSize);
		
		Actions actions=new Actions(driver);
		
		actions.keyDown(Keys.CONTROL).click(selectable.get(0)).
				click(selectable.get(1)). click(selectable.get(2)).build().perform();
		 
		/*
		 * actions.clickAndHold(selectable.get(0));
		 * actions.clickAndHold(selectable.get(1));
		 * actions.clickAndHold(selectable.get(2)); 
		 * actions.build().perform();
		 */
		
	}

}
