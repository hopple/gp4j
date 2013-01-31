package com.zhuganggao.algorithms.genetic.operators;

public class LogarithmOperator extends AbstractOperator{
	
	@Override
	public double getOutput() {
		if(inputX >0)
			return Math.log10(inputX);
		else
			return 1;
	}

}
