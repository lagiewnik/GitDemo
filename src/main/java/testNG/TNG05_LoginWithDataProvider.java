package testNG;

import org.testng.annotations.*;

public class TNG05_LoginWithDataProvider {

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

    //użycie dataprovidera wywoła tyle razy test z różnymi danymi ile ich jest w data providerze
    @Test(groups = {"Smoke"}, dataProvider = "GetData")
    public void MobileLoginCar(String usrname, String pswd) {
        System.out.println("Mobile Login Car - user: " + usrname + " Password: " + pswd);
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

    @DataProvider
    public Object[][] GetData(){
        //1st variant: usr pswd - user with good history
        //2nd variant: usr pswd - user without credit history
        //3nd varianr: fraud credit history

        Object[][] data = new Object[3][2];
        data[0][0] = "Jan";
        data[0][1]="passwd1";
        data[1][0] = "Tyberiusz";
        data[1][1]="passwd2";
        data[2][0] = "Cwaniaczek Darek";
        data[2][1]="passwd3";
        return data;
    }
}
