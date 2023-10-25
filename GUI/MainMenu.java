import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JFrame implements ActionListener {

  private JButton viewBalanceButton;
  private JButton transferButton;
  private JButton withdrawButton;
  private JButton depositButton;
  private JButton exitButton;
  double balance = 5000.00;
  double check_Bal = 2000.00;
  double sav_Bal = 3000.00;

  public MainMenu() {
    super("Main Menu");

    // Create buttons
    viewBalanceButton = new JButton("View Balance");
    transferButton = new JButton("Transfer Funds");
    withdrawButton = new JButton("Withdraw");
    depositButton = new JButton("Deposit");
    exitButton = new JButton("Exit");

    // Add action listeners to buttons
    viewBalanceButton.addActionListener(this);
    transferButton.addActionListener(this);
    withdrawButton.addActionListener(this);
    depositButton.addActionListener(this);
    exitButton.addActionListener(this);

    // Add components to the frame
    JPanel panel = new JPanel(new GridLayout(5, 1));
    panel.add(viewBalanceButton);
    panel.add(transferButton);
    panel.add(withdrawButton);
    panel.add(depositButton);
    panel.add(exitButton);
    add(panel);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 400);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == viewBalanceButton) {
      // Display the user's balance
      getBalance();
    } else if (e.getSource() == transferButton) {
      // Call transfer funds method
      transferFunds();
    } else if (e.getSource() == withdrawButton) {
      // Call withdraw method
      withdraw();
    } else if (e.getSource() == depositButton) {
      // Call deposit method
      deposit();
    } else if (e.getSource() == exitButton) {
      exit();
    }
  }

  public void getBalance() {
    balance = check_Bal + sav_Bal;
    JOptionPane.showMessageDialog(null, "Checking Balance: $" + check_Bal + "\nSavings Balance: $" + sav_Bal);

  }

  public void transferFunds() {

    // Ask the user for the transfer amount
    double transferAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter amount to transfer:"));

    // Ask the user which account to transfer from
    String[] options = { "Checking Account", "Savings Account" };
    int fromAccount = JOptionPane.showOptionDialog(null, "Transfer from which account?", "Transfer Funds",
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

    // Ask the user which account to transfer to
    int toAccount = (fromAccount == 0) ? 1 : 0; // if fromAccount is 0, toAccount is 1, else toAccount is 0

    // Determine the current balance of the fromAccount
    double currentFromBalance = (fromAccount == 0) ? getCheckingBalance() : getSavingsBalance();

    // Ensure the transfer amount is less than or equal to the balance of the
    // fromAccount
    if (transferAmount > currentFromBalance) {
      JOptionPane.showMessageDialog(null, "Error: Transfer amount exceeds the balance of the " +
          ((fromAccount == 0) ? "checking account" : "savings account"));
    } else {
      // Update the balances of the fromAccount and toAccount
      double newFromBalance = currentFromBalance - transferAmount;
      double currentToBalance = (toAccount == 0) ? getCheckingBalance() : getSavingsBalance();
      double newToBalance = currentToBalance + transferAmount;

      // Update the balances of the accounts
      if (fromAccount == 0) {
        setCheckingBalance(newFromBalance);
        setSavingsBalance(newToBalance);
      } else {
        setSavingsBalance(newFromBalance);
        setCheckingBalance(newToBalance);
      }

      // Display a message to the user
      JOptionPane.showMessageDialog(null, "Transferring $" + transferAmount + " from " +
          ((fromAccount == 0) ? "checking account" : "savings account") + " to " +
          ((toAccount == 0) ? "checking account" : "savings account") + ".\nNew checking account balance: $"
          + getCheckingBalance() +
          "\nNew savings account balance: $" + getSavingsBalance());
    }
  }

  public void withdraw() {
    // Ask the user which account to withdraw from
    String[] options = { "Checking Account", "Savings Account" };
    int account = JOptionPane.showOptionDialog(null, "Which account do you want to withdraw from?", "Withdraw",
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

    // Ask the user for the withdrawal amount
    double withdrawAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter amount to withdraw:"));

    // Check if the withdrawal amount is valid
    if (account == 0) {
      // Withdraw from checking account
      double currentCheckingBalance = getCheckingBalance();
      if (withdrawAmount <= currentCheckingBalance) {
        double newCheckingBalance = currentCheckingBalance - withdrawAmount - 1;
        setCheckingBalance(newCheckingBalance);
        JOptionPane.showMessageDialog(null, "Withdrawing $" + withdrawAmount
            + " from checking account.\nNew checking account balance: $" + newCheckingBalance
            + "\nWithdrawal fee of $1.00 included");
      } else {
        JOptionPane.showMessageDialog(null, "Withdrawal amount exceeds checking account balance.");
      }
    } else if (account == 1) {
      // Withdraw from savings account
      double currentSavingsBalance = getSavingsBalance();
      if (withdrawAmount <= currentSavingsBalance) {
        double newSavingsBalance = currentSavingsBalance - withdrawAmount - 1;
        setSavingsBalance(newSavingsBalance);
        JOptionPane.showMessageDialog(null, "Withdrawing $" + withdrawAmount
            + " from savings account.\nNew savings account balance: $" + newSavingsBalance
            + "\nWithdrawal fee of $1.00 included");
      } else {
        JOptionPane.showMessageDialog(null, "Withdrawal amount exceeds savings account balance.");
      }
    }
  }

  public void exit() {
    JOptionPane.showMessageDialog(null,
        "Checking Balance: $" + check_Bal + "\nSavings Balance: $" + sav_Bal + "\nHave a great day :)");
    dispose();
  }

  public void deposit() {
    // Ask the user which account to deposit into
    String[] options = { "Checking Account", "Savings Account" };
    int account = JOptionPane.showOptionDialog(null, "Which account do you want to deposit into?", "Deposit",
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

    // Ask the user for the deposit amount
    double depositAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter amount to deposit:"));

    // Deposit the amount into the selected account
    if (account == 0) {
      // Deposit into checking account
      double currentCheckingBalance = getCheckingBalance();
      double newCheckingBalance = currentCheckingBalance + depositAmount;
      setCheckingBalance(newCheckingBalance);
      JOptionPane.showMessageDialog(null, "Depositing $" + depositAmount
          + " into checking account.\nNew checking account balance: $" + newCheckingBalance);
    } else if (account == 1) {
      // Deposit into savings account
      double currentSavingsBalance = getSavingsBalance();
      double newSavingsBalance = currentSavingsBalance + depositAmount;
      setSavingsBalance(newSavingsBalance);
      JOptionPane.showMessageDialog(null, "Depositing $" + depositAmount
          + " into savings account.\nNew savings account balance: $" + newSavingsBalance);
    }
  }

  public double getCheckingBalance() {

    return check_Bal;
  }

  public void setCheckingBalance(double newBalance) {
    check_Bal = newBalance;
  }

  public double getSavingsBalance() {

    return sav_Bal;
  }

  public void setSavingsBalance(double newBalance) {
    sav_Bal = newBalance;
  }

}
