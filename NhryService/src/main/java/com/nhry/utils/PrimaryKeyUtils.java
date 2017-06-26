package com.nhry.utils;

public class PrimaryKeyUtils {
  
  /**
   * 生成32位唯一的uuid
   * @return
   */
  public static String generateUuidKey(){
	  return java.util.UUID.randomUUID().toString().replace("-", "");
  }
    /**
     * 生成32位唯一的uuid
     * @return
     */
    public static String generateUpperUuidKey(){
        return java.util.UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

  public static void main(String [] args){
      for(int i=0;i<30;i++) {
          System.out.println(generateUuidKey());
      }
  }
}
