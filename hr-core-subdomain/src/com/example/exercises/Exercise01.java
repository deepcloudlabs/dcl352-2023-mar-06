package com.example.exercises;

import java.math.BigInteger;

public class Exercise01 {
	public static void main(String[] args) {
			String name= "jack";
			name = name.toUpperCase();
			System.out.println(name);
			BigInteger bi = BigInteger.valueOf(1_000_000);
			bi = bi.add(BigInteger.ONE);
			System.out.println(bi);			
			
	}
}
