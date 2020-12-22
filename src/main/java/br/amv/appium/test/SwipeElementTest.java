package br.amv.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.amv.appium.core.BaseTest;
import br.amv.appium.page.MenuPage;
import br.amv.appium.page.SwipeListPage;

public class SwipeElementTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SwipeListPage page = new SwipeListPage();
	
	@Test
	public void desafioSwipeElement() {
		// Clicar swipe list
		menu.clicarSwipeList();
		
		//Op1 para direita
		page.swipeElementRight("Opção 1");
		
		//clicar botao +
		page.clicarBotaoMais();
		
		//verificar texto opção
		Assert.assertTrue(page.existeElementoporTexto("Opção 1 (+)"));
		
		//OP4 para direia
		page.swipeElementRight("Opção 4");
		
		//clicar botao -
		page.clicarPorTexto("(-)");
		
		//verificar texto opção
		Assert.assertTrue(page.existeElementoporTexto("Opção 4 (-)"));
		
		//Op5 para esquerda
		page.swipeElementLeft("Opção 5 (-)");
		
		//verificar texto opção
		Assert.assertTrue(page.existeElementoporTexto("Opção 5"));
		
	}

}
