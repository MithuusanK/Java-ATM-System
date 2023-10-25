public class Transaction {

  static int withdrawCharge = 1;

  public static String depositCheque(Account account, int amount) {
      account.deposit(amount);
      Database.setBalance(account.getID(), account.getBalance());
      return ("Transaction was successful");
  }

  public static String depositCash(Account account, int amount, int bills) {
    
      //Updating database
      int current = Database.getInventory();
      Database.setInventory(current + bills);
      
      //Updating account
      account.deposit(amount);
      Database.setBalance(account.getID(), account.getBalance());
      
      //Output
      return ("Transaction was successful");

  }

  public static String withdraw(Account account, int amount) {

    int balance = account.getBalance();
    int limit = account.getWithdrawLimit();

    //check the account withdrawal limit
    if (amount > limit) {
        return ("Transaction failed -> Exceeded withdrawal limit");
         
    //check the account balance 
    } if (amount + withdrawCharge > balance) {
        return ("Transaction failed -> Insufficient fund");

    //check the atm inventory
    } if (amount > Database.getInventory()) {
      return ("Transaction failed -> Technical error");
    }
         
    //Updating account
    account.withdraw(amount);
         
    //charge account
    Database.setInventory(Database.getInventory() - amount);
        
    //Updating database
    charge(account);
    Database.setBalance(account.getID(), account.getBalance());
        
    return ("Transaction was successful");
  }

  private static void charge(Account account) {
      //each transaction would charge 1$ fee
      account.withdraw(withdrawCharge);
  }


public static String transfer(Account originAccount, Account destinationAccount, int amount) {
    int balance = originAccount.getBalance();
    int limit = originAccount.getWithdrawLimit();

    //check the originAccount withdrawal limit
    if (amount > limit) {
        return ("Transaction failed -> Exceeded withdrawl limit");

    //check originAccount balance
    } if (amount > balance) {
      System.out.println("Transaction failed -> Insufficient fund");
    }

    //charge
    charge(originAccount);
  
    //Updating originAccount
    originAccount.withdraw(amount);
    Database.setBalance(originAccount.getID(), originAccount.getBalance());
  
    //Updating destinationAccount
    destinationAccount.deposit(amount);
    Database.setBalance(destinationAccount.getID(), destinationAccount.getBalance());

    return ("Transaction was successful");
  }  
}