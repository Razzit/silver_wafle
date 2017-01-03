package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ReadFile {
	private String path;
	private String line;
	ArrayList<Players> playerArray;
	ArrayList<WorkshopMap> mapsArray;
	private BufferedReader br;
	Players newPlayer;
	WorkshopMap newMap;
	
	String url, workshopTitle;
	
	
	public ReadFile(String file_name){
		this.path = file_name;
		
	}
	
	public ArrayList<Players> OpenPlayersFile() throws IOException{
		playerArray = new ArrayList<Players>();
		try {
			br = new BufferedReader(new FileReader(path));
			while((line = br.readLine())!= null){
				newPlayer = new Players(line);
				playerArray.add(newPlayer);		

			}
			
		} catch (Exception e) {
			System.err.println("Failed to read from file!");
		}
		return playerArray;

		
	}
	
	public ArrayList<WorkshopMap> openMapsFile() throws IOException{
		mapsArray = new ArrayList<WorkshopMap>();
		try{
			br = new BufferedReader(new FileReader(path));
			while((line = br.readLine()) != null){
				StringTokenizer stringTokenizer = new StringTokenizer(line, "|");
				while(stringTokenizer.hasMoreElements()){
					url = stringTokenizer.nextElement().toString();
					workshopTitle = stringTokenizer.nextElement().toString();
					System.out.println(workshopTitle);
					newMap = new WorkshopMap(url, workshopTitle);
					mapsArray.add(newMap);
				}

			}
		} catch (Exception e) {
			System.err.println("Failed to read from file!");
		}
		
		return mapsArray;
		
	}

}
