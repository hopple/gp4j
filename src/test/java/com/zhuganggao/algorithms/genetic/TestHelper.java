package com.zhuganggao.algorithms.genetic;

import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zhuganggao.algorithms.genetic.helper.Configuration;
import com.zhuganggao.algorithms.genetic.helper.ValueConverter;

public class TestHelper {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Test
	public void testConfig() {
		logger.info("Range "+ Configuration.getInstance().getRange());
		logger.info("Sample Number "+ Configuration.getInstance().getSampleNo());
		logger.info("Mutation Number"+Configuration.getInstance().getMutationNo());
	}
	
	@Test
	public void testValueConverter(){
		logger.info(ValueConverter.doubleToFloat(Math.random()));
		logger.info(ValueConverter.floatToDouble((float) 12.4));
		logger.info(ValueConverter.intToFloat(12));
		logger.info(2%3);
		logger.info(1%3);
		logger.info(0%3);
	}

	@Test
	public void testRandom(){
		int random0 = 0;
		int random1 = 0;
		Random r = new Random();
		for(int i=0;i<1000000;i++){
			int j=RandomGenerator.getRandomNumber(0, 1);
			if(j == 0)
				random0++;
			else if(j == 1)
				random1++;
			
		}
		logger.info("random0 :"+random0+"random1 :"+random1);
	}
}
