package com.Java.SeleniumAdvn;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadFilesExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "L:\\PrgrmngLang\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/download.html");
		
		String oldWindow=driver.getWindowHandle();
		
		WebElement downloadExcel=driver.findElement(By.linkText("Download Excel"));
		downloadExcel.click();
		Thread.sleep(2000);	
		
		File fileLocation=new File("C:\\Users\\Devan\\Downloads");
		File[] totalFiles=fileLocation.listFiles();
		for (File file : totalFiles) {
			if(file.getName().equals("testleaf.xlsx")) {
				System.out.println(file.getName()+" File is downloaded.");
				break;
			}
		}
		
		WebElement downloadPDF=driver.findElement(By.linkText("Download PDF"));
		downloadPDF.click();
		Thread.sleep(9000);
		
		driver.findElement(By.xpath("//*[@id=\"icon\"]/iron-icon")).click();
		
		for (File file : totalFiles) {
			if(file.getName().equals("testleaf.pdf")) {
				System.out.println(file.getName()+" File is downloaded.");
				break;
			}
		}
	}

}
