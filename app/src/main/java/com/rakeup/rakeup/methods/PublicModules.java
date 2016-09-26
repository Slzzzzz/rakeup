package com.rakeup.rakeup.methods;

import android.text.format.DateFormat;

import com.rakeup.rakeup.R;

/**
 * Created by emre on 20.09.16.
 */
public class PublicModules {

    public static String calculatePassingTime(long timeStamp, String second, String minute, String hour, String day){
        DateFormat df = new DateFormat();
        long uTime = System.currentTimeMillis() / 1000L;
        long passingTime = uTime - timeStamp;
        if((passingTime / 60) < 1)
            return " " + passingTime + second;
        else if((passingTime / 3600) < 1)
            return " " + (passingTime / 60) + minute;
        else if((passingTime / 43200) < 1)
            return " " + (passingTime / 3600) +  hour;
        else if((passingTime / 129600) < 3)
            return " " + (passingTime / 43200) + day;
        else {
            java.util.Date time = new java.util.Date(timeStamp * 1000);
            return df.format(" dd/MM/yyyy", time).toString();
            //return time.toString();
        }
    }

}
