package Task1;
import java.util.ArrayList;
//Develop a program that allows a teacher to enter students' grades and
//compute their average, highest, and lowest scores. You can use arrays
//or ArrayLists to store the student data.
public class Student {
    String name;
    ArrayList<Double> grades;
    public Student(){}
    public Student(String name, ArrayList<Double> grades) {
        this.name = name;
        this.grades = grades;
    }

    public static void addStudent(ArrayList<Student> studentList, String name, ArrayList<Double> grades) {
        Student newStudent = new Student(name, grades);
        studentList.add(newStudent);
    }

    // Get low, high, and average grades
    public static double getLowGrad(ArrayList<Double> grades) {
        double result = grades.get(0);
        for (double number : grades) {
            if (number < result) {
                result = number;
            }
        }
        return result;
    }

    public static double getHighGrad(ArrayList<Double> grades) {
        double result = grades.get(0);
        for (double number : grades) {
            if (number > result) {
                result = number;
            }
        }
        return result;
    }

    public static double Avg(ArrayList<Double> numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }
    
    // Grade A, B, C
    public static char gradeLetter(ArrayList<Double> numbers) {
        double avg = Avg(numbers);
        char result;
        if (avg >= 90) {
            result = 'A';
        } else if (avg >= 80) {
            result = 'B';
        } else if (avg >= 70) {
            result = 'C';
        } else if (avg >= 65) {
            result = 'D';
        } else {
            result = 'F';
        }
        return result;
    }

}