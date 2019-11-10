package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class N29_CalendarHandlings {
    enum Browser {
        Chrome, FF, IE
    }

    ;

    public static void main(String[] args) throws InterruptedException {
        final String url = "https://www.path2usa.com/travel-companions";

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        driver.findElement(By.id("travel_date")).click();

        //set 3 july
        while (!driver.findElement(By.xpath("//div[@class='datepicker-days']//*[@class='datepicker-switch']")).getText().toLowerCase().contains("july")){
            driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next']")).click();
        }

        //set 23th day
        List<WebElement> dates = driver.findElements(By.className("day"));
        int countDays = dates.size();

        for (int i = 0; i < countDays ; i++) {
            String text = dates.get(i).getText();
            if (text.equalsIgnoreCase("23")){
                dates.get(i).click();
                break;
            }
        }
        //set 3 july


        //driver.quit();
    }


}