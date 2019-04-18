import java.util.*;

public class Event
{
    private String type, name, time;
    private int duration;

    public Event(String type, String name, String time, int duration)
    {
        this.setType(type);
        this.setName(name);
        this.setTime(time);
        this.setDuration(duration);
    }

    void setType(String type) { this.type = type; }
    void setName(String name) { this.name = name; }
    void setTime(String time) { this.time = time; }
    void setDuration(int duration) { this.duration = duration; }

    String getType() { return this.type; }
    String getName() { return this.name; }
    String getTime() { return this.time; }
    int getDuration() { return this.duration; }

    void printEventAbstractDetails()
    {
        String str = getType() + " -- " + getName() + " -- " + getTime() + " -- " + getDuration();
        System.out.println(str);
    }

    void printEventDetails()
    {
        System.out.println("----------------- EVENT DETAILS ----------------");
        System.out.println("Event Type : " + getType());
        System.out.println("Name : " + getName());
        System.out.println("Time : " + getTime());
        System.out.println("Duration : " + getDuration());
    }
}