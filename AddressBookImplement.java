
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Objects;


public class AddressBookImplement implements MultipleAddressBook {

    public Map<String,AddressBook> contact;
    public Map<String,AddressBook> book;

    // Constructor
    public AddressBookImplement(){
        this.contact= new HashMap<>();
        this.book= new HashMap<>();
    }

    @Override
    public void addAddressBook(String BookName,String FirstName, String LastName, String Address, String City, int Zip,String State, long PhoneNumber, String Email){
        AddressBook adder=new AddressBook(BookName,FirstName,LastName,Address,City,Zip,State,PhoneNumber,Email);
        if(uniqBook(BookName)) {
            contact.put(FirstName, adder);
            book.put(BookName, adder);
        }
        else {
            System.out.println("The BookName Is Already Exist Please Use Diff Name For Book");
        }
    }

    @Override
    public boolean uniqBook(String bookName ){
        AddressBook details = book.get(bookName);
        if (details == null){
            return true;
        }
        return false;
    }

    //This method takes console arguments
    @Override
    public void getContact() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Address Book Name");
        String BookName = scan.next();
        System.out.println("Enter you first name");
        String FirstName = scan.next();

        if(UniqContact(FirstName)) {
            System.out.println("Enter you last name");
            String LastName = scan.next();
            System.out.println("Enter you Address name");
            String Address = scan.next();
            System.out.println("Enter you zip ");
            int Zip = scan.nextInt();
            System.out.println("Enter you city name");
            String City = scan.next();
            System.out.println("Enter you state name");
            String State = scan.next();
            System.out.println("Enter you phone number");
            long PhoneNumber = scan.nextLong();
            System.out.println("Enter you email name");
            String Email = scan.next();
            addAddressBook(BookName, FirstName, LastName, Address, City, Zip, State, PhoneNumber, Email);
        }
        else {
            System.out.println("The Name Is Already Exist Please Use Diff Name");
        }
    }

    @Override
    public boolean UniqContact(String firstName ){
        AddressBook details = contact.get(firstName);
        if (details == null){
            return true;
        }
        return false;
    }

    // This method helps to edit the details
    @Override
    public void editContact() {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter your name");
        String name = scan.next();
        AddressBook option = contact.get(name);
        if(option==null) {
            System.out.println("Invalid Name");
        }
        else{
            System.out.println(option);
            boolean conditon = true;
            while (conditon) {
                System.out.println("enter number to edit: 0-firstname, 1-lastname, 2-address, 3-zip, 4-city, 5-state, 6-phonenumber, 7-email, 9 to quit");
                int check = scan.nextInt();
                switch (check) {
                    case 0:
                        System.out.println("Enter you first name");
                        option.FirstName = scan.next();
                        break;
                    case 1:
                        System.out.println("Enter you last name");
                        option.LastName = scan.next();
                        break;
                    case 2:
                        System.out.println("Enter you Address name");
                        option.Address = scan.next();
                        break;
                    case 3:
                        System.out.println("Enter you zip ");
                        option.Zip = scan.nextInt();
                        break;
                    case 4:
                        System.out.println("Enter you city name");
                        option.City = scan.next();
                        break;
                    case 5:
                        System.out.println("Enter you state name");
                        option.State = scan.next();
                        break;
                    case 6:
                        System.out.println("Enter you phone number");
                        option.PhoneNumber = scan.nextLong();
                        break;
                    case 7:
                        System.out.println("Enter you email name");
                        option.Email = scan.next();
                        break;
                    case 9:
                        conditon = false;
                        break;
                    default:
                        System.out.println("invalid input");
                }
            }
        }
    }

    // This method helps to delete the contact details
    @Override
    public void deleteEntry(){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter your name to delete from contact");
        String name = scan.next();
        AddressBook option = contact.get(name);
        if (Objects.equals(option.FirstName, name)) {
            contact.remove(name);
            System.out.println(name+" Details SuccessFully Removed");
        }
        else {
            System.out.println("Invalid Name");
        }
    }

    // This method helps to find contact details by first name
    public void getContactByName() {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Name to search");
        String firstName=obj.nextLine();
        AddressBook op=contact.get(firstName);
        System.out.println(op);
    }

    // This method helps to find address book details by book name
    public void getAddressBookByName(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Address Book Name to search");
        String bookName=obj.nextLine();
        AddressBook op=book.get(bookName);
        System.out.println(op.toString());
    }

    // This method helps user to choose action
    public boolean makeChoice() {
        Scanner obj = new Scanner(System.in);
        System.out.println("Choose Options\n 1-add contact\n 2-display contact\n 3-display address book\n 4-edit\n 5-delete entry\n 0-quit");
        int check = obj.nextInt();
        boolean conditon = true;
        switch (check) {
            case 1:
                getContact();
                break;
            case 2:
                getContactByName();
                break;
            case 3:
                getAddressBookByName();
                break;
            case 4:
                editContact();
                break;
            case 5:
                deleteEntry();
                break;
            case 0:
                conditon = false;
                break;
            default:
                System.out.println("invalid input");
        }
        return conditon;
    }
}