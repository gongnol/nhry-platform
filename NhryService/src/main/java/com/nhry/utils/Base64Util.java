package com.nhry.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class Base64Util {
    
	/**
     * 使用Base64加密算法加密字符串
     *return
     */
    public static String encodeStr(String plainText){
        byte[] b=plainText.getBytes();
        Base64 base64=new Base64();
        b=base64.encode(b);
        String s=new String(b);
        return s;
    }
    
    /**
     * 使用Base64解密
     *return
     */
    public static String decodeStr(String encodeStr){
        byte[] b=encodeStr.getBytes();
        Base64 base64=new Base64();
        b=base64.decode(b);
        String s=new String(b);
        return s;
    } 
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//    System.out.println(encodeStr("sylh.015.016.5组团"));
     System.out.println(decodeStr("c3lsaC4wMTUuMDE2LjXnu4Tlm6I="));
	}

}
