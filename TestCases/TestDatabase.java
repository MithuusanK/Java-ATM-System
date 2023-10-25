import static org.junit.Assert.*;
import org.junit.Test;

class TestDatabase {
  @Test
  public void testGetInventory() {
    assertEquals(10000, Database.getInventory());
  }

  @Test
  public void testSetInventory() {
    Database.setInventory(9000);
    assertEquals(9000, Database.getInventory());
  }

  @Test
  public void testUserExists() {
    assertEquals(true, Database.userExists(0));
  }

  @Test
  public void testGetUsername() {
    assertEquals("John Smith", Database.getUserName(0));
  }

  @Test
  public void testGetWithdrawLimit() {
    assertEquals(200, Database.getWithdrawLimit(2));
  }

  @Test
  public void testGetAccountType() {
    assertEquals("saving", Database.getAccountType(1));
  }

  @Test
  public void testGetPin() {
    assertEquals(4321, Database.getPin(1));
  }

  @Test
  public void testGetAccountIDs() {
    int[] ids = { 0, 2 };
    assertEquals(ids, Database.getAccountIDs(0));
  }

  @Test
  public void testGetBalance() {
    assertEquals(2500, Database.getBalance(3));
  }

  @Test
  public void testSetBalance() {
    Database.setBalance(0, 9000);
    assertEquals(9000, Database.getBalance(0));
  }

}