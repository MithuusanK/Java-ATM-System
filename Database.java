class Database{
  //Temporary dummy values to allow concurrent implementation
  //Current inventory of the ATM
  static int inv = 10000;

  //Arrays representing customer information
  static int[] userID = {0,1};
  static String[] userName = {"John Smith", "Jane Doe"};
  static int[] pin = {1234, 4321};
  
  //Arrays representing account information
  //userID 0, "John Smith", owns accounts 0 and 2
  //userID 1, "Jane Doe", owns accounts 1 and 3
  static int[][] accounts = {{0,2},{1,3}}; 
  static String[] accType = {"saving","saving","chequing","chequing"};
  static int[] balance = {5000,3000,4000,2500};
  static int[] withdrawLimits = {50, 50, 200, 300};


  //Returns the current number of $20 bills in the ATM
  static int getInventory(){
    return inv;
  }
  
  //Sets the current number of $20 bills to "amount"
  static void setInventory(int amount){
    inv = amount;
  }

  //Returns true is user exists, else returns false
  static boolean userExists(int userID){
    return (userID == 0 || userID == 1);
  }
  
  //Returns userName if user exists, else return "error"
  static String getUserName(int userID){
    if (userID == 0 || userID == 1) {
      return userName[userID];
    }
    else {
      return "error";
    }
  }

    
  //Returns account withdraw limit if user exists, else return -1
  static int getWithdrawLimit(int accountID){
    if (accountID == 0 || accountID == 1 || accountID == 2 || accountID == 3) {
      return withdrawLimits[accountID];
    }
    else {
      return -1;
    }
  }

  //Returns account type if user exists, else return error
  static String getAccountType(int accountID){
    if (accountID == 0 || accountID == 1 || accountID == 2 || accountID == 3) {
      return accType[accountID];
    }
    else {
      return "error";
    }
  }
  
  //Returns pin if user exists, else return 0
  static int getPin(int userID){ 
    if (userID == 0 || userID == 1) {
      return pin[userID];
    }
    else {
      return 0;
    }
  }
  
 //Returns an array containing the accounts owned by userID
  static int[] getAccountIDs(int userID){
    if (userID == 0 || userID == 1) {
      return accounts[userID];
    }
    else {
      int[] empty = {};
      return empty;
    }
  }

  //Returns the account type of a particular accNum
  static String getType(int accNum){
    return accType[accNum];  
  }
  
  //returns the balance of a particular accNum
  static int getBalance(int accNum){
    return balance[accNum];
  }

  //sets the balance of a particular accNum
  static void setBalance(int accNum,int amount){
    balance[accNum] = amount;
  }

  //returns the accounts of the user with given userID
  static Account[] getAccounts(int userID){
    int[] accountIDs = getAccountIDs(userID); 
    int totalAccounts = accountIDs.length;
    Account[] userAccounts = new Account[totalAccounts];
    
    for (int i = 0; i < totalAccounts; i++){
      int accNum = accountIDs[i];
      userAccounts[i] = new Account(accNum);
    }
    return userAccounts;
  }
}