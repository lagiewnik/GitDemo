package Jbasic;

public class B10_Constructor {
    //Constructor
    public B10_Constructor(){
        System.out.println("I'm big constructor");
    }

    //parameterised constructor
    public B10_Constructor(int a, int b){
        System.out.println("I'm parametrized constructor with: " + a + " and "  +b);
    }
    public B10_Constructor(String text){
        System.out.println("I'm parametrized constructor with text " + text);
    }
    //another one constructor

    public void getData(){
        System.out.println("I'm method for data");
    };

    public static void main(String[] args) {
        B10_Constructor cd = new B10_Constructor();

        cd.getData();
        B10_Constructor xxx = new B10_Constructor(12, 87);

        B10_Constructor tt = new B10_Constructor("cooo");

    }


}
