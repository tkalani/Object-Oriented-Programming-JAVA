import java.util.*;

public class Person
{
    private String name;
    private long info;

    public Person(String name, long info) 
    {
        this.setName(name);
        this.setInfo(info);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setInfo(long info)
    {
        this.info = info;
    }

    public String getName()
    {
        return name;
    }

    public long getInfo()
    {
        return info;
    }
}

