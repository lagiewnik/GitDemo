package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Iterator;
import java.util.Set;

public class N27_LinkCountOnPage {
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
        driver.get(url);

        //Give me the count of links on the whole page
        //a tag
        System.out.println(driver.findElements(By.tagName("a")).size());
        ;

        //Give me the count of links on the footer
        //a tag
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        //3) count of links in 1 column of footer
        WebElement footerColumn = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int countLinksColumn = footerColumn.findElements(By.tagName("a")).size();
        System.out.println(countLinksColumn);

        //4) Click on each link in the column and check if the page are opening
        for (int i = 1; i < countLinksColumn; i++) {
            String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            footerColumn.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
            Thread.sleep(1000);
        }//open all the tabs

        Set<String> abc = driver.getWindowHandles(); // 4 nowe okna/zakładki
        Iterator<String> it = ((Set) abc).iterator();

        while (it.hasNext()) {

            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());

        }

    }

    //driver.quit();
}