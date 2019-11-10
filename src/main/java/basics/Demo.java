package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Demo {
    enum Browser {
        Chrome, FF, IE
    };
    public static void main(String[] args){

        WebDriver driver=null;
        Browser browserName = Browser.Chrome;
        switch (browserName) {
            case Chrome:
                //Create Driver object for Chrome browse
                System.setProperty("webdriver.chrome,driver", "C:\\selenium_web_driver\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case FF:
                //Create Driver object for Firefox browse
                System.setProperty("webdriver.gecko.driver", "C:\\selenium_web_driver\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case IE:
                //Create Driver object for Firefox browse
                System.setProperty("webdriver.ie.driver", "C:\\selenium_web_driver\\MicrosoftWebDriver.exe");
                driver = new InternetExplorerDriver();
                break;
            default:
        }

        driver.get("https://google.pl");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //System.out.println(driver.getPageSource());

        driver.get("http://yahoo.com");
        driver.navigate().back();

        driver.quit();

    }
}
