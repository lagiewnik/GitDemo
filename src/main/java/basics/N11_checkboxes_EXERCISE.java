package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

public class N11_checkboxes_EXERCISE {
    enum Browser {
        Chrome, FF, IE
    };
    static final String url = "http://qaclickacademy.com/practice.php";
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

        WebElement chkbxOption1 = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
        System.out.println(chkbxOption1.isSelected());
        //Assert.assertFalse(true);
        Assert.assertFalse(chkbxOption1.isSelected());

        chkbxOption1.click();
        System.out.println(chkbxOption1.isSelected());
        Assert.assertTrue(chkbxOption1.isSelected());

        /*
        Count the number of alla checkboxes on the page
         */

        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        Thread.sleep(3000);


        driver.quit();


    }
}
