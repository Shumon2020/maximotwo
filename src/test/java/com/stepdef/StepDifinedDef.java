package com.stepdef;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDifinedDef {
	WebDriver driver;

	@Given("^open the browser$")
	public void open_the_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thoss\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://maximo-demo75.mro.com/maximo/webclient/login/login.jsp");
		driver.manage().window().maximize();
	
	}

	@Then("^check the title of \"([^\"]*)\"$")
	public void check_the_title_of(String arg1) throws Throwable {
		String actual = driver.getTitle();
		System.out.println(actual);
		String expected = "IBM Maximo";
		
		Assert.assertTrue("This Tittle is Wrong", actual.contains(expected));
	}

	@Then("^enter valid user name$")
	public void enter_valid_user_name() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("maximo");

	}

	@Then("^enter valid password$")
	public void enter_valid_password() throws Throwable {
driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("maximo1");
	}

	@Then("^click the sign in button$")
	public void click_the_sign_in_button() throws Throwable {
 driver.findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
 
	List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	System.out.println("The number of links is" + allLinks.size());
	 //Traversing through the list and printing its text along with link address
	 for(WebElement link:allLinks){
	 System.out.println(link.getText() + " - " + link.getAttribute("href"));}
	}

	@Then("^validate page title \"([^\"]*)\"$")
	public void validate_page_title(String arg1) throws Throwable {

	}

	@Then("^click on sign out button$")
	public void click_on_sign_out_button() throws Throwable {

	}

}
