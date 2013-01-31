package com.zhuganggao.algorithms.genetic.operators;

import com.zhuganggao.algorithms.genetic.Operator;
import com.zhuganggao.algorithms.genetic.OperatorProvider.Operation;

public abstract class AbstractOperator implements Operator{
	
	protected double inputX;
	protected double inputY;
	protected Operation operation;
	
	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public AbstractOperator(){
		
	}

	public double getInputX() {
		
		return this.inputX;
	}


	public double getInputY() {
	
		return this.inputY;
	}

	public void setInputX(double x) {
		this.inputX = x;
		
	}

	public void setInputY(double y) {
		this.inputY = y;
		
	}
	
	abstract public double getOutput();

}
