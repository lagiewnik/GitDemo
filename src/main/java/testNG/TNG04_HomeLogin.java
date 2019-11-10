package testNG;

import org.testng.annotations.Test;

public class TNG04_HomeLogin {
    @Test
    public void WebHomeLogin() {
        System.out.println("HomeLogin Web");
    }

    @Test(groups = {"Smoke"})
    public void MobileHomeLogin() {
        System.out.println("Mobile HomeLogin");
    }

    @Test
    public void APIHomeLogin(){
        System.out.println("API HomeLogin");
    }
}
