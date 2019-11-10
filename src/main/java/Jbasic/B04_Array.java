package Jbasic;

public class B04_Array {
    public static void main(String[] args) {
        //Sum of number in array

        int c[] = {2,15,3,1,49};
        int sum=0;
        for (int i = 0; i < c.length ; i++)
        {
           sum +=c[i];

        }
        System.out.println("Sum = " + sum);

    }
}
