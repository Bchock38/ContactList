public class LanguageStudent extends Student{

    private String language;

    public LanguageStudent(String firstName, String lastName, String language, int grade, String phoneNumber ){
        super(firstName, lastName, grade, phoneNumber);
        this.language = language;
    }

    //return language student is learning
    public String getLanguage() {
        return language;
    }

    //create to string
    public String toString() {
        return super.toString() + " Learning " + language;
    }
}
