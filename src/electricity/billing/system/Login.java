package electricity.billing.system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField UserText, UserPassword;
    Choice LoginChoice;

    JButton LoginButton, CancelButton, SignupButton;

    Login(){
        super("Login");
        getContentPane().setBackground(Color.lightGray);


        JLabel Username = new JLabel("UserName");
        Username.setBounds(300,60,100,20);
        add(Username);

        UserText = new JTextField();
        UserText.setBounds(400,60,150,20);
        add(UserText);

        JLabel Password = new JLabel("Password");
        Password.setBounds(300,100, 100,20);
        add(Password);

        UserPassword = new JTextField();
        UserPassword.setBounds(400,100,150,20);
        add(UserPassword);

        JLabel Loggin = new JLabel ("Loggin in As");
        Loggin.setBounds(300,140,100,20);
        add(Loggin);

        LoginChoice = new Choice();
        LoginChoice.add("Admin");
        LoginChoice.add("Customer");
        LoginChoice.setBounds(400,140,150,20);
        add(LoginChoice);

        LoginButton = new JButton("Login");
        LoginButton.setBounds(330,180,100,20);
        LoginButton.addActionListener(this);
        add(LoginButton);

        CancelButton = new JButton("Cancel");
        CancelButton.setBounds(450,180,100,20);
        CancelButton.addActionListener(this);
        add(CancelButton);

        SignupButton = new JButton("Sign Up");
        SignupButton.setBounds(400,215,100,20);
        SignupButton.addActionListener(this);
        add(SignupButton);


        ImageIcon ProfileOne = new ImageIcon(ClassLoader.getSystemResource("icon/Profile.png"));
        Image ProfileTwo = ProfileOne.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
        ImageIcon fProfileOne = new ImageIcon(ProfileTwo);
        JLabel ProfileLable = new JLabel(fProfileOne);
        ProfileLable.setBounds(20,10,250,250);
        add(ProfileLable);







        setSize(640,300);
        setLocation(400,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==LoginButton){
            String susername = UserText.getText();
            String spassword = UserPassword.getText();
            String suser = LoginChoice.getSelectedItem();

            try{
                database c = new database();
                String query = "select * from Signup where username = '"+susername+"' and password = '"+spassword+"' and usertype = '"+suser+"'";
                ResultSet resultSet = c.statement.executeQuery(query);

                if (resultSet.next()){
                    String meter = resultSet.getString("meter_no");
                    setVisible(false);
                    new main_class(suser, meter);
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                }

            }catch (Exception E){
                E.printStackTrace();
            }


        } else if (e.getSource()==CancelButton) {
            setVisible(false);

        } else if (e.getSource()==SignupButton) {
            setVisible(false);
            new Signup();

            
        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
