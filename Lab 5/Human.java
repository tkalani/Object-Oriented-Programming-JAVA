import java.util.*;

public class Human
{
    int age;
    String name, gender, address;
    

    public Human(String name, int age, String gender, String address)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public void printDetails()
    {
        System.out.println("------------- HUMAN DETAILS ------------");
        System.out.println("Name : " + this.name);
        System.out.println("Age : " + this.age);
        System.out.println("Gender : " + this.gender);
        System.out.println("Address : " + this.address);
    }
}