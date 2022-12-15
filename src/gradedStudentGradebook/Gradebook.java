/**
 * Author: Caasi Boakye
 * Date:   Dec 6, 2022
 * Description: 
 */
package gradedStudentGradebook;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author studentgvsc
 *
 */
public class Gradebook {
    private ArrayList<Student> studentGradeBook = new ArrayList<Student>();

    public void addStudent(Student student) {
        studentGradeBook.add(student);
    }

    public void removeStudent(Student student) {
        studentGradeBook.remove(studentGradeBook.indexOf(student));
    }

    public void changeStudentGrade(Student student, int gradeToChange, int newGrade) {
        int oldGradeIndex = student.getGrades().indexOf(gradeToChange);
        student.getGrades().set(oldGradeIndex, newGrade);
    }

    public void display() {
        Student currStudent;
        System.out.println(" (ID)\t\tStudent\t\t\t\tExam 1\t\tExam 2\t\tExam 3\t\tFinal Exam\t\tAverage");
        for (int i = 0; i < studentGradeBook.size(); i++) {
            currStudent = studentGradeBook.get(i);
            System.out.printf("(%04d)\t%-25s%d\t\t\t%d\t\t\t%d\t\t\t%d\t\t\t\t%.2f\n", currStudent.getID(), currStudent.getName(), currStudent.getGrades().get(0), currStudent.getGrades().get(1), currStudent.getGrades().get(2), currStudent.getGrades().get(3), currStudent.getAverageGrade());
        }
    }


}
