package Jbasic;

import java.util.HashSet;
import java.util.Iterator;

public class B16_HashSet {
    public static void main(String[] args) {
       /*
       HashSet. treeset, LinkedHashSet implements Set interface
       dont accept duplikate value
       There is no guarantee that elements are  stored in sequencial order. Random order
        */

        HashSet<String> hs = new HashSet<String>();

        hs.add("Ace");
        hs.add("King");
        hs.add("Queen");
        hs.add("Jack");
        hs.add("Ten");
        hs.add("Ten");
        System.out.println(hs);

        hs.remove("Queen");
        System.out.println(hs);

        System.out.println(hs.size());

        hs.add("Queen");
        hs.add("Nine");
        hs.add("Eight");

        Iterator<String> i = hs.iterator();

        while(i.hasNext()){
            System.out.println(i.next());
        }


    }
}
