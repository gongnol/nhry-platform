package com.nhry.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PromNoUtil {
    
    public static String getPromNo(){
        PromNumber serial = new FileEveryDayPromNumber(5, "EveryDayPromNumber.dat");
        return serial.getPromNumber();
    }
}


abstract class PromNumber {

    public synchronized String getPromNumber() {
        return process();
    }
    protected abstract String process();
}


abstract class EveryDayPromNumber extends PromNumber {
    
    protected final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    protected DecimalFormat df = null;
    
    public EveryDayPromNumber(int width) {
        if(width < 1) {
            throw new IllegalArgumentException("Parameter length must be great than 1!");
        }
        char[] chs = new char[width];
        for(int i = 0; i < width; i++) {
            chs[i] = '0';
        }
        df = new DecimalFormat(new String(chs));
    }
    
    protected String process() {
        Date date = new Date();
        int n = getOrUpdateNumber(date, 1);
        return format(date) + format(n);
    }
    
    protected String format(Date date) {
        return sdf.format(date);
    }
    protected String format(int num) {
        return df.format(num);
    }
    
    /**
     * 获得序列号，同时更新持久化存储中的序列
     * @param current 当前的日期
     * @param start   初始化的序号
     * @return 所获得新的序列号
     */
    protected abstract int getOrUpdateNumber(Date current, int start);
}


class FileEveryDayPromNumber extends EveryDayPromNumber {

    /**
     * 持久化存储的文件
     */    
    private File file = null;
    
    /**
     * 存储的分隔符
     */
    private final static String FIELD_SEPARATOR = ",";    

    public FileEveryDayPromNumber(int width, String filename) {
        super(width);
        file = new File(filename);
    }

    @Override
    protected int getOrUpdateNumber(Date current, int start) {
        String date = format(current);
        int num = start;
        if(file.exists()) {
            List<String> list = FileUtil.readList(file);        
            String[] data = list.get(0).split(FIELD_SEPARATOR);
            if(date.equals(data[0])) {
                num = Integer.parseInt(data[1]);
            }
        }
        FileUtil.rewrite(file, date + FIELD_SEPARATOR + (num + 1));
        return num;
    }        
}


