package gradedStudentGradebook;

public class Tester {
    public static void main(String[] args) {
        Student student = new Student("johnny appleseed", 90, 85, 70, 80);
        Student student2 = new Student("ur mother", 70, 60, 75, 67);
        Student student3 = new Student("obama-kun", 56, 100, 23, 89);
        Gradebook gradebook = new Gradebook();
        gradebook.addStudent(student);
        gradebook.addStudent(student2);
        gradebook.addStudent(student3);
        gradebook.display();
    }
}
