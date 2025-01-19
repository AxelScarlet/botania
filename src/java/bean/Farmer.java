package bean;

public class Farmer  {
    private int id;
    private String username;
    private String name; // This should match the field you want to retrieve
    private String phoneNumber;
    private String address;
    private String password;

    public Farmer() {
    }

    public Farmer(int id, String username, String name, String phoneNumber, String address, String password) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}