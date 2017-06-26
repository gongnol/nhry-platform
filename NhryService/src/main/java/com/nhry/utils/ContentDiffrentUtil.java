package com.nhry.utils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by gongjk on 2016/10/24.
 */
public class ContentDiffrentUtil {
    public static  boolean isDiffrent(Object obj1 ,Object obj2){
        if(obj1 == null && obj2!=null  || (obj2 == null && obj1!=null) ){
            return true;
        }
        if(obj1 == null && obj2==null){
            return false;
        }
        if(obj1 instanceof Integer){
            return !((Integer) obj1).equals(((Integer)obj2));
        }
        if(obj1 instanceof String){
                return !((String) obj1).trim().equals(((String)obj2).trim());
        }
        if(obj1 instanceof Date){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return !format.format(obj1).equals(format.format(obj2));
        }
        return false;
    }

    public static  boolean isDiffrentForRuleTxt(Object obj1 ,Object obj2){
        if(obj1 == null && obj2!=null  || (obj2 == null && obj1!=null) ){
            return true;
        }
        if(obj1 == null && obj2==null){
            return false;
        }
        if(obj1 instanceof Integer){
            return !((Integer) obj1).equals(((Integer)obj2));
        }
        if(obj1 instanceof String){
          String o1 = Arrays.asList(((String) obj1).split(",")).toString();
          String o2 =  Arrays.asList(((String) obj2).split(",")).toString();
            return !((String) o1).trim().equals(((String)o1).trim());
        }
        if(obj1 instanceof Date){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return !format.format(obj1).equals(format.format(obj2));
        }
        return false;
    }


    public static  boolean difIgnoreNull(Object obj1 ,Object obj2){
        if(obj1 == null && obj2!=null  || (obj2 == null && obj1!=null) ){
            return false;
        }
        if(obj1 == null && obj2==null){
            return false;
        }
        if(obj1 instanceof Integer){
            return !((Integer) obj1).equals(((Integer)obj2));
        }
        if(obj1 instanceof String){
            return !((String) obj1).trim().equals(((String)obj2).trim());
        }
        if(obj1 instanceof Date){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return !format.format(obj1).equals(format.format(obj2));
        }
        return false;
    }


    public static void main(String[] args){
        System.out.println(isDiffrent(new Date(),new Date()));
    }
}
