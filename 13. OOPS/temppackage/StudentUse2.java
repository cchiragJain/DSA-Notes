package temppackage;

import oopsbasics.Student;

public class StudentUse2 {
    public static void main(String[] args) {
        Student s1 = new Student("temp", 213);
        // These are not accessible outside there own package
        // s1.name = "kuch bhi";
        // s1.rollNo = 10;

        // public
        // s1.name2 = "Hello";
    }
}
