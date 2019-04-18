public class Student extends Human
{
    int roll_no;

    public Student(String name, int age, String gender, String address, int roll_no)
    {
        super(name, age, gender, address);
        this.roll_no = roll_no;
        
    }

    public Student(String name, int age, String gender, String address)
    {
        super(name, age, gender, address);
        System.out.println("No Roll Number given");
    }

    public void printDetails()
    {
        super.printDetails();
        System.out.println("------------- STUDENT DETAILS ------------");
        System.out.println("Student Roll No : " + this.roll_no);
    }

    public static void main(String[] args)
    {
        Student student = new Student("Tanmay", 21, "M", "Jaipur", 96);
        student.printDetails();

        Student student1 = new Student("Tanmay", 21, "M", "Jaipur");
        student1.printDetails();
    }
}