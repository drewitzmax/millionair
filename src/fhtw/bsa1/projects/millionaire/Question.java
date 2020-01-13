package fhtw.bsa1.projects.millionaire;

import java.util.Base64;
import javax.json.JsonObject;

public abstract class Question {
	private String category;
	private String difficulty;
	private String question;
	
	public Question(JsonObject o) {
		Base64.Decoder dec = Base64.getDecoder();
		category = new String(dec.decode(o.getString("category")));
		difficulty = new String(dec.decode(o.getString("difficulty")));
		question = new String(dec.decode(o.getString("question")));
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getDifficulty() {
		return difficulty;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public abstract boolean isCorrect(String key);
}
