import java.util.Scanner;

public interface DataEntry {

    void MainImplement(String firstName, String lastName, String address, String city, String state, String zip, String phone, String email);

    public String toString();

    public void initEntries(int e);

    public int getLength();

    public void addEntry(String firstName, String lastName, String address, String city,
                         String state, String zip, String phone, String email);

    public void editEntry(String firstName, String lastName, String address, String city,
                          String state, String zip, String phone, String email, String name);

    public void deleteEntry(String name);
}

