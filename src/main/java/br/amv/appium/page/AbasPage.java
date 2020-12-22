package br.amv.appium.page;

import br.amv.appium.core.BasePage;

public class AbasPage extends BasePage {
	
	public boolean isAba1() {
		return existeElementoporTexto("Este é o conteúdo da Aba 1");
	}
	
	public boolean isAba2() {
		return existeElementoporTexto("Este é o conteúdo da Aba 2");
	}
	
	public void selecionarAba2() {
		clicarPorTexto("ABA 2");
	}

}
