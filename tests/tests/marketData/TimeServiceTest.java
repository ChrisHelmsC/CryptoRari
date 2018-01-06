package tests.marketData;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.Date;
import org.junit.Test;

import com.cryptoRari.entities.GDAXTime;
import com.cryptoRari.marketData.TimeService;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

public class TimeServiceTest {
	private TimeService timeService;
	
	public TimeServiceTest() {
		this.timeService = new TimeService();
	}
	
	@Test
	public void testTimeService() {
		GDAXTime gdaxTime = timeService.getTime();
		
		assertTrue(gdaxTime != null);
		assertTrue(gdaxTime.getEpoch().length() > 0);
		assertTrue(gdaxTime.getISO().length() > 0);
	}
	
	@Test
	public void testTimeParsing() {
		GDAXTime gdaxTime = timeService.getTime();
		
		ISO8601DateFormat isoFormat = new ISO8601DateFormat();
		try {
			Date date = isoFormat.parse(gdaxTime.getISO());
			assertTrue(date != null);
		} catch (ParseException e) {
			System.out.print("Error parsing the ISO860 time string.");
			e.printStackTrace();
		}
	}
}
