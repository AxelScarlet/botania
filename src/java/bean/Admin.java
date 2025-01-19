/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author USER
 */
public class Admin implements java.io.Serializable {
    public String username;
    public String name;
    public String phoneNumber;
    public String address;
    public String password;

    public Admin() {
        
    }

    
    public Admin(String username, String name, String phoneNumber, String address, String password) {
        this.username = username;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
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
