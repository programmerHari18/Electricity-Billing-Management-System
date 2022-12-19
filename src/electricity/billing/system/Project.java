package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Project extends JFrame implements ActionListener {
    String aType,meters;
    JMenuItem calculateBill,depositDetails ,newCustomer ,customerDetails;
    Project(String aType,String meters)
    {

        this.aType=aType;
        this.meters=meters;

        setExtendedState(JFrame.MAXIMIZED_BOTH);//set frame size to maximum of screen

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,850,1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);

        JMenu master = new JMenu("Master");
        master.setForeground(Color.RED);


        newCustomer = new JMenuItem("New Customer");
        newCustomer.setFont(new Font("monospace", Font.PLAIN,12));
        newCustomer.setBackground(Color.WHITE);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20,20,1);
        newCustomer.setIcon(new ImageIcon(image1));
        newCustomer.setMnemonic('D');
        newCustomer.addActionListener(this);
        newCustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        master.add(newCustomer);

        customerDetails = new JMenuItem("Customer Details");
        customerDetails.setFont(new Font("monospace", Font.PLAIN,12));
        customerDetails.setBackground(Color.WHITE);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20,20,1);
        customerDetails.setIcon(new ImageIcon(image2));
        customerDetails.setMnemonic('E');
        customerDetails.addActionListener(this);
        customerDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        master.add(customerDetails);

        depositDetails = new JMenuItem("Deposit Details");
        depositDetails.setFont(new Font("monospace", Font.PLAIN,12));
        depositDetails.setBackground(Color.WHITE);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20,20,1);
        depositDetails.setIcon(new ImageIcon(image3));
        depositDetails.setMnemonic('F');
        depositDetails.addActionListener(this);
        depositDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        master.add(depositDetails);

        calculateBill = new JMenuItem("Calculate Bill");
        calculateBill.setFont(new Font("monospace", Font.PLAIN,12));
        calculateBill.setBackground(Color.WHITE);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image4 = icon4.getImage().getScaledInstance(20,20,1);
        calculateBill.setIcon(new ImageIcon(image4));
        calculateBill.setMnemonic('G');
        calculateBill.addActionListener(this);
        calculateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        master.add(calculateBill);

        JMenu info = new JMenu("Information");
        info.setForeground(Color.BLUE);


        JMenuItem updateInfo = new JMenuItem("Update Information");
        updateInfo.setFont(new Font("monospace", Font.PLAIN,12));
        updateInfo.setBackground(Color.WHITE);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image5 = icon5.getImage().getScaledInstance(20,20,1);
        updateInfo.setIcon(new ImageIcon(image5));
        updateInfo.setMnemonic('U');
        updateInfo.addActionListener(this);
        updateInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        info.add(updateInfo);

        JMenuItem viewInfo = new JMenuItem("View Information");
        viewInfo.setFont(new Font("monospace", Font.PLAIN,12));
        viewInfo.setBackground(Color.WHITE);
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(20,20,1);
        viewInfo.setIcon(new ImageIcon(image6));
        viewInfo.setMnemonic('V');
        viewInfo.addActionListener(this);
        viewInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        info.add(viewInfo);

        JMenu user = new JMenu("User");
        user.setForeground(Color.BLACK);

        setLayout(new FlowLayout());

        JMenuItem payBill = new JMenuItem("Pay Bill");
        payBill.setFont(new Font("monospace", Font.PLAIN,12));
        payBill.setBackground(Color.WHITE);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image7 = icon7.getImage().getScaledInstance(20,20,1);
        payBill.setIcon(new ImageIcon(image7));
        payBill.setMnemonic('P');
        payBill.addActionListener(this);
        payBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        user.add(payBill);

        JMenuItem billDetails = new JMenuItem("Bill Details");
        billDetails.setFont(new Font("monospace", Font.PLAIN,12));
        billDetails.setBackground(Color.WHITE);
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
        Image image8 = icon8.getImage().getScaledInstance(20,20,1);
        billDetails.setIcon(new ImageIcon(image6));
        billDetails.setMnemonic('B');
        billDetails.addActionListener(this);
        billDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        user.add(billDetails);

        JMenu report = new JMenu("Report");
        report.setForeground(Color.ORANGE);


        JMenuItem generateBill = new JMenuItem("Generate Bill");
        generateBill.setFont(new Font("monospace", Font.PLAIN,12));
        generateBill.setBackground(Color.WHITE);
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image9 = icon9.getImage().getScaledInstance(20,20,1);
        generateBill.setIcon(new ImageIcon(image9));
        generateBill.setMnemonic('G');
        generateBill.addActionListener(this);
        generateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        report.add(generateBill);


        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);


        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospace", Font.PLAIN,12));
        notepad.setBackground(Color.WHITE);
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image10 = icon10.getImage().getScaledInstance(20,20,1);
        notepad.setIcon(new ImageIcon(image10));
        notepad.setMnemonic('T');
        notepad.addActionListener(this);
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("monospace", Font.PLAIN,12));
        calculator.setBackground(Color.WHITE);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image11 = icon11.getImage().getScaledInstance(20,20,1);
        calculator.setIcon(new ImageIcon(image11));
        calculator.setMnemonic('A');
        calculator.addActionListener(this);
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        utility.add(calculator);

        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);


        JMenuItem exit_1 = new JMenuItem("Exit");
        exit_1.setFont(new Font("monospace", Font.PLAIN,12));
        exit_1.setBackground(Color.WHITE);
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image12 = icon12.getImage().getScaledInstance(20,20,1);
        exit_1.setIcon(new ImageIcon(image12));
        exit_1.setMnemonic('W');
        exit_1.addActionListener(this);
        exit_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        exit.add(exit_1);

        if(aType.equals("Admin"))
        {
            mb.add(master);
        }else{
            mb.add(info);
            mb.add(report);
            mb.add(user);
        }

        mb.add(exit);
        mb.add(utility);

        setLayout(new FlowLayout());

        setVisible(true);

    }
    public static void main(String[] args) {
        new Project("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if(msg.equals("New Customer"))
        {
            new NewCustomer();
        }
        else if(msg.equals("Customer Details"))
        {
            new CustomerDetails();
        }
        else if(msg.equals("Deposit Details"))
        {
            new DepositDetails();
        }
        else if(msg.equals("Calculate Bill"))
        {
            new CalculateBill();
        }else if(msg.equals("View Information"))
        {
//            System.out.println(meters);
            new ViewInfo(meters);
        }else if(msg.equals("Update Information"))
        {
            new UpdateInfo(meters);
        }else if(msg.equals("Bill Details"))
        {
            new BillDetails(meters);
        }else if(msg.equals("Notepad")) {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        } else if (msg.equals("Exit")) {
            setVisible(false);
            new login();
        } else if (msg.equals("Pay Bill")) {
            new PayBill(meters);
        } else if (msg.equals("Generate Bill")) {
            new GenerateBill(meters);
        }
    }
}
