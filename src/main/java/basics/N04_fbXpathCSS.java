package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class N04_fbXpathCSS {
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

        //type email by Xpath: //input[@type='email']
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("blalblacar");
        //type password by Xpath
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("q3qwffsd");
        //click on login button by XPATH
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //NOW use CSS selector
        driver.get("https://facebook.com");
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("qqweqweqweqwe");
        driver.findElement(By.cssSelector("input[id='pass']")).sendKeys("q3qwffsd");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        //driver.quit();

    }
}
