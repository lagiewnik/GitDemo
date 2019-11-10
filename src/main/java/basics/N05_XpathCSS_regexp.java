package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class N05_XpathCSS_regexp {
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

        driver.get("https://www.rediff.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //click on Sign in by Xpath:
        driver.findElement(By.xpath("//a[contains(@title,'Sign in')]")).click();
        driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("qwqweqweqwe");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("qweqweqwe");
        driver.findElement(By.xpath("//input[@name='proceed']")).click();


        //NOW use CSS selector
        driver.get("https://www.rediff.com/");
        driver.findElement(By.cssSelector("a[title*='Sign in']")).click();

        driver.findElement(By.cssSelector("input[id='login1']")).sendKeys("rttttt");
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("qweqwewerqwe");
        driver.findElement(By.cssSelector("input[name='proceed']")).click();
        //driver.quit();

    }
}
