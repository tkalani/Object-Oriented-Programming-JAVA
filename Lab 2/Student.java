import java.util.HashMap;

public class Student {

    private String name;
    private String dateOfJoin;
    private String branch;
    private String rollNo;

    private Double cgpa;

    private HashMap<Integer, HashMap<Integer, Double>> marks;

    public Student(String name, String branch) {

        this.name = name;
        this.branch = branch;

        this.cgpa = -1.0;
    }

    public void inputExamMarks(HashMap<Integer, HashMap<Integer, Double>> marks) {

        this.marks = marks;
    }

    public double calulateCGPA() {

        if (this.marks == null)
            return -1.0;

        cgpa = 0.0;
        for (HashMap<Integer, Double> sem : marks.values()) {

            double sgpa = 0.0;
            for (Integer i : sem.keySet()) {
                sgpa += sem.get(i);
            }
            sgpa = sgpa / 10;
            cgpa = cgpa + sgpa;
        }
        cgpa = cgpa / marks.size();
        return cgpa;
    }
}