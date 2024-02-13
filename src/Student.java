import java.io.*;
import java.util.*;

public class Student implements Comparable<Student> {
	private String name;
	private int score;
	
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}


	@Override
	public int compareTo(Student o) {
		if (this.score < o.getScore()){
			return o.getScore();
		} else {
			return this.score;
		}
	}
	
	public int getScore() {
		return score;
	}


	@Override
	public String toString() {
		return "" + name + " " + score;
	}
	
	
}
