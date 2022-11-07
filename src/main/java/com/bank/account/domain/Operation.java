package com.bank.account.domain;

import com.bank.account.util.Seperator;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@Builder
@EqualsAndHashCode
public class Operation implements Comparable<Operation>{
    private String type;
    private double amount;
    private LocalDate date;

    public StringBuilder print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(this.type)
                .append(Seperator.DOUBLE_VERTICAL_LINE)
                .append(this.amount)
                .append(Seperator.DOUBLE_VERTICAL_LINE)
                .append(this.date);
        return stringBuilder;
    }

    @Override
    public int compareTo(Operation o) {
        return getDate().compareTo(o.getDate());
    }
}

