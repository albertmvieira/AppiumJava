package br.amv.appium.page;

import static br.amv.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.amv.appium.core.BasePage;


public class CliquePage extends BasePage {
	
	public void cliqueLongo() {
		cliqueLongo(By.xpath("//*[@text='Clique Longo']"));
	}
	

	public String obterTextoCampo() {
		return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	} 

}
