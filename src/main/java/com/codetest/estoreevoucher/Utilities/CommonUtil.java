package com.codetest.estoreevoucher.Utilities;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CommonUtil {
	
	public static Set<String> generatePromocodes(List<String> existingPromoCodes, int quantity){
		Set<String> promoCodes = new HashSet<>();
		for(int i = 0; i < quantity; i++) {
			String tmpCode = randomStringGenerator();
			while(promoCodes.contains(tmpCode) || existingPromoCodes.contains(tmpCode)) {
				tmpCode = randomStringGenerator();
			}
			promoCodes.add(tmpCode);
		}
		return promoCodes;
	}
	
	private static String randomStringGenerator() {
		int leftLimit = 65;
	    int rightLimit = 122;
	    int targetStringLength = 5;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    
	    int randomNumber = random.nextInt(999999);
	    generatedString = String.format("%06d%s", randomNumber, generatedString);
	    return generatedString;
	}
	public static void main (String[] args) {
		CommonUtil.randomStringGenerator();
	}
}
