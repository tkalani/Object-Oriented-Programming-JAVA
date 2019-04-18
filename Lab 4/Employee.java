import java.util.*;
import java.text.SimpleDateFormat; 

public class Employee extends Person
{
    double salary;
    int start_year;
    String national_insurance_number;
    String dob;

    public Employee(String name, long info, double salary, int start_year, String national_insurance_number, String dob)
    {
        super(name, info);
        this.salary = salary;
        this.start_year = start_year;
        this.national_insurance_number = national_insurance_number;
        this.dob = dob;
    }

    public void printDetails()
    {
        // System.out.println(employee_id);
        System.out.println("Name : " + getName());
        System.out.println("Info : " + getInfo());
        System.out.println("Salary : " + salary);
        System.out.println("Start Year : " + start_year);
        System.out.println("National Insurance Number : " + national_insurance_number);
        // System.out.println(calculate_weeks(dob));
    }

    public static int countLeapYears(int date, int month, int year)
    {
        if(month <= 2)
            year--;
        return year/4 - year/100 + year/400;
    }

    public int calculate_weeks(String dob)
    {
        System.out.println("DOB : " + dob);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date today_ = new Date();
        String[] today = String.valueOf(dateFormat.format(today_)).split("/");

        int today_day = Integer.parseInt(today[2]);
        int today_month = Integer.parseInt(today[1]);
        int today_year = Integer.parseInt(today[0]);

        // String[] dob_ = ("1998/3/13").split("/");
        String[] dob_ = dob.split("/");
        int dob_day = Integer.parseInt(dob_[2]);
        int dob_month = Integer.parseInt(dob_[1]);
        int dob_year = Integer.parseInt(dob_[0]);

        int monthDays[]= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int n1 = dob_year*365 + dob_day;
        for(int i=0; i<dob_month-1; i++)
            n1 += monthDays[i];
        n1 += countLeapYears(dob_day, dob_month, dob_year);

        int n2 = today_year*365 + today_day;
        for(int i=0; i<today_month-1; i++)
            n2 += monthDays[i];
        n2 += countLeapYears(today_day, today_month, today_year);

        return (n2-n1)/7;
    }

    public boolean equals(Object obj) { 
        if(this == obj) 
            return true; 

        if(obj == null || obj.getClass()!= this.getClass()) {
            return false; 
        }

        Employee emp = (Employee) obj; 
            
        return (emp.getName().equals(this.getName()) && emp.national_insurance_number.equals(this.national_insurance_number)); 
    } 

    public static void main(String[] args)
    {
        // System.out.println("Enter Details of Employee 1 : \n");
        // System.out.println("Enter Name : \n");
        // Scanner sc = new Scanner(System.in);
        String name = "Tanmay";
        // String name = sc.nextLine();

        // System.out.println("Enter Info : \n");
        long info = 1234;
        // long info = sc.nextLong();

        // System.out.println("Enter Salary : \n");
        // double salary = sc.nextDouble();
        double salary = 2000;

        // System.out.println("Enter start_year : \n");
        int start_year = 2016;
        // int start_year = sc.nextInt();

        // System.out.println("Enter National Insurance Number : \n");
        // sc.next();
        // String national_insurance_number = sc.nextLine();
        String national_insurance_number = "100";

        // System.out.println("Enter DOB (yyyy/MM/dd): \n");
        // sc.next();
        // String dob = sc.nextLine();
        String dob = "100-200";

        Employee employee1 = new Employee(name, info, salary, start_year, national_insurance_number, dob);
        System.out.println("Weeks : " + employee1.calculate_weeks("1998/3/13") + "\n");
        employee1.printDetails();

        System.out.println("----------");


        // System.out.println("Enter Details of Employee 2 : \n");
        // System.out.println("Enter Name : \n");
        // sc.next();
        name = "abc";
        // name = sc.nextLine();

        // System.out.println("Enter Info : \n");
        info = 4567;
        // info = sc.nextLong();

        // System.out.println("Enter Salary : \n");
        salary = 3000;
        // salary = sc.nextDouble();

        // System.out.println("Enter start_year : \n");
        start_year = 2016;
        // start_year = sc.nextInt();

        // System.out.println("Enter National Insurance Number : \n");
        // sc.next();
        // national_insurance_number = sc.nextLine();
        national_insurance_number = "300";

        // System.out.println("Enter DOB (yyyy/MM/dd): \n");
        // sc.next();
        // dob = sc.nextLine();
        dob = "1998/9/28";

        Employee employee2 = new Employee(name, info, salary, start_year, national_insurance_number, dob);
        System.out.println("Weeks : " + employee2.calculate_weeks("1998/9/28") + "\n");
        employee2.printDetails();

        System.out.println("----------");

        if(employee1.equals(employee2))
            System.out.println("same");
        else
            System.out.println("not same");
    }
}