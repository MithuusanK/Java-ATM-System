import org.junit.Test;
import static org.junit.Assert.*;

public class TestMain {

    @Test
    public void testInputID() {
        assertTrue(Main.inputID(0));
        assertFalse(Main.inputID(100));
    }

    @Test
    public void testInputPin() {
        assertTrue(Main.inputID(0)); // must call inputID first
        assertTrue(Main.inputPin(1234));
        assertFalse(Main.inputPin(4321));
    }

    @Test
    public void testGetAccounts() {
        assertTrue(Main.inputID(0)); // must call inputID first
        assertTrue(Main.inputPin(1234)); // must call inputPin first
        assertNotNull(Main.getAccounts());
    }

    @Test
    public void testDepositCheque() {
        assertTrue(Main.inputID(0)); // must call inputID first
        assertTrue(Main.inputPin(1234)); // must call inputPin first
        Account[] accounts = Main.getAccounts();
        assertNotNull(accounts);
        assertEquals("Transaction was successful", Main.depositCheque(accounts[0], 500));
    }

    @Test
    public void testDepositCash() {
        assertTrue(Main.inputID(1)); // must call inputID first
        assertTrue(Main.inputPin(4321)); // must call inputPin first
        Account[] accounts = Main.getAccounts();
        assertNotNull(accounts);
        assertEquals("Transaction was successful", Main.depositCash(accounts[1], 500, 5));
    }

    @Test
    public void testWithdraw() {
        assertTrue(Main.inputID(0)); // must call inputID first
        assertTrue(Main.inputPin(1234)); // must call inputPin first
        Account[] accounts = Main.getAccounts();
        assertNotNull(accounts);
        assertEquals("Transaction was successful", Main.withdraw(accounts[0], 50));
        assertEquals("Withdrawal amount exceeds balance", Main.withdraw(accounts[0], 5500));
    }

    @Test
    public void testTransfer() {
        assertTrue(Main.inputID(0)); // must call inputID first
        assertTrue(Main.inputPin(1234)); // must call inputPin first
        Account[] accounts = Main.getAccounts();
        assertNotNull(accounts);
        assertEquals("Transaction was successful", Main.transfer(accounts[0], accounts[2], 500));
        assertEquals("Withdrawal amount exceeds balance", Main.transfer(accounts[0], accounts[2], 5500));
    }

    @Test
    public void testExit() {
        assertEquals("Successfully logged out", Main.exit());
    }
}
