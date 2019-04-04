package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.navegacao;

public class cadastro_page {

	WebDriver driver; 
	
	public cadastro_page(WebDriver driver) {
		this.driver = driver;
	}

	// Elementos
	private static String inp_nome      = "nome";
	private static String inp_email     = "email";
	private static String inp_senha     = "senha";
	private static String btn_cadastrar = "//*[@class='btn btn-primary']";
	private static String msg_sucess    = "//div[@class=\"alert alert-success\"]";
	private static String msg_error     = "//div[@class=\"alert alert-danger\"]";

	public void acessarUrlCadastro(String url) {
		navegacao.acessar_url(url);
	}

	public void preencherNome(String arg1) throws InterruptedException {
		navegacao.digitar_texto(By.id(inp_nome), arg1);
	}

	public void preencherEmail(String arg1) throws InterruptedException {
		navegacao.digitar_texto(By.id(inp_email), arg1);
	}

	public void preencherSenha(String arg1) throws InterruptedException {
		navegacao.digitar_texto(By.id(inp_senha), arg1);
	}
	
	public void preencherFormulario(String nome, String email, String senha) throws InterruptedException {
		preencherNome(nome);
		preencherEmail(email);
		preencherSenha(senha);
	}

	public void clicarCadastrar() throws InterruptedException {
		navegacao.clicar_elemento(By.xpath(btn_cadastrar));
	}

	public void validarMensagemSucesso(String arg1) throws InterruptedException {
		String textoElement = this.driver.findElement(By.xpath(msg_sucess)).getText();
		assertEquals(arg1, textoElement);
	}

	public void validarMensagemErro(String arg1) throws InterruptedException {
		String textoElement = this.driver.findElement(By.xpath(msg_error)).getText();
		assertEquals(arg1, textoElement);
	}
}