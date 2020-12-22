package br.amv.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.amv.appium.core.BaseTest;
import br.amv.appium.page.CliquePage;
import br.amv.appium.page.MenuPage;


public class CliqueTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private CliquePage page = new CliquePage();
	
	@Before
	public void setup() {
		//acessar menu
		menu.acessarCliques();
	}
	
	@Test
	public void deveRealizarCliqueLongo(){

		
		//clique longo
		page.cliqueLongo();
		
		//verificar texto
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
		page.clicarPorTexto("Clique duplo");
		page.clicarPorTexto("Clique duplo");
		
		//verificar texto
		Assert.assertEquals("Duplo Clique", page.obterTextoCampo());
	}

}
