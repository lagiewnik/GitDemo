package Jbasic;

public class B12_This {

    String a ="Outside method inside class";

    public void getData(){
        String a = "Inside method";
        System.out.println("Printed with this - class level: " + this.a);
        System.out.println("Printed without this - method level: " + a);
    }

    public static void main(String[] args) {

        B12_This xxx = new B12_This();
        xxx.getData();
    }
}
