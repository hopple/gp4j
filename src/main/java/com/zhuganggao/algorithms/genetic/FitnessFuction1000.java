package com.zhuganggao.algorithms.genetic;


public class FitnessFuction1000 {
	
	private static double[] sample = new double[1204];
	private static double range = 20;
	private static double sampleNo = 1000;
	private static double step = range/(sampleNo -1);
	
	static{
		getTargetSample();
	}
	
	public static double getFitnessFunctionValue(Chromosome chromosome){
		double expectation = 0;
		int index =0;
		double i = -(range/2);
		while(index <sampleNo){
			double value = chromosome.getOutputValue(i);
			expectation=expectation + Math.abs(value-sample[index]);
			i = i+step;
			index++;
		}	
		return (expectation/sampleNo);
	}
	
	public static void getTargetSample(){
		
		int index =0;
		double i = -(range/2);
		while(index <sampleNo){
			sample[index] = FitnessFunction.getTargetFunctionValue(i);
			i = i+step;
			index++;
		}	
	}
	

}
