package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class navegacao {
	
static WebDriver driver; 
	
	public navegacao(WebDriver driver) {
		navegacao.driver = driver;
	}
	
	public static void acessar_url(String url) {
		driver.get(url);
	}
	
	public static void clicar_elemento(By by) {
		driver.findElement(by).click();
	}
	
	public static void digitar_texto(By by, String valor) {
		driver.findElement(by).sendKeys(valor);
	}
}
