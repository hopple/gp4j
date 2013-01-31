package com.zhuganggao.algorithms.genetic;

import com.zhuganggao.algorithms.genetic.operators.*;

public class OperatorProvider {
	
	//define the operations
	public enum Operation{
		Add,Minus,Multiply,Divide,Sin,Cos,Exp,Log
	}
	
	//randomly decide the operation
	public static Operation getRandomOperation(){
		Operation operation = null;
		switch(RandomGenerator.getRandomNumber(0, 7)){
		case 0:
			operation = Operation.Add;
			break;
		case 1:
			operation = Operation.Minus;
			break;
		case 2:
			operation = Operation.Multiply;
			break;
		case 3:
			operation = Operation.Divide;
			break;
		case 4:
			operation = Operation.Sin;
			break;
		case 5:
			operation = Operation.Cos;
			break;
		case 6:
			operation = Operation.Exp;
			break;
		case 7:
			operation = Operation.Log;
			break;
		}
		return operation;
	}
	
	//obtain a randomly operator
	public static Operator getRandomOperator(){
		return getOperator(getRandomOperation());
	}

	//obtain a operator according to the operation type
	public static Operator getOperator(Operation operation){
		
		Operator operator = null;
		
		switch(operation){
		case Add:
			operator = new AddOperator();
			operator.setOperation(Operation.Add);
			break;
		case Minus:
			operator = new MinusOperator();
			operator.setOperation(Operation.Minus);
			break;
		case Multiply:
			operator = new MultiplierOperator();
			operator.setOperation(Operation.Multiply);
			break;
		case Divide:
			operator = new DividerOperator();
			operator.setOperation(Operation.Divide);
			break;
		case Sin:
			operator = new SinOperator();
			operator.setOperation(Operation.Sin);
			break;
		case Cos:
			operator = new CosOperator();
			operator.setOperation(Operation.Cos);
			break;
		case Exp:
			operator = new ExpOperator();
			operator.setOperation(Operation.Exp);
			break;
		case Log:
			operator = new LogarithmOperator();
			operator.setOperation(Operation.Log);
			break;
		}

		return operator;
	}

}
