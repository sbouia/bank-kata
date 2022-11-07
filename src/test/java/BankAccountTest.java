import com.bank.account.domain.Account;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class BankAccountTest {

    @Test
    public void should_deposit_money_in_account() {
        //GIVEN
        Account account = new Account();

        //WHEN
        account.deposit(1000, LocalDate.of(2022, 11, 1));
        //THEN
        Assert.assertEquals(1000, 000.1, account.getBalance());
    }

    @Test
    public void should_withdraw_money_in_account() {
        //GIVEN
        Account account = new Account();
        account.setBalance(1000);
        //WHEN
        account.withdraw(500, LocalDate.of(2022, 11, 2));
        //THEN
        Assert.assertEquals(500, 000.1, account.getBalance());
    }

    @Test
    public void should_account_history_in_account() {
        //GIVEN
        Account account = new Account();
        account.deposit(1000, LocalDate.of(2022, 11, 1));
        account.withdraw(500, LocalDate.of(2022, 11, 2));
        account.deposit(100, LocalDate.of(2022, 11, 3));
        //WHEN
        account.showOperationsHistory();
        //THEN
        Assert.assertEquals(3, account.getStatement().getOperations().values().size());
    }

}