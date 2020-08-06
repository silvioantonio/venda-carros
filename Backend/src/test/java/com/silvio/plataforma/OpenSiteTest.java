package com.silvio.plataforma;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenSiteTest {
	
	private String url = "http://localhost:4200/login";
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\silvio\\workspace-spring-tool\\chromedriver.exe" );
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testLoginUserFail() throws InterruptedException {
		driver.get(this.url);
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.name("user")).sendKeys("teste");
		driver.findElement(By.name("password")).sendKeys("senha123");
		driver.findElement(By.name("btnLogin")).click();
		
		assertNotEquals("http://localhost:4200/", driver.getCurrentUrl());
		
		Thread.sleep(5000);
	}

	@Test
	public void testLoginOk() throws InterruptedException {
		driver.get(this.url);
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.name("user")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("senha123");
		driver.findElement(By.name("btnLogin")).click();
		
		assertEquals("http://localhost:4200/", driver.getCurrentUrl());
		
		Thread.sleep(5000);
	}

	@Test
	public void testVeiculos() throws InterruptedException {
		driver.get(this.url);
		
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.name("user")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("senha123");
		driver.findElement(By.name("btnLogin")).click();
		
		driver.findElement(By.name("btnVeiculos")).click();
		
		assertEquals("http://localhost:4200/veiculos", driver.getCurrentUrl());
		
		Thread.sleep(15000);
	}

}