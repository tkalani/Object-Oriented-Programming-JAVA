import java.util.*;

public class Quiz extends Event
{
    private static ArrayList<Participant> participants_list = new ArrayList<Participant>();
    private int max_marks;

    public Quiz(String type, String name, String time, int duration, int max_marks)
    {
        super(type, name, time, duration);
        this.setMaxMarks(max_marks);
    }

    void setMaxMarks(int max_marks) { this.max_marks = max_marks; }

    int getMaxMarks() { return this.max_marks; }

    public void addParticipant(Participant obj_participant)
    {
        if(obj_participant.getNumberOfEventsRegistered() < 3)
        {
            if(participants_list.contains(obj_participant))
                System.out.println("-- Participant ( " + obj_participant.getParticipantID() + " ) Already Listed --");
            else
            {
                participants_list.add(obj_participant);
                obj_participant.addEventToParticipantList(this);
                System.out.println("-- Participant ( " + obj_participant.getParticipantID() + " ) Added --");
            }
        }
        else
        {
            System.out.println("----------- STUDENT CAN BE REGISTERED IN MAXIMUM 3 EVENTS ---------------");
        }
        
    }

    public void showParticularEventDetails()
    {
        System.out.println("----------- ALL QUIZ PRESENTATION EVENTS ---------------");
        super.printEventDetails();
        System.out.println("Max Marks : "+getMaxMarks());
    }

    public void showAllParticipants()
    {
        System.out.println("----------- QUIZ PRESENTATION DETAILS ---------------");
        super.printEventDetails();
        System.out.println("----------- ALL PARTICPANTS ( " + participants_list.size() + " ) ------------");
        for(int i=0; i<participants_list.size(); i++)
        {
            System.out.println("----- PARTICPANTS : " + (i+1) + " ------------");
            participants_list.get(i).printParticipantDetails();
        }
    }
}