package br.amv.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.amv.appium.core.BaseTest;
import br.amv.appium.page.MenuPage;

public class SwipeTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	
	@Test
	public void deveRealizarSwipe() {
		//acessar menu
		menu.acessarSwipe();
		
		//verificar texto "a esquerda"
		Assert.assertTrue(menu.existeElementoporTexto("a esquerda"));
		
		//swipe para direita
		menu.swipeRight();
		
		//verificar texto "E veja se"
		Assert.assertTrue(menu.existeElementoporTexto("E veja se"));
		
		//clicar botão direita
		menu.clicarPorTexto("›");
		
		//verificar texto  "Chegar até o fim!"
		Assert.assertTrue(menu.existeElementoporTexto("Chegar até o fim!"));
		
		//swipe esquerda
		menu.swipeLeft();
		
		//clicar botão esquerda
		menu.clicarPorTexto("‹");
		
		//verificar texto "a esquerda"
		Assert.assertTrue(menu.existeElementoporTexto("a esquerda"));
	}

}
