
import java.util.Scanner;
import java.util.InputMismatchException;

public class Validate {
	
	// Initialise Scanner
	public static Scanner SC = new Scanner (System.in);
	
	//Constructor
	public Validate() {
		
	}

	/*
	 * Validate Integer method
	 * parse input to Integer
	 * Assigns to variable number
	 * Returns number
	 * Catches InputMismatchException
	 */
	public static int validateInteger() {
		while(true) {
		try {
			int number = Integer.parseInt(SC.nextLine());
			return number;
		}
		catch(InputMismatchException e) {
			SC.nextLine();
			errorMessage("integer");
			e.printStackTrace();
		}
	}
}
	
	/*
	 * Validate String method
	 * Tries to scan nextLine()
	 * Assigns to variable ref
	 * Returns ref
	 * Catches InputMismatchException
	 */
	public static String validateString() {
		while(true) {
		try {
			String ref = SC.nextLine();
			return ref;
		} catch (InputMismatchException e) {
			SC.nextLine();
			errorMessage("string");
			e.printStackTrace();
		}
	}
}

	/*
	 * UniqueId Generator method
	 * Takes prefix as parameter
	 * Prefix for Cage is CG
	 * Prefix for Keeper is KP
	 * Prefix for Animal is animalType.substring(0, 2).toUpperCase();
	 * Generates a random number between 0 and 1 and multiplies it 
	 * by 1000 - giving a random number between 0 and 999
	 * Sets id to prefix + random number
	 * Returns UniqueId
	 */
	public static String UniqueId(String prefix) {
		int random = (int)Math.ceil(Math.random() * 1000);
		String id = prefix + random;
		return id;
	}

	/*
	 * Error Message method
	 * Takes String note as parameter
	 * Prints error message based on note
	 * Flush System.out
	 */
	public static void errorMessage(String note) {
		System.err.println("Invalid " + note + ", please try again");
		System.out.flush();
	}

	
	public static void errorMessage() {
		System.err.println("Error");
		System.out.flush();
	}

	
}
