public class AddressBookMain {
    public static void main(String[] args){
        AddressBookImplement bookBuilder=new AddressBookImplement();
        bookBuilder.makechoice();
        boolean conditon=true;
        while (conditon) {
            boolean condition = bookBuilder.makechoice();
            if (condition == false)
                break;
        }
    }
}
