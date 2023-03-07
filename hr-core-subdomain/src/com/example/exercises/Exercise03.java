package com.example.exercises;

import com.example.hr.domain.JobStyle;

public class Exercise03 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		var jobStyle = JobStyle.PART_TIME;
		// jobStyle = JobStyle.valueOf("FREELANCE");
		for (var value : JobStyle.values()) {
			System.out.println("%s\t%d".formatted(value.name(),value.ordinal()));
		}
	}

}
