package oopsbasics;

public class StudentUse {
	public static void main(String[] args) {
		// Student s1 = new Student(); we need to pass values now to the constructor
		System.out.println(Student.getNumStudents());

		Student s1 = new Student("chirag", 10);
		Student s2 = new Student("jain", 30);

		// System.out.println(s1.numStudents);
		// System.out.println(s2.numStudents);
		System.out.println(Student.getNumStudents());

		Student s3 = new Student("hello", 20);
		// System.out.println(s1.numStudents);
		System.out.println(Student.getNumStudents());

		// System.out.println(s1);

		// s1.name = "Chirag";
		// s1.rollNo = 10;

		// Student s2 = new Student();
		// s2.name = "Jain";
		// s2.rollNo = 50;

		// System.out.println(s1.name + " " + s1.getRollNo());
		// System.out.println(s2.name + " " + s2.getRollNo());

		// s1.setRollNo(10);
		// s2.setRollNo(50);

		// System.out.println(s1.name + " " + s1.getRollNo());
		// System.out.println(s2.name + " " + s2.getRollNo());

		// Student s3 = new Student("hello tehre");
		// System.out.println(s3.name + " " + s3.getRollNo());

		// s1.conversionFactor = 0.98; can't do this

	}
}