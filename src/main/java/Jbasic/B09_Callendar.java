package Jbasic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class B09_Callendar {
    public static void main(String[] args) {


        Calendar cal = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println(sdf.format(cal.getTime()));

        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal.get(Calendar.AM_PM));
    }
}
