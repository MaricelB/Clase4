package Pruebas;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import Paginas.paginaInicio;
import Paginas.paginaLogin;

public class Laboratorio3_E2 
{
	WebDriver driver;
	String url="http://automationpractice.com/index.php";
	String pathDriver="..\\Automatizacion\\Drivers\\chromedriver.exe";

	@BeforeTest
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver", pathDriver);
		driver = new ChromeDriver();
		driver.get(url);
	}

	@Test (priority=0)
	public void f() 
	{
		// variable de tipo de clase e instanciarla
		paginaInicio inicio = new paginaInicio(driver);
		inicio.clicLogin();

	}
	
	@Test (priority=1)
	public void ingreso() throws IOException
	{
		paginaLogin login=new paginaLogin(driver);
		login.irRegistro("sdfsdf","1234");
		
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\Automatizacion\\Evidencias\\Test.png"));
	}
}
