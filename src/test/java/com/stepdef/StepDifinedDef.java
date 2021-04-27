package com.stepdef;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.pagefactory.PageFactoryClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDifinedDef {
	WebDriver driver;

	PageFactoryClass pom;

	@Given("^open the browser$")
	public void open_the_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thoss\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		try {
			driver.get("https://maximo-demo75.mro.com/maximo/webclient/login/login.jsp");
			driver.manage().window().maximize();
		} catch (Exception e) {

			// how can you size the browser and why? if your monitor is smaller we need to
			// size up the dimension?
			// for parralel testing/ multiple windows, we need dimention on selenium grid
			// not on selenium ide.
			// driver.manage().window().setSize(new Dimension(1000, 500));
			StepDifinedDef.takeSnapShot(driver, "c://ScreenShot//homepage.png");
		}
		pom = PageFactory.initElements(driver, PageFactoryClass.class);

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
		pom.getUserName().sendKeys("maximo");
	}

	@Then("^enter valid password$")
	public void enter_valid_password() throws Throwable {
		 driver.findElement(By.xpath("//*[@id=\"password\"]"));
		pom.getPassword().sendKeys("maximo1");
		// StepDifinedDef.takeSnapShot(driver, "c://ScreenShot//log.png") ;
	}

	@Then("^click the sign in button$")
	public void click_the_sign_in_button() throws Throwable {
		// driver.findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
		// How to take a screenshot ?
		try {
		pom.getLoginbutton().click();
		} catch (Exception e) {
			StepDifinedDef.takeSnapShot(driver, "c://ScreenShot//logfail.png");
		}
			// StepDifinedDef.takeSnapShot(driver, "c://ScreenShot//test.png") ;
		// How many links are there or the method to get links info from a  webpage?
			List<WebElement> allLinks = driver.findElements(By.tagName("a"));
			System.out.println("The number of links is" + allLinks.size());
			// Traversing through the list and printing its text along with link address
			//for (WebElement link : allLinks) {
				//System.out.println(link.getText() + " - " + link.getAttribute("href"));
			//}
		

	}

	@Then("^validate page title \"([^\"]*)\"$")
	public void validate_page_title(String arg1) throws Throwable {

	}

	@Then("^click on sign out button$")
	public void click_on_sign_out_button() throws Throwable {

	}
   
	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
		// i create a method name screenshot, pass the webdriver and file path name as
		// an obj...
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination... (on the c drive)
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		
	}
	
}

