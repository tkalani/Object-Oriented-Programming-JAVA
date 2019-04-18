public class Paragraph
{
    String content;
    int numberOfSpaces, numberofSpecialCharacters, numberOfWords;
    public static final String SPECIAL_CHARACTER_REGEX = "[!@#$%^&*()[\\\\]|;',./{}\\\\\\\\:\\\"<>?]";
    
    public Paragraph()
    {
        this.content = "I am Tanmay.";
        this.calculateNumberofSpacesandSpecialCharacters();
        this.calculateNumberofWords();
        this.printDetails();
    }

    public Paragraph(String content)
    {
        this.content = content;

        this.calculateNumberofSpacesandSpecialCharacters();
        this.calculateNumberofWords();
        this.printDetails();
    }

    public void printDetails()
    {
        System.out.println(numberOfSpaces);
        System.out.println(numberofSpecialCharacters);
        System.out.println(numberOfWords);
    }

    public void calculateNumberofSpacesandSpecialCharacters()
    {
        int specialCharCount = content.split(SPECIAL_CHARACTER_REGEX, -1).length - 1;
        int spaces = content.replaceAll("[^ ]", "").length();

        System.out.println("Special Character Count : " + specialCharCount);
        System.out.println("Spaces Count : " + spaces);

        this.numberOfSpaces = spaces;
        this.numberofSpecialCharacters = specialCharCount;
    }

    public int calculateNumberofWords()
    {
        int words = content.split("\\s+").length;
        this.numberOfSpaces = words;
        return words;
    }

    public String encode1()
    {
        String encoded_string = "";
        for(int i=0; i < content.length(); i++)
        {
            int a = content.charAt(i);
            a = a*2;
            char b = (char)a;
            encoded_string += b;
        }
        return encoded_string;
    }

    public String encode2()
    {
        String encoded_string = "";
        for(int i=0; i < content.length(); i++)
        {
            int a = content.charAt(i);
            a = (a*a)+a + 2;
            char b = (char)a;
            encoded_string += b;
        }
        return encoded_string;
    }

    public static void main(String[] args)
    {
        Paragraph para = new Paragraph("A paragraph (from the Ancient Greek παράγραφος paragraphos, to write beside or written beside) is a self-contained unit of a discourse in writing dealing with a particular point or idea. A paragraph consists of one or more sentences.[1] Though not required by the syntax of any language, paragraphs are usually an expected part of formal writing, used to organize longer prose.");
        System.out.println("Number of Words : " + para.calculateNumberofWords());
        para.calculateNumberofSpacesandSpecialCharacters();
        System.out.println(para.encode1());
        System.out.println(para.encode2());

        // System.out.println("------------------------------");

        Paragraph para1 = new Paragraph();
        System.out.println("Number of Words : " + para1.calculateNumberofWords());
        para1.calculateNumberofSpacesandSpecialCharacters();
        System.out.println(para1.encode1());
        System.out.println(para1.encode2());
    }
}