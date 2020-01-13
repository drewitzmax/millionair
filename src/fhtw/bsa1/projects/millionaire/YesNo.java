package fhtw.bsa1.projects.millionaire;

import javax.json.JsonObject;

import java.util.Base64;
public class YesNo extends Question{
	private boolean answer;
	
	public YesNo(JsonObject o) {
		super(o);
		answer = ( new String(Base64.getDecoder().decode((o.getString("correct_answer").getBytes()))) == "True" );
	}
	
	public boolean isTrue() {
		return answer;
	}
	
	public boolean isCorrect(String ans) {
		return (ans.toLowerCase() == "true") == answer;
	}
	
	public String toString() {
		return super.getQuestion() + "\n\n \"True\" or \"False\"?";
	}
}
