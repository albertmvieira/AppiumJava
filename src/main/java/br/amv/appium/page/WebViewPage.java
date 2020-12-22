package br.amv.appium.page;

import java.util.Set;

import org.openqa.selenium.By;

import br.amv.appium.core.BasePage;
import br.amv.appium.core.DriverFactory;

public class WebViewPage extends BasePage {
	
	public void entrarContextoWeb() {
		Set<String> contextHandles = DriverFactory.getDriver().getContextHandles();
		for (String valor : contextHandles) {
			System.out.println(valor);
		}
		DriverFactory.getDriver().context((String) contextHandles.toArray()[1]);
	}
	
	public void sairContextoWeb() {
		DriverFactory.getDriver().context((String) DriverFactory.getDriver().getContextHandles().toArray()[0]);
	}
	
	public void setEmail(String email) {
		DriverFactory.getDriver().findElement(By.id("email")).sendKeys(email);;
	}
	
	public void setSenha(String senha) {
		DriverFactory.getDriver().findElement(By.id("senha")).sendKeys(senha);;
	}
	
	public void entrar() {
		clicar(By.xpath("//button[@type='submit']"));
	}
	
	public String getMensagem() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}

}
