package br.amv.appium.page;

import static br.amv.appium.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;

import br.amv.appium.core.BasePage;
import br.amv.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class DragNDropPage extends BasePage {
	
	public void arrastar(String origem, String destino) {
		MobileElement inicio = DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+ origem +  "']"));
		MobileElement fim = DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+ destino +  "']"));
		
		AndroidTouchAction touch = new AndroidTouchAction (getDriver());
		touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(inicio)))
						.moveTo(ElementOption.element(fim))
						.release()
						.perform();
	}
	
	public String[] obterLista() {
		List<MobileElement> elements = DriverFactory.getDriver().findElements(By.className("android.widget.TextView"));
		String[] retorno = new String[elements.size()];
		for (int i = 0; i < elements.size(); i++) {
			retorno[i] = elements.get(i).getText();
//			System.out.println("\"" + retorno[i] + "\", ");
		}
		return retorno;	
	}
	
	

}
