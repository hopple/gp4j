package com.zhuganggao.algorithms.genetic.operators;

public class ExpOperator extends AbstractOperator{
	
	@Override
	public double getOutput() {
		return Math.exp(inputX);
	}

}
