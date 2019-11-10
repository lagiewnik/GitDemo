package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class N28_EXERCISE_Assigment {
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

        /*
        1. Select any checkbox.
        2. Grab label of the selected checkbox
        3. select an option in dropdown. option to select should come from step2.
        4. enter the step2 grabbed label text in Editbox.
        5. Click alert and verify if text grabbed from step 2 is present in pop up message
         */

        //1.
        List<WebElement> chckbxList = driver.findElements(By.xpath("//fieldset//input[@type='checkbox']"));
        int checkboxCount = chckbxList.size();
        //System.out.println("Count of checkbox: "+checkboxCount);
        Random r = new Random();
        int rndmId = r.nextInt(checkboxCount)+1;
        //System.out.println("I take: " + rndmId + " element");
        String xpathChckbox = "(//fieldset//input[@type='checkbox'])["+rndmId+"]";

        System.out.println(xpathChckbox);
        WebElement chckbxToSelect = driver.findElement(By.xpath(xpathChckbox));
        chckbxToSelect.click();

        //2
        String xpathLabel = "//*[@id='checkbox-example']//label[" +rndmId +"]";
        String labelText = driver.findElement(By.xpath(xpathLabel)).getText();

        //3
        Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
        s.selectByVisibleText(labelText);

        //4
        driver.findElement(By.id("name")).sendKeys(labelText);
        //5
        driver.findElement(By.id("alertbtn")).click();

        String alertText = driver.switchTo().alert().getText();
        if (alertText.contains(labelText)){
            System.out.println("Alert is correct! " + alertText);
        }
        else {
            System.out.println("error: " + alertText);
        }

        driver.quit();
    }


}