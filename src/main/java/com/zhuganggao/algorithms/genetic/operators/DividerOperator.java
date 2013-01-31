package com.zhuganggao.algorithms.genetic.operators;

public class DividerOperator extends AbstractOperator{
	
	@Override
	public double getOutput() {
		
		if(this.inputY == 0)
			return 1;
		else return (inputX / inputY);
	}

}
