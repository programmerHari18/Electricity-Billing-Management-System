package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JButton login,cancel,signup;
    JTextField userName,passWord;
    Choice loggingIn;
    JLabel loginInAs,lblUserName,lblPassword;
    login()
    {

        super("Login Page");
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("Icon/second.jpg"));
        Image i8 = i7.getImage().getScaledInstance(120,120,1);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(175,25,300,100);
        add(image);

        lblUserName = new JLabel("User Name");
        lblUserName.setBounds(150,150,300,20);
        add(lblUserName);

        userName = new JTextField();
        userName.setBounds(250,150,200,20);
        add(userName);

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(150,180,300,20);
        add(lblPassword);

        passWord = new JTextField();
        passWord.setBounds(250,180,200,20);
        add(passWord);

        loginInAs = new JLabel("Login In As");
        loginInAs.setBounds(150,210,100,20);
        add(loginInAs);

        loggingIn = new Choice();
        loggingIn.add("--");
        loggingIn.add("Admin");
        loggingIn.add("Customer");
        loggingIn.setBounds(250,210,200,20);
        add(loggingIn);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        login = new JButton("Login",new ImageIcon(i2));
        login.setBounds(245,250,100,20);
        login.addActionListener(this);
        add(login);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("Icon/cancel.jpg"));
        Image i4 = i3.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        cancel = new JButton("Cancel",new ImageIcon(i4));
        cancel.setBounds(310,290,100,20);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("Icon/signup.png"));
        Image i6 = i5.getImage().getScaledInstance(16,16,1);
        signup = new JButton("Sign Up",new ImageIcon(i6));
        signup.setBounds(375,250,100,20);
        signup.addActionListener(this);
        add(signup);

        setSize(640,400);
        setLocation(400,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login)
        {
            String username = userName.getText();
            String password = passWord.getText();
            String user = loggingIn.getSelectedItem();


            try{
                conn c = new conn();
                String query = "select * from login where user_name ='"+username+"' and password ='"+password+"' and type = '"+user+"'";
                ResultSet rs = c.s.executeQuery(query);

                if(rs.next())
                {
                    String meter = rs.getString("meter_no");
                    System.out.println(user);
                    setVisible(false);
                    new Project(user,meter);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid login");
                    userName.setText("");
                    passWord.setText("");
                }
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else if(e.getSource()==signup)
        {
            setVisible(false);
            new signup();
        }
        else if(e.getSource()==cancel)
        {
            setVisible(false);
        }
    }
}
