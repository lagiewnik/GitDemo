package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class N02Facebook {
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

        driver.get("https://facebook.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //System.out.println(driver.getPageSource());
        driver.findElement(By.id("email")).sendKeys("ziomal");
        driver.findElement(By.name("pass")).sendKeys("dupa123");
        driver.findElement(By.linkText("Nie pamiętasz nazwy konta?")).click();
        driver.quit();

    }
}
