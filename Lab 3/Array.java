import java.util.*;

public class Array
{
    int[] arr;

    public Array(int[] array)
    {
        this.arr = array;
        this.printArray();
    }

    public void printArray()
    {
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + ", ");
        System.out.println();
    }

    public void encode1()
    {
        int[] encoded_arr = new int[arr.length];
        for(int i=0; i<arr.length; i++)
            encoded_arr[i] = arr[i]*2;
        Array enc_arr = new Array(encoded_arr);
    }

    public void encode2()
    {
        int[] encoded_arr = new int[arr.length];
        for(int i=0; i<arr.length; i++)
            encoded_arr[i] = arr[i]*arr[i] + arr[i] + 3;
        Array enc_arr = new Array(encoded_arr);
    }

    public int findThirdLowest()
    {
        Arrays.sort(arr);
        return arr[2];
    }

    public void reverseArray()
    {
        int[] reversed_arr = new int[arr.length];
        for(int i=0; i<arr.length; i++)
            reversed_arr[i] = arr[arr.length-i-1];
        Array rev_arr = new Array(reversed_arr);
    }

    public static void main(String[] args)
    {
        int[] intArray = new int[]{ 21,22,23,24,25,26,27,28,29,30 };
        Array arr = new Array(intArray);
        arr.encode1();
        arr.encode2();
        System.out.println(arr.findThirdLowest());
        arr.reverseArray();
    }
}