package fhtw.bsa1.projects.millionaire;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;

import javax.json.JsonObject;
import javax.json.JsonString;

public class MultipleChoice extends Question{
	private String correctAnswer;
	private ArrayList<String> falseAnswers;
	private HashMap<String,String> answerMapping;
	
	public MultipleChoice(JsonObject o) {
		super(o);
		Base64.Decoder dec = Base64.getDecoder();
		falseAnswers = new ArrayList<>();
		correctAnswer = new String(dec.decode(o.getString("correct_answer")));
		for(JsonString inc: o.getJsonArray("incorrect_answers").getValuesAs(JsonString.class)) {
			falseAnswers.add(new String(dec.decode(inc.getString())));
		}
		answerMapping = new HashMap<>();
	}
	
	public String getAnswer() {
		return correctAnswer; 
	}
	
	public ArrayList<String> getFalseAnswers(){
		return falseAnswers;
	}
	
	public boolean isCorrect(String key) {
		return correctAnswer.equals(answerMapping.get(key.toUpperCase()));
	}
	
	public String toString() {
		String output = super.getQuestion() +"\n\n";
		String[] markers = {"A","B","C","D"};
		ArrayList<String> temp = new ArrayList<>(falseAnswers);
		temp.add(correctAnswer);
		Collections.shuffle(temp);
		for(int i=0; i<temp.size(); i++) {
			output += markers[i] + ": " + temp.get(i) +"\n";
			answerMapping.put(markers[i], temp.get(i));
		}
		return output;
	}
}
