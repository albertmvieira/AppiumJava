package br.amv.appium.page.seuBarriga;

import br.amv.appium.core.BasePage;

public class SBMenuPage extends BasePage {
	
	public void acessarContas() {
		clicarPorTexto("CONTAS");
	}
	
	public void acessarMovimentacao() {
		clicarPorTexto("MOV...");
	}
	
	public void acessarResumo() {
		clicarPorTexto("RESUMO");
	}
	
	public void acessarHome() {
		clicarPorTexto("HOME");
	}

}
