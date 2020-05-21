package Pruebas;

import org.testng.annotations.Test;

import Paginas.paginaInicio;
import Paginas.paginaLogin;
import Utilidades.DatosExcel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterSuite;

public class Laboratorio4_E1 
{

	WebDriver driver;
	String url="http://automationpractice.com/index.php";
	String pathDriver="..\\Automatizacion\\Drivers\\chromedriver.exe";
	
	 @BeforeSuite
		public void setUp() 
		{
		 System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
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
		
		@Test (priority=1, dataProvider="Registro invalido excel")
		public void ingreso(String usuario, String clave) throws IOException
		{
			paginaLogin login=new paginaLogin(driver);
			login.irRegistro(usuario,clave);
			
			File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen,new File("..\\Automatizacion\\Evidencias\\Test.png"));
			
			Assert.assertEquals("AUTHENTICATION",login.getTituloForm());
			
			
			
		}

   @DataProvider(name="Registro invalido")
   public Object[][] dp() 
   {
   
	   Object [][] datos= new Object[2][2];//la cantidad de datos a pasarle
	   datos[0][0]="mari";
	   datos[0][1]="contraseña";
	   datos[1][0]="milagros";
	   datos[1][1]="1245";
	   
	   return datos;
   }
   
   @DataProvider(name="Registro invalido excel")
   public Object[][] datosPruebasExcel() throws Exception
   {
	   Object [][] datos = DatosExcel.leerExcel("C:\\Users\\marib\\eclipse-workspace\\Automatizacion\\Recursos\\Datos.xlsx","Hoja1");
	   return datos;
	   
   }
  
 

  @AfterSuite
  public void afterSuite() 
  {
	  driver.quit();
  }

}
