import java.io.*;
import java.util.Scanner;


public class CleanSweeperRobot {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Group7's Clean Sweeper Robot!");

		System.out.println("Please enter file to read room from.  Choose from : \n simple.json\n initial.json");
		Scanner in = new Scanner(System.in);
		String name = in.next();
		ConfigMngr configMngr = new ConfigMngr(name);
	}
}
