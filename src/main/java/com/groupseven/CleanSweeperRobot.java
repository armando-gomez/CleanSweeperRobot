package com.groupseven;

import com.groupseven.floorPlan.ConfigMngr;
import com.groupseven.floorPlan.Layout;
import com.groupseven.logger.Logger;
import com.groupseven.logger.LoggerFactory;
import com.groupseven.robot.Robot;

import java.io.*;
import java.util.Scanner;


public class CleanSweeperRobot {
	public static Logger logger;
	public static LoggerFactory loggerFactory = new LoggerFactory();
	public static File out = new File("log.txt");
	public static FileWriter fr = null;
	public static BufferedWriter br = null;
	public static PrintWriter pr = null;
	public static Robot robot;

	public static void main(String[] args) {
		try {
			fr = new FileWriter(out, true);
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);


			System.out.println("Welcome to Group7's Clean Sweeper Robot!");
			logger = loggerFactory.build('m');
			logger.log("Clean Sweeper Robot program", "Main");

			System.out.println("Please enter file to read room from.  Choose from : \n simple.json\n initial.json");
			Scanner in = new Scanner(System.in);
			String name = in.next();
			ConfigMngr configMngr = new ConfigMngr(name);
			robot = configMngr.makeRobot();

			//	Option to add dirt to Layout
			System.out.println("Would you like add dirt to the program?\n 1 	yes \n 2	no");
			int num = in.nextInt();
			if (num == 1) {
				// add random dirt
				System.out.println("Please enter the number of cells to alter between 0 and " + ((Layout.getInstance().getNumRows()*Layout.getInstance().getNumCols())));
				num = in.nextInt();
				configMngr.addDirt(num);
				System.out.println("Returning from adding dirt.");
			}
			else {
				System.out.println("Continuing Application");
			}
			System.out.println("Would you like to change the doors in the program?\n 1 	yes \n 2	no");
			num = in.nextInt();
			if (num == 1) {
				// add change doors

				configMngr.changeDoorArray();
				System.out.println("Returning from changing Doors.");
			}
			else {
				System.out.println("Continuing Application");
			}

			//	Shut down the program.
			logger = loggerFactory.build('s');
			logger.log("program", "Main");

			//ending logging files
			pr.close();
			br.close();
			fr.close();
			//end scanner
			in.close();


		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
