package Planner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Transaction {
	
	public Transaction() {
		
	}
	
	public Transaction(String name,String concertName,String CardNumber, String price){
		
		File file = new File("Purchases.txt");
		FileWriter fr = null;
		
		try {
			fr = new FileWriter(file, true);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		try {
			fr.write(name+";"+concertName+";"+"****************"+";"+price+";"+new Date()+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean find(String name,String concertName) {
				
		File file = new File("Purchases.txt");
		Scanner s = null;
		
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(s.hasNext()) {
			String[] udaje = s.nextLine().split(";");
			
			if(udaje[0].equals(name) && udaje[1].equals(concertName)) {
				return true;
			}
		}
		return false;
	}
}
