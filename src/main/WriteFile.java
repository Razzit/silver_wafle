package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteFile {
	
	String path, file_name;
	private boolean append_to_file = false;
	private PrintWriter print_line;
	
	public WriteFile(String file_path, boolean append_to_file){
		this.path = file_path;
		this.append_to_file = append_to_file;
	}
	
	public void writeToPlayersFile(ArrayList<Players> players) throws IOException{
		FileWriter write = new FileWriter(path, append_to_file);
		print_line = new PrintWriter(write);
		
		for(int i = 0; i<players.size();i++){
			print_line.printf("%s" + "%n", players.get(i).getName());
		}
		
		print_line.close();
	}
	
	public void writeToMapsFile(ArrayList<WorkshopMap> maps) throws IOException{
		FileWriter write = new FileWriter(path, append_to_file);
		print_line = new PrintWriter(write);
		
		for(int i = 0; i<maps.size();i++){
			print_line.printf("%s|%s" + "%n", maps.get(i).getWorkshopURL(), maps.get(i).getWorkshopTitle());
		}
		
		print_line.close();
	}

}
