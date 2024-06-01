package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class meterinfo extends JFrame implements ActionListener {

    JLabel header, meternum, meterText, meterLoc, meterType, phasecode, billtype, days, note, note1;
    Choice meterchoice, metertypecho, phasechoice, billchoice;
    JButton submit;
    String meternumber;

    meterinfo(String meternumber){
        super ("Meter Information");

        this.meternumber = meternumber;

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        header = new JLabel("Meter Information");
        header.setBounds(180,10,200,20);
        header.setFont(new Font("Tahoma", Font.BOLD,20));
        panel.add(header);


        meternum = new JLabel("Meter Number");
        meternum.setBounds(50,80,100,20);
        panel.add(meternum);

        meterText = new JLabel(meternumber);
        meterText.setBounds(180,80,150,20);
        panel.add(meterText);


        meterLoc = new JLabel("Meter Location");
        meterLoc.setBounds(50,120,100,20);
        panel.add(meterLoc);

        meterchoice = new Choice();
        meterchoice.add("Outside");
        meterchoice.add("Inside");
        meterchoice.setBounds(180,120,150,20);
        panel.add(meterchoice);

        meterType = new JLabel("Meter Type");
        meterType.setBounds(50,160,100,20);
        panel.add(meterType);

        metertypecho = new Choice();
        metertypecho.add("Electric Meter");
        metertypecho.add("Solar Meter");
        metertypecho.add("Smart Meter");
        metertypecho.setBounds(180,160,150,20);
        panel.add(metertypecho);

        phasecode = new JLabel("Phase Code");
        phasecode.setBounds(50,200,100,20);
        panel.add(phasecode);

        phasechoice = new Choice();
        phasechoice.add("011");
        phasechoice.add("022");
        phasechoice.add("033");
        phasechoice.add("044");
        phasechoice.add("055");
        phasechoice.add("066");
        phasechoice.add("077");
        phasechoice.add("088");
        phasechoice.add("099");
        phasechoice.setBounds(180,200,150,20);
        panel.add(phasechoice);


        billtype = new JLabel("Bill Type");
        billtype.setBounds(50,240,100,20);
        panel.add(billtype);

        billchoice = new Choice();
        billchoice.add("Normal");
        billchoice.add("Industrial");
        billchoice.setBounds(180,240,150,20);
        panel.add(billchoice);


        days = new JLabel("30 Days Billing Time...");
        days.setBounds(50,280,150,20);
        panel.add(days);


        note = new JLabel("Note:-");
        note.setBounds(50,320,100,20);
        panel.add(note);

        note1 = new JLabel("By Default The Bill Is Calculated For 30 Days Only");
        note1.setBounds(50,340,300,20);
        panel.add(note1);


        submit = new JButton("Submit");
        submit.setBounds(220,390,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        panel.add(submit);




        setLayout(new BorderLayout());
        add(panel, "Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/details.png"));
        Image i2 = i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imglabel = new JLabel(i3);
        add(imglabel, "East");









        setSize(700,500);
        setLocation(400,150);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit){
            String smeterNum = meternumber;
            String smeterloc = meterchoice.getSelectedItem();
            String smeterType = metertypecho.getSelectedItem();
            String sphase = phasechoice.getSelectedItem();
            String sbilltype = billchoice.getSelectedItem();
            String sday = "30";

            String query_meterInfo = "insert into meter_info values ('"+smeterNum+"', '"+smeterloc+"', '"+smeterType+"', '"+sphase+"', '"+sbilltype+"', '"+sday+"')";

            try{
                database c = new database();
                c.statement.executeUpdate(query_meterInfo);

                JOptionPane.showMessageDialog(null, "Meter Information Submitted Successfully");
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {

        new meterinfo("");

    }
}
