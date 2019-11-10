package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class N37_TableSortingVerify {
    enum Browser {
        Chrome, FF, IE
    }

    ;

    public static void main(String[] args) throws InterruptedException, IOException {
        final String url = "https://rahulshettyacademy.com/seleniumPractise/#/offers";

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


        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get(url);
        //click on header columnn to sort
        driver.findElement(By.xpath("//table[@id='sortableTable']//th[2]")).click();
        //driver.findElement(By.xpath("//table[@id='sortableTable']//th[2]")).click();

        List<WebElement> firstColList = driver.findElements(By.xpath("//table[@id='sortableTable']//tr/td[2]"));
        //copy original column to arrayList
        ArrayList<String> originalList = new ArrayList<String>();
        for (int i = 0; i < firstColList.size(); i++) {
            originalList.add(firstColList.get(i).getText());
        }
        ;

        ArrayList<String> coppiedList = new ArrayList<String>();
        for (int i = 0; i < originalList.size(); i++) {
            coppiedList.add(originalList.get(i));
        }
        System.out.println("############## copied sorted list ###############");
        Collections.sort(coppiedList);
        Collections.reverse(coppiedList);
        for (String s: coppiedList)
        {
            System.out.println(s);
        }
        System.out.println("################ original list #############");

        for (String s: originalList)
        {
            System.out.println(s);
        }
        //compare original list and copied sorted list

        Assert.assertTrue(originalList.equals(coppiedList));

        //driver.quit();
    }


}