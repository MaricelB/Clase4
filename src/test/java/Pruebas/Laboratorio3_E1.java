package Pruebas;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class Laboratorio3_E1 {
	WebDriver driver;
	@BeforeSuite
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "..\\Automatizacion\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@BeforeTest
	public void irUrl()
	{
		driver.get("https://www.facebook.com/");
	}
	
	@BeforeClass
	public void maxVentana()
	{
		driver.manage().window().maximize();
	}
		
	
	@Test (description="Registro invalido de usuario")
	public void registroUsuario() 
	{
		WebDriverWait myWaitVar = new WebDriverWait(driver, 10);

		WebElement txtNombre = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("firstname")));
		txtNombre.sendKeys("Mari");

		WebElement txtApellido = myWaitVar.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//input[contains(@class,'inputtext _58mg')])[2]")));
		// WebElement txtApellido =
		// myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("lastname")));
		txtApellido.sendKeys("Burgener");

		WebElement txtCel = myWaitVar
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='reg_email__']")));
		txtCel.sendKeys("13123");

		WebElement txtCont = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("reg_passwd__")));
		txtCont.sendKeys("13123");

		Select mes = new Select(myWaitVar.until(ExpectedConditions.elementToBeClickable(By.id("month"))));
		mes.selectByVisibleText("mar");

		Select dia = new Select(myWaitVar.until(ExpectedConditions.elementToBeClickable(By.id("day"))));
		dia.selectByValue("3");
		// dia.selectByIndex(); otra forma de seleccionar el dia

		WebElement btnClic = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("websubmit")));
		btnClic.click();

		Assert.assertEquals("https://www.facebook.com/", driver.getCurrentUrl());
	}
	
	@AfterClass
	public void finPrueba()
	{
		System.out.println("Fin de prueba");
	}
	@AfterTest
	public void cierre()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void finSuite()
	{
		System.out.println("Fin Suite");
	}
}
