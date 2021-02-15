import java.util.Scanner;

public class AddressBook{

        private final String firstName;
        private final String lastName;
        private final String address;
        private final String city;
        private final String state;
        private final String zip;
        private final String phone;
        private final String email;

        public AddressBook() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter First Name");
            this.firstName = sc.next();
            System.out.println("Enter last Name");
            this.lastName = sc.next();
            System.out.println("Enter Address");
            this.address = sc.next();
            System.out.println("Enter Your City Name");
            this.city = sc.next();
            System.out.println("Enter Your State");
            this.state = sc.next();
            System.out.println("Enter Zip");
            this.zip = sc.next();
            System.out.println("Enter Phone Number");
            this.phone = sc.next();
            System.out.println("Enter Email");
            this.email = sc.next();
        }

        public String toString(){
            return "First Name:"+firstName+", Last Name:"+lastName+", Address:"+address+
                    ", State:"+state+", City:"+city+", ZIP:"+zip+", Phone:"+phone+", Email:"+email;
        }


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Number Of Entry U Want");
            int noOfEntry = sc.nextInt();

            String list[] = new String[noOfEntry];

            for (int i=0; i<noOfEntry; i++) {
                System.out.println("Enter Value For contact No."+(i+1));
                AddressBook obj = new AddressBook();
                String contactDetails = obj.toString();
                list[i]=contactDetails;
            }
            for (int i=0; i<noOfEntry; i++){
                System.out.println(list[i]);
            }
        }
}


