package fhtw.bsa1.projects.extras;

/**
 * Utility class providing convenience function for terminal control using
 * <a href="https://www.csie.ntu.edu.tw/~r92094/c++/VT100.html">vt100 commands</a>
 * 
 * @author	Alija Sabic
 * @email	sabic@technikum-wien.at
 * @version	0.1
 */
public class Util {
	
	/**	vt100 escape sequences*/
	public static final String ESC = "\033";
	/** cursor home:  `[H` - Move cursor to upper left corner. */
	public static final String CURSORHOME = "[H";
	/** clear screen: `[2J` - Clear entire screen. */
	public static final String CLEARSCREEN = "[2J";
	
	/** 
	 * `private` Constructor to prevent instantiations of this utility class.
	 */
	private Util() {}	
	
	/**
	 * Clears the terminal screen (supporting vt100 commands).
	 */
	public static void clearScreen() {
		System.out.print(ESC + CURSORHOME + ESC + CLEARSCREEN);
		System.out.flush();
	}
}