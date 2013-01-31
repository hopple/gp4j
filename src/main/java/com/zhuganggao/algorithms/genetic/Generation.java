package com.zhuganggao.algorithms.genetic;

import org.apache.log4j.Logger;

public class Generation {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	private Chromosome[] generation = new Chromosome[8];
	
	private double bestFitnessValue = 0;
	
	private int bestChromosomeIndex = 0;
	
	public int getBestChromosomeIndex() {
		return bestChromosomeIndex;
	}

	public void setBestChromosomeIndex(int bestChromosomeIndex) {
		this.bestChromosomeIndex = bestChromosomeIndex;
	}

	public double getBestFitnessValue() {
		return bestFitnessValue;
	}

	public void setBestFitnessValue(double bestFitnessValue) {
		this.bestFitnessValue = bestFitnessValue;
	}

	public Chromosome[] getGeneration() {
		return generation;
	}

	public void setGeneration(Chromosome[] generation) {
		this.generation = generation;
	}

	private double[] fitnessValues = new double[8];
	
	public double[] getFitnessValues() {
		return fitnessValues;
	}

	public void setFitnessValues(double[] fitnessValues) {
		this.fitnessValues = fitnessValues;
	}

	public Generation(){};
	
	public void displayGeneration(){
		logger.info("-----**Generation Information**------");
		logger.info("Father Info");
		logger.info(generation[0].displayCodedArray());
		logger.info("Fitness Value :"+fitnessValues[0]);
		for(int i=1;i<=7;i++){
			logger.info("Child-"+i+" Info");
			logger.info(generation[i].displayCodedArray());
			logger.info("Fitness Value :"+fitnessValues[i]);
		}
	}
	
	public void displayBestChromosomeInfo(){
		logger.info("******The best chromosome is *******");
		logger.info(generation[bestChromosomeIndex].displayCodedArray());
		logger.info("Fitness Value :"+bestFitnessValue);
		
	}

	
	public void displayBestChromosomeInfo(int generationNo){
		logger.info("-----Chromosome Evolution Information------");
		logger.info("Generation number: "+ generationNo);
		logger.info(generation[bestChromosomeIndex].displayCodedArray());
		logger.info("Fitness Value :"+bestFitnessValue);
		
	}

	
	
}
