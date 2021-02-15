import java.security.KeyStore;
import java.util.Objects;
import java.util.Scanner;

class Book{
    class Entry{
        private final String firstName;
        private final String lastName;
        private final String address;
        private final String city;
        private final String state;
        private final String zip;
        private final String phone;
        private final String email;

        Entry(String firstName, String lastName, String address, String city, String state,
              String zip, String phone, String email){
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
            return "First Name:"+firstName+"\nLast Name:"+lastName+"\nAddress:"+address+
                    "\nState:"+state+"\nCity:"+city+"\nZIP:"+zip+"\nPhone:"+phone+"\nEmail:"+email;
        }
    }

    //Keeps track of how many entries are in the book
    private int entries = 0;
    Entry[] content;
    public void initEntries(int e){
        content = new Entry[e];
        for (int i = 0;i<content.length;i++){      //Initializes an array of entries, then loops through to initialize each individual entry
            content[i] = new Entry();
        }
    }
    // Returns the length
    public int getLength(){
        return content.length;
    }
    //Adds an entry to the book
    public void addEntry(String firstName, String lastName, String address, String city,
                         String state, String zip, String phone, String email){
        content[entries] = new Entry(firstName, lastName, address, city, state, zip, phone, email);
        entries++;
    }

    //Edits the values of an entry according to the name
    public void editEntry(String firstName, String lastName, String address, String city,
                          String state, String zip, String phone, String email, String name){
        for (int i = 0;i<content.length;i++) {
            if (Objects.equals(content[i].firstName, name))
                content[i] = new Entry(firstName, lastName, address, city, state, zip, phone, email);
            else
                System.out.println("Person Not found at Entry");
        }
    }
}

public class AddressBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book book = new Book();
        while (true) {
            System.out.print("How many entries in book ");
            int numOfEntry = sc.nextInt();
            if (numOfEntry > 0) {
                book.initEntries(numOfEntry);
                break;
            } else System.out.println("You must create at least 1 Entry.");
        }

        boolean done = false;
        int choice;
        while (true) {
            System.out.println("Book is currently selected.");
            for (int i = 0; i < book.getLength(); i++) {
                System.out.println("===========Entry " + (i + 1) + " ===========");
                System.out.println(book.content[i]); //Accessing the array of entries INSIDE the array of books/the book
                System.out.println("================================");
            }

            System.out.println("1. Add an entry");
            System.out.println("2. Edit an entry");
            System.out.println("3. Exit the menu");
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
                    book.addEntry(firstName, lastName, address, city, state, zip, phone, email);
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
                    book.editEntry(firstName, lastName, address, city,
                            state, zip, phone, email, name);
                    break;
                default:
                    System.out.print("Invalid Choice");
                    break;
            }
        }
    }
}


