package com.zhuganggao.algorithms.genetic;

import org.junit.Ignore;
import org.junit.Test;

public class TestChromosome {

	@Ignore
	public void test() {
		
		Chromosome ch = GeneticEvolution.getRandomFatherChromosome();
		Chromosome ch1 = Mutation.getChild(ch);
		Gene g1=null;
		Gene g2=null;
		
		for(int i=0;i<=26;i++){
			
			g1 = ch.getChromosome().get(i);
			g2 = ch1.getChromosome().get(i);
			System.out.println("Port: "+g1.getPort()+"| "+g2.getPort());
			System.out.println("Inputx: "+g1.getInputX()+"|"+g2.getInputX());
			System.out.println("Inputy: "+g1.getInputY()+"|"+g2.getInputY());
			if(g1.getOperator() != null)
				System.out.println("Operation: "+g1.getOperator().getOperation()+"|"+g2.getOperator().getOperation());
		}
				
	}
	
	@Test
	public void testGeneration(){
		Generation generation = GeneticEvolution.
				getNextGeneration(GeneticEvolution.getRandomFatherChromosome());
		Chromosome chromosome = GeneticEvolution.getNextFather(generation);
		generation = GeneticEvolution.getNextGeneration(chromosome);
		
	}
}