package fhtw.bsa1.projects.millionaire;

import java.util.Scanner;
import fhtw.bsa1.projects.extras.*;

public class MillionaireApp {

	public static void main(String[] args) {
		TriviaAPI api = new TriviaAPI();
		Scanner sc = new Scanner(System.in);
		int counter = 0;
		int amount = 10;
		for(MultipleChoice q: api.getMultiple(amount)) {
			System.out.println(q.toString());
			String ans = sc.next();
			if(q.isCorrect(ans)) {
				counter++;
				System.out.println("Correct");
			}else {
				System.out.println("False");
			}
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				System.out.println("Thread sleep exception");
			}
			//Util.clearScreen();
		}
		sc.close();
		System.out.println("You got " + counter + " out of " + amount + "right");
		
	}

}
