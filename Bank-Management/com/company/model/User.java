package com.company.model;

public class User {

    /**
     * Attributes of the class user
     * The attributes are private
     */

    private String name;
    private String surname;
    private int age;
    private BankAccount account;
    private BankAccount balance;


    public User(String name, String surname, BankAccount account, int age) {
        this.name = name;
        this.surname = surname;
        this.account = account;
        this.age = age;
    }

    /**
     * Getter:   get all method by name , their surname , accountNum and age.
     *
     * @return : Get all the information of User
     */


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAccountNum() {
        return account.getAccountNum();
    }

    public int getAge() {
        return age;
    }

    public double getBalance() {
        return account.getBalance();
    }

    /**
     * @return Return all data of the user on the Screen
     */
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", accountNum=" + account.getAccountNum() +
                ", age=" + age +
                ", balance=" + account.getBalance() +
                '}';
    }

    /**
     *  This methos is to deposit money in back account.
     * @param amount .
     */
    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Amount to be deposited should be positive");
        } else {
            account.depositTo(amount);
        }
    }

    /**
     * This method is for withdraw the amount from account.
     * @param amount that a user contains in their account
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount to be withdrawn should be positive");
        } else if (getBalance() < amount){
                System.out.println("Insufficient balance");
            } else {
                account.withdrawTo(amount);

            }
        }

    @Override
    public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            User  u = (User) obj ;
            return account == u.account &&
                    name.equals(u.name);
        }


}

