import java.util.*;

public class Registration
{
    private static ArrayList<Participant> participants_list = new ArrayList<Participant>();
    public static ArrayList<Event> all_events = new ArrayList<>();
    private static ArrayList<Cultural> all_cultural_programs = new ArrayList<>();
    private static ArrayList<PaperPresentation> all_paper_presentation_programs = new ArrayList<>();
    private static ArrayList<PosterPresentation> all_poster_presentation_programs = new ArrayList<>();
    private static ArrayList<Quiz> all_quiz_programs = new ArrayList<>();

    public static void registerParticipant(String name, String address, String gender, String email, String mobile_no, String batch, int age, int number_of_events)
    {
        Participant obj_participant = new Participant(name, address, gender, email, mobile_no, batch, age, number_of_events);
        participants_list.add(obj_participant);
        System.out.println("-- Participant Added Successfully --");
        // obj_participant.printParticipantDetails();
    }

    public static void createPaperPresentation(String topic, String time, int duration)
    {
        PaperPresentation obj_paperpresentation = new PaperPresentation("PAPER_PRESENTATION", topic, time, duration);
        System.out.println("-- Paper Presentation Event Scheduled Successfully --");
        all_paper_presentation_programs.add(obj_paperpresentation);
        // obj_paperpresentation.showParticularEventDetails();
        all_events.add(obj_paperpresentation);
        // return obj_paperpresentation;
    }

    public static void createQuiz(String topic, String time, int duration, int max_marks)
    {
        Quiz obj_quiz = new Quiz("QUIZ", topic, time, duration, max_marks);
        System.out.println("-- Quiz Event Scheduled Successfully --");
        all_quiz_programs.add(obj_quiz);
        // obj_quiz.showParticularEventDetails();
        all_events.add(obj_quiz);
        // return obj_quiz;
    }

    public static void createPosterPresentation(String topic, String time, int duration)
    {
        PosterPresentation obj_posterpresentation = new PosterPresentation("POSTER_PRESENTATION", topic, time, duration);
        System.out.println("-- Poster Presentation Event Scheduled Successfully --");
        // obj_posterpresentation.showParticularEventDetails();
        all_events.add(obj_posterpresentation);
        all_poster_presentation_programs.add(obj_posterpresentation);
        // return obj_posterpresentation;
    }

    public static void createCulturalProgram(String name, String time, int duration)
    {
        Cultural obj_cultural = new Cultural("CULTURAL_PROGRAM", name, time, duration);
        all_cultural_programs.add(obj_cultural);
        all_events.add(obj_cultural);
        System.out.println("-- Cultural Program Scheduled Successfully --");
        // obj_cultural.showParticularEventDetails();
        // return obj_cultural;
    }

    public static void addToPaperPresentation(PaperPresentation obj_paperpresentation, Participant obj_participant)
    {
        obj_paperpresentation.addParticipant(obj_participant);
    }

    public static void addToQuiz(Quiz obj_quiz, Participant obj_participant)
    {
        obj_quiz.addParticipant(obj_participant);
    }

    public static void addToPosterPresentation(PosterPresentation obj_posterpresentation, Participant obj_participant)
    {
        obj_posterpresentation.addParticipant(obj_participant);
    }

    public static void addToCulturalProgram(Cultural obj_cultural, Participant obj_participant)
    {
        int index = 0;
        for(int i=0; i<all_cultural_programs.size(); i++)
            if(all_cultural_programs.get(i) == obj_cultural)
                index = i;
        obj_cultural.addParticipant(index, obj_participant);
    }

    public static void checkCreatePaperPresentationConditions()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Topic : ");
        String topic = sc.nextLine();

        System.out.print("Enter Time (Morning / Evening) : ");
        String time = sc.nextLine();

        int duration = 15;

