package com.silvio.plataforma;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenSiteTest {
	
	private String url = "https://gestao-de-frotas.netlify.app";
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

		driver.findElement(By.id("usuario")).sendKeys("teste");
		driver.findElement(By.id("senha")).sendKeys("senha123");
		driver.findElement(By.name("btnLogin")).click();
		
		assertNotEquals("https://gestao-de-frotas.netlify.app/", driver.getCurrentUrl());
		
		Thread.sleep(5000);
	}

	@Test
	public void testLoginOk() throws InterruptedException {
		driver.get(this.url);
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.findElement(By.id("usuario")).sendKeys("admin");
		driver.findElement(By.id("senha")).sendKeys("senha123");
		driver.findElement(By.name("btnLogin")).click();
		
		assertEquals("https://gestao-de-frotas.netlify.app/", driver.getCurrentUrl());
		
		Thread.sleep(5000); 
	}

	@Test
	public void testVeiculosRead() throws InterruptedException {
		driver.get(this.url);
		
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
		driver.findElement(By.id("usuario")).sendKeys("admin");
		driver.findElement(By.id("senha")).sendKeys("senha123");
		driver.findElement(By.name("btnLogin")).click();
		
		driver.findElement(By.linkText("Condutor")).click();
		
		assertEquals("https://gestao-de-frotas.netlify.app/condutor", driver.getCurrentUrl());
		
		Thread.sleep(15000);
	}
	
	@Test
	public void testCondutorCreate() throws InterruptedException {
		
		driver.get(this.url);
		
		driver.findElement(By.id("usuario")).sendKeys("admin");
		driver.findElement(By.id("senha")).sendKeys("senha123");
		driver.findElement(By.name("btnLogin")).click();		
		driver.findElement(By.linkText("Condutor")).click();
		
		driver.findElement(By.id("btnNovo")).click();
		driver.findElement(By.name("nome")).sendKeys("Teste Selenium");
		driver.findElement(By.name("cpf")).sendKeys("12345678901");
		driver.findElement(By.name("matricula")).sendKeys("1234");
		driver.findElement(By.name("numeroCNH")).sendKeys("12456789");
		driver.findElement(By.name("validade")).sendKeys("10102020");
		driver.findElement(By.name("categoriaCnh")).click();
		driver.findElement(By.id("D")).click();
		driver.findElement(By.name("cidade")).sendKeys("Palmas");
		driver.findElement(By.name("bairro")).sendKeys("Sul");
		driver.findElement(By.name("complemento")).sendKeys("s/n");
		driver.findElement(By.name("numero")).sendKeys("1");
		driver.findElement(By.id("btnCriar")).click();
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://gestao-de-frotas.netlify.app/condutor"));
		
		driver.manage().timeouts().implicitlyWait(40000, TimeUnit.MILLISECONDS);
		assertEquals("https://gestao-de-frotas.netlify.app/condutor", driver.getCurrentUrl());
	}
	
	@Test
	public void testCondutorUpdate() throws InterruptedException {
		
		driver.get(this.url);
		
		driver.findElement(By.id("usuario")).sendKeys("admin");
		driver.findElement(By.id("senha")).sendKeys("senha123");
		driver.findElement(By.name("btnLogin")).click();		
		driver.findElement(By.linkText("Condutor")).click();

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.id("editar")).click();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.name("cpf")).clear();
		driver.findElement(By.name("cpf")).sendKeys("000011112345");
		driver.findElement(By.name("matricula")).clear();
		driver.findElement(By.name("matricula")).sendKeys("9876");
		driver.findElement(By.name("cnh")).clear();
		driver.findElement(By.name("cnh")).sendKeys("654321987");
		driver.findElement(By.name("validade")).clear();
		driver.findElement(By.name("validade")).sendKeys("25-08-2025");
		driver.findElement(By.name("categoria")).click();
		driver.findElement(By.id("E")).click();
		driver.findElement(By.name("cidade")).clear();
		driver.findElement(By.name("cidade")).sendKeys("Palmas");
		driver.findElement(By.name("bairro")).clear();
		driver.findElement(By.name("bairro")).sendKeys("Centro");
		driver.findElement(By.name("complemento")).clear();
		driver.findElement(By.name("complemento")).sendKeys("Casa 3");
		driver.findElement(By.name("numero")).clear();
		driver.findElement(By.name("numero")).sendKeys("0");
		driver.findElement(By.id("btnSalvar")).click();
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://gestao-de-frotas.netlify.app/condutor"));
		
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		assertEquals("9876", driver.findElement(By.id("matricula")).getText());
	}
	
	@Test
	public void testCondutorDelete() throws InterruptedException {
		
		driver.get(this.url);
		
		driver.findElement(By.id("usuario")).sendKeys("admin");
		driver.findElement(By.id("senha")).sendKeys("senha123");
		driver.findElement(By.name("btnLogin")).click();		
		driver.findElement(By.linkText("Condutor")).click();

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.id("deletar")).click();
				
		driver.findElement(By.name("btnDeletar")).click();
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://gestao-de-frotas.netlify.app/condutor"));
		
		assertEquals("https://gestao-de-frotas.netlify.app/condutor", driver.getCurrentUrl());
	}

}