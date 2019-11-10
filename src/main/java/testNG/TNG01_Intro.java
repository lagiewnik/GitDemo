package testNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TNG01_Intro extends TNG07_Properties{
    //open browser
    //Login();
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
    }
    @AfterTest
    public void lastExecution(){
        System.out.println("+++++++++++++++++++++++I'm execute on the end of test+++++++++++++++++++++++++++++++++");
    }
}
