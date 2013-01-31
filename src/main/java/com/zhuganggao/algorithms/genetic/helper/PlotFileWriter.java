package com.zhuganggao.algorithms.genetic.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PlotFileWriter {
	
	private File file = null;
	private FileWriter fstream = null;
	private BufferedWriter out = null;
	
	public PlotFileWriter(String filename)throws IOException{
		this.file = new File(filename);
		boolean exist = file.createNewFile();
		if (!exist) {
			throw new IllegalArgumentException(
					"The file already exists: " + filename);
		} else {
			fstream = new FileWriter(filename);
			out = new BufferedWriter(fstream);

		}
	}
	
	public void write(String msg) throws IOException{
		out.write(msg);
	}
	
	public void close() throws IOException{
		if(out != null)
			out.close();
	}
	

}
