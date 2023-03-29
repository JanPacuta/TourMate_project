package Planner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.scene.control.TableView;

public class ConcertWatcher {

	File file = new File("Events.txt");
	Scanner s = null;
	
	public String[] search(TableView<String[]> t) {
		String[] udaje = null;
		
		t.getItems().clear();
		
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(s.hasNext()) {
			udaje = s.nextLine().split(";");
			
			String[] temp = {udaje[1],udaje[2],udaje[3]+"€"};
			
			t.getItems().add(temp);
		}
		
		return udaje;
	}
	
	public String[] find(String name) {
		String[] udaje = null;
		
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(s.hasNext()) {
			udaje = s.nextLine().split(";");
			
			if(udaje[1].equals(name)) {
				break;
			}
		}
		
		return udaje;
	}
}
