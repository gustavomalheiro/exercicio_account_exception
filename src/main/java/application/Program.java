package application;

import model.entities.Account;

public class Program {
    public static void main(String[] args) {

        System.out.println("Hello World!");

        Account account = new Account(8021, "Gustavo", 1000.00, 200.00);

        System.out.println(account.getBalance());

    }
}
