// Account objects contain account information including balance and withdrawal limit//

class Account{
  private int accountID;
  private String accountType;
  private int accountBalance;
  private int withdrawLimit;
  
  
  // constructor//
  public Account(int accountID){
    this.accountID = accountID;
    this.accountType = Database.getAccountType(accountID);
    this.accountBalance = Database.getBalance(accountID);
    this.withdrawLimit = Database.getWithdrawLimit(accountID);
    
  }
  //Account type: chequing; savings//
  public void setTitle(String accountType){
    this.accountType = accountType;
  }

  //add amount to accountBalance//
  public void deposit(int amount){
    this.accountBalance += amount;
  }

  //subtract amount from accountBalance//
  public void withdraw(int amount){
    this.accountBalance -= amount;
  }
  
  public String getAccountTitle(){
    return accountType;
  }

     
  //returns the withdraw limit of the account//
  public int getWithdrawLimit(){
    return this.withdrawLimit;
  }

  //returns the integer balance of the account//
  public int getBalance(){
    return this.accountBalance;
  }

  // set the integer balance of an account to the amount//
  public void setBalance(int amount){
        this.accountBalance = amount;
  }
  // returns the integer value of the account ID//
  public int getID(){
    return accountID;
  }
  //returns the account type and balance in a string//
  public String toString(){
    return accountType + " -> Balance: " + Integer.toString(accountBalance);
  }
}