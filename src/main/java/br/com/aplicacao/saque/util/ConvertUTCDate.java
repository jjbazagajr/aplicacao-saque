package br.com.aplicacao.saque.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ConvertUTCDate {

    public static Date toLocalTimeZone(String UTCDate) throws ParseException {
        DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date date = utcFormat.parse(UTCDate);
        DateFormat pstFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        pstFormat.setTimeZone(Calendar.getInstance().getTimeZone());

        return date;
    }
}
