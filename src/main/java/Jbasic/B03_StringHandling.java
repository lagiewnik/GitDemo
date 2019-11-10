package Jbasic;

public class B03_StringHandling {
    public static void main(String[] args) {
        //Payment $100 paid

        String str="Payment $100 paid";

        //print value of char on 8 index in string
        System.out.println(str.charAt(8));

        //
        String str1 = "Payments $100 paid";
        //Find index of  "$"
        System.out.println( str1.indexOf("$"));

        //extract value of cash (beetween $ and las space)
        System.out.println(str.substring(str.indexOf("$"),str.lastIndexOf(" ")));

        //reverse string
        String name = "Marcin";
        for (int i = name.length()-1; i >= 0 ; i--) {
            System.out.println(name.charAt(i));
            
        };

        //is string the palidrom?
        String t ="";

        for (int i = name.length()-1; i >= 0 ; i--) {
           t= t+ name.charAt(i);
        }
        if (t == name){
            System.out.println("Is palidrom");
        }
        else
        {
            System.out.println("not palidrom");
        }

    }
}
