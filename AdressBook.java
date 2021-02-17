import java.util.Scanner;

class AddressBook{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MainImplement entry = new MainImplement() {
            @Override
            public void MainImplement(String firstName, String lastName, String address, String city, String state, String zip, String phone, String email) {
            }
        };

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