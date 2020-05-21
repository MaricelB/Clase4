package Clase1;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
//espera explicita
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Lab2 
{
	@Ignore
	public void lab2_E1()//espera implicita
	{
		System.setProperty("webdriver.chrome.driver","..\\Automatizacion\\Drivers\\chromedriver.exe");
		 WebDriver driver= new ChromeDriver(); //creamos una variable de tipo driver
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://selenium.dev/");
		WebElement linkDescarga = driver.findElement(By.linkText("Downloads"));
		//para que haga click en el elemento
		linkDescarga.click();
		
		driver.quit();		
		
	}
	@Test
	public void lab2_E1a()//Espera explicita
	{
		 System.setProperty("webdriver.chrome.driver","..\\Automatizacion\\Drivers\\chromedriver.exe");
		 WebDriver driver= new ChromeDriver();
		 
		 driver.get("https://www.facebook.com/");
		 driver.manage().window().maximize();
		 
		 WebDriverWait myWaitVar = new WebDriverWait(driver, 10);
		 
         WebElement txtNombre = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("firstname")));         
         txtNombre.sendKeys("Mari");
         
         WebElement txtApellido = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[contains(@class,'inputtext _58mg')])[2]")));
         //WebElement txtApellido = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("lastname")));
         txtApellido.sendKeys("Burgener");
         
     
         
         WebElement txtCel = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='reg_email__']")));
         txtCel.sendKeys("13123");
         
         WebElement txtCont = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("reg_passwd__")));
         txtCont.sendKeys("13123");
         
         Select mes = new Select(myWaitVar.until(ExpectedConditions.elementToBeClickable(By.id("month"))));
         mes.selectByVisibleText("mar");
         
         Select dia = new Select(myWaitVar.until(ExpectedConditions.elementToBeClickable(By.id("day"))));
         dia.selectByValue("3");
         //dia.selectByIndex(); otra forma de seleccionar el dia
         
         WebElement btnClic = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("websubmit")));
         btnClic.click();
         
         driver.quit();
		 
	}
	@Ignore
	public void lab2_E1b()
	{
		System.setProperty("webdriver.chrome.driver","..\\Automatizacion\\Drivers\\chromedriver.exe");
		 WebDriver driver= new ChromeDriver();
		 
		 driver.get("https://www.facebook.com/");
		 driver.manage().window().maximize();
		 
		 WebDriverWait myWaitVar = new WebDriverWait(driver, 10);
		 
		 WebElement corrElec = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("email")));
		 corrElec.sendKeys("2543");
		 
		 WebElement contra = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("pass")));
		 contra.sendKeys("548");
		 
		 WebElement btnInicio = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Entrar']")));
		 //WebElement Iniciar = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("Entrar")));
		 //WebElement Iniciar = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("Iniciar sesión")));
		 btnInicio.click();	 
		 
		 
	}
	

}
