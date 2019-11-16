package com.groupseven;

import com.groupseven.floorplan.FileParser;
import com.groupseven.floorplan.Layout;
import com.groupseven.robot.Robot;
import com.groupseven.sensorsimulator.SensorSimulator;

import java.util.Scanner;

public class CleanSweeper {
	private static Scanner in;
	private static Layout layout;

	public static void main(String[] args) {
		try {
			System.out.println("Welcome to Group7's Clean Sweeper Robot!");
			in = new Scanner(System.in);
			System.out.println("Please type the file name of the room you would like to explore: ");
			String fileName = in.nextLine();

			layout = FileParser.parseFile(fileName);
			Robot robot = new Robot(SensorSimulator.getInstance(layout));

			System.out.print("Would you like to start cleaning? y/n: ");
			String response;
			do {
				response = in.next();
				if(response.equals("y") || response.equals("Y")) {
					robot.start();
					break;
				} else {
					System.out.println();
					System.out.print("Would you like to start cleaning? y/n: ");
				}
			} while(!(response.equals("y") || response.equals("Y")));



		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
