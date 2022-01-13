package com.Java.SeleniumAdvn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadFilesExample {

	public static void main(String[] args) throws AWTException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"L:\\PrgrmngLang\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "L:\\PrgrmngLang\\Selenium\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		 * WebDriver driver = new FirefoxDriver();
		 */

		driver.get("http://leafground.com/pages/upload.html");

		WebElement uploadButton = driver.findElement(By.name("filename"));
		//uploadButton.click();
		Actions action=new Actions(driver);
		action.moveToElement(uploadButton).click().build().perform();
		
		// Thread.sleep(2000);
		// C:\Users\Devan\Downloads\testleaf.xlsx

		// To copy:
		String file = "C:\\Users\\Devan\\Downloads\\testleaf.xlsx";
		StringSelection selection = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		// To paste:
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
