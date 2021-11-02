package model.entities;

import model.exceptions.DomainException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount) {
        balance += amount;
    }

    // como não estamos tratando aqui ainda, temos que avisar na assinatura do método que estamos jogando pro método de cima
    public void withdraw(Double amount) throws DomainException {
        validateWithdraw(amount);
        balance -= amount;
    }

    // criando um método privado apenas para validar se o saque pode ser feito
    private void validateWithdraw(Double amount) throws DomainException  {

        if (withdrawLimit < amount) {
            throw new DomainException("The amount exceeds withdraw limit");
        }
        if (balance < amount) {
            throw new DomainException("Not enough balance");
        }
    }
}