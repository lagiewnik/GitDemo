package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class N21_FluentWait {
    enum Browser {
        Chrome, FF, IE
    }

    ;

    public static void main(String[] args) throws InterruptedException {
        final String url = "http://the-internet.herokuapp.com/dynamic_loading/1";
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

        driver.findElement(By.xpath("//div[@id='start']/button")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class).withTimeout(Duration.ofSeconds(30));

        final WebDriver finalDriver = driver;
        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                if (finalDriver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
                    return finalDriver.findElement(By.cssSelector("[id='finish'] h4"));
                } else {
                    return null;
                }

            }
        });
        System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
        Thread.sleep(3000);

        driver.quit();
    }


}
