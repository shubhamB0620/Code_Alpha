package Task1;
import java.util.ArrayList;
import java.util.Scanner;

class StudentGradeTracker{
            // {90, 85, 75, 85, 95}, {100, 85, 75, 55, 95}, {55, 85, 65, 85, 95},
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();
        System.out.println("Welcome to the Student Grade Tracker\n");
        // Adding students
        while (true) {
            System.out.print("Enter student name (or 'done' to finish): ");
            String studentName = input.nextLine();

            if (studentName.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter comma-separated grades for " + studentName + ": ");
            String[] gradesInput = input.nextLine().split(",");
            ArrayList<Double> studentGrades = new ArrayList<>();

            for (String grade : gradesInput) {
                studentGrades.add(Double.parseDouble(grade.trim()));
            }

            Student.addStudent(studentList, studentName, studentGrades);
        }

        
        // Displaying student information
        System.out.println("\n------------------Student Information:--------------------");

        for (Student s : studentList) {
            System.out.println("\nStudent Name: " + s.name);
            System.out.println("Grades: " + s.grades);
            System.out.println("Average: " + Student.Avg(s.grades));
            System.out.println("Lowest Grade: " + Student.getLowGrad(s.grades));
            System.out.println("Highest Grade: " + Student.getHighGrad(s.grades));
            System.out.println("Grade Letter: " + Student.gradeLetter(s.grades));
            System.out.println("-----------------------");
        }

        input.close();
    }
}