package br.amv.appium.test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.amv.appium.core.BaseTest;
import br.amv.appium.core.DriverFactory;
import br.amv.appium.page.FormularioPage;
import br.amv.appium.page.MenuPage;
import io.appium.java_client.MobileBy;

public class FormularioTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private FormularioPage formulario = new FormularioPage();
	

	@Before
	public void inicializarAppium() throws MalformedURLException {	
		
		menu.acessarFormulario();

		/* Outras formas para selecionar o formulario
		 * // Selecionar formulario 2(por lista de elementos) List<MobileElement>
		 * elementosEncontrados =
		 * driver.findElements(By.className("android.widget.TextView")); // mostrando
		 * todos itens do formulario, pegando todos elementos e listando // através do
		 * for
		 * 
		 * for (MobileElement elemento: elementosEncontrados) {
		 * System.out.println(elemento.getText()); }
		 * 
		 * elementosEncontrados.get(1).click();
		 */

		// Selecionar formulario 3
		// driver.findElement(By.xpath("//*[@text='Formulário']")).click();
	}
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		formulario.escreverNome("Albert");

		// Checar nome escrito
		Assert.assertEquals("Albert", formulario.obterNome());
	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		formulario.selecionarCombo("Nintendo Switch");
		
		// verificar o opção selecionada
		Assert.assertEquals("Nintendo Switch", formulario.obterValorCombo());

	}

	@Test
	public void deveInteragirSwitchCheckbox() throws MalformedURLException {

		// verificar status dos elementos
		Assert.assertFalse(formulario.isCheckMarcado());
		Assert.assertTrue(formulario.isSwitchMarcado());

		// Clicar nos elementos
		formulario.clicarCheck();
		formulario.clicarSwitch();

		// verificar sestados alterados
		Assert.assertTrue(formulario.isCheckMarcado());
		Assert.assertFalse(formulario.isSwitchMarcado());

	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException {

		// Preencher campos
		formulario.escreverNome("Albert");
		formulario.clicarCheck();
		formulario.clicarSwitch();
		formulario.selecionarCombo("Nintendo Switch");

		// salvar
		formulario.salvar();

		// verificações
		Assert.assertEquals("Nome: Albert", formulario.obterNomeCadastrado());
		Assert.assertEquals("Console: switch", formulario.obterConsoleCadastrado());
		Assert.assertTrue(formulario.obterCheckCadastrado().endsWith("Off"));	
		Assert.assertTrue(formulario.obterSwitchCadastrado().endsWith("Marcado"));

	}
	
	@Test
	public void deveRealizarCadastroDemorado() throws MalformedURLException {

		// Preencher campos
		formulario.escreverNome("Albert");

		//zerando espera implicita no test para validar espera explicita
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		// salvar
		formulario.salvarDemorado();
		
		//Espera Explicita
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Albert']")));

		// verificações
		Assert.assertEquals("Nome: Albert", formulario.obterNomeCadastrado());

	}
	
	@Test
	public void deveAlterarData() throws InterruptedException {
		formulario.clicarPorTexto("01/01/2000");
		formulario.clicarPorTexto("20");
		formulario.clicarPorTexto("OK");
		Thread.sleep(1000); //apenas para teste
		Assert.assertTrue(formulario.existeElementoporTexto("20/2/2000"));
	}
	
	@Test
	public void deveAlterarHora() {
		formulario.clicarPorTexto("06:00");
		formulario.clicar(MobileBy.AccessibilityId("10"));
		formulario.clicar(MobileBy.AccessibilityId("40"));
		formulario.clicarPorTexto("OK");
		Assert.assertTrue(formulario.existeElementoporTexto("10:40"));
	}
	
	@Test
	public void deveInteragirComSeekbar() {
		//clicar seek bar
		formulario.clicarSeekBar(0.05);
		
		//salvar
		formulario.salvar();
	}
}
