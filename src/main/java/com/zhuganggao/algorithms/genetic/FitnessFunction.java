package com.zhuganggao.algorithms.genetic;

import com.zhuganggao.algorithms.genetic.OperatorProvider.Operation;
import com.zhuganggao.algorithms.genetic.helper.Configuration;
import com.zhuganggao.algorithms.genetic.helper.ValueConverter;



public class FitnessFunction {
	
	private static double[] sample = new double[1204];
	private static double range = Configuration.getInstance().getRange();
	private static double sampleNo = Configuration.getInstance().getSampleNo();
	private static double step = range/(sampleNo -1);
	
	static{
		getTargetSample();
	}
	
	public static double getTargetFunctionValue(double x){
		
		double y;
		y = x*x;
		Operator operatorSin = OperatorProvider.getOperator(Operation.Sin);
		operatorSin.setInputX(x);
		double sinx = operatorSin.getOutput();
		Operator operatorExp = OperatorProvider.getOperator(Operation.Exp);
		operatorExp.setInputX(sinx);
		double exp = operatorExp.getOutput();
		y = y*exp;
		y = y+x;
		double pi = ValueConverter.doubleToFloat(Math.PI);
		operatorSin.setInputX(pi/(x*x*x));
		double sinPiX3 = operatorSin.getOutput();
		y = y+ sinPiX3;
		
		return y;
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
	
	public static double[] getSampleValues(){
		return sample;
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
	
	
}
