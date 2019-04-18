public class Car
{
    int car_id;
    String car_name;

    public Car(int car_id, String car_name)
    {
        this.car_id = car_id;
        this.car_name = car_name;
    }

    public void printDetails()
    {
        System.out.println("------------- CAR DETAILS ------------");
        System.out.println("Car ID : " + this.car_id);
        System.out.println("Car Name : " + this.car_name);
    }
}