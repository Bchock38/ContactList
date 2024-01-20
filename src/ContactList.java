import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {

    ArrayList<Person> contactList;

    public ContactList(){
        contactList = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts(){
        return contactList;
    }

    public void addContacts(Person newPerson){
        contactList.add(newPerson);
    }

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

    public Person searchByFirstName(String firstName){
        for(int i = 0; i < contactList.size(); i ++){
            if (contactList.get(i).getFirstName().equals(firstName)){
                return contactList.get(i);
            }
        }
        return null;
    }
    public Person searchByLastName(String lastName){
        for(int i = 0; i < contactList.size(); i ++){
            if (contactList.get(i).getLastName().equals(lastName)){
                return contactList.get(i);
            }
        }
        return null;
    }
    public Person searchByPhoneNumber(String phoneNumber){
        for(int i = 0; i < contactList.size(); i ++){
            if (contactList.get(i).getPhoneNumber().equals(phoneNumber)){
                return contactList.get(i);
            }
        }
        return null;

    }

    public void listStudents(){

        for(int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i) instanceof Student) {
                System.out.println(contactList.get(i));
            }
        }
    }
    public static void main(String[] args) {
        int number = 0;
        Scanner input = new Scanner(System.in);
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
        while(pickingNumber == true){
            number = input.nextInt();
            input.nextLine();
            if (number >= 0 && number < 9){
                pickingNumber = false;
                break;
            }


        }
        if(number == 2){
            sortBy(0);
            printContacts();
        }
        if(number == 3){
            sortBy(1);
            printContacts();
        }
        if(number ==4){
            sortBy(2);
            printContacts();
        }

        if(number == 5){
            listStudents();
        }

        if(number == 6){
            String fName = input.nextLine();
            if(searchByFirstName(fName) == null){
                System.out.println("(name/number) is not in the list");
            }
            else{
                System.out.println(searchByFirstName(fName));
            }
        }

        if(number == 7){
            String lName = input.nextLine();
            if(searchByLastName(lName) == null){
                System.out.println("(name/number) is not in the list");
            }
            else{
                System.out.println(searchByLastName(lName));
            }
        }

        if(number == 8){
            String PNum = input.nextLine();
            if(searchByPhoneNumber(PNum) == null){
                System.out.println("(name/number) is not in the list");
            }
            else{
                System.out.println(searchByPhoneNumber(PNum));
            }
        }

    }

}
