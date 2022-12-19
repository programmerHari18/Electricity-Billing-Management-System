package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;

public class BillDetails extends JFrame {
    BillDetails(String meter)
    {
        setBounds(400,150,700,650);

        getContentPane().setBackground(Color.WHITE);

        JTable table = new JTable();

        try{
            conn c = new conn();
            String query = "select * from bill where meter = '"+meter+"'";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next())
            {

            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0,700,650);
        add(sp);
        setVisible(true);
    }
    public static void main(String[] args) {
        new BillDetails("");
    }
}
