package Jbasic;

public class B11_ChildDemo extends B11_ParentDemo {

    String name = "ZiomalChild";

    public B11_ChildDemo()
    {
        super();
        System.out.println("child class constructor");
    }
    public void getStringData(){
        System.out.println("Name from child class: "+name);
        System.out.println("Name from parent class(with super ): " + super.name);
    }

    public void getData(){
        super.getData();
        System.out.println("I'm child class method");
    }
    public static void main(String[] args) {
        B11_ChildDemo cdc = new B11_ChildDemo();
        //would be printed name from class Child
        cdc.getStringData();
        cdc.getData();
    }
}
