package Jbasic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class B08_Date {
    public static void main(String[] args) {
        Date d = new Date();

        System.out.println(d.toString());

        //formating date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'");
        SimpleDateFormat sd = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        System.out.println(sdf.format(d));
        System.out.println(sd.format(d));
    }
}
