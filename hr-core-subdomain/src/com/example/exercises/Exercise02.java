package com.example.exercises;

import com.example.hr.domain.FullName;

public class Exercise02 {

	public static void main(String[] args) {
		var jackBauer1 = new FullName("jack","bauer");
		var jackBauer2 = new FullName("jack","bauer");
		System.out.println(jackBauer1.firstName());
		System.out.println(jackBauer1.lastName());
		System.out.println(jackBauer1.toString());
		System.out.println(jackBauer1.equals(jackBauer2));
		System.out.println(jackBauer1.hashCode());
		System.out.println(jackBauer2.hashCode());
	}

}
