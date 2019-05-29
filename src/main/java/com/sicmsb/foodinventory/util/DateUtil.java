package com.sicmsb.foodinventory.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {

	private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

	private static String DATE_FORMAT = "dd/MM/yyyy";
	private static String ISO = "yyyy-MM-dd'T'HH:mm:ssZ";
	private static String RESPONSE_DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss 'GMT'";

	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat(DATE_FORMAT).parse(date);
		} catch (Exception e) {
			logger.error("Error parseDate", e);
			return null;
		}
	}

	public static String DateToString(Date date) {
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		return df.format(date);
	}

	public static String formatResponseDate(Date date) {
		DateFormat df = new SimpleDateFormat(RESPONSE_DATE_FORMAT);
		return df.format(date);
	}

	public static String formatDate(Date date) {
		try {
			return new SimpleDateFormat(DATE_FORMAT).format(date);
		} catch (Exception e) {
			logger.error("Error formatDate", e);
			return null;
		}
	}
	
	public static Date formatTodayDateYMD() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);	
		String date = simpleDateFormat.format(new Date());
		Date returnDate = new Date();
		try {
			returnDate = new SimpleDateFormat(pattern).parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnDate;
	}
}
