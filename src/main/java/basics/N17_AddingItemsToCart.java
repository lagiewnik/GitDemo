package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class N17_AddingItemsToCart {
    enum Browser {
        Chrome, FF, IE
    }

    ;
    static final String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
    static String airlineName = "LOT";
    static String[] vegetablesToBuy = {"Cucumber", "Brocolli", "Beetroot", "Pista"};

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
        Thread.sleep(3000);

        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        //convert array buy needed to list
        List vegeToBuyList = Arrays.asList(vegetablesToBuy);

        for (int i = 0; i < products.size(); i++) {
            String name[] = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

            System.out.println("Check name: " + formattedName + " number#" + i);

            if (vegeToBuyList.contains(formattedName)) {
                //click item to cart
                j++;
                //locator based on text is not good because text is changing by clicking and change indexes of findings elements
                //driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                //instead of use this locator:
                driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
                System.out.println("Click on: " + formattedName + " number#" + i);
                if (j == vegetablesToBuy.length) {
                    break;
                }
            }

        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();

        Thread.sleep(5000);
        driver.quit();


    }
}
