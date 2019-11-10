package basics;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/*
TArget of test:
Enter the letters BENG
Verify if Airport option is displayes in the suggestive box

 */
public class N32_AutoSuggestDropDownHiddenElementJavaExecutor {
    enum Browser {
        Chrome, FF, IE
    }

    ;

    public static void main(String[] args) throws InterruptedException {
        final String url = "https://ksrtc.in/oprs-web/guest/home.do?h=1";

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

        driver.findElement(By.xpath("//span[@class='init-close']")).click();

        WebElement from = driver.findElement(By.xpath("//input[@name='fromPlaceName']"));
        from.sendKeys("BENG");
        Thread.sleep(500);
        //from.sendKeys(Keys.DOWN);
        //nie wypisuje nic jakbyśmy się spodziewali mimo że w polu from widoczna jest wartość BENGALURU DARSHINI - pole is hidden
        System.out.println(from.getText());

        //javascript DOM can extract hidden elements
        //because selenium cannot identify hidden elements - (ajax implementation
        //investigate the properties of object if it have any hidden text

        //JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor)driver;

        String script = "return document.getElementById(\"fromPlaceName\").value;";
        String textFrom =(String) js.executeScript(script);
        System.out.println(textFrom);

        //Airport name to find: BENGALURU INTERNATIONAL AIRPORT
        int i=0;
        final int LIMIT_STEP = 20;
        while (!textFrom.equalsIgnoreCase("BENGALURU INTERNATION -AIRPORT")){
            i++;
            from.sendKeys(Keys.DOWN);
            textFrom =(String) js.executeScript(script);
            System.out.println(textFrom);
            if (i>LIMIT_STEP){
                break;
            };
        }

        if (i> LIMIT_STEP){
            System.out.println("Element not found");
        }
        else{
            System.out.println("Element found");
        }

        driver.quit();
    }


}