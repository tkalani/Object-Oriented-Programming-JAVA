import java.util.*;

public class PaperPresentation extends Event
{
    private static ArrayList<Participant> participants_list = new ArrayList<Participant>();

    public PaperPresentation(String type, String name, String time, int duration)
    {
        super(type, name, time, duration);
    }

    public int getNoOfPartipantsByGender(String gender)
    {
        int count = 0;
        for(int i=0; i<participants_list.size(); i++)
            if(participants_list.get(i).getGender() == gender)
                count++;
        return count;
    }

    public void addParticipant(Participant obj_participant)
    {
        if(obj_participant.getNumberOfEventsRegistered() < 3)
        {
            int permit = 0;
            if(obj_participant.getGender() == "M")
                if(getNoOfPartipantsByGender("M") < 6)
                    permit = 1;
                else
                    permit = 0;
            else    
                if(getNoOfPartipantsByGender("F") < 4)
                    permit = 1;
                else
                    permit = 0;
            if(permit == 1)
            {
                if(obj_participant.getBatch() != "UG4")
                {
                    System.out.println("-- Participant ( " + obj_participant.getParticipantID() + " ) is not a UG4 Student. --");
                }
                else
                {
                    if(obj_participant.checkIfPosterPresentationAlreadyExists())
                    {
                        System.out.println("-- Participant ( " + obj_participant.getParticipantID() + " ) Already Listed in Poster Presentation --");
                    }
                    else
                    {
                        if(Collections.frequency(participants_list, obj_participant) >= 2)
                            System.out.println("-- Participant ( " + obj_participant.getParticipantID() + " ) Already Listed in 2 Topics --");
                        else
                        {
                            participants_list.add(obj_participant);
                            obj_participant.addEventToParticipantList(this);
                            System.out.println("-- Participant ( " + obj_participant.getParticipantID() + " ) Added --");
                        }
                    }   
                }
            }
            else
            {
                System.out.println("-- Participant ( " + obj_participant.getParticipantID() + " ) Cannot be listed - Gender Limit Reached --");
            }
        }
        else
        {
            System.out.println("----------- STUDENT CAN BE REGISTERED IN MAXIMUM 3 EVENTS ---------------");
        }
    }

    public void showParticularEventDetails()
    {
        System.out.println("----------- PAPER PRESENTATION EVENT DETAIL ---------------");
        super.printEventDetails();
    }

    public void showAllParticipants()
    {
        System.out.println("----------- PAPER PRESENTATION DETAILS ---------------");
        super.printEventDetails();
        System.out.println("----------- ALL PARTICPANTS ( " + participants_list.size() + " ) ------------");
        for(int i=0; i<participants_list.size(); i++)
        {
            System.out.println("----- PARTICPANTS : " + (i+1) + " ------------");
            participants_list.get(i).printParticipantDetails();
        }
    }
}