package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class N20_EXERCISE_ExplicitWait {
    enum Browser {
        Chrome, FF, IE
    }

    ;

    public static void main(String[] args) throws InterruptedException {
        final String url = "http://www.itgeared.com/demo/1506-ajax-loading.html";

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
        WebDriverWait w = new WebDriverWait(driver, 10);

        driver.get(url);


        driver.findElement(By.xpath("//a[text()='Click to load get data via Ajax!']")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='results']")));

        System.out.println(driver.findElement(By.xpath("//div[@id='results']")).getText());

        driver.quit();
    }



}
