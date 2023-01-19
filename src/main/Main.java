package main;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Service service = new Service();
		Student[] sortedCompSciStudents = service.sort("COMPSCI");
		service.writeFile(sortedCompSciStudents, "course1.csv");
		Student[] sortedAPMTHStudents = service.sort("APMTH");
		service.writeFile(sortedAPMTHStudents, "course2.csv");
		Student[] sortedSTATStudents = service.sort("STAT");
		service.writeFile(sortedSTATStudents, "course3.csv");
		
//		for(Student item : myList) {
//			
//			System.out.println(item);
//		}
		
	}
}
