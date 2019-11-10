package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class N09_Autosuggest_Lesson52 {
    enum Browser {
        Chrome, FF, IE
    };
    static final String url = "https://www.makemytrip.com";
    public static void main(String[] args) throws InterruptedException {

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
        driver.manage().window().maximize();
        driver.get(url);




         /*
        Selected airport FROM: warsaw
        and TO: mexico        ===
         */
        driver.findElement(By.xpath("//input[@id='fromCity']")).click();
        Thread.sleep(500);
        WebElement sourcePlaceHolder = driver.findElement(By.xpath("//input[@placeholder='From']"));
        sourcePlaceHolder.clear();
        Thread.sleep(100);
        sourcePlaceHolder.sendKeys("warsaw" + Keys.ARROW_DOWN + Keys.ENTER);
        Thread.sleep(1000);
        WebElement destinationPlaceHolder = driver.findElement(By.xpath("//input[@placeholder='To']"));
        destinationPlaceHolder.click();
        Thread.sleep(500);

        destinationPlaceHolder.clear();
        Thread.sleep(100);
        destinationPlaceHolder.sendKeys("mexico" + Keys.ARROW_DOWN + Keys.ENTER);
        Thread.sleep(3000);
        //System.out.println("Selected FROM: " + driver.findElement(By.id("fromCity")).getText() + " TO: " + driver.findElement(By.id("toCity")).getText());
        driver.quit();


    }
}
