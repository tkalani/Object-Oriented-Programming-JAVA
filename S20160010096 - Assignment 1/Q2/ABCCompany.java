import java.util.*;

public class ABCCompany
{
    private double base_pay, hours_worked;
    public ArrayList<Double> base_pay_list = new ArrayList<>();

    public ABCCompany()
    {

    }

    public ABCCompany(double base_pay, double hours_worked)
    {
        this.setBasePay(base_pay);
        this.setHoursWorked(hours_worked);
        this.base_pay_list.add(base_pay);
    }

    void setBasePay(double base_pay) { this.base_pay = base_pay; }
    void setHoursWorked(double hours_worked) { this.hours_worked = hours_worked; }

    double getBasePay() { return this.base_pay; }
    double getHoursWorked() { return this.hours_worked; }

    public void getTotalPay()
    {
        double total_pay = 0;
        if(this.getBasePay() < 400)
            System.out.println("Base Pay is less than minimum wage.");
        else if(this.getHoursWorked() > 60)
            System.out.println("Hours worked is more than 60 hrs.");
        else
        {
            if(this.getHoursWorked() < 40)
                total_pay = this.getBasePay() * this.getHoursWorked();
            else
            {
                total_pay = this.getBasePay() * 40;
                total_pay += (1.5 * this.getBasePay())*(this.getHoursWorked()-40);
                System.out.println("Total Pay : "+total_pay);
            }
        }
        if(this.getBasePay() < 0.7*Collections.max(base_pay_list))
        {
            DiwaliEmployee obj_diwali_employee = new DiwaliEmployee(this);
            obj_diwali_employee.getDiwaliBonus();
        }
    }

    public static void main(String[] args)
    {
        ABCCompany employee1 = new ABCCompany(485, 55);
        ABCCompany employee2 = new ABCCompany(350, 47);
        ABCCompany employee3 = new ABCCompany(415, 60);
        ABCCompany employee4 = new ABCCompany(499, 67);
        ABCCompany employee5 = new ABCCompany(420, 55);

        System.out.println("Employee 1 : ");
        employee1.getTotalPay();

        System.out.println("Employee 2 : ");
        employee2.getTotalPay();

        System.out.println("Employee 3 : ");
        employee3.getTotalPay();

        System.out.println("Employee 4 : ");
        employee4.getTotalPay();

        System.out.println("Employee 5 : ");
        employee5.getTotalPay();
    }
}

class DiwaliEmployee extends ABCCompany
{
    public ABCCompany obj_abc_company;
    public DiwaliEmployee(ABCCompany obj_abc_company)
    {
        this.obj_abc_company = obj_abc_company;
    }

    public void getDiwaliBonus()
    {
        double diwali_bonus = 0.2 * this.obj_abc_company.getBasePay();
        // double diwali_bonus = 0.2 * super.getBasePay();
        System.out.println("Diwali Bonus : " + diwali_bonus);
    }
}