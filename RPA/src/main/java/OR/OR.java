package OR;

import java.util.List;

import org.openqa.selenium.WebElement;

import Wrapper.Selenium;

public class OR {

	Selenium se = new Selenium();

	public String getText(String xpath) {
		return se.Se_getText(xpath);
	}

	public String getText(WebElement ele) {
		return se.Se_getText(ele);
	}

	public WebElement getElement(String xpath) {
		return se.Se_getElement(xpath);
	}
	public WebElement getElement(WebElement ele, String xpath) {
		return se.Se_getElement(ele,xpath);
	}

	public List<WebElement> getElements(String xpath) {
		return se.Se_getElements(xpath);
	}

	public List<WebElement> getChilds(WebElement ele, String xpath) {
		return se.Se_getChilds(ele, xpath);
	}

	public String getText(WebElement element, String xpath) {
		System.out.println(element.getText());
		return se.Se_getText(element, xpath);
	}
	public String getAttribute(WebElement element,String attribute) {
		return  se.Se_getAttribute(element,attribute);
	}
	public boolean click(WebElement element) {
		return se.Se_click(element);
	}
	public  boolean waitforSecond() {
		boolean res=false;
		try {
			se.Se_waitforElement();
			res=true;
		} catch (Exception e) {
			
		}
		return res;
	}
}
