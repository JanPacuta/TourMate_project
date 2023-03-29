package Planner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Attendee extends User{

	public Attendee(String name, String pass){
		this.loginName = name;
		this.password = pass;
	}
	
	public Attendee() {
	}
	
	public boolean addToList() throws IOException {
		File file = new File("LoginsA.txt");
		FileWriter fr = new FileWriter(file, true);
		if(!this.loginName.isEmpty() && !this.password.isEmpty()) {
			fr.write(loginName+";"+password+"\n");
			fr.close();
		}
		return this.loginName.isEmpty() && this.password.isEmpty();
	}
	
	public void show() {
		System.out.println(loginName+password);
	}
	
	public boolean find(String name,String pass) {
		boolean x=false;
		File file = new File("LoginsA.txt");
		Scanner s = null;
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(s.hasNext()) {
			String[] udaje = s.nextLine().split(";");
			if(name.equals(udaje[0]) && pass.equals(udaje[1])) {
				x=true;
			}
		}
		return x;
	}
}
