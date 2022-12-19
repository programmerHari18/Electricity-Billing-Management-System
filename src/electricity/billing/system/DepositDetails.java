package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import net.proteanit.sql.DbUtils;

public class DepositDetails extends JFrame implements ActionListener {
Choice meterNumber,cMonth;
JTable table;
JButton search,print;
    DepositDetails(){
        super("Deposit Details");

        setBounds(400,100,700,700);


        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblMeterNumber = new JLabel("Search by meter number");
        lblMeterNumber.setBounds(20,20,150,20);
        add(lblMeterNumber);

        meterNumber = new Choice();
        meterNumber.setBounds(180,20,150,20);

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next())
            {
                meterNumber.add(rs.getString("meter_no"));
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        add(meterNumber);

        JLabel lblMonth = new JLabel("Search by Month");
        lblMonth.setBounds(400,20,100,20);
        add(lblMonth);

        cMonth = new Choice();
        cMonth.setBounds(520,20,100,20);
        cMonth.add("January");
        cMonth.add("February");
        cMonth.add("March");
        cMonth.add("April");
        cMonth.add("May");
        cMonth.add("June");
        cMonth.add("July");
        cMonth.add("August");
        cMonth.add("September");
        cMonth.add("October");
        cMonth.add("November");
        cMonth.add("December");
        add(cMonth);

        table = new JTable();

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from bill");

            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0,100,700,600);
        add(pane);

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Search");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);


        setVisible(true);
    }
    public static void main(String[] args) {
        new DepositDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search)
        {
            String query = "select * from bill where meter = '"+meterNumber.getSelectedItem()+"' and month = '"+cMonth.getSelectedItem()+"';";
            try{
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else
        {
            try{
                table.print();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
