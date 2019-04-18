import java.util.*;
import java.sql.*;

class MAINFUN
{
    public static void main(String[] args)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/OOPS_THREADING_BANK_DB","root","kalani@1998");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        // System.out.println("HRRLO");
         
    }
}