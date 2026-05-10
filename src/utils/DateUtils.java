package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtils {

    public static void DateUtils(){

    }



    public Date createDate(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e) {
            return new Date();
        }
    }
}
