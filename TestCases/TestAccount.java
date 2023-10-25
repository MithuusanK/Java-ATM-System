//Unit tests for the Account class//
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestAccount{
  
  @Test
public void testCreateAccount() {
  //Test if the new account object matches the 'Jane Doe' savings account as anticipated: savings; balance 3000; withdrawal limit 50//
  Account account = new Account(1);
        assertEquals("savings",
        account.getAccountTitle());

        assertEquals(3000,
        account.getBalance());

        assertEquals(50,
        account.getWithdrawLimit());
        
        assertEquals(1,
        account.getID());

        assertEquals("chequing -> Balance: 3000", account.toString());
}
  @Test
  public void testSetTitle(){
  //'John Smith' savings account initialized; change title to chequing, test//  
    Account account = new Account(0);
    account.setTitle("chequing");

    assertEquals(account.getAccountTitle(), "chequing");

}
  @Test
  public void testSetBalance(){
  //'John Smith' savings account initialized with balance 5000; set balance to 10, test//  
    Account account = new Account(0);
    account.setBalance(10);              assertEquals(account.getBalance(), 10);
}
  @Test  
  public void testDeposit(){
  //'John Smith' savings account initialized with a balance of 5000; deposit 100, test that the balance is 5100//  
      Account account = new Account(0);
      account.deposit(100);

      assertEquals(5100, account.getBalance());
}
  @Test  
    public void testWithdraw(){
  //'John Smith' savings account initialized with a balance of 5000; withdraw 100, test that the balance is 4900//  
      Account account = new Account(0);
      account.withdraw(100);
      assertEquals(4900, account.getBalance());
}
}