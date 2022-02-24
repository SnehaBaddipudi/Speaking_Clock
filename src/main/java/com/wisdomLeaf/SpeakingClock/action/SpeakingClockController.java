package com.wisdomLeaf.SpeakingClock.action;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wisdomLeaf.SpeakingClock.service.SpeakingClockService;
@Controller
public class SpeakingClockController {
	
	@Autowired
	SpeakingClockService speakingClockService;
	
	public String changeTimetoWords() {	
		String timeInWords="";
		try {
			
			LocalDateTime currentTime=LocalDateTime.now();
			//To know current time in Words
			timeInWords=speakingClockService.convertTimeToWords(currentTime.getHour(),currentTime.getMinute());

			System.out.println();
			System.out.println(timeInWords);
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return timeInWords;
	}

	
}
