import org.junit.Test;
import static org.junit.Assert.*;

public class TestTransaction {
    private static Account acc1;
    private static Account acc2;

    
    public static void setup() {
        // Create two accounts for testing
        acc1 = new Account(0);
        acc2 = new Account(1);
    }


  
    @Test
    public void testDepositCheque() {
        // Create an account object with initial balance of $1000
        Account account = new Account(0);
        assertEquals(5000, account.getBalance());

        // Deposit a cheque of $2000 into the account
        Transaction.depositCheque(account, 2000);

        // Assert that the account balance has been updated to $7000
        assertEquals(7000, account.getBalance());
    }

    @Test
    public void testDepositCash() {
        // Create an account object with initial balance of $1000
        Account account = new Account(0);
        assertEquals(5000, account.getBalance());

        // Deposit $100 cash (5 bills of $20) into the account
        Transaction.depositCash(account, 100, 5);

        // Assert that the account balance has been updated to $5100
        assertEquals(5100, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        // Create an account object with initial balance of $1000
        Account account = new Account(0);
        assertEquals(5000, account.getBalance());

        // Withdraw $200 from the account
        String result = Transaction.withdraw(account, 200);

        // Assert that the transaction was successful and the account balance has been updated to $4800
        assertEquals("Transaction was successful", result);
        assertEquals(4800, account.getBalance());

        // Attempt to withdraw $1000 (which exceeds the withdraw limit of $50) from the account
        result = Transaction.withdraw(account, 1000);

        // Assert that the transaction failed and the account balance remains unchanged
        assertEquals("Withdrawal amount exceeds limit", result);
        assertEquals(4800, account.getBalance());

        // Attempt to withdraw $5000 (which exceeds the account balance) from the account
        result = Transaction.withdraw(account, 5000);

        // Assert that the transaction failed and the account balance remains unchanged
        assertEquals("Insufficient funds", result);
        assertEquals(4800, account.getBalance());
    }
  @Test
    public void testTransferSufficientBalance() {
        // Test transfer with sufficient balance in the source account
        int amount = 1000;
        acc1.setBalance(2000);
        acc2.setBalance(500);
        String result = Transaction.transfer(acc1, acc2, amount);
        assertEquals("Transaction was successful", result);
        assertEquals(1000, acc1.getBalance());
        assertEquals(1500, acc2.getBalance());
    }

    @Test
    public void testTransferInsufficientBalance() {
        // Test transfer with insufficient balance in the source account
        int amount = 5000;
        acc1.setBalance(2000);
        acc2.setBalance(500);
        String result = Transaction.transfer(acc1, acc2, amount);
        assertEquals("Insufficient balance", result);
        assertEquals(2000, acc1.getBalance());
        assertEquals(500, acc2.getBalance());
    }

    @Test
    public void testTransferNegativeAmount() {
        // Test transfer with negative amount
        int amount = -1000;
        acc1.setBalance(2000);
        acc2.setBalance(500);
        String result = Transaction.transfer(acc1, acc2, amount);
        assertEquals("Invalid amount", result);
        assertEquals(2000, acc1.getBalance());
        assertEquals(500, acc2.getBalance());
    }
  
}
