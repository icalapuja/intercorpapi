package com.valcom.icalapuja.intercorpapi.util;

import java.util.Date;
import java.util.Random;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;

public class Util {
	
	private Util() {
		
	}
	
	public static int getAge(Date birthdate) {
		LocalDate localDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(birthdate.getTime()), ZoneId.systemDefault()).toLocalDate();
		return Period.between(localDate, LocalDate.now()).getYears();
	}
	
	public static Date getDeathDate() {
		LocalDate deathDate = LocalDate.now().plusWeeks(new Random().nextInt(1560));
		
		return java.util.Date.from(deathDate.atStartOfDay()
			      .atZone(ZoneId.systemDefault())
			      .toInstant());
	}
	
	public static Double getMedia(int[] numbers) {
		double media = 0D;

		if(numbers.length > 0) {
			double sum = 0L;
			
			for(int number : numbers) {
				sum += number;
			}
			
			media = (sum / numbers.length);
		}
		
		return Math.round(media * 100d)/100d;
	}
	
	public static Double getStandarDeviation(int[] numbers) {
		double standarDeviation = 0;
		
		if(numbers.length > 0) {
			double media = getMedia(numbers);
			double sum = 0;
			
			for(int number : numbers) {
				sum += Math.pow(Math.abs(number - media), 2);
			}
			
			standarDeviation = Math.sqrt(sum / numbers.length);
		}
		
		
		
		return Math.round(standarDeviation * 100d)/100d;
	}
}
