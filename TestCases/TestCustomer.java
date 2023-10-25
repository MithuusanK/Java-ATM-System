import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestCustomer {

  @Test
  public void customerGetUserID() {
    Customer user = new Customer(1);
    assertEquals(1, user.getId());
  }

  @Test
  public void customerGetUsername() {
    Customer user = new Customer(1);
    assertEquals("Jane Doe", user.getUsername());
  }

}