/* class Customer defines a registered customer. It keeps track of the customer's userID, userName and accounts.

*/

class Customer{

  private int userID;
  private String userName;
  private Account[] userAccounts;

  // constructor (initialize)

  public Customer(int id) {
    //if id == -1, create a dummy Customer object 
    if (id != -1){
      //initialize variables
      this.userID = id;
      this.userName = Database.getUserName(id);
  
      //fill Account[] with Account objects held by customer
      userAccounts = new Account[Database.getAccounts(id).length];
      userAccounts = Database.getAccounts(id);
    }
  }

  public Account[] getAccounts(){
    return userAccounts;
  }

  // Returns the User Id 
  public int getId(){
    return this.userID;
  }

  public String getUsername(){
    return this.userName;
  }

  // toString()
  public String toString(){
    String toReturn = "";
    for (int i = 0; i < this.getAccounts().length; i++){
      toReturn = toReturn + Integer.toString(i) + ": " + this.getAccounts()[i].toString() + "\n";
    }
    return toReturn;
  }
}

