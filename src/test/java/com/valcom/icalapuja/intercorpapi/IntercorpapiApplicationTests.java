package com.valcom.icalapuja.intercorpapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.assertj.core.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.valcom.icalapuja.intercorpapi.util.Util;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntercorpapiApplicationTests {
	
	@Test
	public void age() {
		try {
			Assertions.assertThat(Util.getAge(new SimpleDateFormat("yyyy-MM-dd").parse("1983-11-07"))).isEqualTo(35);
		} catch (Exception e) {}
	}
	
	@Test
	public void deathDate() {
		Assertions.assertThat(Util.getDeathDate()).isAfter(new Date());
	}
	
	@Test
	public void media() {
		int[] numbers = {10, 20,30};
		Assertions.assertThat(Util.getMedia(numbers)).isEqualTo(20D);
	}
	
	@Test
	public void standarDeviation() {
		int[] numbers = {10, 20,30};
		Assertions.assertThat(Util.getStandarDeviation(numbers)).isEqualTo(8.16D);
	}
	
}
