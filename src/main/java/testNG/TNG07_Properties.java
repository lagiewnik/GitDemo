package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TNG07_Properties {

    @Test
    public void Login() throws IOException {
        System.out.println(System.getProperty("user.dir"));
        Properties propies=new Properties();
        File file;
        FileInputStream fis = new FileInputStream("D:\\KURSY\\SELENIUM_UDEMY\\Introduction\\src\\main\\java\\testNG\\datadriven.properties");

        propies.load(fis);

        System.out.println(propies.getProperty("username"));
        WebDriver driver = null;
        String browserName = propies.getProperty("browser").toLowerCase();

        switch (browserName) {
            case "chrome":
                //Create Driver object for Chrome browse
                System.setProperty("webdriver.chrome,driver", "C:\\selenium_web_driver\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "ff":
                //Create Driver object for Firefox browse
                System.setProperty("webdriver.gecko.driver", "C:\\selenium_web_driver\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "ie":
                //Create Driver object for Firefox browse
                System.setProperty("webdriver.ie.driver", "C:\\selenium_web_driver\\MicrosoftWebDriver.exe");
                driver = new InternetExplorerDriver();
                break;
            default:
        }
        driver.get(propies.getProperty("url"));
    }






}
