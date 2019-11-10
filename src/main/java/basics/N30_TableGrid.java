package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class N30_TableGrid {
    enum Browser {
        Chrome, FF, IE
    }

    ;

    public static void main(String[] args) throws InterruptedException {
        final String url = "https://www.cricbuzz.com/live-cricket-scorecard/23719/qat-vs-jer-2nd-t20i-jersey-tour-of-qatar-2019";

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

        int sum = 0;
        WebElement table = driver.findElement(By.xpath("(//div[contains(@class,'cb-col cb-col-100 cb-ltst-wgt-hdr')])[1]"));
        int rowCounts = table.findElements(By.xpath("div[contains(@class,'cb-col cb-col-100 cb-scrd-itms')]")).size();

        int fieldCount = table.findElements(By.xpath("div[contains(@class,'cb-col cb-col-100 cb-scrd-itms')]/div[3]")).size();

        System.out.println(rowCounts + "" + fieldCount);
        for (int i = 0; i < fieldCount - 2; i++) {
            String value = table.findElements(By.xpath("div[contains(@class,'cb-col cb-col-100 cb-scrd-itms')]/div[3]")).get(i).getText();            ;
            int valueInt = Integer.parseInt(value);
            sum = sum + valueInt;
        }

        System.out.println(sum);
        String extras = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();

        int extrasInt = Integer.parseInt(extras);

        int totalSumValue = sum + extrasInt;

        String ActualSum = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
        int actualSumInt = Integer.parseInt(ActualSum);

        if (actualSumInt == totalSumValue){
            System.out.println("Very good - count matches: " + totalSumValue);
        }
        else {
            System.out.println("Count fail");
        }
        //set 3 july


        //driver.quit();
    }


}