package com.zhuganggao.algorithms.genetic;

import com.zhuganggao.algorithms.genetic.OperatorProvider.Operation;

public interface Operator {

	double getInputX();
	
	void setInputX(double x);
	
	double getInputY();
	
	void setInputY(double y);
	
	double getOutput();
	
	Operation getOperation();
	
	void setOperation(Operation operation);
	
	
}
