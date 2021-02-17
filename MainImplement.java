import java.util.Objects;
abstract class MainImplement implements DataEntry {
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public String zip;
    public String phone;
    public String email;

    public MainImplement(String firstName, String lastName, String address, String city, String state, String zip, String phone, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }
    MainImplement(){
        this("","","","","","","","");
    }


    public String toString(){
        return "First Name:"+firstName+",  Last Name:"+lastName+",  Address:"+address+
                ",  State:"+state+",  City:"+city+",  ZIP:"+zip+",  Phone:"+phone+",  Email:"+email;
    }
    private int entries = 0;
    MainImplement[] list;
    public void initEntries(int e){
        list = new MainImplement[e];
        for (int i = 0;i<list.length;i++){      //Initializes an array of entries, then loops through to initialize each individual entry
            list[i] = new MainImplement() {
                @Override
                public void MainImplement(String firstName, String lastName, String address, String city, String state, String zip, String phone, String email) {

                }
            };
        }
    }
    // Returns the length
    public int getLength(){
        return list.length;
    }

    //Adds an entry to the book
    public void addEntry(String firstName, String lastName, String address, String city,
                         String state, String zip, String phone, String email){
        list[entries] = new MainImplement(firstName, lastName, address, city, state, zip, phone, email) {
            @Override
            public void MainImplement(String firstName, String lastName, String address, String city, String state, String zip, String phone, String email) {

            }
        };
        entries++;
    }

    public void editEntry(String firstName, String lastName, String address, String city,
                          String state, String zip, String phone, String email, String name){
        for (int i=0; i<list.length; i++) {
            if (Objects.equals(list[i].firstName, name))
                list[i] = new MainImplement(firstName, lastName, address, city, state, zip, phone, email) {
                    @Override
                    public void MainImplement(String firstName, String lastName, String address, String city, String state, String zip, String phone, String email) {

                    }
                };
            else
                System.out.println("Person Not found at " +(i+1)+" Entry");
        }

    }

    //Deleted an entry from the book according to the name
    public void deleteEntry(String name) {
        if (entries>0){

            MainImplement[] removedArray = new MainImplement[list.length];
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

