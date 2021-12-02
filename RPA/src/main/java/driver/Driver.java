package driver;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Flow.Write.WebToJson;
import OR.Pagination;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		long startTime = System.currentTimeMillis();
		String Url = "https://datatables.net/examples/data_sources/dom";
		driver.get(Url);
		WebToJson wtj = new WebToJson();
		Pagination pg = new Pagination("//div[@id='example_paginate']/span/a");
		wtj.pageControl();
		driver.close();
		long endTime = System.currentTimeMillis();
		System.out.println("Runnable time :" + (endTime - startTime) / 1000 + " Seconds");
	}
}
