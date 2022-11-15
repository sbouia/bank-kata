package com.bank.account.domain;

import com.bank.account.util.Seperator;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
@ToString
public class Statement {
    private final HashMap<Double, Operation> operations;

    public Statement() {
        this.operations = new HashMap<>();
    }

    public void addOperation(Operation operation, double balance) {
        this.operations.put(balance, operation);
    }

    public StringBuilder print() {
        StringBuilder statement = new StringBuilder();
        operations
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry ->
                {
                    Operation operation = entry.getValue();
                    Double balance = entry.getKey();
                    statement
                            .append(operation.print())
                            .append(Seperator.DOUBLE_VERTICAL_LINE)
                            .append(balance);
                    statement.append(Seperator.NEW_LINE);
                });
        return statement;
    }

}