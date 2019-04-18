import java.util.*;

public class Participant
{
    private String name, address, gender, email, mobile_no, batch;
    private int participant_id, age;
    private static int number_of_events;
    public ArrayList<Event> events_list = new ArrayList<Event>();

    public static int id = 0;

    public Participant(String name, String address, String gender, String email, String mobile_no, String batch, int age, int number_of_events)
    {
        id += 1;
        this.setParticipantID(id);
        this.setName(name);
        this.setAddress(address);
        this.setGender(gender);
        this.setEmail(email);
        this.setMobileNo(mobile_no);
        this.setBatch(batch);
        this.setAge(age);
        this.setEventCount(0);
    }

    void setParticipantID(int id) { this.participant_id = id; }
    void setName(String name) { this.name = name; }
    void setAddress(String address) { this.address = address; }
    void setGender(String gender) { this.gender = gender; }
    void setEmail(String email) { this.email = email; }
    void setMobileNo(String mobile_no) { this.mobile_no = mobile_no; }
    void setBatch(String batch) { this.batch = batch; }
    void setAge(int age) { this.age = age; }
    void setEventCount(int number_of_events) { this.number_of_events = number_of_events; }
    
    int getParticipantID() { return this.participant_id; }
    String getName() { return this.name; }
    String getAddress() { return this.address; }
    String getGender() { return this.gender; }
    String getEmail() { return this.email; }
    String getMobileNo() { return this.mobile_no; }
    String getBatch() { return this.batch; }
    int getAge() { return this.age; }
    int getEventCount() { return this.events_list.size(); }

    void printParticipantAbstractDetails()
    {
        String str = getParticipantID() + " -- " + getName() + " -- " + getAddress() + " -- " + getGender() + " -- ";
        str += getEmail() + " -- " + getMobileNo() + " -- " + getBatch() + " -- " + getAge() + " -- ";
        System.out.println(str);
    }

    void printParticipantDetails()
    {
        System.out.println("----------------- PARTICIPANT DETAILS ----------------");
        System.out.println("Participant ID : " + getParticipantID());
        System.out.println("Name : " + getName());
        System.out.println("Address : " + getAddress());
        System.out.println("Gender : " + getGender());
        System.out.println("Email : " + getEmail());
        System.out.println("Mobile No. : " + getMobileNo());
        System.out.println("Batch : " + getBatch());
        System.out.println("Age : " + getAge());
        System.out.println("Number of events participated : " + getEventCount());
    }

    public void addEventToParticipantList(Event event)
    {
        events_list.add(event);
    }

    public void showAllEvents()
    {
        System.out.println("----- EVENTS FOR PARTICIPANT : " + participant_id + " ------------");
        for(int i=0; i<events_list.size(); i++)
            events_list.get(i).printEventDetails();
    }

    public boolean checkIfPaperPresentationAlreadyExists()
    {
        for(int i=0; i<events_list.size(); i++)
            if(events_list.get(i).getType() == "PAPER_PRESENTATION")
                return true;
        return false;
    }

    public boolean checkIfPosterPresentationAlreadyExists()
    {
        for(int i=0; i<events_list.size(); i++)
            if(events_list.get(i).getType() == "POSTER_PRESENTATION")
                return true;
        return false;
    }

    public int getNumberOfEventsRegistered()
    {
        return events_list.size();
    }
}