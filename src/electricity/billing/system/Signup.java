package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Signup extends JFrame implements ActionListener {

    Choice CreateAsChoice;
    TextField MeterText,EmployeeText,UserText, NameText, PassText;
    JButton create, back;


    Signup(){
        super ("Signup Page");

        getContentPane().setBackground(Color.lightGray);

        JLabel CreateAs = new JLabel("Create Account As");
        CreateAs.setBounds(30,50,125,20);
        add(CreateAs);

        CreateAsChoice = new Choice();
        CreateAsChoice.add("Admin");
        CreateAsChoice.add("Customer");
        CreateAsChoice.setBounds(170,50,125,20);
        add(CreateAsChoice);

        JLabel MeterNo = new JLabel("Meter Number");
        MeterNo.setBounds(30, 100,125,20);
        MeterNo.setVisible(false);
        add(MeterNo);


        MeterText = new TextField();
        MeterText.setBounds(170,100,125,20);
        MeterText.setVisible(false);
        add(MeterText);


        JLabel EmployeeID = new JLabel("Employee ID");
        EmployeeID.setBounds(30, 100,125,20);
        EmployeeID.setVisible(true);
        add(EmployeeID);


        EmployeeText = new TextField();
        EmployeeText.setBounds(170,100,125,20);
        EmployeeText.setVisible(true);
        add(EmployeeText);

        JLabel Username = new JLabel("UserName");
        Username.setBounds(30,140,125,20);
        add(Username);

        UserText = new TextField();
        UserText.setBounds(170,140,125,20);
        add(UserText);


        JLabel name = new JLabel("Name");
        name.setBounds(30,180,125,20);
        add(name);

        NameText = new TextField("");
        NameText.setBounds(170,180,125,20);
        add(NameText);

        MeterText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {

                try{
                    database c = new database();
                    ResultSet resultSet = c.statement.executeQuery("select * from Signup where meter_no = '"+MeterText.getText()+"' ");
                    if (resultSet.next()){
                        NameText.setText(resultSet.getString("name"));

                    }
                }catch (Exception E){
                    E.printStackTrace();
                }


            }
        });




        JLabel Password = new JLabel("PassWord");
        Password.setBounds(30,220,125,20);
        add(Password);

        PassText = new TextField();
        PassText.setBounds(170,220,125,20);
        add(PassText);


        CreateAsChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = CreateAsChoice.getSelectedItem();

                if (user.equals("Customer")){
                    EmployeeID.setVisible(false);
                    NameText.setEditable(false);
                    EmployeeText.setVisible(false);
                    MeterNo.setVisible(true);
                    MeterText.setVisible(true);
                } else {
                    EmployeeID.setVisible(true);
                    EmployeeText.setVisible(true);
                    MeterNo.setVisible(false);
                    MeterText.setVisible(false);

                }

            }
        });

        create = new JButton("Create");
        create.setBounds(50,280,100,25);
        create.addActionListener(this);
        add(create);

        back = new JButton("Back");
        back.setBounds(180,280,100,25);
        back.addActionListener(this);
        add(back);

       ImageIcon SignupIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Signup.png"));
       Image SignUp = SignupIcon.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
       ImageIcon SignupIcon2 = new ImageIcon(SignUp);
       JLabel SignupLabel = new JLabel(SignupIcon2);
       SignupLabel.setBounds(320,30,250,250);
       add(SignupLabel);









     setSize(600,380);
     setLocation(500,200);
     setLayout(null);
     setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if (e.getSource()==create){
         String sloginAs = CreateAsChoice.getSelectedItem();
         String susername = UserText.getText();
         String sname = NameText.getText();
         String spassword = PassText.getText();
         String smeter = MeterText.getText();

         try{
             database c = new database();
             String query = null;
             if (CreateAsChoice.equals("Admin")) {
                 query = "insert into Signup value('" + smeter + "', '" + susername + "', '" + sname + "', '" + spassword + "', '" + sloginAs + "')";
             }else {
                 query = "update Signup set username = '"+susername+"', password = '"+spassword+"', usertype = '"+sloginAs+"' where meter_no = '"+smeter+"' ";
             }
             c.statement.executeUpdate(query);

             JOptionPane.showMessageDialog(null, "Account Created Successfully");
             setVisible(false);
             new Login();

         }catch (Exception E){
             E.printStackTrace();
         }

     } else if (e.getSource()==back) {
         setVisible(false);
         new Login();

     }
    }

    public static void main(String[] args) {
       new Signup();
    }
}
