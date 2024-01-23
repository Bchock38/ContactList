public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Person(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    //return first name
    public String getFirstName(){
        return firstName;
    }
    // return last name
    public String getLastName() {
        return lastName;
    }
    //return phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }


    //create to string
    public String toString() {
        return firstName + " " + lastName + " - # " + phoneNumber;
    }
}
