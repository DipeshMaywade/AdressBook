import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class AddressBookTest {
    @Test
    void fromAddressBookDB_WhenRetrieved_ShouldMatchEmployeeCount() {
        AddressBookImplement addressBookImplement = new AddressBookImplement();
        List<AddressBook> addressBookList = addressBookImplement.readAddressBookData();
        System.out.println(addressBookList);
        Assertions.assertEquals(3, addressBookList.size());
    }

    @Test
    void givenNewAddressForContact_whenUpdate_shouldSyncWithDB() {
        AddressBookImplement addressBookImplement = new AddressBookImplement();
        List<AddressBook> employeePayrollData = addressBookImplement.readAddressBookData();
        addressBookImplement.updateAddressBook("ram", "Dehli");
        boolean result = addressBookImplement.checkAddressBookSyncWithDB("ram");
        Assertions.assertEquals(true, result);
    }

    @Test
    void givenStateForAddressBookDB_WhenRetrieved_ShouldMatchExpectedCount() {
        AddressBookImplement addressBookImplement = new AddressBookImplement();
        String state = "mp";
        List<AddressBook> addressBookList = addressBookImplement.readFilteredAddressBookData(state);
        System.out.println(addressBookList);
        Assertions.assertEquals(2, addressBookList.size());
    }

    @Test
    void givenNewContactToDB_whenAdded_shouldSyncWithDB() {
        AddressBookImplement addressBookImplement = new AddressBookImplement();
        addressBookImplement.readAddressBookData();
        addressBookImplement.addContacts("book3", "Rohit", "Maywade", "mumbai", "mumbai", "mh", 456536, 345634566, "gg@gmail.com");
        boolean result = addressBookImplement.checkAddressBookSyncWithDB("Rohit");
        Assertions.assertTrue(result);
    }

    @Test
    void givenNewContactToAddressBookDB_whenAdded_shouldMatchWithEntries() {
        AddressBook[] addressBooks = {
                new AddressBook("book0", "Rohit", "Maywade", "mumbai", "mumbai", 456536, "mh", 345634566, "gg@gmail.com"),
                new AddressBook("book4", "gsdf", "Maywade", "mumbai", "mumbai", 456536, "mh", 345634566, "gg@gmail.com"),
                new AddressBook("book5", "dgdf", "Maywade", "mumbai", "mumbai", 456536, "mh", 345634566, "gg@gmail.com"),
                new AddressBook("book6", "dfgf", "Maywade", "mumbai", "mumbai", 456536, "mh", 345634566, "gg@gmail.com"),
                new AddressBook("book7", "dfg", "Maywade", "mumbai", "mumbai", 456536, "mh", 345634566, "gg@gmail.com"),
                new AddressBook("book8", "dfg", "Maywade", "mumbai", "mumbai", 456536, "mh", 345634566, "gg@gmail.com")
        };
        AddressBookImplement addressBookImplement = new AddressBookImplement();
        addressBookImplement.readAddressBookData();
        Instant threadStart = Instant.now();
        addressBookImplement.addContactDBWithThreads(Arrays.asList(addressBooks));
        Instant threadEnd = Instant.now();
        System.out.println("Duration with thread  " + Duration.between(threadStart, threadEnd));
        Assertions.assertEquals(11, addressBookImplement.countEntries());
    }

    public void setup(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;
    }

    @Test
    void givenAddressBookDataInJSONServer_WhenRetrieved_shouldMatchYheCount() {
        AddressBook[] addressBooksData = getContactList();
        AddressBookImplement addressBookImplement;
        addressBookImplement = new AddressBookImplement(Arrays.asList(addressBooksData));
        long entries = addressBookImplement.countEntries();
        Assertions.assertEquals(2,entries);
    }

    public AddressBook[] getContactList() {
        setup();
        Response response = RestAssured.get("/address_book");
        System.out.println("Entries In JsonServer:\n"+ response.asString());
        AddressBook[] arrayOfEmp = new Gson().fromJson(response.asString(),AddressBook[].class);
        return arrayOfEmp ;
    }

    private Response addContactToJSONServer(AddressBook addressBookData) {
        String empJSON = new  Gson().toJson(addressBookData);
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.body(empJSON);
        return requestSpecification.post("/address_book");
    }
    @Test
    void givenListOfNewEmployee_whenAdded_shouldMatch201Response() {
        AddressBookImplement addressBookImplement;
        AddressBook[] addressBooksData = getContactList();
        addressBookImplement = new AddressBookImplement(Arrays.asList(addressBooksData));

        AddressBook[] data = {
                new AddressBook(1,"book0", "Rohit", "Maywade", "mumbai", "mumbai", 456536, "mh", 345634566, "gg@gmail.com"),
                new AddressBook(0,"book4", "gsdf", "Maywade", "mumbai", "mumbai", 456536, "mh", 345634566, "gg@gmail.com"),
                new AddressBook(0,"book5", "dgdf", "Maywade", "mumbai", "mumbai", 456536, "mh", 345634566, "gg@gmail.com")
        };
        for (AddressBook addressBookData : data){
            Response response = addContactToJSONServer(addressBookData);
            int statusCode = response.getStatusCode();
            Assertions.assertEquals(201,statusCode);

            addressBookData = new Gson().fromJson(response.asString(), AddressBook.class);
            addressBookImplement.addContacts(addressBookData);
        }
        long entries = addressBookImplement.countEntries();
        Assertions.assertEquals(5,entries);
    }
}
