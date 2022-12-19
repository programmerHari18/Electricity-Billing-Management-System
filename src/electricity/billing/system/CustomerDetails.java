package electricity.billing.system;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import net.proteanit.sql.DbUtils;

public class CustomerDetails extends JFrame implements ActionListener {
    JTable table;
    JButton print;
    CustomerDetails(){
        super("Customer Details");

        setBounds(200,150,800,500);




        table = new JTable();

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");

            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        JScrollPane pane = new JScrollPane(table);

        add(pane);



        print = new JButton("Print");
        print.addActionListener(this);
        add(print,"South");


        setVisible(true);
    }
    public static void main(String[] args) {
        new CustomerDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            try{
                table.print();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
    }
}
