package Jbasic;

import java.util.ArrayList;

public class B19_CollectionDemo {

    public static void main(String[] args) {

        int a[] = {4,5,5,5,4,6,6,9,4,11,9,11,9,7,8,12,7,4,22};

        //print unique value ant count of reapeted them
        //Output should be: 4 - 3, 5- 3, 6-2 , 9-1

        ArrayList<Integer> al = new ArrayList<Integer>();

        for (int i = 0; i < a.length ; i++) {
            int k = 0;
            if (!al.contains(a[i])){
                al.add(a[i]);
                k++;

                for (int j = i+1; j < a.length ; j++) {
                    if(a[i] == a[j])
                    {
                        k++;
                    }
                }
                System.out.println(a[i] + " : " + k + "times");
            }

        }
    }
}
