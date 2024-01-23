import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {

    ArrayList<Person> contactList;

    public ContactList(){
        contactList = new ArrayList<Person>();
    }

    //return contact list
    public ArrayList<Person> getContacts(){
        return contactList;
    }
    //add person to contact list
    public void addContacts(Person newPerson){
        contactList.add(newPerson);
    }

    //print out full contact list
    public void printContacts(){
        for (Person person : contactList) {
            System.out.println(person);
        }
    }

    public void sortBy(int sortBy){

        //sortBY First Name
        if (sortBy == 0){
            for (int i = 0; i < contactList.size(); i++){

                for (int j = 0; j < contactList.size()-1; j++){
                    Person hold;
                    if(contactList.get(j).getFirstName().compareTo(contactList.get(j+1).getLastName()) > 0){
                        hold = contactList.get(j);
                        contactList.set(i,contactList.get(j+1));
                        contactList.set(j+1,hold);
                    }
                }
            }
        }


        //sortBY Last Name
        if (sortBy == 1){
            for (Person person : contactList){
                for (int i = 0; i < contactList.size()-1; i++){
                    Person hold;
                    if(contactList.get(i).getLastName().compareTo(contactList.get(i+1).getLastName()) > 0){
                        hold = contactList.get(i);
                        contactList.set(i,contactList.get(i+1));
                        contactList.set(i+1,hold);
                    }
                }
            }
        }

        //sortBY Phone Number
        if (sortBy == 2){
            for (Person person : contactList){
                for (int i = 0; i < contactList.size()-1; i++){
                    Person hold;
                    if(contactList.get(i).getPhoneNumber().compareTo(contactList.get(i+1).getPhoneNumber()) > 0){
                        hold = contactList.get(i);
                        contactList.set(i,contactList.get(i+1));
                        contactList.set(i+1,hold);
                    }
                }
            }
        }



    }

    //Search for person in contact list by first name
    public Person searchByFirstName(String firstName){
        for(int i = 0; i < contactList.size(); i ++){
            if (contactList.get(i).getFirstName().equals(firstName)){
                return contactList.get(i);
            }
        }
        return null;
    }
    //Search for person in contact list by last name
    public Person searchByLastName(String lastName){
        for(int i = 0; i < contactList.size(); i ++){
            if (contactList.get(i).getLastName().equals(lastName)){
                return contactList.get(i);
            }
        }
        return null;
    }
    //Search for person in contact list by phone number
    public Person searchByPhoneNumber(String phoneNumber){
        for(int i = 0; i < contactList.size(); i ++){
            if (contactList.get(i).getPhoneNumber().equals(phoneNumber)){
                return contactList.get(i);
            }
        }
        return null;

    }

    //print out all students in contact list
    public void listStudents(){

        for(int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i) instanceof Student) {
                System.out.println(contactList.get(i));
            }
        }
    }
    public static void main(String[] args) {
        ContactList r1 = new ContactList();
        r1.run();

    }

    //run method
    public void run(){
        int number = 0;
        boolean run = true;
        Scanner input = new Scanner(System.in);
        //while user has not exited run menu
        while(run == true) {
            System.out.println("Menu:");
            System.out.println("1. Add Contact ");
            System.out.println("2. List All Contacts by First Name ");
            System.out.println("3. List All Contacts by Last Name ");
            System.out.println("4. List All Contacts by Phone Number ");
            System.out.println("5. List All Students");
            System.out.println("6. Search by First Name");
            System.out.println("7. Search by Last Name");
            System.out.println("8. Search by Phone Number");
            System.out.println("0. Exit ");

            boolean pickingNumber = true;
            //make sure user selects a number in menu
            while (pickingNumber == true) {
                number = input.nextInt();
                input.nextLine();
                if (number >= 0 && number < 9) {
                    pickingNumber = false;
                    break;
                }


            }
            //if user selects 0 exit
            if(number == 0){
                run = false;
                break;
            }
            //if user selects 1 prompt user to add new contact
            if (number == 1){
                System.out.println("Select a type of Contact to Add");
                System.out.println("1. Student");
                System.out.println("2. Language Student");
                int selection = input.nextInt();
                input.nextLine();
                //prompt user for information need to make new student
                if (selection == 1){
                    System.out.println("Enter in the following information");
                    System.out.println("First Name: ");
                    String fname = input.nextLine();
                    System.out.println("Last Name: ");
                    String lName = input.nextLine();
                    System.out.println("Phone Number: ");
                    String phoneNum = input.nextLine();
                    System.out.println("Grade: ");
                    int grade = input.nextInt();
                    input.nextLine();
                    Person toAdd = new Student(fname, lName, grade, phoneNum);
                    addContacts(toAdd);
                }
                // prompt user for information needed to create new language student
                else if (selection == 2){
                    System.out.println("Enter in the following information");
                    System.out.println("First Name: ");
                    String fname = input.nextLine();
                    System.out.println("Last Name: ");
                    String lName = input.nextLine();
                    System.out.println("Phone Number: ");
                    String phoneNum = input.nextLine();
                    System.out.println("Grade: ");
                    int grade = input.nextInt();
                    input.nextLine();
                    System.out.println("Langauge: ");
                    String language = input.nextLine();
                    Person toAdd = new LanguageStudent(fname, lName, phoneNum, grade, language);
                    addContacts(toAdd);
                }

            }
            //if user selects 2 sort contact list by first name then print list
            if (number == 2) {
                sortBy(0);
                printContacts();
            }
            //if user selects 3 sort contact list by last name then print list
            if (number == 3) {
                sortBy(1);
                printContacts();
            }
            //if user selects 4 sort contact list by phone number then print list
            if (number == 4) {
                sortBy(2);
                printContacts();
            }
            //if user selects 5 print out students
            if (number == 5) {
                listStudents();
            }
            //if user selects 6 search for contact by first name
            if (number == 6) {
                String fName = input.nextLine();
                if (searchByFirstName(fName) == null) {
                    System.out.println("(name/number) is not in the list");
                } else {
                    System.out.println(searchByFirstName(fName));
                }
            }
            //if user selects 7 search for contact by last name
            if (number == 7) {
                String lName = input.nextLine();
                if (searchByLastName(lName) == null) {
                    System.out.println("(name/number) is not in the list");
                } else {
                    System.out.println(searchByLastName(lName));
                }
            }
            //if user selects 8 search for contact by phone number
            if (number == 8) {
                String PNum = input.nextLine();
                if (searchByPhoneNumber(PNum) == null) {
                    System.out.println("(name/number) is not in the list");
                } else {
                    System.out.println(searchByPhoneNumber(PNum));
                }
            }
        }

    }
}
