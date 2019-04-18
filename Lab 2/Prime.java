import java.util.*;

public class Prime
{
    static boolean isPrime(int n)
    {
        for(int i=2; i*i<=n; i++)
            if(n%i == 0)
                return false;
        return true;
    }

    static void findNumbers(int n)
    {
        for(int i=1; i<=(n/2); i++)
            if( isPrime(i) && isPrime(n-i) )
                System.out.println(i + " + " + (n-i));
    }

    public static void main(String[] args)
    {
        System.out.println("Enter Number : \n");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        findNumbers(n);
    }
}