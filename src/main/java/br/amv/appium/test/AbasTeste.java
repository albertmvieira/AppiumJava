package br.amv.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.amv.appium.core.BaseTest;
import br.amv.appium.page.AbasPage;
import br.amv.appium.page.MenuPage;

public class AbasTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AbasPage abas = new AbasPage();
	
	
	@Test
	public void deveInteragirComAbas() {
		//acessar menu abas
		menu.acessarAbas();
		
		//verificar que esta na aba 1
		Assert.assertTrue(abas.isAba1());
		
		//acessar aba 2
		abas.selecionarAba2();
		
		//verificar que esta na aba 2
		Assert.assertTrue(abas.isAba2());
	}

}
