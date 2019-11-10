package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class N07_DropDownWithSelect {
    enum Browser {
        Chrome, FF, IE
    };
    static final String url = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
    public static void main(String[] args){

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

        driver.get(url);
        WebElement showChoice = driver.findElement(By.xpath("//p[@class='selected-value']"));
        Select s = new Select(driver.findElement(By.id("select-demo")));
        //select by value
        s.selectByValue("Friday");
        System.out.println( showChoice.getText());

        //select by Index
        s.selectByIndex(1);
        System.out.println( showChoice.getText());

        //select by visible text
        s.selectByVisibleText("Saturday");
        System.out.println( showChoice.getText());

        driver.quit();

    }
}
