package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class OrangeHRMTest {
	
	ChromeDriver driver;
	
	@Test(priority=1)
	public void Login()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	
	@Test(priority=3)
	public void Logout()
	{
		WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-userdropdown-tab")));
		
		driver.findElement(By.className("oxd-userdropdown-tab")).click();
		
		WebDriverWait wait5 = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		
		driver.findElement(By.linkText("Logout")).click();
	}
	
	
	@Test(priority=2)
	public void Login_Cred()
	{
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

		driver.findElement(By.name("username")).sendKeys("Admin");
		
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		
		
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}
	
	
	@Test(priority=4)
	public void CloseBrowser()
	{
		driver.close();
	}
	
}
