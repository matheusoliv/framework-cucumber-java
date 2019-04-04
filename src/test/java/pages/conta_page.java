package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.navegacao;

public class conta_page {
	WebDriver driver;
	
	public conta_page(WebDriver driver) {
		this.driver = driver;
	}
	
	// Elementos
	private static String dropContas           = "dropdown-toggle";
	private static String dropContasAdicionar  = "//li/a[text() = \"Adicionar\"]";
	private static String inpNomeConta         = "nome";
	private static String btnSalvar            = "/html/body/div[2]/form/div[2]/button";
	private static String msg_sucess           = "alert-success";
	private static String msg_error            = "alert-danger";
	private static String btn_Sair 			   = "Sair";
	
	// Variaveis
	private static String urlLogout      = "https://srbarriga.herokuapp.com/logout";
		
	public void clicarContas() {
		navegacao.clicar_elemento(By.className(dropContas));
		navegacao.clicar_elemento(By.xpath(dropContasAdicionar));
	}

	public void adicionarConta(String arg1) {
		navegacao.digitar_texto(By.id(inpNomeConta), arg1);
		navegacao.clicar_elemento(By.xpath(btnSalvar));
	}
	
	public void clicarSair() {
		navegacao.clicar_elemento(By.partialLinkText(btn_Sair));
	}

	public void validarMensagemContaSucesso(String arg1) {
		String textoElement = this.driver.findElement(By.className(msg_sucess)).getText();
        assertEquals(arg1, textoElement);
	}

	public void validarMensagemContaExistente(String arg1) {
		String textoElement = this.driver.findElement(By.className(msg_error)).getText();
        assertEquals(arg1, textoElement);
	}

	public void validarLogout() {
		String urlAtual = this.driver.getCurrentUrl();
        assertEquals(urlLogout, urlAtual);	
	}	
}
