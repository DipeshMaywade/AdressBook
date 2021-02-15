
public class AddressBook {
        private final String firstName;
        private final String lastName;
        private final String address;
        private final String city;
        private final String state;
        private final String zip;
        private final String phone;
        private final String email;


        public AddressBook(String firstName, String lastName, String address, String city,
                               String state, String zip, String phone, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.phone = phone;
            this.email = email;
        }
        public String toString(){
            return "First Name:"+firstName+"\nLast Name:"+lastName+"\nAddress:"+address+
                     "\nState:"+state+"\nCity:"+city+"\nZIP:"+zip+"\nPhone:"+phone+"\nEmail:"+email;
        }

        public static void main(String[] args) {
            AddressBook obj = new AddressBook("Dipesh", "Maywade", "Betul", "Betul",
                    "MadhyaPradesh", "460001", "8269602271", "dipshmaywade@gmail.com");

            System.out.println(obj.toString());
        }
}

