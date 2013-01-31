package com.zhuganggao.algorithms.genetic.operators;

public class SinOperator extends AbstractOperator{
	
	@Override
	public double getOutput() {
		return Math.sin(inputX);
	}

}
