package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class newCustomer extends JFrame implements ActionListener {


    JLabel heading, meterText, customerName, meterNum, address, city, state, email, phone;
    JButton next, cancel;
    JTextField nameText, addrText, cityText, stateText, emailText, phoneText;

    newCustomer(){
        super("New Customer");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        heading = new JLabel("New Customer");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma", Font.BOLD,20));
        panel.add(heading);

        customerName = new JLabel("New Customer");
        customerName.setBounds(50,80,100,20);
        panel.add(customerName);

        nameText = new JTextField();
        nameText.setBounds(180,80,150,20);
        panel.add(nameText);

        meterNum = new JLabel("Meter Number");
        meterNum.setBounds(50,120,100,20);
        panel.add(meterNum);

        meterText = new JLabel("");
        meterText.setBounds(180,120,150,20);
        panel.add(meterText);

        Random num = new Random();
        long number = num.nextLong() % 1000000;
        meterText.setText(""+ Math.abs(number));


        address = new JLabel("Address");
        address.setBounds(50,160,100,20);
        panel.add(address);

        addrText = new JTextField();
        addrText.setBounds(180,160,150,20);
        panel.add(addrText);

        city = new JLabel("City");
        city.setBounds(50,200,100,20);
        panel.add(city);

        cityText = new JTextField();
        cityText.setBounds(180,200,150,20);
        panel.add(cityText);

        state = new JLabel("State");
        state.setBounds(50,240,100,20);
        panel.add(state);

        stateText = new JTextField();
        stateText.setBounds(180,240,150,20);
        panel.add(stateText);

        email = new JLabel("Email");
        email.setBounds(50,280,100,20);
        panel.add(email);

        emailText = new JTextField();
        emailText.setBounds(180,280,150,20);
        panel.add(emailText);

        phone = new JLabel("Phone Number");
        phone.setBounds(50,320,100,20);
        panel.add(phone);

        phoneText = new JTextField();
        phoneText.setBounds(180,320,150,20);
        panel.add(phoneText);


        next = new JButton("Next");
        next.setBounds(80,390,100,25);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        panel.add(next);


        cancel = new JButton("Cancel");
        cancel.setBounds(200,390,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        panel.add(cancel);



        setLayout(new BorderLayout());
        add(panel, "Center");


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
        Image i2 = i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imglabel = new JLabel(i3);
        add(imglabel,"West");

        setSize(700,500);
        setLocation(400,150);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==next){
            String sname = nameText.getText();
            String smeter = meterText.getText();
            String saddress = addrText.getText();
            String scity = cityText.getText();
            String sstate = stateText.getText();
            String semail = emailText.getText();
            String sphone = phoneText.getText();


            String query_customer = "insert into new_customer values('"+sname+"', '"+smeter+"', '"+saddress+"', '"+scity+"', '"+sstate+"', '"+semail+"', '"+sphone+"')";
            String query_signup = "insert into Signup values('"+smeter+"','','"+sname+"','','')";

            try{
                database c = new database();
                c.statement.executeUpdate(query_customer);
                c.statement.executeUpdate(query_signup);

                JOptionPane.showMessageDialog(null, "Customer details added successfully");
                setVisible(false);
                new meterinfo(smeter);

            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {

        new newCustomer();

    }

}
