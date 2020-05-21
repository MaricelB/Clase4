package Clase1;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Lab1 
{
 @Ignore
 public void lab1_E1 ()
 {
	 //recibe dos parametro, el primero el chrome drivers y
	 //luego la ruta
	 System.setProperty("webdriver.chrome.driver","..\\Automatizacion\\Drivers\\chromedriver.exe");
	 WebDriver driver= new ChromeDriver(); //creamos una variable de tipo driver
	driver.get("https://selenium.dev/"); 
	driver.quit();
	 
 }
 @Ignore
 public void lab1_E2()
 {
	System.setProperty("webdriver.gecko.driver","\"..\\Automatizacion\\Drivers\\geckodriver.exe");
	WebDriver driver= new FirefoxDriver();
	driver.get("https://selenium.dev/");
	driver.manage().window().maximize(); //para hacer que maximice la ventana
	driver.quit();//para cerrar
	
 }
 @Test
 public void lab1_E3()
 {
	 System.setProperty("webdriver.chrome.driver","..\\Automatizacion\\Drivers\\chromedriver.exe");
	 WebDriver driver= new ChromeDriver();
	 driver.get("https://selenium.dev/"); 
	 driver.manage().window().maximize();
	 WebElement txtBusqueda=driver.findElement(By.id("gsc-i-id1"));//para que encuentre el elemento
	 txtBusqueda.sendKeys("busqueda lala");//para enviar texto
	 txtBusqueda.sendKeys(Keys.ENTER);
	 
	 driver.quit();
	 
 }
	
}
