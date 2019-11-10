package basics;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;


public class N33_EXERCISE_AutoSuggestDropDownHiddenElementJavaExecutor {
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);



        WebElement from = driver.findElement(By.xpath("//input[@id='autocomplete']"));
        from.sendKeys("POL");
        Thread.sleep(500);

        //JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor)driver;

        String script = "return document.getElementById(\"autocomplete\").value;";
        String textFrom =(String) js.executeScript(script);
        System.out.println(textFrom);


        int i=0;
        final int LIMIT_STEP = 10;
        while (!textFrom.equalsIgnoreCase("POLAND")){
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