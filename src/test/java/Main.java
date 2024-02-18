import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class Main extends DriverSettings {

    @BeforeClass
    public static void setUpSettings() {
        try {
            initializeDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDown() {
        quitDriver();
    }

    @Test
    public void verifySearchFunctionality() {
        driver.findElement(By.id("com.obilet.androidside:id/find_bus_journey_departure_today_button")).click();
    }
}
