import java.util.Scanner;
public interface DataEntry {

    String toString();

    void initEntries(int e);

    int getLength();

    void addEntry(String firstName, String lastName, String address, String city,
                         String state, String zip, String phone, String email);

    void editEntry(String firstName, String lastName, String address, String city,
                          String state, String zip, String phone, String email, String name);

    void deleteEntry(String name);
}

