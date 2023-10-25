/*
  The Main class holds several methods to allow the user to take
  actions about their bank accounts. It is structured for the GUI
  to be able connect text fields to methods intuitively. The GUI
  is implemented in the main method through Java Swing.
*/

import javax.swing.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

import org.hamcrest.core.IsInstanceOf;

import junit.framework.JUnit4TestCaseFacade;

class Main {

  // temporary variables
  private static int tempUserID = -1;
  public static Customer tempCustomer = new Customer(-1);

  // ---LOGIN----------------------------

  // if ID exists on database, return true, else return false
  static boolean inputID(int userID) {
    tempUserID = userID;
    return Database.userExists(userID);
  }

  // if PIN corresponds with tempUserID, create tempCustomer and return true, else
  // return false
  static boolean inputPin(int PIN) {
    if (PIN == Database.getPin(tempUserID)) {
      tempCustomer = new Customer(tempUserID);
      return true;
    }
    return false;
  }

  // ---ACTION---------------------------

  // return customer accounts
  static Account[] getAccounts() {
    return tempCustomer.getAccounts();
  }

  // deposit a cheque, if successful return "Transaction was successful"
  static String depositCheque(Account account, int amount) {
    return Transaction.depositCheque(account, amount);
  }

  // deposit cash, if successful return "Transaction was successful"
  static String depositCash(Account account, int amount, int bills) {
    return Transaction.depositCash(account, amount, bills);
  }

  // if withdraw is successful, return "Transaction was successful",
  // else return string diagnosing issue with withdraw
  static String withdraw(Account account, int amount) {
    return Transaction.withdraw(account, amount);
  }

  // if transfer is successful, "Transaction was successful",
  // else return string diagnosing issue with transfer
  static String transfer(Account originAccount, Account destinationAccount, int amount) {
    return Transaction.transfer(originAccount, destinationAccount, amount);
  }

  // reset temp variables, as in log out user
  static String exit() {
    tempUserID = -1;
    tempCustomer = new Customer(-1);
    return ("Successfully logged out");
  }

  public static void main(String[] args) {
    

    // GUI implementation goes here
    JOptionPane.showMessageDialog(null, "Welcome to the Banking ATM System");
    new Login();    
    

  }
}