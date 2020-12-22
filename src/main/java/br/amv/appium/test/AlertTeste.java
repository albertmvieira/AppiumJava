package br.amv.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.amv.appium.core.BaseTest;
import br.amv.appium.page.AlertaPage;
import br.amv.appium.page.MenuPage;

public class AlertTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AlertaPage pageAlerta = new AlertaPage();
	
	@Before
	public void setup() {
		//acessar menu alerta
		menu.acessarAlertas();
	}
	
	@Test
	public void deveConfirmarAlerta() {
		
		//clicar em alerta confirm
		pageAlerta.clicarAlertaConfirm();
		
		//verificar os textos
		Assert.assertEquals("Info", pageAlerta.obterTitleAlerta());
		Assert.assertEquals("Confirma a operação?", pageAlerta.obterMensagemAlerta());
		
		//confirmar alerta
		pageAlerta.confirmar();
		
		//verificar nova mensagem
		Assert.assertEquals("Confirmado", pageAlerta.obterMensagemAlerta());
		
		//sair
		pageAlerta.sair();
	}
	
	@Test
	public void deveClicarForaAlerta() {
		//clicar alerta simples
		pageAlerta.clicarAlertaSimples();
		
		// clicar fora da caixa
		esperar(1500);
		pageAlerta.clicarForaCaixa();
		
		//verificar que a mensagem não está presente
		esperar(1000);
		Assert.assertFalse(pageAlerta.existeElementoporTexto("Pode clicar no OK ou fora da caixa para sair"));
	}

}
