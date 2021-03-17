import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookTest {
    @Test
    void fromAddressBookDB_WhenRetrieved_ShouldMatchEmployeeCount() {
        AddressBookImplement addressBookImplement = new AddressBookImplement();
        List<AddressBook> addressBookList = addressBookImplement.readAddressBookData();
        System.out.println(addressBookList);
        Assertions.assertEquals(3, addressBookList.size());
    }


}
