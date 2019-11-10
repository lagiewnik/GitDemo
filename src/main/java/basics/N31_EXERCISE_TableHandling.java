package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class N31_EXERCISE_TableHandling {
    enum Browser {
        Chrome, FF, IE
    }

    ;

    public static void main(String[] args) throws InterruptedException {
        final String url = "http://qaclickacademy.com/practice.php";

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


        WebElement table = driver.findElement(By.xpath("//table[@id='product']"));
        int columnCounts = table.findElements(By.xpath("//table[@id='product']//tr/th")).size();
        int rowCounts = table.findElements(By.xpath("//table[@id='product']//tr")).size();

        System.out.println("Count of rows: " + rowCounts + ". Count of columns: " + columnCounts);

        for (int i = 0; i <  columnCounts; i++) {
            System.out.println(table.findElements(By.xpath("//table[@id='product']//tr[3]/td")).get(i).getText());
        }


        //driver.quit();
    }


}