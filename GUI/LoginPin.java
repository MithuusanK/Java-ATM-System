import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPin extends JFrame implements ActionListener {
    private JLabel idLabel;
    private JTextField idField;
    private JButton loginButton;

  public LoginPin() {
    // Set up the frame
    setTitle("ATM Login");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 300);
    setLayout(new FlowLayout());

    // Add a label and a text field for the ID input
    idLabel = new JLabel("Enter your Pin:");
    add(idLabel);
    idField = new JTextField(20);
    add(idField);

    // Add a login button to submit the ID
    loginButton = new JButton("Enter");
    add(loginButton);
    loginButton.addActionListener(this);

    // Display the frame
    setVisible(true);
  }

  // Defined the actionPerformed method to handle button clicks
  public void actionPerformed(ActionEvent event) {
      if (event.getSource() == loginButton) {
          String pin = idField.getText();
          String message = checkID(pin);
          JOptionPane.showMessageDialog(null, message);
        if (message.equals("Pin Correct")){
            dispose();
        }
      }
  }
  
  // Defined the method to check the ID and return a message
  public String checkID(String pin) {
    int userPin = Integer.parseInt(pin);
    if(Main.inputPin(userPin))  
    {
      MainMenu menu = new MainMenu();
      menu.setVisible(true);
      return "Pin Correct";
    }
    else 
    {
      idField.setText("");
      return "Incorrect Pin. Please Re-Enter";  
    }
  }
  
}
