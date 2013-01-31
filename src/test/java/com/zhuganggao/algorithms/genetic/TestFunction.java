package com.zhuganggao.algorithms.genetic;

import java.io.IOException;


import org.junit.Test;

import com.zhuganggao.algorithms.genetic.helper.Configuration;
import com.zhuganggao.algorithms.genetic.helper.PlotFileWriter;

public class TestFunction {

	@Test
	public void test() {
		PlotFileWriter writer2;
		try {
			writer2 = new PlotFileWriter("target.dat");
			double range = Configuration.getInstance().getRange();
			double sampleNo = Configuration.getInstance().getSampleNo();
			double step = range/(sampleNo -1);
			int index =0;
			double i = -(range/2);
			while(index <sampleNo){
				writer2.write(i+"		"+FitnessFunction.getTargetFunctionValue(i)+"\n");
				i = i+step;
				index++;
			}	
			writer2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
