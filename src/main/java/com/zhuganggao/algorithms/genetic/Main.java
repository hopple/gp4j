package com.zhuganggao.algorithms.genetic;


import java.io.IOException;

import org.apache.log4j.Logger;

import com.zhuganggao.algorithms.genetic.helper.Configuration;
import com.zhuganggao.algorithms.genetic.helper.PlotFileWriter;


public class Main {
	
	static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args){
		
		double[] generationGraph = new double[1000001];
	
		logger.info("Starting ....");
		int index = 0;
		Chromosome ch = GeneticEvolution.getRandomFatherChromosome();
		
		System.out.println("**********"+"Generation : "+(index++)+"**********");
		Generation generation = GeneticEvolution.getNextGeneration(ch);
		Chromosome chromosome = GeneticEvolution.getNextFather(generation);
		generation.displayBestChromosomeInfo(0);
		generationGraph[0] = generation.getBestFitnessValue();
		
		int i=0;
		for(;i<Configuration.getInstance().getGenerationNo();i++){
			System.out.println("**********"+"Generation : "+(index++)+"**********");
			generation = GeneticEvolution.getNextGeneration(chromosome);
			chromosome = GeneticEvolution.getNextFather(generation);
			if(generation.getBestChromosomeIndex()!=0){
				generation.displayBestChromosomeInfo(i+1);
			}
			generationGraph[i+1] = generation.getBestFitnessValue();
		}
		
		
		generation.displayBestChromosomeInfo();
		logger.info("The fitness value of best chromosome when the sample number is 1000...");
		logger.info("FitnessValue :" +FitnessFuction1000.getFitnessFunctionValue(chromosome));
		
		
		logger.info("Stop running, recording...");
		
		PlotFileWriter writer;
		try {
			writer = new PlotFileWriter("generationevolution.dat");
			for(int j=0;j<i+1;j++){
				
				writer.write(j+"	"+generationGraph[j]+"\n");
				
			}
			writer.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		logger.info("writing the best chromosome graph data");
		try {
			PlotFileWriter writer2 = new PlotFileWriter("bestChromosome.dat");
			double range = Configuration.getInstance().getRange();
			double sampleNo = Configuration.getInstance().getSampleNo();
			double step = range/(sampleNo -1);
			
			int j =0;
			double stepV = -(range/2);
			while(j <sampleNo){
				writer2.write(stepV+"	"+chromosome.getOutputValue(stepV)+"\n");
				stepV = stepV+step;
				j++;
			}	
			
			writer2.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		logger.info("Recording successful, finished...");
	}
	
	
	
}
