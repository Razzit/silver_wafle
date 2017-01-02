package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
	private String path;
	private String line;
	ArrayList<Players> playerArray;
	private BufferedReader br;
	Players newPlayer;
	
	public ReadFile(String file_name){
		this.path = file_name;
		
	}
	
	public ArrayList<Players> OpenFile() throws IOException{
		playerArray = new ArrayList<Players>();
		try {
			br = new BufferedReader(new FileReader(path));
			
		} catch (Exception e) {
			System.err.println("Failed to read from file");
		}

		
		while((line = br.readLine())!= null){
			newPlayer = new Players(line);
			try {
				playerArray.add(newPlayer);		
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return playerArray;
	}

}
