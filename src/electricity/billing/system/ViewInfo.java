package electricity.billing.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewInfo extends JFrame implements ActionListener {
    JLabel heading,lblName,name,lblMeter,meter,lblAddress,address,lblCity,city,lblState,state,lblEmail,email,lblPhone,phone;
    JButton cancel;
    ViewInfo(String meterNum){
        setBounds(350,150,850,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        heading = new JLabel("View Customer Information");
        heading.setBounds(280,0,500,40);
        heading.setFont(new Font("Thoma",Font.PLAIN,30));
        add(heading);

        lblName = new JLabel("User Name");
        lblName.setBounds(70,80,100,20);
        add(lblName);

        name = new JLabel("");
        name.setBounds(250,80,100,20);
        add(name);

        lblMeter = new JLabel("Meter Number");
        lblMeter.setBounds(70,140,100,20);
        add(lblMeter);

        meter = new JLabel("");
        meter.setBounds(250,140,100,20);
        add(meter);

        lblAddress = new JLabel("Address");
        lblAddress.setBounds(70,200,100,20);
        add(lblAddress);

        address = new JLabel("");
        address.setBounds(250,200,100,20);
        add(address);

        lblCity = new JLabel("City");
        lblCity.setBounds(70,260,100,20);
        add(lblCity);

        city = new JLabel("");
        city.setBounds(250,260,100,20);
        add(city);

        lblState = new JLabel("State");
        lblState.setBounds(500,80,100,20);
        add(lblState);

        state = new JLabel("");
        state.setBounds(650,80,100,20);
        add(state);

        lblEmail = new JLabel("Email");
        lblEmail.setBounds(500,140,100,20);
        add(lblEmail);

        email = new JLabel("");
        email.setBounds(650,140,100,20);
        add(email);

        lblPhone = new JLabel("Phone");
        lblPhone.setBounds(500,200,100,20);
        add(lblPhone);

        phone = new JLabel("");
        phone.setBounds(650,200,100,20);
        add(phone);


        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(350,340,100,25);
        add(cancel);
        cancel.addActionListener(this);

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meterNum+"'");
            while (rs.next())
            {
                name.setText(rs.getString("name"));
                meter.setText(rs.getString("meter_no"));
                address.setText(rs.getString("address"));
                city.setText(rs.getString("city"));
                state.setText(rs.getString("state"));
                email.setText(rs.getString("email"));
                phone.setText(rs.getString("phone"));
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,350,600,300);
        add(image);






        setVisible(true);
    }
    public static void main(String[] args) {
        new ViewInfo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}
