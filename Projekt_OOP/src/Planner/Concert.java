package Planner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Concert {
	
	String organizer;
	Artist artist;
	String name;
	Dates dateAndTime;
	float price;
	String place;
	
	public Concert(String Organizer,String Name, Artist main, float price, Dates date, String place) {
		this.name = Name;
		this.price = price;
		
		File file = new File("Events.txt");
		FileWriter fr = null;
		
		try {
			fr = new FileWriter(file, true);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		try {
			fr.write(Organizer+";"+Name+";"+main.name+";"+(int)price+";"+date.day+";"+date.month+";"+date.year+";"+place+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public void showAll(){

	}
	
}
