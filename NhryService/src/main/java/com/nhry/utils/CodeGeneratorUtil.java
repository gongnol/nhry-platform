package com.nhry.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by cbz on 7/16/2016.
 */
public  class CodeGeneratorUtil {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmssSSS");
    public static String getCode(){
        int num = new Random().nextInt(89999)+10000;
        return format.format(new Date())+num;
    }

    public static void main(String[] args){
        System.out.println(getCode());
    }

}
