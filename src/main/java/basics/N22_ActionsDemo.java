package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class N22_ActionsDemo {
    enum Browser {
        Chrome, FF, IE
    }

    ;

    public static void main(String[] args) throws InterruptedException {
        final String url = "https://www.amazon.com/";
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

        Actions a = new Actions(driver);
        WebElement moveHello = driver.findElement(By.id("nav-link-accountList"));
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));

        //move to specific element
        a.moveToElement(moveHello).build().perform();

        //wpisanie w searchbox DUŻYMI LITERAMI z SHIFT-em i zaznaczenie przez double click
        a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("football").doubleClick().build().perform();

        // right click on element
        a.moveToElement(moveHello).contextClick().build().perform();
        //driver.quit();
    }


}
