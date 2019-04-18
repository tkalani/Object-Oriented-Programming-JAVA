import java.util.HashMap;

public class Question1 {

    public static void main(String[] args) {

        Student student = new Student("Tanmay Kalani", "CSE");

        HashMap<Integer, HashMap<Integer, Double>> marks = new HashMap<>();
        for (int i = 0; i < 6; i++) {

            HashMap<Integer, Double> sem = new HashMap<>();
            sem.put(0, 15.0);
            sem.put(1, 11.0);
            sem.put(2, 17.0);
            sem.put(3, 21.0);
            sem.put(4, 26.0);

            marks.put(i, sem);
        }

        student.inputExamMarks(marks);

        System.out.println(student.calulateCGPA());
    }
}