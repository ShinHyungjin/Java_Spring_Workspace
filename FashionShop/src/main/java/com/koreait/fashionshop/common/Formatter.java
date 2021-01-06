package com.koreait.fashionshop.common;

import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

public class Formatter {
	public static String getCurrency(long number) {
		DecimalFormat df = new DecimalFormat("###,###");
		String currency = Currency.getInstance(Locale.KOREA).getSymbol();
	
		String result = currency + df.format(number);
		
		return result;
	}
//	public static void main(String[] args) {
//		System.out.println(getCurrency(2000000000));
//	}
}
