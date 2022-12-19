package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class NewCustomer extends JFrame implements ActionListener {
    JTextField tfName,tfAddress,tfCity,tfState,tfEmail,tfPhone;
    JButton next,cancel;
    JLabel  lblMeter;

    NewCustomer(){
        setBounds(400,200,800,550);
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);

        JLabel  heading = new JLabel("New Customer");
        heading.setBounds(250,25,250,25);
        heading.setFont(new Font("Thoma",Font.PLAIN,30));
        p.add(heading);

        JLabel  lblName = new JLabel("Customer Name");
        lblName.setBounds(150,95,150,20);
        lblName.setFont(new Font("Thoma",Font.PLAIN,20));
        p.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(350,95,200,20);
        p.add(tfName);

        JLabel  lblMeterNo = new JLabel("Meter Number");
        lblMeterNo.setBounds(150,135,150,20);
        lblMeterNo.setFont(new Font("Thoma",Font.PLAIN,20));
        p.add(lblMeterNo);



        lblMeter = new JLabel();
        lblMeter.setBounds(350,135,150,20);
        lblMeter.setFont(new Font("Thoma",Font.PLAIN,20));
        p.add(lblMeter);

        Random ran = new Random();
        long number  = ran.nextLong() % 1000000;
        lblMeter.setText(""+Math.abs(number));

        JLabel  lblAddress = new JLabel("Address");
        lblAddress.setBounds(150,175,150,20);
        lblAddress.setFont(new Font("Thoma",Font.PLAIN,20));
        p.add(lblAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(350,175,200,20);
        p.add(tfAddress);

        JLabel  lblCity = new JLabel("City");
        lblCity.setBounds(150,215,150,20);
        lblCity.setFont(new Font("Thoma",Font.PLAIN,20));
        p.add(lblCity);

        tfCity = new JTextField();
        tfCity.setBounds(350,215,200,20);
        p.add(tfCity);

        JLabel  lblState = new JLabel("State");
        lblState.setBounds(150,255,150,20);
        lblState.setFont(new Font("Thoma",Font.PLAIN,20));
        p.add(lblState);

        tfState = new JTextField();
        tfState.setBounds(350,255,200,20);
        p.add(tfState);

        JLabel  lblEmail = new JLabel("Email");
        lblEmail.setBounds(150,295,150,20);
        lblEmail.setFont(new Font("Thoma",Font.PLAIN,20));
        p.add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(350,295,200,20);
        p.add(tfEmail);

        JLabel  lblPhone = new JLabel("Phone Number");
        lblPhone.setBounds(150,335,150,20);
        lblPhone.setFont(new Font("Thoma",Font.PLAIN,20));
        p.add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(350,335,200,20);
        p.add(tfPhone);

        next = new JButton("Next");
        next.setBounds(180,375,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(360,375,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);

        add(p,"Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,300,1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image,"West");


        setVisible(true);
    }
    public static void main(String[] args) {
        new NewCustomer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next)
        {
            String name = tfName.getText();
            String meter = lblMeter.getText();
            String address = tfAddress.getText();
            String city = tfCity.getText();
            String state = tfState.getText();
            String email = tfEmail.getText();
            String phone = tfPhone.getText();


            String query1 = "insert into customer values('"+name+"', '"+meter+"', '"+address+"', '"+city+"', '"+state+"', '"+email+"', '"+phone+"')";
            String query2 = "insert into login values('"+meter+"', '', '"+name+"', '', '')";

            try{
                conn c = new conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Customer details added successfully");
                setVisible(false);

                new MeterInfo(meter);

//                new MeterInfo();
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else if(e.getSource()==cancel)
        {
            setVisible(false);
        }
    }
}
