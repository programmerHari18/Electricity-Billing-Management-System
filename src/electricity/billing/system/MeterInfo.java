package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MeterInfo extends JFrame implements ActionListener {
    JTextField tfName,tfAddress,tfCity,tfState,tfEmail,tfPhone;
    JButton next,cancel;
    JLabel  lblMeter;
    Choice meterLocation,meterType,phaseCode,billType;
    String meterNumber;
    MeterInfo(String meterNumber){
        this.meterNumber=meterNumber;
        setBounds(400,200,800,550);
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);

        JLabel  heading = new JLabel("Meter Information");
        heading.setBounds(250,25,250,25);
        heading.setFont(new Font("Thoma",Font.PLAIN,30));
        p.add(heading);

        JLabel  lblName = new JLabel("Meter Number");
        lblName.setBounds(150,95,150,20);
        lblName.setFont(new Font("Thoma",Font.PLAIN,20));
        p.add(lblName);

        JLabel  lblMeterNumber = new JLabel(meterNumber);
        lblMeterNumber.setBounds(350,95,150,20);
        p.add(lblMeterNumber);

        JLabel  lblMeterNo = new JLabel("Meter Location");
        lblMeterNo.setBounds(150,135,150,20);
        lblMeterNo.setFont(new Font("Thoma",Font.PLAIN,20));
        p.add(lblMeterNo);

        meterLocation = new Choice();
        meterLocation.add("Outside");
        meterLocation.add("Inside");
        meterLocation.setBounds(350,135,200,20);
        p.add(meterLocation);



        JLabel  lblAddress = new JLabel("Meter Type");
        lblAddress.setBounds(150,175,150,20);
        lblAddress.setFont(new Font("Thoma",Font.PLAIN,20));
        p.add(lblAddress);

        meterType = new Choice();
        meterType.add("Electric Meter");
        meterType.add("Solar Meter");
        meterType.add("Smart Meter");
        meterType.setBounds(350,175,200,20);
        p.add(meterType);

        JLabel  lblCity = new JLabel("Phase Code");
        lblCity.setBounds(150,215,150,20);
        lblCity.setFont(new Font("Thoma",Font.PLAIN,20));
        p.add(lblCity);

        phaseCode = new Choice();
        phaseCode.add("011");
        phaseCode.add("022");
        phaseCode.add("033");
        phaseCode.add("044");
        phaseCode.add("055");
        phaseCode.add("066");
        phaseCode.add("077");
        phaseCode.add("088");
        phaseCode.add("099");
        phaseCode.setBounds(350,215,200,20);
        p.add(phaseCode);

        JLabel  lblState = new JLabel("Bill Type");
        lblState.setBounds(150,255,150,20);
        lblState.setFont(new Font("Thoma",Font.PLAIN,20));
        p.add(lblState);

        billType = new Choice();
        billType.add("Normal");
        billType.add("Industrial");
        billType.setBounds(350,255,200,20);
        p.add(billType);


        JLabel  lblEmail = new JLabel("Days");
        lblEmail.setBounds(150,295,150,20);
        lblEmail.setFont(new Font("Thoma",Font.PLAIN,20));
        p.add(lblEmail);

        JLabel  lblEmails = new JLabel("30 Days");
        lblEmails.setBounds(350,295,150,20);
        lblEmails.setFont(new Font("Thoma",Font.PLAIN,20));
        p.add(lblEmails);

        JLabel  lblPhone = new JLabel("Note");
        lblPhone.setBounds(150,335,150,20);
        lblPhone.setFont(new Font("Thoma",Font.PLAIN,20));
        p.add(lblPhone);

        JLabel  lblPhones = new JLabel("Calculated for 30 days only");
        lblPhones.setBounds(350,335,300,25);
        lblPhones.setFont(new Font("Thoma",Font.PLAIN,20));
        p.add(lblPhones);


        next = new JButton("Next");
        next.setBounds(260,400,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);


        setLayout(new BorderLayout());

        add(p,"Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,300,1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image,"West");


        setVisible(true);
    }
    public static void main(String[] args) {
        new MeterInfo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next)
        {
            String meter = meterNumber;
            String location = meterLocation.getSelectedItem();
            String type = meterType.getSelectedItem();
            String code = phaseCode.getSelectedItem();
            String bType = billType.getSelectedItem();
            String days = "30 days";


            String query = "insert into meter_info values('"+meter+"', '"+location+"', '"+type+"', '"+code+"', '"+bType+"', '"+days+"')";

            try{
                conn c = new conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Meter Information added Successfully");
                setVisible(false);

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
