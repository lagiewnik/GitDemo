package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class N23_MultipleWindows {
    enum Browser {
        Chrome, FF, IE
    }

    ;

    public static void main(String[] args) throws InterruptedException {
        final String url = "https://accounts.google.com/signup";
        String[] vegetablesToBuy = {"Cucumber", "Brocolli", "Beetroot", "Pista"};
        WebDriver driver = null;
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



        driver.manage().window().maximize();
        driver.get(url);

        driver.findElement(By.xpath("//a[contains(.,'Pomoc')]")).click();
        driver.findElement(By.xpath("//a[contains(.,'Warunki')]")).click();

        System.out.println(driver.getTitle());

        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ((Set) ids).iterator();
        String parentid  = it.next();
        String childid = it.next();
        String childid2 = it.next();

        driver.switchTo().window(childid);
        System.out.println(driver.getTitle());

        driver.switchTo().window(childid2);
        System.out.println(driver.getTitle());



        //driver.quit();
    }


}
