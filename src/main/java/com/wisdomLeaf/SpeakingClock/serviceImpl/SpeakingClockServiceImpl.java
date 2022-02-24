package com.wisdomLeaf.SpeakingClock.serviceImpl;

import org.springframework.stereotype.Service;

import com.wisdomLeaf.SpeakingClock.service.SpeakingClockService;

@Service
public class SpeakingClockServiceImpl implements SpeakingClockService {

	@Override
	public String convertTimeToWords(int hours, int minutes) {
		String hoursandMinsInWords = "";
		try {

			String numsForhoursandMinutes[] = { "", " one", " two", " three", " four", " five", " six", " seven",
					" eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
					" seventeen", " eighteen", " nineteen" };
			String[] tensPlaceforMinutes = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy",
					" eighty", " ninety" };

			String minInWords;

			if (hours == 0 && minutes == 0) {
				hoursandMinsInWords = "It's Midnight";
			} else if (hours == 12 && minutes == 0) {
				hoursandMinsInWords = "It's Midday";
			} else {
				if (minutes % 100 < 20) {
					minInWords = numsForhoursandMinutes[minutes % 100];
					minutes /= 100;
				} else {
					minInWords = numsForhoursandMinutes[minutes % 10];
					minutes /= 10;

					minInWords = tensPlaceforMinutes[minutes % 10] + minInWords;
					minutes /= 10;
				}
				
				hoursandMinsInWords = "It's" + " "+ numsForhoursandMinutes[hours] + " "
						+ numsForhoursandMinutes[minutes]+" "+ minInWords+" ";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hoursandMinsInWords;

	}

}
