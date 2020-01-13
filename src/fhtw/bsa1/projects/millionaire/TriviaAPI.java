package fhtw.bsa1.projects.millionaire;

import java.io.*;
import java.net.URL;
import java.util.*;

import javax.json.*;

public class TriviaAPI {
	
	public static final String ENDPOINT = "https://opentdb.com/";
	private String token;
	
	public TriviaAPI() {
		token = "&encode=base64";
	}
	
	public TriviaAPI(String token) {
		this.token = token + "&encode=base64";
	}
	
	public List<MultipleChoice> getMultiple(int amount){
		ArrayList<MultipleChoice> temp = new ArrayList<>();
		try {
            URL url = new URL(ENDPOINT + "api.php?amount=" + amount +"&type=multiple" + token);
            try (InputStream is = url.openStream();
                 JsonReader rdr = Json.createReader(is)) {
                JsonObject obj = rdr.readObject();
                for(JsonObject o: obj.getJsonArray("results").getValuesAs(JsonObject.class)) {	
                	temp.add(new MultipleChoice(o));
                }
                
            }
        }catch(Exception e){
            System.err.println(e);
        }
		return temp;
	}
	
	public List<YesNo> getYesNo(int amount){
		ArrayList<YesNo> temp = new ArrayList<>();
		try {
            URL url = new URL(ENDPOINT + "api.php?amount=" + amount +"&type=boolean" + token);
            try (InputStream is = url.openStream();
                 JsonReader rdr = Json.createReader(is)) {
                JsonObject obj = rdr.readObject();
                for(JsonObject o: obj.getJsonArray("results").getValuesAs(JsonObject.class)) {
                	temp.add(new YesNo(o));
                }
                
            }
        }catch(Exception e){
            System.err.println(e);
        }
		return temp;
	}

}

