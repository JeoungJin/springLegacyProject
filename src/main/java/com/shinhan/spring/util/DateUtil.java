package com.shinhan.spring.util;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {
    //date->String
	//String->date 
	public static String converToString(Date d1) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		String str = sdf.format(d1); // 
		return str;
	}
	
	public static Date convertToDate(String str2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		Date d2 = null;
		try {
			d2 = sdf.parse(str2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d2;
	}
    public static java.sql.Date convertToSQLDate(Date d){
    	
    	return new java.sql.Date(d.getTime());
    }
    
    
    public static java.sql.Date convertToSQLDate(String str){
    	
    	return convertToSQLDate(convertToDate(str));
    }


	
}








