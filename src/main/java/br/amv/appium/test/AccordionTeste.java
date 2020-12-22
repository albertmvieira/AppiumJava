package br.amv.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.amv.appium.core.BaseTest;
import br.amv.appium.page.AccordionPage;
import br.amv.appium.page.MenuPage;

public class AccordionTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AccordionPage accordion = new AccordionPage();

	@Test
	public void deveInteragirComAccordion() throws InterruptedException {
		//acessar menu
		menu.acessarAccordion();
		
		//clicar op 1
		accordion.selecionarOp1();
		
		//verificar texto op 1
		Thread.sleep(1000);
		Assert.assertEquals("Opção 1", accordion.obterValorOp1());
		
	}
}
