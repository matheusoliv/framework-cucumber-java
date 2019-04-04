package pages;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helper.navegacao;

public class login_page {

	WebDriver driver;

	public login_page(WebDriver driver) {
		this.driver = driver;
	}

	// Elementos
	private static String inp_email = "email";
	private static String inp_senha = "senha";
	private static String btn_entrar = "//button[@class =\"btn btn-primary\"]";
	private static String msg_sucess = "//div[@class = \"alert alert-success\"]";

	public void acessarUrlLogin(String url) {
		navegacao.acessar_url(url);
	}

	public void preencherEmail(String arg1) {
		navegacao.digitar_texto(By.id(inp_email), arg1);
	}

	public void preencherSenha(String arg1) {
		navegacao.digitar_texto(By.id(inp_senha), arg1);
	}

	public void preencherFormularioLogin(String email, String senha) {
		preencherEmail(email);
		preencherSenha(senha);
	}

	public void clicarEntrar() {
		navegacao.clicar_elemento(By.xpath(btn_entrar));
	}

	public void validarMensagemLoginSucesso(String arg1) {
		String textoElement = this.driver.findElement(By.xpath(msg_sucess)).getText();
		assertEquals(arg1, textoElement);
	}
}