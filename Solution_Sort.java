package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution_Sort {

	// Complete the code
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		List<Student> studentList = new ArrayList<Student>();
		while (testCases > 0) {
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();

			Student st = new Student(id, fname, cgpa);
			studentList.add(st);

			testCases--;
		}

		studentList = studentList.stream().sorted((x, y) -> {
			if (x.getCgpa() != y.getCgpa()) {
				return Double.valueOf(y.getCgpa()).compareTo(x.getCgpa());
			} else if (!x.getFname().equals(y.getFname())) {
				return x.getFname().compareTo(y.getFname());
			} else {
				return Integer.valueOf(y.getId()).compareTo(x.getId());
			}
		}).collect(Collectors.toList());
		for (Student st : studentList) {
			System.out.println(st.getFname());
		}
	}
}

class Student {
	private int id;
	private String fname;
	private double cgpa;

	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}
}

