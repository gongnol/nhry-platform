package com.nhry.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.geronimo.mail.util.Base64Encoder;

/**
 * @author zhaoxijun
 * @date 2017年5月10日
 */
public class RandomCodeUtils {
	public static BufferedImage getImageBuffer(){
		String code = randomCode(4);
		return getImageBuffer(code);
	}
	
	public static String base64Image(BufferedImage image){
		ByteArrayOutputStream outputStream = null;  
	    try {  
	      outputStream = new ByteArrayOutputStream();  
	      ImageIO.write(image, "jpg", outputStream);  
	    } catch (Exception e) {  
	    	//ignore
	    }  
	    sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();  
	    return "data:image/jpg;base64,".concat(encoder.encodeBuffer(outputStream.toByteArray()).trim().replaceAll("\n", "").replaceAll("\r", ""));
	}
	
	public static final String USERRANDOMCODE = "RANDOMCODE";
	
	public static BufferedImage getImageBuffer(String code){
		Random r = new Random();
		BufferedImage bi = new BufferedImage(80, 24, BufferedImage.TYPE_INT_BGR);
		Graphics g = bi.getGraphics();
		g.setColor(new Color(255,255,255));
		g.fillRect(0, 0, 80, 24);
		
		for (int i = 0; i < code.length(); i++) {
			g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));
			g.setFont(new Font("Arial", Font.BOLD , 18));
			g.drawString(code.charAt(i)+"" , (i * 15) + 3, 18);
		}
		return bi;
	}
	
	private static final String[] CODES = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "Y", "Z", "K", "M", "N", "S", "T" };
	
	public static String randomCode(int count) {
		Random r = new Random();
		StringBuilder stringBuilder = new StringBuilder("");
		for (int i = 0; i <count; i++) {
			stringBuilder.append(CODES[r.nextInt(CODES.length)]);
		}
		return stringBuilder.toString();
	}
}
