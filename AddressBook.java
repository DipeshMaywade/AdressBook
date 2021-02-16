import java.util.Objects;
import java.util.Scanner;

class Entry{
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String city;
    private final String state;
    private final String zip;
    private final String phone;
    private final String email;

    Entry(String firstName, String lastName, String address, String city, String state, String zip, String phone, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        }

        Entry(){
            this("","","","","","","","");
        }

        public String toString(){
            return "First Name:"+firstName+",  Last Name:"+lastName+",  Address:"+address+
                    ",  State:"+state+",  City:"+city+",  ZIP:"+zip+",  Phone:"+phone+",  Email:"+email;
        }


    //Keeps track of how many entries are in the book
    private int entries = 0;
    Entry[] list;
    public void initEntries(int e){
        list = new Entry[e];
        for (int i = 0;i<list.length;i++){      //Initializes an array of entries, then loops through to initialize each individual entry
            list[i] = new Entry();
        }
    }
    // Returns the length
    public int getLength(){
        return list.length;
    }

    //Adds an entry to the book
    public void addEntry(String firstName, String lastName, String address, String city,
                         String state, String zip, String phone, String email){
        list[entries] = new Entry(firstName, lastName, address, city, state, zip, phone, email);
        entries++;
    }

    //Edits the values of an entry according to the name
    public void editEntry(String firstName, String lastName, String address, String city,
                          String state, String zip, String phone, String email, String name){
        for (int i=0; i<list.length; i++) {
            if (Objects.equals(list[i].firstName, name))
                list[i] = new Entry(firstName, lastName, address, city, state, zip, phone, email);
            else
                System.out.println("Person Not found at " +(i+1)+" Entry");
        }

    }
//Deleted an entry from the book according to the name
    public void deleteEntry(String name) {
        if (entries>0){
            Entry[] removedArray = new Entry[list.length];
            for (int i = 0, k = 0 ;i<list.length;i++){
                if (Objects.equals(list[i].firstName, name)){
                    continue;
                }
                removedArray[k++] = list[i];
            }
            System.arraycopy(removedArray, 0, list, 0, entries);

        }
        else System.out.println("Error: book is empty.");
    }

}

public class AddressBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Entry entry = new Entry();
        while (true) {
            System.out.print("How Many Entries U Want In AddressBook ");
            int numOfEntry = sc.nextInt();
            if (numOfEntry > 0) {
                entry.initEntries(numOfEntry);
                break;
            } else System.out.println("You must create at least 1 Entry.");
        }

        int choice;
        while (true) {
            System.out.println("WelCome To AddressBook");

            //Multiple entries in AdressBook
            for (int i = 0; i < entry.getLength(); i++) {
                System.out.println("===========Entry Format===========");
                System.out.println(entry.list[i]); //Accessing the array of entries INSIDE the array of books/the book
                System.out.println("================================");
            }

            System.out.println("1. Add an entry");
            System.out.println("2. Edit an entry");
            System.out.println("3. Remove an entry");
            System.out.println("4. Exit the menu");
            choice = sc.nextInt();
            String firstName, lastName, address, city, state, zip, phone, email;
            switch (choice) {
                case 1:
                    System.out.print("First name: ");
                    firstName = sc.next();
                    System.out.print("Last name: ");
                    lastName = sc.next();
                    System.out.print("Address: ");
                    address = sc.next();
                    System.out.print("City: ");
                    city = sc.next();
                    System.out.print("State: ");
                    state = sc.next();
                    System.out.print("ZIP: ");
                    zip = sc.next();
                    System.out.print("Phone: ");
                    phone = sc.next();
                    System.out.print("Email: ");
                    email = sc.next();
                    entry.addEntry(firstName, lastName, address, city, state, zip, phone, email);
                    break;
                case 2:
                    System.out.print("Please enter the first name of Person u want to edit: ");
                    String name = sc.next();
                    System.out.print("First name: ");
                    firstName = sc.next();
                    System.out.print("Last name: ");
                    lastName = sc.next();
                    System.out.print("Address: ");
                    address = sc.next();
                    System.out.print("City: ");
                    city = sc.next();
                    System.out.print("State: ");
                    state = sc.next();
                    System.out.print("ZIP: ");
                    zip = sc.next();
                    System.out.print("Phone: ");
                    phone = sc.next();
                    System.out.print("Email: ");
                    email = sc.next();
                    entry.editEntry(firstName, lastName, address, city, state, zip, phone, email, name);
                    break;
                case 3:
                    System.out.println("Please enter the first name of Person u want to delete: ");
                    name = sc.next();
                    entry.deleteEntry(name);
                    break;
                default:
                    System.out.print("Invalid Choice");
            }
        }
    }
}


