package br.amv.appium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.amv.appium.core.BaseTest;
import br.amv.appium.page.MenuPage;
import br.amv.appium.page.WebViewPage;

public class WebViewTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private WebViewPage page = new WebViewPage();
	
	@Test
	public void deveFazerLogin() {
		//acessar menu
		menu.acessarSBHibrido();
		esperar(3000);
		page.entrarContextoWeb();
		
		//preencher email
		page.setEmail("albert2@teste.com");
		
		//senha
		page.setSenha("albert123");
		
		//entrar
		page.entrar();
		
		//verificar
		Assert.assertEquals("Bem vindo, Albert!", page.getMensagem());
	}
	
	@After
	public void backContext() {
		page.sairContextoWeb();
	}

}
