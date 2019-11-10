package Jbasic;

import java.util.ArrayList;

public class B15_ArrayList {

    public static void main(String[] args) {
        //all classes implement List (ArrayList, Linked List, Vector) class accepted duplicate values
        //array have fixed size where as arraylist can grow dynamicaly
        // you can access and insert any value in any index

        ArrayList<String> a = new ArrayList<String>();

        a.add("MArcin");
        a.add("Komputer");

        System.out.println(a);

        a.add(0,"holdem");
        a.add(3,"holdem");
        System.out.println(a);

        System.out.println("Remove from index 1");
        a.remove(1);
        System.out.println(a);
        System.out.println("REmove element by value- would be remove first");
        a.remove("holdem");
        System.out.println(a);

        a.add("Jack");
        a.add("Quenn");
        a.add("Jack");
        System.out.println(a);

        //Check if List contains valur
        System.out.println(a.contains("Ace"));

        //check index of the element
        System.out.println(a.indexOf("Jack"));
        System.out.println(a.indexOf("Ace"));

        System.out.println("Size a:" + a.size());
        System.out.println("a is Empty: "+a.isEmpty());

    }
}
