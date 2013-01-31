package com.zhuganggao.algorithms.genetic;

import java.util.ArrayList;

import org.apache.log4j.Logger;


public class GeneticEvolution {
	
	private Logger logger = Logger.getLogger(this.getClass());

	public static Chromosome getRandomFatherChromosome(){
		
		ArrayList<Gene> chromosome = new ArrayList<Gene>();
		int port =0;
		
		//this is for the input value of x
		Gene input = new Gene();
		input.setPort(0);
		input.setInputX(0);
		input.setInputY(0);
		chromosome.add(0, input);
	
		for(int i=1;i<=25;i++){
	
			Gene gene = new Gene();
			gene.setPort(i);
			gene.setOperator(OperatorProvider.getRandomOperator());
			port = RandomGenerator.getRandomNumber(0, i-1);
			gene.setInputX(port);
			port = RandomGenerator.getRandomNumber(0, i-1);
			gene.setInputY(port);
			chromosome.add(gene);
		}
		
		// this is for the output value of y
		Gene output = new Gene();
		output.setPort(26);
		port = RandomGenerator.getRandomNumber(0, 25);
		output.setInputX(port);
		chromosome.add(26, output);
		return new Chromosome(chromosome);
	}
	
	private static Chromosome getChildChromosome(Chromosome father){
		return Mutation.getChild(father);
	}
	
	public static Generation getNextGeneration(Chromosome father){
		Generation generation = new Generation();
		generation.getGeneration()[0]=father;
		generation.getFitnessValues()[0]=FitnessFunction.getFitnessFunctionValue(father);
		for(int i=1;i<=7;i++){
			Chromosome chromosome = getChildChromosome(father);
			generation.getGeneration()[i]=chromosome;
			generation.getFitnessValues()[i]=FitnessFunction.getFitnessFunctionValue(chromosome);
		}
		//generation.displayGeneration();
		return generation;
	}
	
	public static Chromosome getNextFather(Generation generation){
		double[] fitnessValues = generation.getFitnessValues();
		double value = fitnessValues[0];
		int j=0;
		for(int i=0;i<8;i++){
			if(fitnessValues[i]<value){
				value = fitnessValues[i];
				j=i;
			}
		}
		generation.setBestFitnessValue(value);
		generation.setBestChromosomeIndex(j);
		
		/*
	
		logger.info("-----**Evolution Information**------");
		logger.info("Calculating next father chromosome...");
		String str = "";
		if(j==0)
			str = "The chosen chromosome is father...";
		else
			str = "The chosen chromosome is child-"+j+"...";
		logger.info("Next father chromosome info: "+str);
		logger.info(generation.getGeneration()[j].displayCodedArray());
		logger.info("Fitness value : " + fitnessValues[j]);
		*/
		
		return generation.getGeneration()[j];
	}
	
	
}
