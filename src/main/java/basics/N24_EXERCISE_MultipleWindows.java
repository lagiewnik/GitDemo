package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Iterator;
import java.util.Set;

public class N24_EXERCISE_MultipleWindows {
    enum Browser {
        Chrome, FF, IE
    }

    ;

    public static void main(String[] args) throws InterruptedException {
        final String url = "http://the-internet.herokuapp.com/windows";
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

        driver.findElement(By.xpath("//a[contains(.,'Click Here')]")).click();




        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ((Set) ids).iterator();
        String parentid  = it.next();
        String childid = it.next();


        driver.switchTo().window(childid);
        System.out.println(driver.findElement(By.xpath("//h3")).getText());

        driver.switchTo().window(parentid);
        System.out.println(driver.findElement(By.xpath("//h3")).getText());



        driver.quit();
    }


}
