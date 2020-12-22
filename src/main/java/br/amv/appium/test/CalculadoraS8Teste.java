package br.amv.appium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraS8Teste {

	@Test
	public void deveSomarDoisNumeros() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "Android Emulator");
		desiredCapabilities.setCapability("udid", "ce10171a312a3c1004");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		desiredCapabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		
		MobileElement el3 = (MobileElement) driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("Plus");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("com.sec.android.app.popupcalculator:id/calc_tv_result");
		Assert.assertEquals("4", el6.getText());
		driver.quit();
	}
}
