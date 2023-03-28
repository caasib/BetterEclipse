package passwordGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGenerator implements ActionListener {
    private JFrame mainFrame = new JFrame("Password Generator");
    //The JPanel will hold all of our functional components
    //Never put components (other than panels) directly onto your frame
    private JPanel panel = new JPanel();
    private JLabel account = new JLabel("Account: ");
    private JLabel user = new JLabel("Username: ");
    private JLabel passLength = new JLabel("Password length: ");
    private JTextField accountBox = new JTextField(20);
    private JTextField userBox = new JTextField(20);
    private JRadioButton length8 = new JRadioButton("8");
    private JRadioButton length12 = new JRadioButton("12");
    private JRadioButton length16 = new JRadioButton("16");
    private ButtonGroup radios = new ButtonGroup();
    private JPanel buttonPanel = new JPanel();
    private JLabel generatePassword = new JLabel("Generate password: ");
    private JLabel password = new JLabel("");
    private JButton generate = new JButton("Generate");

    public PasswordGenerator() {
        mainFrame.setSize(500, 500);

        //All of our components will be added before the mainFrame is made visible
        mainFrame.setLayout(new GridBagLayout());
        panel.setLayout(new GridBagLayout()); //Allows us to place the components in a grid

        //We must add eventlisteners to trigger the actionPerformed method
        length8.addActionListener(this);
        length12.addActionListener(this);
        length16.addActionListener(this);
        generate.addActionListener(this);

        //Allows us to manipulate the col/row for the grid as well as alignment, width, etc.
        GridBagConstraints cons = new GridBagConstraints();

        cons.gridx = 0; //Sets the column of the component to be placed
        cons.gridy = 0; //Sets the row of the component to be placed
        panel.add(account, cons);

        cons.gridx = 1;
        cons.gridy = 0;
        panel.add(accountBox, cons);

        cons.gridx = 0;
        cons.gridy = 1;
        panel.add(user, cons);

        cons.gridx = 1;
        cons.gridy = 1;
        panel.add(userBox, cons);

        cons.gridx = 0;
        cons.gridy = 2;
        panel.add(passLength, cons);

        //Add the buttons to their own panel and add that panel to our main panel
        radios.add(length8);
        radios.add(length12);
        radios.add(length16);
        buttonPanel.add(length8);
        buttonPanel.add(length12);
        buttonPanel.add(length16);

        cons.gridx = 1;
        cons.gridy = 2;
        panel.add(buttonPanel, cons);

        cons.gridx = 0;
        cons.gridy = 3;
        panel.add(generatePassword, cons);

        cons.gridx = 1;
        cons.gridy = 3;
        panel.add(password, cons);

        cons.gridx = 1;
        cons.gridy = 4;
        panel.add(generate, cons);


        mainFrame.add(panel);
        mainFrame.setDefaultCloseOperation(3); //Stops the application from running
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generate) {
            if (length8.isSelected()) {
                password.setText(makePassword(8));
            }
            if (length12.isSelected()) {
                password.setText(makePassword(12));
            }
            if (length16.isSelected()) {
                password.setText(makePassword(16));
            }
        }
    }

    public String makePassword(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        characters += characters.toUpperCase();
        characters += "0123456789!@#$%^&*?";
        String password = "";
        for (int i = 0; i < length; i++) {
            int num = (int)(Math.random() * characters.length());
            password += characters.substring(num, num + 1);
        }
        return password;
    }

    public static void main(String[] args) {
        PasswordGenerator password = new PasswordGenerator();
    }
}
