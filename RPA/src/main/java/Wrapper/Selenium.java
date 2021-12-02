package Wrapper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driver.Driver;

public class Selenium {
	WebDriver driver = Driver.driver;

	public String Se_getText(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}

	public String Se_getText(WebElement ele) {
		return ele.getText();
	}
	public WebElement Se_getElement(String xpath){
		return driver.findElement(By.xpath(xpath));
	}
	public WebElement Se_getElement(WebElement ele,String xpath){
		return ele.findElement(By.xpath(xpath));
	}

	public List<WebElement> Se_getElements(String xpath){
		return driver.findElements(By.xpath(xpath));
	}

	public List<WebElement> Se_getChilds(WebElement ele, String xpath){
		return ele.findElements(By.xpath(xpath));
	}

	public String Se_getText(WebElement element,String xpath) {
		System.out.println(element.getText());
		return element.findElement(By.xpath(xpath)).getText();
	}
	public String Se_getAttribute(WebElement element,String attribute) {
		return element.getAttribute(attribute);
	}
	public boolean Se_click(WebElement element) {
		boolean res=false;
		try {
			element.click();
			
			res=true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
		
	}
	public void Se_waitforElement() throws InterruptedException {
		driver.wait(1000);
		
	}
	
	
}
