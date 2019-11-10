package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class N18_AddingItemsToCart_ImplicitWait {
    enum Browser {
        Chrome, FF, IE
    };

    public static void main(String[] args) throws InterruptedException {
        final String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        Thread.sleep(3000);
        addItems(driver, vegetablesToBuy);

        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

        System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
        Thread.sleep(3000);
        driver.quit();
    }
    public static void addItems(WebDriver driver, String[] vegetablesToBuy) throws InterruptedException {
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

    }

}
