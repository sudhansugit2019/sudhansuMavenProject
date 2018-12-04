package com.orange.hrm.hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.orange.hrm.testbase.TestBase;
import com.orange.hrm.utils.TestUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends TestBase {

	@Before
	public void beforeHook(Scenario scenario) {
		intilizationSetup();
		System.out.println(scenario.getName());
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		System.out.println(capabilities.getBrowserName());
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	@After
	public void afterHook(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			scenario.write("URL :" + driver.getCurrentUrl());
		}
		driver.quit();
	}
}
