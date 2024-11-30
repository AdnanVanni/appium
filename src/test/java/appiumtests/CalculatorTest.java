package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorTest {
    public static void main(String[] args) {
        calculatorTest();
    }

    public static void calculatorTest() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "13");
        capabilities.setCapability("appium:deviceName", "DN2101");
        capabilities.setCapability("appium:udid", "FUSSK7J7T48TYD99");
        capabilities.setCapability("appium:appPackage", "io.appium.android.apis");
        capabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");

        // Log the capabilities for debugging
        System.out.println("Using the following capabilities:");
        System.out.println(capabilities);

        try {
            // Create the Appium driver with the desired capabilities
            AndroidDriver driver = new  AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
            System.out.println("Session created successfully!");

            driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"App\"]")).click();
           String text= driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Alarm\"]")).getText();
           driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Alarm\"]")).click();
           System.out.print(text);
            // Add some test actions here, e.g., find and interact with elements
            // Example: driver.findElementById("com.android.calculator2:id/digit_1").click();

            // Quit the driver session after test completion
            driver.quit();
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error during session creation.");
            e.printStackTrace();
        }
    }
}
