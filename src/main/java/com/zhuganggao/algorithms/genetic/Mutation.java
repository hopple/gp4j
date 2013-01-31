package com.zhuganggao.algorithms.genetic;

import org.apache.log4j.Logger;

import com.zhuganggao.algorithms.genetic.helper.Configuration;



public class Mutation {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	private static int mutationNo = Configuration.getInstance().getMutationNo();
	
	public static Chromosome getChild(Chromosome father){
		
		Chromosome child = new Chromosome(father);
		
		for(int i=0;i<mutationNo;i++){
			
			int index = RandomGenerator.getRandomNumber(0, 75);
			
			if(index == 75){
				int j = RandomGenerator.getRandomNumber(0, 25);
				
				child.getChromosome().get(26).
					setInputX(j);
				
			}else{
				
				int port = index/3 +1;
				int mutationItem = index%3;
				switch(mutationItem){
				case 0:
					child.getChromosome().get(port).
						setInputX(RandomGenerator.getRandomNumber(0, port-1));
					break;
				case 1:
					child.getChromosome().get(port).
						setInputY(RandomGenerator.getRandomNumber(0, port-1));
					break;
				case 2:
					child.getChromosome().get(port).
						setOperator(OperatorProvider.getRandomOperator());
					break;
				}
			}
			
		}
		
		return child;
	}

}
