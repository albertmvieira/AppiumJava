package br.amv.appium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTeste {

	@Test
	public void deveSomarDoisNumeros() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "Android Emulator");
		desiredCapabilities.setCapability("udid", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
		desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		
		MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("plus");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
		Assert.assertEquals("4", el6.getText());
		driver.quit();
	}
}
