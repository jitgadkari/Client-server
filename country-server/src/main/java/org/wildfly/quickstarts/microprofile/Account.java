package org.wildfly.quickstarts.microprofile;


//import javax.persistence.*;
//import javax.persistence.Entity;

import javax.persistence.*;

@Entity
@Table(name ="Accounts")
public class Account {

//    public String name;
//    public int balance;
//    public int id;
//
//    public Account(String name, int balance, int id) {
//        this.name = name;
//        this.balance = balance;
//        this.id = id;

//    }
@Id
@GeneratedValue
private Long id;

    @Column(unique = true)
    private String Accountusername;

    private String firstName;

    private String lastName;

    public Account() {
    }
    public Long getId() {
        return this.id;
    }

    public String getAccountUsername() {

        return Accountusername;
    }

    public void setAccountusername(String Accountusername) {

        this.Accountusername = Accountusername;
    }

    public String getFirstName() {

        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {

        return this.lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }


}
