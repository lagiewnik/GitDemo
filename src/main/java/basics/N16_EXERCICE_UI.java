package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class N16_EXERCICE_UI {
    enum Browser {
        Chrome, FF, IE
    }

    ;
    static final String url = "https://www.cleartrip.com/";
    static String airlineName = "LOT";

    public static void main(String[] args) throws InterruptedException {
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

        //Set current date
        driver.findElement(By.id("DepartDate")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

        //Set passangers
        Select adults = new Select(driver.findElement(By.id("Adults")));
        adults.selectByValue("2");
        Select children = new Select(driver.findElement(By.id("Childrens")));
        children.selectByVisibleText("3");

        //click for more options:
        driver.findElement(By.id("MoreOptionsLink")).click();
        Thread.sleep(500);

        //Set addditional option:
        Select travelClass = new Select(driver.findElement(By.id("Class")));
        travelClass.selectByIndex(3);
        driver.findElement(By.id("AirlineAutocomplete")).sendKeys(airlineName);
        Thread.sleep(5000);
        driver.findElement(By.id("AirlineAutocomplete")).sendKeys("" + Keys.ARROW_DOWN + Keys.ARROW_DOWN + Keys.ARROW_DOWN + Keys.ENTER);

        driver.findElement(By.id("SearchBtn")).click();

        Thread.sleep(500);
        if (driver.findElement(By.id("homeErrorMessage")).getAttribute("style").equals("none")) {
            System.out.println("ITS OK");
        } else {
            System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
        }
        Thread.sleep(5000);
        driver.quit();


    }
}
