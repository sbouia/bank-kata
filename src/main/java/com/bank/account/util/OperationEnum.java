package com.bank.account.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OperationEnum {

    DEPOSIT("DEPOSIT_OPERATION"),
    WITHDRAWAL("WITHDRAWAL_OPERATION");

    private final String type;
}
