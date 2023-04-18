import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankAccountBeforeAndAfterTest {
    static BankAccount bankAccount;

    //@BeforeAll
    //static para all
    @BeforeAll
    public  void prepTest(){
        System.out.println("Hi");
        bankAccount = new BankAccount(500, 0);
    }
    @Test
    public void testWithdraw() {
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }
    @Test
    public void testDeposit(){
        bankAccount.deposit(500);
        assertEquals(700, bankAccount.getBalance());
    }

    //@AfterAll
    @AfterAll
    //static para el all
    public void endTest(){
        System.out.println("Bye!");
    }
}
