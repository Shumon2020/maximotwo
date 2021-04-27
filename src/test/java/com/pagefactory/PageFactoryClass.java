package com.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageFactoryClass {
 
	@FindBy (how= How.XPATH, using = "//*[@id=\"username\"]")
	private WebElement UserName;
	
	@FindBy (how= How.XPATH, using = "//*[@id=\"password\"]")
	private WebElement password;
	
	@FindBy (how= How.XPATH, using = "//*[@id=\"loginbutton\"]")
	private WebElement loginbutton;
	
	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	
}
