package com.zhuganggao.algorithms.genetic.operators;

public class MinusOperator extends AbstractOperator{

	@Override
	public double getOutput() {
		
		return (this.inputX - this.inputY);
	}

}
