import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class ScoreTrakker {
	
	private ArrayList<Student> students;
	
	private static String[] files = {"scores.txt", "badscore.txt", "nofile.txt"};
	
	public ScoreTrakker() {
		
		students = new ArrayList<Student>();
		
	}
	
	public void loadDataFile(String filename) throws FileNotFoundException {
		
		Scanner scanner = null;
		
		try {

			scanner = new Scanner(new File(filename));
			
			while (scanner.hasNextLine()) {
				
				String name = scanner.nextLine();
				String scoreStr = scanner.nextLine();
				
				try {
					
					int score = Integer.parseInt(scoreStr.trim());
					students.add(new Student(name, score));
					
				} catch (NumberFormatException e) {
					
					System.out.println("Incorrect format for " + name + " not a valid score: " + scoreStr);
					System.out.println();
					
				}
				
			}

			
		} finally {
			
			if (scanner != null) {
				
				scanner.close();
				
			}
			
		}
		
	}
	
	public void printInOrder() {
		
		System.out.println("Student Score List");
		
		Collections.sort(students);
		
		for (Student student : students) {
			
			System.out.println(student);
			
		}
		
	}
	
	public void processFiles(String[] files) {
		
		for (int i = 0; i < files.length; i++) {

			students.clear();
			
			try {
				
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
