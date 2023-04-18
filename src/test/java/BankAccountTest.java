import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("Test BankAccount class")
public class BankAccountTest {
    @Test
    @DisplayName("Withdraw 500 successfully")
    public void testWithdraw(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 successfully")
    public void testDeposit(){
        BankAccount bankAccount = new BankAccount(400,0);
        bankAccount.deposit(500);
        assertEquals(900, bankAccount.getBalance());
    }
    @Test
    @DisplayName("Withdraw will become negative")
    public void testWithdrawNotStuckAtZero() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(800);
        assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Test activation account after creation")
    public void testActive(){
        BankAccount bankAccount = new BankAccount(500, 0);
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test set holder name")
    public void testHolderNameSet(){
        BankAccount bankAccount = new BankAccount(500, 0);
        bankAccount.setHolderName("Carlos");
        assertNotNull(bankAccount.getHolderName());
    }

    @Test
    @DisplayName("Test that we can't withdraw below minimum")
    public void testNoWithdrawBelowMinimum(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000));
    }
    @Test
    @DisplayName("Test no exception for withdraw and deposit")
    public void testWithdrawAndDepositWihtoutException(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        //fail(); used to forcing a fail e.g: wanting to avoid something to go thru a loop
        assertAll(() -> bankAccount.deposit(200), () -> bankAccount.withdraw(450));
    }
    @Test
    @DisplayName("Test speed deposit")
    public void testDepositTimeout(){
        BankAccount bankAccount = new BankAccount(400, 0);
        assertTimeout(Duration.ofNanos(10), () -> bankAccount.deposit(200));
        //assertEquals(0.33, 1/3, 0.01);
        assertEquals(0.33, 1/3, "Ooops, not the same");

    }

    @Test
    @DisplayName("Test activation account after creation")
    public void testActive2(){
        BankAccount bankAccount = new BankAccount(500, 0);
        //assumeTrue(bankAccount == null, "Account is null");
        //assumeFalse(bankAccount == null);
        assumingThat(bankAccount == null, () -> assertTrue(bankAccount.isActive()));
        //assertTrue(bankAccount.isActive());
    }

}
