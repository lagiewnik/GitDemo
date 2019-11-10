package testNG;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//ITestListener interface which implements Testng Listener
public class TNG06_Listeners implements ITestListener {
    @Parameters({"URL","USRname"})
    @Test
    public void Demo(String urlname, String user)
    {
        System.out.println("hello " + user +" on: "+urlname);
    }
    @Test
    public void SecondTest()
    {
        System.out.println("Do widzenia");
        Assert.assertTrue(false);
    }
    @AfterTest
    public void lastExecution(){
        System.out.println("+++++++++++++++++++++++I'm execute on the end of test+++++++++++++++++++++++++++++++++");
    }

    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test wspaniale przeszedł - PASSED");
    }


    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("ERROR - "  + iTestResult.getName());
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
