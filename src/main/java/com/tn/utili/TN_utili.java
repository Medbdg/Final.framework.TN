package com.tn.utili;

import java.util.Date;

public class TN_utili {
	public static String generateEmailWithThisTimeStamp() {
		Date date = new Date();
		String timeStamp =  date.toString().replace(" ", "_").replace(":", "").substring(11, 17);
		return "med.bdg" + timeStamp + "@gmail.com";
	}
	public static final int implitWaitTime = 10;
	public static final int pageLoadTime = 10;
    public static final int scriptTime = 100;
}

