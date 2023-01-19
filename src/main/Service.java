package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class Service {
	public Student[] readFile() throws IOException  {
		Student[] data = new Student[100];
		String line;
		String iD = null;
		String name = null;
		String course = null;
		String grade = null;
		int i = 0;
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("student-master-list.csv"));
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				iD = values[0];
				name = values[1];
				course = values[2];
				grade = values[3];
				Student student = createStudent(iD,name,course,grade);
				data[i] = student;
				i++;				
			}
		} finally {
			br.close();
		}
		
		return data;
	}
	public Student createStudent(String iD, String name, String course, String grade) {
		Student student = new Student();
		student.setiD(iD);
		student.setName(name);
		student.setCourse(course);
		student.setGrade(grade);
		return student;
	}
	public Student[] sort(String course) throws IOException {
		int count = 0;
		int count2 = 0;
		Student[] myList = readFile();			
		for (Student student : myList) {
			if(student.getCourse().contains(course)) {
				count++;
			}			
		}
		Student[] sortedStudents = new Student[count];		
		for (Student student : myList) {
			if(student.getCourse().contains(course)) {
				sortedStudents[count2++] = student;				
			}			
		}
		Arrays.sort(sortedStudents);
		
		return sortedStudents;
		
	}
	public void writeFile(Student[] sortedStudents, String fileName) throws IOException {
		
		BufferedWriter br = null;
		try {
			br = new BufferedWriter(new FileWriter(fileName));
			br.write("Student ID,Student Name,Course,Grade \n");
			for (Student variable : sortedStudents) {				
				br.write(variable.getiD() + ", ");
				br.write(variable.getName()+ ", ");
				br.write(variable.getCourse()+ ", ");
				br.write(variable.getGrade() + "\n");			
			}
		}finally {
			if (br != null)br.close();
		}
	}
	
}
