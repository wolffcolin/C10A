/*
 
Class: Student 
Description: Holds name and score for each student. compareTo method is implemented from 
Comparable and compares two students based on score.
Authors: Colin Wolff and Matt McGrath
Date: 2/12/2024
Collaborators: N/A
Sources: N/A
*/

import java.io.*;
import java.util.*;

public class Student implements Comparable<Student> {
	private String name; //Student Name
	private int score; //Student score
	
	
	public Student(String name, int score) { //Class Constructor
		this.name = name;
		this.score = score;
	}

/*Method compares two students based on score. If current student score is less
 * than the reference student's score, then it returns -1. If it is greater, it returns 1.
 * If the scores are the same, returns 0
*/
	@Override
    public int compareTo(Student o) {
        if (this.score < o.getScore()){
            return -1;
        } else if (this.score > o.getScore()) {
            return 1;
        } else {
            return 0;
        }
    }
	//Getter for score
	public int getScore() {
		return score;
	}

//To string method prints name and score
	@Override
	public String toString() {
		return "" + name + " " + score;
	}
	
	
}