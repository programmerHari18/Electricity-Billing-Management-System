package electricity.billing.system;


import java.sql.*;

public class conn {
    Connection c;
    Statement s;
    conn() throws SQLException {
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","Hari@2001");
        //Above is step 1 --installing jdbc drivers
        // and step 2 -- connecting mysql  in jdbc connectivity
        s = c.createStatement();
        //creating statement is step 3
    }

    public static void main(String[] args) {

    }
}
