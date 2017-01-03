package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WorkshopMap extends Client {
	private String workshopTitle; //implemented
	private String url;

	
	public WorkshopMap(String url){
		this.url = url;
		setWorkshopTitle();
		
	}
	
	
	public void setWorkshopTitle(){
		
		try {
			URL workshopURL = new URL(url);
			BufferedReader in = new BufferedReader(new InputStreamReader(workshopURL.openStream()));
			String str;
			 
			while((str = in.readLine()) != null){
				str = str.toString();			
				if(str.contains("workshopItemTitle")){
					str = str.replaceAll("<div class=\"workshopItemTitle\">", "");
					str = str.replaceAll("</div>", "").trim();
					workshopTitle = str;

				}		
			}
			in.close();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}

		
	}
	
	public String getWorkshopTitle(){
		return workshopTitle;
	}

}
