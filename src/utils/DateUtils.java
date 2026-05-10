package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.IllegalFormatConversionException;


public class DateUtils {

    public static void DateUtils(){

    }



    public Date createDate(String str) throws ParseException {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e) {
            throw new ParseException("Date cannot be parsed" + str, 0);

        }
    }
}
