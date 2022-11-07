package com.bank.account.domain;

import com.bank.account.util.OperationEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Account {
    private double balance;
    private Statement statement;

    public Account() {
        this.statement = new Statement();
        this.balance = 0;
    }

    public void withdraw(double amount, LocalDate date) {
        if (this.balance > amount) {
            this.balance -= amount;
            this.setOperation(OperationEnum.WITHDRAWAL, amount, date, this.balance);
        } else {
            System.out.println("you do not have enough money to withdraw");
        }
    }

    public void deposit(double amount, LocalDate date) {
        this.balance += amount;
        this.setOperation(OperationEnum.DEPOSIT, amount, date, this.balance);
    }

    public void showOperationsHistory() {
        System.out.println("OPERATION    AMOUNT    DATE   BALANCE");
        System.out.println("--------------------------------------");
        System.out.println(statement.print());
    }

    private void setOperation(OperationEnum operationType, double amount, LocalDate date, double balance) {
        Operation operation = this.buildOperation(operationType, amount, date);
        this.statement.addOperation(operation, balance);
    }

    private  Operation buildOperation(OperationEnum operationType, double amount, LocalDate date) {
        return Operation.builder()
                    .type(operationType.getType())
                    .amount(amount)
                    .date(date)
                .build();
    }

}