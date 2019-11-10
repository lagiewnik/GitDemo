package testNG;

import net.bytebuddy.build.ToStringPlugin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TNG02_Intro {
    @Test(groups = {"Smoke"})
    public void Demo() {
        System.out.println("demo2");
    }

    @Test
    public void SecondTest() {
        System.out.println("Good By");
    }

    @BeforeTest
    public  void Prerequiste()
    {
        System.out.println("+++++++++++++++++++ I'm execute before test++++++++++++++++++++++++++++");
    }
}
