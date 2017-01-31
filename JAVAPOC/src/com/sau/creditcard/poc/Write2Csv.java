package com.sau.creditcard.poc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.CsvWriter;

public class Write2Csv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fpath= "tempcsc.csv";
		
	
		try {
			// use FileWriter constructor that specifies open for appending
			CsvWriter csvOutput = new CsvWriter(new FileWriter(fpath, true), ',');
			
			// if the file didn't already exist then we need to write out the header line
			
				
			// else assume that the file already has the correct header line
			
			// write out a few records
			csvOutput.write("1234567891234567");
			csvOutput.write("Bret Lee");
			csvOutput.endRecord();
			
			csvOutput.write("123456789987654321");
			csvOutput.write("John Cena");
			csvOutput.endRecord();
			
			csvOutput.close();
			
			
			
			
			String line="";
			BufferedReader br = new BufferedReader(new FileReader(new File(fpath)));
	            while (( line = br.readLine()) != null) {
	            	String[] country = line.split(",");
	                for(int i=0;i<country.length;i++){
	                	System.out.println(country[i]);
	                }
	            }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}

}
