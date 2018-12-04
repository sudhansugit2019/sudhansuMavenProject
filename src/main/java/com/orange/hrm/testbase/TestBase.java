package com.orange.hrm.testbase;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;

	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/orange/hrm/properties/Test.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public static void intilizationSetup() {
		String browserName = prop.getProperty("browser");
		try {
			if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"D:\\JavaProject\\SeleniumProjects\\com.orange.hrm\\server\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.gecko.driver",
						"D:\\JavaProject\\SeleniumProjects\\com.orange.hrm\\server\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
		} catch (Exception e) {
			System.out.println("Browser couldn't be loaded " + e.getMessage());
		}
	}
}
