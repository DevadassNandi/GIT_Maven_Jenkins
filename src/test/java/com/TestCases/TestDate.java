package com.TestCases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("hhmmsss");
		Date d = new Date();
		
		String emailid = "abc.xyz@gmail.com";
		
		System.out.println(sdf.format(d));
		
		String email = emailid.split("@")[0]+"_"+sdf.format(d)+"@"+emailid.split("@")[1];
		
		System.out.println(email);
		

	}

}
