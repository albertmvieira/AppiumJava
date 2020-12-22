package br.amv.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.amv.appium.core.BaseTest;
import br.amv.appium.page.MenuPage;
import br.amv.appium.page.SplashPage;

public class SplashTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SplashPage splash = new SplashPage();
	
	@Test
	public void deveAguardarSplahSumir() {
		//acessar menu splash
		menu.acessarSplash();
		
		//verificar que o splash esta sendo exibido
		splash.isTelaSplashVisivel();
		
		//aguardar saida do splash
		splash.aguardarSplashSumir();
		
		//verificar que o formulario esta sendo exibido
		Assert.assertTrue(splash.existeElementoporTexto("Formulário"));
	}

}
