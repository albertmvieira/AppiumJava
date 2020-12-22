package br.amv.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.amv.appium.core.BaseTest;
import br.amv.appium.page.MenuPage;
import br.amv.appium.page.seuBarriga.SBContasPage;
import br.amv.appium.page.seuBarriga.SBHomePage;
import br.amv.appium.page.seuBarriga.SBLoginPage;
import br.amv.appium.page.seuBarriga.SBMenuPage;
import br.amv.appium.page.seuBarriga.SBMovimentacaoPage;
import br.amv.appium.page.seuBarriga.SBResumoPage;

public class SBTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SBLoginPage login = new SBLoginPage();
	private SBMenuPage sbMenu = new SBMenuPage();
	private SBContasPage conta = new SBContasPage();
	private SBMovimentacaoPage mov = new SBMovimentacaoPage();
	private SBHomePage home = new SBHomePage();
	private SBResumoPage resumo = new SBResumoPage();
	
	@Before
	public void setup() {
		menu.acessarSBNativo();
		login.setEmail("albert2@teste.com");
		login.setSenha("albert123");
		login.entrar();
	}
	
	@Test
	public void deveInserirContacomSucesso() {
		//entrar em contas
		sbMenu.acessarContas();
		
		//digitar nome conta
		conta.setConta("Conta do Albert");
		
		//salvar
		conta.salvar();
		
		//verificar mensagem
		Assert.assertTrue(conta.existeElementoporTexto("Conta adicionada com sucesso"));
	}
	
	@Test
	public void deveExcluirConta() {
		//entrar em contas
		sbMenu.acessarContas();
		
		//clique longo na conta
		conta.selecionarConta("Conta do Albert");
		
		//excluir
		conta.excluir();
				
		//verificar mensagem
		Assert.assertTrue(conta.existeElementoporTexto("Conta excluída com sucesso"));
	}
	
	@Test
	public void deveValidarInclusaoMov() {
		sbMenu.acessarMovimentacao();
		
		//validar desc
		esperar(1000);
		mov.salvar();
		Assert.assertTrue(mov.existeElementoporTexto("Descrição é um campo obrigatório"));
		
		//validar interessado
		mov.setDescricao("Desc");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoporTexto("Interessado é um campo obrigatório"));
		
		//validar valor
		mov.setInteressado("interessado");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoporTexto("Valor é um campo obrigatório"));
		
		//validar conta
		mov.setValor("1234");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoporTexto("Conta é um campo obrigatório"));
		
		//inserir com sucesso
		mov.setConta("mov");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoporTexto("Movimentação cadastrada com sucesso"));
	}
	
	@Test
	public void deveAtualizarSaldoAoExcluirMovimen() {
		//Verificar saldo conta "Conta para saldo 500"
		Assert.assertEquals("500.00", home.obterSaldoConta("Conta para saldo"));
		
		//ir para resumo
		sbMenu.acessarResumo();
		
		//excluir movimentação Test 2
		resumo.excluirMovimentacao("Teste 2");
		
		//validar mensagem "Movimentação removida com sucesso!"
		Assert.assertTrue(resumo.existeElementoporTexto("Movimentação removida com sucesso!"));
		
		//voltar home
		sbMenu.acessarHome();
		
		//atualizar saldo com scroll down
		esperar(1000);
		home.scroll(0.2, 0.9);
		
		//validar saldo atualizado 650
		Assert.assertEquals("650.00", home.obterSaldoConta("Conta para saldo"));
		
	}

}
