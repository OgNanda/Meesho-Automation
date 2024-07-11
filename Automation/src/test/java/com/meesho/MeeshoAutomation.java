package com.meesho;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// This class represents a Selenium test project for interacting with the Meesho website.

public class MeeshoAutomation {

	public static WebDriver driver;

	// Setup method to initialize WebDriver before tests.
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
	}

	// Test method to launch the Meesho website.
	@Test(priority = 1)
	public void launch() {
		
		driver.get("https://www.meesho.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
	}

	// Test method to search for a product.
	@Test(priority = 2)
	public void search() throws InterruptedException {
		WebElement search = driver.findElement(By.xpath("(//*[@type='text'])[1]"));
		Thread.sleep(3000);
		search.sendKeys("SHOES");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

	// Test method to apply product filters.
	@Test(priority = 3)
	public void product_filter() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Casual Shoes']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@label='Men']")).click();

	}

	// Test method to select and add a shoe to the cart.
	@Test(priority = 4)
	public void shoe() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@alt='Modern Trendy Men Casual Shoes']")).click();
		Thread.sleep(3000);
		WebElement size = driver.findElement(By.xpath("//span[text()='IND-8']"));
		size.click();
		if (size.isDisplayed()) {
			System.out.println("IND-8 Clickable");
		} else {
			System.out.println("Not Clickable");
		}
		driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
	}
	// Method to close the WebDriver after tests.

	@AfterTest
	public void close() {
		driver.close();

	}
}
