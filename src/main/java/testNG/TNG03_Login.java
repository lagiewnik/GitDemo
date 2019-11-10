package testNG;

import org.testng.annotations.*;

import java.net.URL;

public class TNG03_Login {

    //parametry są ustawiane w pliku xml jako <parameter name="URL" value="www.wp.pl"/>
    //annotacja @Parameters dotyczy tylko najbliższego @Test
    @Parameters({"URL", "USRname"})
    @Test
    public void WebLogin(String urlname, String usr) {
        System.out.println("Login: " + usr + " on web page:" + urlname);
    }

    @Test
    public void MobileLogin() {
        System.out.println("Mobile Login");
    }
    @Test(groups = {"Smoke"})
    public void MobileLoginCar() {
        System.out.println("Mobile Login Car");
    }

    //atrybut enabled - pozwala włączyć/wyłączyć dany test -
    @Test(enabled=false)
    public void MobileLoginHome() {
        System.out.println("Mobile Login Home");
    }

    //parametr dependOnMethods wskazuje, że test jest zależny od innego/innych i będzie wykonany po nich
    @Test(dependsOnMethods = {"WebLogin","MobileLogin"})
    public void APILogin(){
        System.out.println("API login");
    }

    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("BEFORE SUITE");
    }
    @AfterSuite
    public void AfterSuite(){
        System.out.println("AFTER SUITE");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("========== before method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method ==========================");
    }

    @BeforeClass
    public void BeforeClass(){
        System.out.println("************ IM BEFORE CLASS******************");
    }
    @AfterClass
    public void AfterClass(){
        System.out.println("************ IM AFTER CLASS********************");
    }
}
