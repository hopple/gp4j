package com.zhuganggao.algorithms.genetic;

import org.apache.log4j.Logger;

public class ThreadRun extends Thread{

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public void run() {
		logger.info("Starting ....");
		int index = 1;
		Chromosome ch = GeneticEvolution.getRandomFatherChromosome();
		logger.info("Generation : "+index++);
		Generation generation = GeneticEvolution.getNextGeneration(ch);
		for(int i=0;i<1000000;i++){
			Chromosome chromosome = GeneticEvolution.getNextFather(generation);
			generation = GeneticEvolution.getNextGeneration(chromosome);
			logger.info("Generation : "+index++);
		}
		
	}
}
