import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
  private JLabel idLabel;
  private JTextField idField;
  private JButton loginButton;

  public Login() {
    // Set up the frame
    setTitle("ATM Login");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 300);
    setLayout(new FlowLayout());

    // Add a label and a text field for the ID input
    idLabel = new JLabel("Enter your ID:");
    add(idLabel);
    idField = new JTextField(20);
    add(idField);

    // Add a login button to submit the ID
    loginButton = new JButton("Login");
    add(loginButton);
    loginButton.addActionListener(this);

    // Display the frame
    setVisible(true);
  }

  // Defined the actionPerformed method to handle button clicks
  public void actionPerformed(ActionEvent event) {
    if (event.getSource() == loginButton) {
        String id = idField.getText();
        String message = checkID(id);
        JOptionPane.showMessageDialog(null, message);
        if (message.equals("ID Correct")){
          dispose();
        }
    }
  }
  
  
  // Defined the method to check the ID and return a message
  public String checkID(String id) {
    int userId = Integer.parseInt(id);
    if (Main.inputID(userId)) 
    {
      LoginPin loginPin = new LoginPin();
      loginPin.setVisible(true);
      return "ID Correct";
    } 
    else 
    {
      idField.setText("");
      return "Invalid ID. Please Re-Enter";
    }
  }
  
}
