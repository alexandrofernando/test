package com.jpmc.theater;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ScheduleDisplay {

	private String Sequence;
	private String StartTime;
	private String Title;
	private String Duration;
	private double Fees;
}
