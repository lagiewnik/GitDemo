package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

public class N10_checkboxes {
    enum Browser {
        Chrome, FF, IE
    };
    static final String url = "https://spicejet.com";
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

        WebElement chkbxSeniorCitizen = driver.findElement(By.xpath("//input[contains(@id, 'SeniorCitizenDiscount')]"));
        System.out.println(chkbxSeniorCitizen.isSelected());
        //Assert.assertFalse(true);
        Assert.assertFalse(chkbxSeniorCitizen.isSelected());

        chkbxSeniorCitizen.click();
        System.out.println(chkbxSeniorCitizen.isSelected());
        Assert.assertTrue(chkbxSeniorCitizen.isSelected());

        /*
        Count the number of alla checkboxes on the page
         */

        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        Thread.sleep(3000);

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(500);
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
        driver.quit();


    }
}
