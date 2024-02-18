import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverSettings {
    public static AppiumDriver driver;
    public static String appPackage = "com.obilet.androidside";
    public static String appActivity = "com.obilet.androidside.presentation.screen.splash.activity.SplashScreen";
    public static String bundleId = "ilerde ios yazarken işimize yarayacak (uygulamanın paket ismi gibi denebilir)";
    public static Boolean isAndroid = true; //ios ise true'ya çekilir onun ayarları çalışır

    public static Boolean isBrowserStack = true;
    public static String Username = "batuhandas_hdq4VD";
    public static String Access_Key = "2z3xWrDQiDio3UHEmts2";

    public static final String URL = "https://" + Username + ":" + Access_Key + "@hub-cloud.browserstack.com/wd/hub";

    public static void initializeDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (isBrowserStack) {
            capabilities.setCapability("deviceName", "Samsung Galaxy S22 Ultra");
            capabilities.setCapability("os_version", "12.0");
            capabilities.setCapability("Project", "Demo App Automation");
            capabilities.setCapability("build", "5.1");
            capabilities.setCapability("name", "BrowserStack Sample Name");
            capabilities.setCapability("app", "bs://61a655370e11e39c20cb37c133c0734f9a121262");
            capabilities.setCapability("automationName", "UiAutomator2");
            driver = new AndroidDriver(new URL(URL), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } else {
            if (isAndroid) {
                capabilities.setCapability("BROWSER_NAME", "Android");
                capabilities.setCapability("VERSION", "11.0");
                capabilities.setCapability("deviceName", "device");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("appPackage", appPackage);
                capabilities.setCapability("appActivity", appActivity);
            } else {
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("platformVersion", "16.3.1");
                capabilities.setCapability("deviceName", "iPhone XR");
                capabilities.setCapability("udid", "ios cihazımızın kimlik numarası denebilir");
                capabilities.setCapability("bundleId", bundleId);
            }
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
