package Paginas;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class paginaLogin 
{
 
	WebDriver driver;
	
	@FindBy (id="email")
  	WebElement txtEmail;
	
	@FindBy (id="passwd")
	WebElement txtPass;
	
	@FindBy (xpath="//*[@id=\"SubmitLogin\"]/span")
    WebElement btnLogin;
	
	
	
	@FindBy (xpath="//*[@id=\"center_column\"]/h1")
	WebElement tituloForm;
	
	public paginaLogin(WebDriver driver) 
	{
		this.driver = driver;
  	    //Inicializa los elementos con una espera implicita
  	    PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this);
	}
	
	public void irRegistro(String email, String clave)
	{
		txtEmail.clear();
		txtEmail.sendKeys(email);
		
		txtPass.clear();
		txtPass.sendKeys(clave);
		
		btnLogin.click();
	}
	
	public String getTituloForm()
	{
		return tituloForm.getText();
	}
	
}
