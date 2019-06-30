import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "QA_19_class");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.ebay.mobile");
        capabilities.setCapability("appActivity", "");
        capabilities.setCapability("app", "C:\\Users\\97255\\Downloads\\com.ebay.mobile_163_apps.evozi.com.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    protected String getElementText(By locator) {
        return driver.findElement(locator).getText();
    }

    protected void typeText(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    protected void clickSplash() {
        click(By.id("search_box"));
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
