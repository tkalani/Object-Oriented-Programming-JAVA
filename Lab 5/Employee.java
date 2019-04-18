import java.util.*;

public class Employee extends Human
{
    int eno;
    String ename, department;

    public Employee(int age, String gender, String address, int eno, String ename, String department)
    {
        super(ename, age, gender, address);
        this.eno = eno;
        this.ename = ename;
        this.department = department;
    }

    public void printDetails()
    {
        // System.out.println("Name : " + this.name);
        // System.out.println("Age : " + this.age);
        // System.out.println("Gender : " + this.gender);
        // System.out.println("Address : " + this.address);
        
        super.printDetails();
        System.out.println("------------- EMPLOYEE DETAILS ------------");
        System.out.println("E No : " + this.eno);
        System.out.println("E Name : " + this.ename);
        System.out.println("Department : " + this.department);
    }

    public static void main(String[] args)
    {
        Employee employee = new Employee(18, "M", "Chennai", 1, "ABC", "Finance");
        employee.printDetails();
    }
}