package com.zhuganggao.algorithms.genetic.helper;

public class ValueConverter {
	
	public static Double floatToDouble(float original){
		return Double.valueOf(String.valueOf(original));
	}
	
	public static float doubleToFloat(Double original){
		return Float.valueOf(String.valueOf(original));
	}
	
	public static float intToFloat(int original){
		return Float.valueOf(String.valueOf(original));
	}

}
