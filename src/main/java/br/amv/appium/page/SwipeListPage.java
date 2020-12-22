package br.amv.appium.page;

import static br.amv.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.amv.appium.core.BasePage;
import br.amv.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class SwipeListPage extends BasePage {
	
	public void swipeElementLeft(String opcao) {
		swipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.1, 0.9);
	}
	
	public void swipeElementRight(String opcao) {
		swipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.9, 0.1);
	}
	
	public void clicarBotaoMais() {
		MobileElement botao =  DriverFactory.getDriver().findElement(By.xpath("//*[@text='(+)']/.."));
		AndroidTouchAction touch = new AndroidTouchAction (getDriver());
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(botao, -50, 0))).perform();
	}

}
