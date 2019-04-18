public class Author extends Human
{
    public Author(String name, int age, String gender, String address)
    {
        super(name, age, gender, address);
    }

    public void printDetails()
    {
        System.out.println("------------- AUTHOR DETAILS ------------");
        super.printDetails();
    }
}