package com.nhry.utils;

import java.util.Date;

/**
 * Created by gongjk on 2016/6/28.
 */
public class SerialUtil {

    public static String creatSeria(){
        Date date = new Date();
       String serial = String.valueOf(date.getTime());
        return serial;
    }
}
