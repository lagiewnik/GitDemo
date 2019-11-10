package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class N12_CalendarUICurrentDate {
    enum Browser {
        Chrome, FF, IE
    };
    static final String url = "https://www.spicejet.com/";
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
        Select count of passanger: 5 adults and 1 inf
        */
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(500);
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        Thread.sleep(500);
        driver.findElement(By.id("hrefIncInf")).click();
        Thread.sleep(500);
        driver.findElement(By.id("btnclosepaxoption")).click();
        Thread.sleep(500);
        System.out.println("You've selected: " + driver.findElement(By.id("divpaxinfo")).getText());

         /*
        Selected airport FROM: Leh (IXL)  ===  //a[@value='IXL']
        and TO: Mumbai (BOM)              ===
         */
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@value='IXL']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='BOM']")).click();
        Thread.sleep(500);
        // Select current day from calendar <a class="ui-state-default ui-state-highlight ui-state-active" href="#">5</a>

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
        Thread.sleep(3000);



        driver.quit();


    }
}
