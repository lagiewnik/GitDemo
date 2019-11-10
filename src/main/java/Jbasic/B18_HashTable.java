package Jbasic;

import java.util.*;

public class B18_HashTable {

    public static void main(String[] args) {

        Hashtable<Integer, String> hm = new Hashtable<Integer, String>();
        hm.put(0, "2");
        hm.put(1, "3");
        hm.put(2, "4");
        hm.put(3, "5");
        hm.put(4, "6");
        hm.put(5, "7");
        hm.put(6, "8");
        hm.put(7, "9");
        hm.put(8, "T");
        hm.put(9, "J");
        hm.put(10, "Q");
        hm.put(11, "K");
        hm.put(12, "A");
        hm.put(13, "JOKER");

        System.out.println(hm.get(6));
        System.out.println(hm.get(62));


        //Convert to set
        Set sn = hm.entrySet();
        Iterator it = sn.iterator();
        while (it.hasNext()){

            Map.Entry mp = (Map.Entry) it.next();
            System.out.println(mp);
            System.out.println(mp.getKey() + " " + mp.getValue());
        }

    }
}
