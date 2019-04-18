import java.util.*;

public class SumOfNaturalNumber
{
    public static int calculateSum(int n)
    {
        if(n == 1)
            return n;
        
        return n+calculateSum(n-1);
    }

    public static void main(String[] args)
    {
        System.out.println("Enter Number : \n");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(calculateSum(n));
    }
}