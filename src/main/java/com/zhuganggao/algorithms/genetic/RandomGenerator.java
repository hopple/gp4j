package com.zhuganggao.algorithms.genetic;

import java.util.Random;

public class RandomGenerator {
	
	private static Random random = new Random();
	
	public static int getRandomNumber(int start,int end){
		return random.nextInt(end+1);
	}

}
