import java.util.*;

public class Driver extends Human
{
    // String car_name;
    // int car_id;
    Car car;

    public Driver(String name, int age, String gender, String address, int car_id, String car_name)
    {
        super(name, age, gender, address);
        // this.car_id = car_id;
        // this.car_name = car_name;
        this.car = new Car(car_id, car_name);
    }

    public void printDetails()
    {
        // System.out.println("Name : " + this.name);
        // System.out.println("Age : " + this.age);
        // System.out.println("Gender : " + this.gender);
        // System.out.println("Address : " + this.address);
        System.out.println("------------- DRIVER DETAILS ------------");
        super.printDetails();
        car.printDetails();
        // System.out.println("Car ID : " + this.car_id);
        // System.out.println("Car Name : " + this.car_name);
    }

    public static void main(String[] args)
    {
        Driver driver = new Driver("ABC", 18, "M", "Chennai", 1, "Audi");
        driver.printDetails();
    }
}