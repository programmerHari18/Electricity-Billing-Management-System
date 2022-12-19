package electricity.billing.system;

//import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class signup extends JFrame implements ActionListener {
    JButton back,create;
    JTextField meter,userName,name,password;
    Choice accountType;
    JPanel panel;
    JLabel heading,lblMeter,lblUserName,lblName,lblPassword;

    signup(){

        setBounds(450,150,750,400);
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);

        panel = new JPanel();
        panel.setBounds(30,30,700,300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),"Create Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(173,216,230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34,139,34));
        add(panel);

        heading = new JLabel("Create Account");
        heading.setBounds(100,50,140,20);
        heading.setForeground(Color.darkGray);
        heading.setFont(new Font("Tanaka",Font.BOLD,14));
        panel.add(heading);

        accountType = new Choice();
        accountType.add("--");
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260,50,150,20);
        panel.add(accountType);


        lblMeter = new JLabel("Meter Number");
        lblMeter.setBounds(100,90,140,20);
        lblMeter.setForeground(Color.darkGray);
        lblMeter.setFont(new Font("Tanaka",Font.BOLD,14));
        lblMeter.setVisible(false);
        panel.add(lblMeter);

        meter = new JTextField();
        meter.setBounds(260,90,150,20);
        meter.setVisible(false);
        panel.add(meter);

        lblUserName = new JLabel("User Name");
        lblUserName.setBounds(100,130,140,20);
        lblUserName.setForeground(Color.darkGray);
        lblUserName.setFont(new Font("Tanaka",Font.BOLD,14));
        panel.add(lblUserName);

        userName = new JTextField();
        userName.setBounds(260,130,150,20);
        panel.add(userName);

        lblName = new JLabel("Name");
        lblName.setBounds(100,170,140,20);
        lblName.setForeground(Color.darkGray);
        lblName.setFont(new Font("Tanaka",Font.BOLD,14));
        panel.add(lblName);

        name = new JTextField();
        name.setBounds(260,170,150,20);
        panel.add(name);

        meter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from login where meter_no  = '"+meter.getText()+"';");
                    while(rs.next())
                    {
                        name.setText(rs.getString("name"));
                    }
                }catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(100,210,140,20);
        lblPassword.setForeground(Color.darkGray);
        lblPassword.setFont(new Font("Tanaka",Font.BOLD,14));
        panel.add(lblPassword);

        password = new JTextField();
        password.setBounds(260,210,150,20);
        panel.add(password);

        accountType.addItemListener(e -> {
            String user = accountType.getSelectedItem();
            if(user.equals("Customer"))
            {
                lblMeter.setVisible(true);
                meter.setVisible(true);
                name.setEditable(false);
            }else{
                lblMeter.setVisible(false);
                meter.setVisible(false);
                name.setEditable(true);
            }
        });


        create = new JButton("Create");
        create.setBounds(140,260,120,25);
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.addActionListener(this);
        panel.add(create);

        back = new JButton("Back");
        back.setBounds(300,260,120,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(415,30,300,250);
        panel.add(image);


        setVisible(true);
    }
    public static void main(String[] args) {
        new signup();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String aType = accountType.getSelectedItem();
            String sUserName = userName.getText();
            String sName = name.getText();
            String sPassword = password.getText();
            String sMeter = meter.getText();

            try {
                conn c = new conn();

                String query;
                if (aType.equals("Admin")) {
                    query = "insert into login values('"+sMeter+"', '"+sUserName+"', '"+sName+"', '"+sPassword+"', '"+aType+"')";
                } else {
                    query = "update login set user_name = '"+sUserName+"', password = '"+sPassword+"', type = '"+aType+"' where meter_no = '"+sMeter+"'";
                }
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Dear "+sName+", Account Created Successfully");

                setVisible(false);
                new login();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);

            new login();
        }
    }
}
