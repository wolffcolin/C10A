/*
 
Class: ScoreTrakker
Description: Reads student names and scores from a text file and parses data into object, tracks objects with arraylist and prints the students in order
Date: 2/12/2024
Collaborators: N/A
Sources: N/A
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


//ScoreTrakker class
public class ScoreTrakker {
	
	//array list of students
	private ArrayList<Student> students;
	
	//filenames to be read
	private static String[] files = {"scores.txt", "badscore.txt", "nofile.txt"};
	
	public ScoreTrakker() {
		
		students = new ArrayList<Student>();
		
	}
	
	//parses data from file into Student objects and adds to students list. throws filenotfound exception if no file
	//throws numberformatexception if the score cant be parsed into an int
	public void loadDataFile(String filename) throws FileNotFoundException {
		
		Scanner scanner = null;
		
		try {

			//open scanner
			scanner = new Scanner(new File(filename));
			
			//loop thru file
			while (scanner.hasNextLine()) {
				
				//variable setup
				String name = scanner.nextLine();
				String scoreStr = scanner.nextLine();
				
				try {
					
					//tries parsing into int
					int score = Integer.parseInt(scoreStr.trim());
					students.add(new Student(name, score));
					
				} catch (NumberFormatException e) {
					
					//exception if the score isnt an integer
					System.out.println("Incorrect format for " + name + " not a valid score: " + scoreStr);
					System.out.println();
					
				}
				
			}

			
		} finally {
			
			//closes scanner
			if (scanner != null) {
				
				scanner.close();
				
			}
			
		}
		
	}
	
	//sorts students and prints
	public void printInOrder() {
		
		System.out.println("Student Score List");
		
		//sort
		Collections.sort(students);
		
		//print
		for (Student student : students) {
			
			System.out.println(student);
			
		}
		
	}
	
	//loops thru files and calls methods on them. throws filenotfound exception if no file present
	public void processFiles(String[] files) {
		
		for (int i = 0; i < files.length; i++) {

			students.clear();
			
			try {
				
				//runs methods
				loadDataFile(files[i]);
				printInOrder();
				System.out.println();
				
			} catch (FileNotFoundException e) {
				
				System.out.println("Can't open file: " + files[i]);
				
			}
			
			
		}
		


		
	}
	
	public static void main(String[] args) {
		
		ScoreTrakker scoreTracker = new ScoreTrakker();
		scoreTracker.processFiles(files);

		
	}
	
	
}
