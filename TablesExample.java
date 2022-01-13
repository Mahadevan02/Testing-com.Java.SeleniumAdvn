package com.Java.SeleniumAdvn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TablesExample {

	public static void main(String[] args) {
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "L:\\PrgrmngLang\\Selenium\\chromedriver_win32\\chromedriver.exe"); 
		 * WebDriver driver = new ChromeDriver();
		 */
		System.setProperty("webdriver.gecko.driver",
				"L:\\PrgrmngLang\\Selenium\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.navigate().to("http://leafground.com/pages/table.html");
		
		List<WebElement> columns=driver.findElements(By.tagName("th"));
		int columnCount=columns.size();
		System.out.println("Number of Columns: "+columnCount);
		List<WebElement> rows=driver.findElements(By.tagName("tr"));
		int rowCount=rows.size();
		System.out.println("Number of Rows: "+rowCount);
		/** tr->row, th->column, td->cell
		 * //td[.='Learn to interact with Elements']//following::td[1]
		 * //td[normalize-space()='Learn to interact with Elements']//following::td[1]
		 */
		WebElement getPercent=driver.findElement(By.
				xpath("//td[normalize-space()='Learn to interact with Elements']//following::td[1]"));
		String percentage=getPercent.getText();
		System.out.println("Percentage : "+percentage);
		
		List<WebElement> allProgress=driver.findElements(By.xpath("//td[2]"));
		List<Integer> numberList=new ArrayList<Integer>();
		for (WebElement webElement : allProgress) {
			String individualValue=webElement.getText().replace("%", "");
			numberList.add(Integer.parseInt(individualValue));
		}
		System.out.println("Final List : "+numberList);
		
		int smallValue=Collections.min(numberList);
		System.out.println("Small Value : "+smallValue);
		/** //td[normalize-space()='30%']//following::td[1]
		 * //*[@id="table_id"]/tbody/tr[4]/td[3]/input
		 */
		String smallValueString=Integer.toString(smallValue)+"%";
		String finalXpath="//td[normalize-space()="+"\""+ smallValueString+ "\""+"]"+"//following::td[1]";
		System.out.println(finalXpath);
		WebElement check=driver.findElement(By.xpath(finalXpath));
		check.click();
	}

}
