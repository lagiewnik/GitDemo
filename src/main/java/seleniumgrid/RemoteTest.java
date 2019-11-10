package seleniumgrid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteTest {
    public static void main(String[] args) {
        //DesiredCapabilities
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("chrome");
        //dc.setPlatform(Platform.WINDOWS);
        dc.setPlatform(Platform.VISTA);

        //webdriver for remote
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),dc);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get("http://www.google.pl");
        try {
            Thread.sleep(3999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

    }
}
