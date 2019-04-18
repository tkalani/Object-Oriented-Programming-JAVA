import java.util.*;

public class Cultural extends Event
{
    private static ArrayList<ArrayList<Participant>> participants_list = new ArrayList<>();
    // private static ArrayList<Event> all_cultural_programs = new ArrayList<>();

    public Cultural(String type, String name, String time, int duration)
    {
        super(type, name, time, duration);
        ArrayList new_cultural_program_participant_list = new ArrayList<>();
        participants_list.add(new_cultural_program_participant_list);
        // all_cultural_programs.add(this);
    }

    public void showParticularEventDetails()
    {
        System.out.println("----------- ALL CULTURAL PROGRAMS ---------------");
        super.printEventDetails();
    }

    public void addParticipant(int index, Participant obj_participant)
    {
        if(obj_participant.getNumberOfEventsRegistered() < 3)
        {
            participants_list.get(index).add(obj_participant);
            obj_participant.addEventToParticipantList(this);
            System.out.println("-- Participant ( " + obj_participant.getParticipantID() + " ) Added --");
        }
        else
        {
            System.out.println("----------- STUDENT CAN BE REGISTERED IN MAXIMUM 3 EVENTS ---------------");
        }   
    }

    public void showAllParticipants(int index)
    {
        for(int i=0; i<participants_list.get(index).size(); i++)
            participants_list.get(index).get(i).printParticipantDetails();
    }
}