package com.Java.SeleniumAdvn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompleteExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "L:\\PrgrmngLang\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/autoComplete.html");
		
		WebElement input= driver.findElement(By.id("tags"));
		input.sendKeys("s");
		Thread.sleep(2000);
		
		List<WebElement> optionsLlist=driver.findElements(By.
				xpath("//*[@id=\"ui-id-1\"]/li"));
		System.out.println(optionsLlist.size());
	
		for (WebElement webElement : optionsLlist) {
			if(webElement.getText().equals("Web Services")) {
				System.out.println("Selecting : "+webElement.getText());
				webElement.click();
				break;
			}
			else {
				System.out.println("else");
			}
		}
	}

}
