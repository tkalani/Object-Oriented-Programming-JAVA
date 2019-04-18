public class Book
{
    Author auth;
    String name;
    float price;

    public Book(String name, int age, String gender, String address, String book_name, float price)
    {
        this.auth = new Author(name, age, gender, address);
        this.name = book_name;
        this.price = price;
    }

    public void printDetails()
    {
        auth.printDetails();
        System.out.println("------------- BOOK DETAILS ------------");
        System.out.println("Book Name : " + this.name);
        System.out.println("Book Price : " + this.price);
    }

    public static void main(String[] args)
    {
        Book book = new Book("ABC", 18, "M", "Chennai", "Java OOPS", 100);
        book.printDetails();
    }
}