package com.zhuganggao.algorithms.genetic;

public class Gene {

	int inputX = 0;
	int inputY = 0;
	Operator operator = null;
	int port = 0;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Gene() {

	}

	public int getInputX() {
		return inputX;
	}

	public void setInputX(int inputX) {
		this.inputX = inputX;
	}

	public int getInputY() {
		return inputY;
	}

	public void setInputY(int inputY) {
		this.inputY = inputY;
	}
	

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}
}
