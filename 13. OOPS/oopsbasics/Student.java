package oopsbasics;

public class Student {
	// private int rollNo; will be accessible only here
	// int rollNo; this has default access modifier

	// public String name2;
	// private int rollNo2;

	String name;
	final private int rollNo;
	// for conversion factor it makes sense for it to be a final type variable
	// also since it will remain same this should be static as well
	final static double CONVERSIONFACTOR = 0.95;
	// numStudents belong to the class and not to the object
	// if numStudents was not static each object will have its own copy of numStudents with value = 1
	private static int numStudents;

	public Student(String name, int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
		// this.conversionFactor = 0.98; can't do this since variable is declared final
		numStudents++;

		// we can even skip taking rollNo now and just use numStudents as the count of rollNo
	}

	// public Student(String name) {
	// 	this.name = name;
	// }

	// public Student() {
	// 	this.name = "default";
	// }

	public int getRollNo() {
		return this.rollNo;
	}

	// public void setRollNo(int num) {
	// 	if (num <= 0) {
	// 		// using setters we can have control over how properties are set
	// 		return;
	// 	}
	// 	rollNo = num;
	// }

	// public void setRollNo(int rollNo) {
	// 	if (rollNo <= 0) {
	// 		return;
	// 	}
	// 	// this.rollNo = rollNo;
	// }

	public static int getNumStudents() {
		return numStudents;
	}
}