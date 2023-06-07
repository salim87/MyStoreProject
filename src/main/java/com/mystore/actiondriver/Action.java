package com.mystore.actiondriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.mystore.base.BaseClass;

public class Action extends BaseClass{

	public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	public static void click(WebDriver driver, WebElement locatorName) {
		Actions action = new Actions(driver);
		action.moveToElement(locatorName).click().build().perform();
	}
	
	public static boolean findElement(WebDriver driver, WebElement ele) {
		boolean flag=false;
		
		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			flag=false;
		}finally {
			if(flag) {
				System.out.println("Successfully found element at");	
			}else {
				System.out.println("unable to locate element at");	
			}
		}
		return flag;
		
	}
	public static boolean isDisplayed(WebDriver driver, WebElement ele) {
		boolean flag=false;
		flag=findElement(driver, ele);
		if(flag) {
			flag=ele.isDisplayed();
			if(flag) {
				System.out.println("The element is displayed");	
			}else {
				System.out.println("The element is not displayed");	
			}
		} else {
			System.out.println("not displayed");	
		}
		return flag;
	}
	
	public static boolean isSelected(WebDriver driver, WebElement ele) {
		boolean flag=false;
		flag=findElement(driver, ele);
		if(flag) {
			flag=ele.isSelected();
			if(flag) {
				System.out.println("The element is selected");	
			}else {
				System.out.println("The element is not selected");	
			}
		} else {
			System.out.println("not selected");	
		}
		return flag;
	}
	public static boolean isEnabled(WebDriver driver, WebElement ele) {
		boolean flag=false;
		flag=findElement(driver, ele);
		if(flag) {
			flag=ele.isDisplayed();
			if(flag) {
				System.out.println("The element is enabled");	
			}else {
				System.out.println("The element is not enabled");	
			}
		} else {
			System.out.println("not enabled");	
		}
		return flag;
	}
	
	public static boolean type(WebElement ele, String text) {
		boolean flag=false;
		
		try {
			ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag = true;
		} catch (Exception e) {
			System.out.println("Location not found");	
			flag=false;
		}finally {
			if(flag) {
				System.out.println("Successfully entered value");	
			}else {
				System.out.println("unable to enter value");	
			}
		}
		return flag;
		
	}
	
	public static boolean selectBySendKeys(WebElement ele, String value) {
		boolean flag=false;
		
		try {
			ele.sendKeys(value);
			flag = true;
			return true;
		} catch (Exception e) {
			//System.out.println("Location not found");	
			return false;
		}finally {
			if(flag) {
				System.out.println("option select value from dropdown");	
			}else {
				System.out.println("not selected value from dropdown");	
			}
		}	
		
	}
	
	public static boolean selectByIndex(WebElement ele, int index) {
		boolean flag=false;
		
		try {
			Select s= new Select(ele);
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			//System.out.println("Location not found");	
			return false;
		}finally {
			if(flag) {
				System.out.println("option selected by value from dropdown by index");	
			}else {
				System.out.println("option not selected by value from dropdown by index");	
			}
		}	
		
	}
	public static boolean selectByValue(WebElement ele, String value) {
		boolean flag=false;
		
		try {
			Select s= new Select(ele);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {
			//System.out.println("Location not found");	
			return false;
		}finally {
			if(flag) {
				System.out.println("option selected by value from dropdown by value");	
			}else {
				System.out.println("option not selected by value from dropdown by value");	
			}
		}	
		
	}
	public static boolean selectByVisiblityText(WebElement ele, String visiblityText) {
		boolean flag=false;
		
		try {
			Select s= new Select(ele);
			s.selectByVisibleText(visiblityText);
			flag = true;
			return true;
		} catch (Exception e) {
			//System.out.println("Location not found");	
			return false;
		}finally {
			if(flag) {
				System.out.println("option selected by visible text from dropdown");	
			}else {
				System.out.println("option not selected by visible text from dropdown");	
			}
		}	
		
	}
}