        createPaperPresentation(topic, time, duration);
        // showAllEvents();
        startRegistration();
    }

    public static void checkCreatePosterPresentationConditions()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Topic : ");
        String topic = sc.nextLine();

        System.out.print("Enter Time (Morning / Evening) : ");
        String time = sc.nextLine();

        int duration = 15;

        createPosterPresentation(topic, time, duration);
        // showAllEvents();
        startRegistration();
    }

    public static void checkCreateQuizConditions()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Topic : ");
        String topic = sc.nextLine();

        System.out.print("Enter Time (1. Morning / 2. Evening) : ");
        int time_id = sc.nextInt();

        if(time_id != 2)
        {
            System.out.println("Quiz can only be scheduled in 2nd (Evening) half.");
            startRegistration();
        }
        String time = "Evening";

        System.out.print("Enter Max Marks : ");
        int max_mark = sc.nextInt();

        if(max_mark > 30)
        {
            System.out.println("Max Mark limit is 30.");
            startRegistration();
        }

        int duration = 30;
        createQuiz(topic, time, duration, max_mark);
        // showAllEvents();
        startRegistration();
    }

    public static void checkCreateCulturalConditions()
    {
        if(all_cultural_programs.size() < 5)
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Topic : ");
            String topic = sc.nextLine();

            System.out.print("Enter Time (1. Morning / 2. Evening) : ");
            int time_id = sc.nextInt();

            if(time_id != 2)
            {
                System.out.println("Cultural Program can only be scheduled in 2nd (Evening) half.");
                startRegistration();
            }
            String time = "Evening";

            System.out.print("Enter Duration : ");
            int duration = sc.nextInt();

            if(duration > 15)
            {
                System.out.println("Duration limit is 15 min.");
                startRegistration();
            }

            createCulturalProgram(topic, time, duration);
            // showAllEvents();
            startRegistration();
        }
        else
            System.out.println("-- Maximum number of cultural programs is limited to 5.");
    }

    public static void checkAddParticipantPaperConditions()
    {
        if(all_paper_presentation_programs.size() > 0 && participants_list.size() > 0)
        {
            Scanner sc = new Scanner(System.in);

        // showAllEventsAbstract("PAPER_PRESENTATION");
            for(int i=0; i<all_paper_presentation_programs.size(); i++)
            {   
                System.out.print((i+1) + " -- ");
                all_paper_presentation_programs.get(i).printEventAbstractDetails();
            }
            System.out.println("--------------");
            showAllParticipantsAbstract();
            System.out.println("--------------");

            System.out.println("---- CHOOSE PAPER ----");
            int paper_id = sc.nextInt();

            System.out.println("---- CHOOSE PARTICIPANT ----");
            int participant_id = sc.nextInt();

            System.out.println(paper_id + " -- " + participant_id);
            all_paper_presentation_programs.get(paper_id-1).addParticipant(participants_list.get(participant_id-1));
        }
        else
            System.out.println("---- ADD ATLEAST ONE PAPER PRESENTATION AND ATLEAST ONE PARTICIPANT ----");
        startRegistration();
    }

    public static void checkAddParticipantPosterConditions()
    {
        if(all_poster_presentation_programs.size() > 0 && participants_list.size() > 0)
        {
            Scanner sc = new Scanner(System.in);

        // showAllEventsAbstract("PAPER_PRESENTATION");
            for(int i=0; i<all_poster_presentation_programs.size(); i++)
            {   
                System.out.print((i+1) + " -- ");
                all_poster_presentation_programs.get(i).printEventAbstractDetails();
            }
            System.out.println("--------------");
            showAllParticipantsAbstract();
            System.out.println("--------------");

            System.out.println("---- CHOOSE POSTER ----");
            int paper_id = sc.nextInt();

            System.out.println("---- CHOOSE PARTICIPANT ----");
            int participant_id = sc.nextInt();

            System.out.println(paper_id + " -- " + participant_id);
            all_poster_presentation_programs.get(paper_id-1).addParticipant(participants_list.get(participant_id-1));
        }
        else
            System.out.println("---- ADD ATLEAST ONE POSTER PRESENTATION AND ATLEAST ONE PARTICIPANT ----");
        startRegistration();
    }

    public static void checkAddParticipantQuizConditions()
    {
        if(all_quiz_programs.size() > 0 && participants_list.size() > 0)
        {
            Scanner sc = new Scanner(System.in);

            // showAllEventsAbstract("PAPER_PRESENTATION");
            for(int i=0; i<all_quiz_programs.size(); i++)
            {   
                System.out.print((i+1) + " -- ");
                all_quiz_programs.get(i).printEventAbstractDetails();
            }
            System.out.println("--------------");
            showAllParticipantsAbstract();
            System.out.println("--------------");

            System.out.println("---- CHOOSE QUIZ ----");
            int paper_id = sc.nextInt();

            System.out.println("---- CHOOSE PARTICIPANT ----");
            int participant_id = sc.nextInt();

            System.out.println(paper_id + " -- " + participant_id);
            all_quiz_programs.get(paper_id-1).addParticipant(participants_list.get(participant_id-1));
        }
        else
            System.out.println("---- ADD ATLEAST ONE QUIZ PRESENTATION AND ATLEAST ONE PARTICIPANT ----");
        startRegistration();
    }

    public static void checkAddParticipantCulturalConditions()
    {
        if(all_cultural_programs.size() > 0 && participants_list.size() > 0)
        {
            Scanner sc = new Scanner(System.in);

        // showAllEventsAbstract("PAPER_PRESENTATION");
            for(int i=0; i<all_cultural_programs.size(); i++)
            {   
                System.out.print((i+1) + " -- ");
                all_cultural_programs.get(i).printEventAbstractDetails();
            }
            System.out.println("--------------");
            showAllParticipantsAbstract();
            System.out.println("--------------");

            System.out.println("---- CHOOSE CULTURAL PROGRAMS ----");
            int paper_id = sc.nextInt();

            System.out.println("---- CHOOSE PARTICIPANT ----");
            int participant_id = sc.nextInt();

            System.out.println(paper_id + " -- " + participant_id);
            // all_cultural_programs.get(paper_id-1).addParticipant(participants_list.get(participant_id-1));
            addToCulturalProgram(all_cultural_programs.get(paper_id-1), participants_list.get(participant_id-1));
        }
        else
            System.out.println("---- ADD ATLEAST ONE CULTURAL PROGRAM AND ATLEAST ONE PARTICIPANT ----");
        startRegistration();
    }

    public static void checkRegisterParticipantConditions()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Name : ");
        String name = sc.nextLine();
        // sc.next();

        System.out.print("Enter Address : ");
        String address = sc.nextLine();
        // sc.next();

        System.out.print("Enter gender (M / F) : ");
        String gender = sc.nextLine();
        // sc.next();

        System.out.print("Enter email : ");
        String email = sc.nextLine();
        // sc.next();

        System.out.print("Enter Mobile No. : ");
        String mobile_no = sc.nextLine();
        // sc.next();

        System.out.print("Enter Batch (UG1 / UG2 / UG3 / UG4) : ");
        String batch = sc.nextLine();
        // sc.next();

        System.out.print("Enter Age : ");
        int age = sc.nextInt();
        if(age < 18)
        {
            System.out.println("Minimum age limit is 18.");
            startRegistration();
        }
        // sc.next();

        int number_of_events = 0;
        registerParticipant(name, address, gender, email, mobile_no, batch, age, number_of_events);
        startRegistration();
    }

    public static void showAllParticipantsAbstract()
    {
        for(int i=0; i<participants_list.size(); i++)
            participants_list.get(i).printParticipantAbstractDetails();
    }

    public static void showAllParticipants()
    {
        for(int i=0; i<participants_list.size(); i++)
            participants_list.get(i).printParticipantDetails();
        if(participants_list.size() == 0)
            System.out.println("-- NO REGISTERED PARTICPANTS --");
        startRegistration();
    }

    public static void showAllEvents()
    {
        System.out.println("-- ALL EVENTS --");
        for(int i=0; i<all_events.size(); i++)
            all_events.get(i).printEventDetails();
        if(all_events.size() == 0)
            System.out.println("-- NO EVENTS ADDED --");
        startRegistration();
    }

    public static void showAllCulturalProgramParticipants(Cultural obj_cultural)
    {
        int index = 0;
        for(int i=0; i<all_cultural_programs.size(); i++)
            if(all_cultural_programs.get(i) == obj_cultural)
                index = i;
        obj_cultural.showAllParticipants(index);
    }

    public static void showAllCulturalPrograms()
    {
        System.out.println("-- ALL CULTURAL PROGRAMS --");
        for(int i=0; i<all_cultural_programs.size(); i++)
            all_cultural_programs.get(i).printEventDetails();
    }

    public static void showParticularParticipantEvent()
    {
        showAllParticipantsAbstract();
        System.out.println("-- CHOOSE PARTICIPNAT ID --");

        Scanner sc = new Scanner(System.in);
        int p_id = sc.nextInt();

        if(p_id > participants_list.size())
        {
            System.out.println("-- Invalid Choice --");
            startRegistration();
        }
        else
        {
            participants_list.get(p_id-1).showAllEvents();
            startRegistration();
        }
    }

    public static void startRegistration()
    {

        System.out.println("Press \n\t1. Create Paper Presentation \n\t2. Create Poster Presentation \n\t3. Create Quiz Event \n\t4. Create Cultural Program");
        System.out.println("\t5. Add Participant to Paper Presentation \n\t6. Add Participant to Poster Presentation \n\t7. Add Participant To Quiz\n\t8. Add Participant to Cultural Program");
        // System.out.println("\t9. Show All Paper Presentation Participants \n\t10. Show All Poster Presentation Participants \n\t11. Show All Quiz Participants\n\t12. Show Cultural Program Participants");
        System.out.println("\t9. Register Praticipant");
        System.out.println("\t10. Show All Events");
        System.out.println("\t11. Show All Participants");
        System.out.println("\t12. Show particular participants' events");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        
        switch(choice)
        {
            case 1:
                checkCreatePaperPresentationConditions();
                break;
            case 2:
                checkCreatePosterPresentationConditions();
                break;
            case 3:
                checkCreateQuizConditions();
                break;
            case 4:
                checkCreateCulturalConditions();
                break;
            case 5:
                checkAddParticipantPaperConditions();
                break;
            case 6:
                checkAddParticipantPosterConditions();
                break;
            case 7:
                checkAddParticipantQuizConditions();
                break;
            case 8:
                checkAddParticipantCulturalConditions();
                break;
            case 9:
                checkRegisterParticipantConditions();
                break;
            case 10:
                showAllEvents();
                break;
            case 11:
                showAllParticipants();
                break;
            case 12:
                showParticularParticipantEvent();
                break;
            default:
                System.out.println("-- Invalid Choice --");
                startRegistration();
                break;
        }
    }

    public static void main(String[] args)
    {
        System.out.println("-- WELCOME TO EVENT MANAGER --");
        System.out.println("Press codes against tasks listed for desired functionalities");

        createPaperPresentation("GAN", "Morning", 15);
        createPaperPresentation("3D-MAPPING", "Morning", 15);
        createPosterPresentation("Infanticide", "Morning", 15);
        createPosterPresentation("Genocide", "Morning", 15);
        createQuiz("GK", "Evening", 20, 25);
        createQuiz("Tech", "Evening", 30, 30);
        createCulturalProgram("Dance", "Evening", 30);
        createCulturalProgram("Painiting", "Evening", 50);
        createCulturalProgram("Skating", "Evening", 10);
        // showAllEvents();

        registerParticipant("Tanmay", "Jaipur", "M", "tk@i.in", "702", "UG3", 21, 0);
        registerParticipant("Bhavi", "Gurgaon", "M", "bh@i.in", "991", "UG3", 21, 0);
        registerParticipant("Sanyem", "Kaithal", "M", "sa@i.in", "894", "UG3", 20, 0);
        registerParticipant("Rajat", "Benaras", "M", "ra@i.in", "965", "UG4", 23, 0);
        registerParticipant("Tushar", "Jaipur", "M", "tu@i.in", "233", "UG4", 23, 0);

        
        // showAllParticipants();

        startRegistration();
    }
}