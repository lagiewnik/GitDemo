package Jbasic.B06_Interface;

public class Developing implements Bankingclient,DomainClient {
    //now this clas is responsible to implement all the method of banking client
    public static void main(String[] args) {
        Developing d=new Developing();
        d.checkingbalance();
        d.paycreditcard();
        d.transferbalance();
        d.login();

        Bankingclient client = new Developing(); // run the poliform
        ((Developing) client).login();
        client.checkingbalance();

        DomainClient ds = new Developing();
        ds.investment();

    }

    @Override
    public void paycreditcard() {
        System.out.println("PAYCREDITCARD IMPLEMENTS");
    }

    @Override
    public void transferbalance() {
        System.out.println("TRANSFERBALANCE IMPLEMENTS");
    }

    @Override
    public void checkingbalance() {
        System.out.println("CHECKINGBALANCE IMPLEMENTS");
    }

    public void login(){
        System.out.println("LOGIN");
    }

    @Override
    public void investment() {
        System.out.println("INVESTING");
    }
}
