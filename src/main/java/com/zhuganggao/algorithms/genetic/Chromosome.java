package com.zhuganggao.algorithms.genetic;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class Chromosome {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	private ArrayList<Gene> chromosome;
	
	public ArrayList<Gene> getChromosome() {

		return chromosome;
	}

	public void setChromosome(ArrayList<Gene> chromosome) {
		this.chromosome = chromosome;
	}

	public Chromosome(){}
	
	public Chromosome(ArrayList<Gene> chromosome){
		this.chromosome = chromosome;
	}
	
	public Chromosome(Chromosome chromosome){
		this.chromosome = new ArrayList<Gene>();
		for(int i=0;i<=26;i++){
			Gene clone = new Gene();
			clone.setInputX(chromosome.getChromosome().get(i).getInputX());
			clone.setInputY(chromosome.getChromosome().get(i).getInputY());
			if(chromosome.getChromosome().get(i).getOperator() != null)
				clone.setOperator(OperatorProvider.getOperator(chromosome.getChromosome().get(i)
						.getOperator().getOperation()));
			clone.setPort(chromosome.getChromosome().get(i).getPort());
			this.chromosome.add(clone);
		}
	}
	
	
	public double getOutputValue(double x){
		double[] values = new double[26];
		values[0]=x;
		Gene gene = null;
		int outputPort = chromosome.get(26).getInputX();
		for(int i=1;i<=outputPort;i++){
			gene = chromosome.get(i);
			gene.getOperator().setInputX(values[gene.getInputX()]);
			gene.getOperator().setInputY(values[gene.getInputY()]);
			values[i]=gene.getOperator().getOutput();
		}
		return values[outputPort];
	}
	
	public String displayCodedArray(){
		String arrayStr = "Chromosome Array : ";
		for(int i=1;i<=25;i++){
			arrayStr= arrayStr+" ["+chromosome.get(i).getInputX()+","+chromosome.get(i).getInputY()+
					","+chromosome.get(i).getOperator().getOperation()+"] ";
		}
		arrayStr = arrayStr+" ["+chromosome.get(26).getInputX()+"] ";
		return arrayStr;
	}

}
