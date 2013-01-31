package com.zhuganggao.algorithms.genetic.helper;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Configuration {

	private double range = 0;
	private double sampleNo = 0;
	private int mutationNo = 0;
	private int generationNo = 0;

	private static Configuration configuration = null;

	public static Configuration getInstance() {
		if (configuration == null) {
			configuration = new Configuration();
		}
		return configuration;
	}

	private Configuration() {
		Properties props = new Properties();

		try {
			props.load(new FileInputStream(Constants.CONFIG_FILE_NAME));
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}		

		try {
			
			this.range = Double.parseDouble(props.getProperty("Range"));
			this.sampleNo = Double.parseDouble(props.getProperty("SampleNo"));
			this.mutationNo = Integer.parseInt(props.getProperty("MutationNo"));
			this.generationNo = Integer.parseInt(props.getProperty("GenerationNo"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public double getRange(){
		return this.range;
	}
	
	public double getSampleNo(){
		return this.sampleNo;
	}
	
	public int getMutationNo(){
		return this.mutationNo;
	}
	
	public int getGenerationNo(){
		return this.generationNo;
	}

}
