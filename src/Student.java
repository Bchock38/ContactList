import java.util.ArrayList;

// A Student is a Person with a grade.

public class Student extends Person {

    // Instance variables
    private int grade;

    // Constructors
    public Student(String firstName, String lastName, int grade, String phoneNumber){
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    // Methods

    //return grade
    public int getGrade() {
        return grade;
    }

    //set grade
    public void setGrade(int grade) {
        this.grade = grade;
    }

    //create to string
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }


}
