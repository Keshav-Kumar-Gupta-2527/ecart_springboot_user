
//
//package com.ecart.ecartFullProject.Model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name = "Users")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long userId;
//
//    @Column(name = "userName")
//    private String userName;
//
//    @Column(name = "password")
//    private String password;
//
//    @Column(name = "contact")
//    private String contact;
//
//    @Column(name = "address")
//    private String address;
//
//    @Column(name = "wallet")
//    private double wallet;
//}

package com.ecart.ecartFullProject.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column(name="userName")
    private String userName;

    @Column(name="password")
    private String password;
    @Column(name="contact")
    private String contact;
    @Column(name="address")
    private String address;
    @Column(name="wallet")
    private double wallet;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
