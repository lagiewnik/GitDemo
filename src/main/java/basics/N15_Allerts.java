package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

public class N15_Allerts {
    enum Browser {
        Chrome, FF, IE
    };
    static final String url = "https://rahulshettyacademy.com/AutomationPractice/";
    static String text  = "Ziomeczek";

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

        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.id("alertbtn")).click();

        //grab text presented on alert window
        System.out.println("Text of alert: " + driver.switchTo().alert().getText());
        //accept alert:
        driver.switchTo().alert().accept();

        //Alert window with confirm/cancel
        driver.findElement(By.id("confirmbtn")).click();
        //Confirm use
        Thread.sleep(500);
        driver.switchTo().alert().accept();
        //cancel use
        Thread.sleep(500);
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(500);
        driver.switchTo().alert().dismiss();


        Thread.sleep(3000);
        driver.quit();


    }
}
